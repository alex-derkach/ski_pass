package io.ski.cards.notworkday.unlimited.support;

import io.ski.card.CardDefinition;
import io.ski.card.CardFactory;
import io.ski.card.Handler;
import io.ski.card.Validator;
import io.ski.card.handler.UnlimitedHandler;
import io.ski.card.type.UnlimitedCard;

import java.time.LocalDateTime;

public abstract class AbstractNotWorkdayUnlimitedCardDefinition implements CardDefinition<UnlimitedCard> {

  @Override
  public CardFactory<UnlimitedCard> getCardFactory() {
    return () -> {
      UnlimitedCard unlimitedCard = new UnlimitedCard(getDiscriminator());

      LocalDateTime resultStartPoint = LocalDateTime.now();
      // if current time is after start hour, create a card for tomorrow
      if(resultStartPoint.getHour() > getStartHour()) {
        resultStartPoint = resultStartPoint.plusDays(1);
      }
      // reset minutes and seconds to 00:00
      resultStartPoint = resultStartPoint.withHour(getStartHour()).withMinute(0).withSecond(0);
      unlimitedCard.setStartPoint(resultStartPoint);
      unlimitedCard.setEndPoint(resultStartPoint.plusHours(getValidityHours()));
      return unlimitedCard;
    };
  }

  @Override
  public Validator<UnlimitedCard> getValidator() {
    return new NotWorkdayUnlimitedComplexValidator<>();
  }

  @Override
  public Handler<UnlimitedCard> getHandler() {
    return new UnlimitedHandler<>();
  }

  protected abstract int getStartHour();
  protected abstract int getValidityHours();
}