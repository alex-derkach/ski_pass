package io.ski.cards.not_workday.unlimited.support;

import io.ski.card.CardDefinition;
import io.ski.card.CardFactory;
import io.ski.card.Handler;
import io.ski.card.Validator;
import io.ski.card.handler.UnlimitedHandler;
import io.ski.card.type.UnlimitedCard;

import java.time.LocalDateTime;

public abstract class AbstractNotWorkdayUnlimitedCardDefinition implements CardDefinition<UnlimitedCard> {

  private final String cardType;
  private final int startHour;
  private final int validityHours;

  protected AbstractNotWorkdayUnlimitedCardDefinition(String cardType, int startHour, int validityHours) {
    this.cardType = cardType;
    this.startHour = startHour;
    this.validityHours = validityHours;
  }

  @Override
  public String getDiscriminator() {
    return cardType;
  }

  @Override
  public CardFactory<UnlimitedCard> getCardFactory() {
    return () -> {
      UnlimitedCard unlimitedCard = new UnlimitedCard(cardType);

      LocalDateTime resultStartPoint = LocalDateTime.now();
      // if current time is after start hour, create a card for tomorrow
      if(resultStartPoint.getHour() > startHour) {
        resultStartPoint = resultStartPoint.plusDays(1);
      }
      // reset minutes and seconds to 00:00
      resultStartPoint = resultStartPoint.withHour(startHour).withMinute(0).withSecond(0);
      unlimitedCard.setStartPoint(resultStartPoint);
      unlimitedCard.setEndPoint(resultStartPoint.plusHours(validityHours));
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

}