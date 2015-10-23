package io.ski.card.validator;

import io.ski.card.Validator;
import io.ski.card.type.UnlimitedCard;
import io.ski.support.validation.ValidationResult;

import java.time.Clock;
import java.time.LocalDateTime;

public class TimeRangeValidator<T extends UnlimitedCard> implements Validator<T> {

  public static final String YOUR_CARD_HAS_EXPIRED_MESSAGE = "Your card has expired.";
  public static final String YOUR_CARD_PERIOD_HAS_NOT_STARTED_MESSAGE = "Your card usage period has not started yet.";

  private final Clock clock;

  public TimeRangeValidator() {
    clock = Clock.systemDefaultZone();
  }

  // Used for testing
  TimeRangeValidator(Clock clock) {
    this.clock = clock;
  }

  @Override
  public void validate(T card, ValidationResult validationResult) {
    LocalDateTime time = LocalDateTime.now(clock);
    if (time.isBefore(card.getStartPoint())) {
      validationResult.reject(YOUR_CARD_PERIOD_HAS_NOT_STARTED_MESSAGE);
    }
    if (time.isAfter(card.getEndPoint())) {
      validationResult.reject(YOUR_CARD_HAS_EXPIRED_MESSAGE);
    }
  }
}
