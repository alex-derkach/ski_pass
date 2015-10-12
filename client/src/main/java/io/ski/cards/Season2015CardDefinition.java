package io.ski.cards;

import io.ski.card.*;
import io.ski.card.handler.UnlimitedHandler;
import io.ski.card.type.UnlimitedCard;
import io.ski.card.validator.BlockedValidator;
import io.ski.card.validator.TimeRangeValidator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Season2015CardDefinition implements CardDefinition<UnlimitedCard> {

  private static final String CARD_TYPE = Season2015CardDefinition.class.getSimpleName();
  private static final int SEASON_LENGTH_MONTHS = 3;

  private static final LocalDateTime START_POINT = LocalDate.of(2015, Month.DECEMBER, 1).atStartOfDay();
  private static final LocalDateTime END_POINT = START_POINT.plusMonths(SEASON_LENGTH_MONTHS);

  @Override
  public String getDiscriminator() {
    return CARD_TYPE;
  }

  @Override
  public CardFactory<UnlimitedCard> getCardFactory() {
    return () -> {
      UnlimitedCard unlimitedCard = new UnlimitedCard(CARD_TYPE);
      unlimitedCard.setStartPoint(START_POINT);
      unlimitedCard.setEndPoint(END_POINT);
      return unlimitedCard;
    };
  }

  @Override
  public Validator<UnlimitedCard> getValidator() {
    return new SeasonValidator();
  }

  @Override
  public Handler<UnlimitedCard> getHandler() {
    return new UnlimitedHandler<>();
  }

  private class SeasonValidator extends ComplexValidator<UnlimitedCard> {
    @Override
    protected void registerValidators() {
      registerValidators(
          new BlockedValidator<>(),
          new TimeRangeValidator<>()
      );
    }
  }
}
