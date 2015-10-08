package io.ski;

import io.ski.card.*;
import io.ski.repository.CardRepository;
import io.ski.statistics.repository.PassEventRepository;
import io.ski.support.validation.HolidayResolver;
import io.ski.util.AbstractMockitoTest;
import io.ski.util.HolidayResolverAwareValidator;
import org.junit.Before;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class AbstractCardSystemTest extends AbstractMockitoTest {

  protected static final String DEFAULT_DISCRIMINATOR = "DEFAULT_DISCRIMINATOR";
  protected static final Long DEFAULT_CARD_ID = 1L;

  @Mock protected HolidayResolver holidayResolver;
  @Mock protected CardRepository cardRepository;
  @Mock protected PassEventRepository passEventRepository;

  @Mock protected CardDefinition cardDefinition;
  @Mock protected CardFactory cardFactory;
  @Mock protected HolidayResolverAwareValidator validator;
  @Mock protected Handler<Card> handler;

  @Mock protected Card defaultCard = mock(Card.class);
  @Mock protected UserCard validUserCard = mock(UserCard.class);

  protected CardSystem cardSystem;

  @Before
  public void setup() {
    cardSystem = new CardSystem(cardRepository, passEventRepository, holidayResolver);

    when(cardDefinition.getDiscriminator()).thenReturn(DEFAULT_DISCRIMINATOR);
    when(cardDefinition.getCardFactory()).thenReturn(cardFactory);
    when(cardDefinition.getValidator()).thenReturn(validator);
    when(cardDefinition.getHandler()).thenReturn(handler);

    cardSystem.registerCardType(cardDefinition);
    when(cardFactory.create()).thenReturn(defaultCard);
    when(cardRepository.get(DEFAULT_CARD_ID)).thenReturn(defaultCard);

    when(defaultCard.getId()).thenReturn(DEFAULT_CARD_ID);
    when(defaultCard.getDiscriminator()).thenReturn(DEFAULT_DISCRIMINATOR);
    when(validUserCard.getId()).thenReturn(DEFAULT_CARD_ID);
  }
}