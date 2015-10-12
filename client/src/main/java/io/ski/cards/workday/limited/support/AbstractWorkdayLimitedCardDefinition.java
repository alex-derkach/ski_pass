package io.ski.cards.workday.limited.support;

import io.ski.card.CardDefinition;
import io.ski.card.Handler;
import io.ski.card.CardFactory;
import io.ski.card.Validator;
import io.ski.card.handler.LimitedHandler;
import io.ski.card.type.LimitedCard;

public abstract class AbstractWorkdayLimitedCardDefinition implements CardDefinition<LimitedCard> {

  @Override
  public CardFactory<LimitedCard> getCardFactory() {
    return () -> {
      LimitedCard card = new LimitedCard(getDiscriminator());
      card.setCounter(getTripCount());
      return card;
    };
  }

  @Override
  public Validator<LimitedCard> getValidator() {
    return new WorkdayLimitedComplexValidator<>();
  }

  @Override
  public Handler<LimitedCard> getHandler() {
    return new LimitedHandler<>();
  }

  public abstract Long getTripCount();
}
