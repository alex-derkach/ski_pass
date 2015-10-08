package io.ski;

import io.ski.card.Card;
import io.ski.card.CardDefinition;
import io.ski.card.Validator;
import io.ski.card.event.PostHandleListener;
import io.ski.card.event.PostValidationListener;
import io.ski.card.validator.support.HolidayResolverAware;
import io.ski.exception.AlreadyRegisteredCardTypeException;
import io.ski.exception.UnregisteredCardTypeException;
import io.ski.repository.CardRepository;
import io.ski.statistics.HandleLogger;
import io.ski.statistics.ValidationRejectionLogger;
import io.ski.statistics.View;
import io.ski.statistics.repository.PassEventRepository;
import io.ski.support.validation.BindingResult;
import io.ski.support.validation.HolidayResolver;

import java.util.*;

public class CardSystem {
  private final Map<String, CardProvider<? extends Card>> cardProviderResolver;
  private final CardRepository cardRepository;
  private final PassEventRepository passEventRepository;
  private final HolidayResolver holidayResolver;

  private final Collection<PostHandleListener> postHandleListeners;
  private final Collection<PostValidationListener> postValidationListeners;

  public CardSystem(CardRepository cardRepository, PassEventRepository passEventRepository, HolidayResolver holidayResolver) {
    this.holidayResolver = holidayResolver;
    this.cardRepository = cardRepository;
    this.passEventRepository = passEventRepository;

    this.cardProviderResolver = new HashMap<>();
    this.postHandleListeners = new ArrayList<>();
    this.postValidationListeners = new ArrayList<>();

    initPostListeners();
  }

  public View createEventQueryView() {
    return new View(this.passEventRepository);
  }

  public void registerCardType(CardDefinition<?> cardDefinition) {
    Objects.requireNonNull(cardDefinition.getDiscriminator());
    Objects.requireNonNull(cardDefinition.getCardFactory());
    Objects.requireNonNull(cardDefinition.getValidator());
    Objects.requireNonNull(cardDefinition.getHandler());

    String type = cardDefinition.getDiscriminator();
    if (cardProviderResolver.containsKey(type)) {
      throw new AlreadyRegisteredCardTypeException(type);
    }

    CardProvider<? extends Card> cardProvider = toProvider(cardDefinition);
    cardProviderResolver.put(type, cardProvider);

    postRegistration(cardProvider);
  }

  public UserCard create(String cardDiscriminator) {
    Card card = createInstance(cardDiscriminator);
    cardRepository.persist(card);
    return UserCard.of(card);
  }

  public boolean pass(UserCard userCard) {
    Card card = getCard(userCard);
    BindingResult bindingResult = new BindingResult();

    applyValidator(card, bindingResult);
    applyPostValidationListeners(card, bindingResult);
    if (bindingResult.hasErrors()) {
      return false;
    }

    applyHandler(card);
    applyPostHandleListeners(card);
    return true;
  }

  public void block(UserCard userCard) {
    setBlock(userCard, true);
  }

  public void unblock(UserCard userCard) {
    setBlock(userCard, false);
  }

  public void addPostPassHandleListener(PostHandleListener listener) {
    postHandleListeners.add(listener);
  }

  public void addPostValidationRejectionListener(PostValidationListener listener) {
    postValidationListeners.add(listener);
  }

  private void setBlock(UserCard userCard, boolean block) {
    Card card = getCard(userCard);
    cardRepository.get(card.getId()).setBlocked(block);
  }

  private Card createInstance(String cardType) {
    return getProvider(cardType).getCardFactory().create();
  }

  private void postRegistration(CardProvider<? extends Card> provider) {
    Validator<? extends Card> validator = provider.getValidator();
    if (validator instanceof HolidayResolverAware) {
      ((HolidayResolverAware) validator).setHolidayResolver(holidayResolver);
    }
  }

  @SuppressWarnings("unchecked")
  private void applyValidator(Card card, BindingResult bindingResult) {
    String cardDiscriminator = card.getDiscriminator();
    getProvider(cardDiscriminator).getValidator().validate(card, bindingResult);
  }

  @SuppressWarnings("unchecked")
  private void applyHandler(Card card) {
    String cardDiscriminator = card.getDiscriminator();
    getProvider(cardDiscriminator).getHandler().handle(card);
  }

  private void applyPostValidationListeners(Card card, BindingResult bindingResult) {
    postValidationListeners.parallelStream().forEach(l -> l.postValidation(card, bindingResult));
  }

  private void applyPostHandleListeners(Card card) {
    postHandleListeners.parallelStream().forEach(l -> l.postHandle(card));
  }

  private CardProvider getProvider(String cardType) {
    return Optional.ofNullable(cardProviderResolver.get(cardType)).orElseThrow(() -> new UnregisteredCardTypeException(cardType));
  }

  private Card getCard(UserCard userCard) {
    return cardRepository.get(userCard.getId());
  }

  private void initPostListeners() {
    addPostValidationRejectionListener(new ValidationRejectionLogger(this.passEventRepository));
    addPostPassHandleListener(new HandleLogger(this.passEventRepository));
  }

  @SuppressWarnings("unchecked")
  private static CardProvider<? extends Card> toProvider(CardDefinition<? extends Card> cardDefinition) {
    return new CardProvider(
        cardDefinition.getCardFactory(),
        cardDefinition.getValidator(),
        cardDefinition.getHandler()
    );
  }
}
