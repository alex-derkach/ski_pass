package io.ski.card.validator;

import io.ski.card.Validator;
import io.ski.card.type.LimitedCard;
import io.ski.support.validation.ValidationResult;

public class LimitedValidator<T extends LimitedCard> implements Validator<T> {

  public static final String YOU_HAVE_NO_TRIPS_LEFT_MESSAGE = "You have no trips left.";

  @Override
  public void validate(T card, ValidationResult validationResult) {
    if (!hasPositiveCounter(card)) {
      validationResult.reject(YOU_HAVE_NO_TRIPS_LEFT_MESSAGE);
    }
  }

  private static boolean hasPositiveCounter(LimitedCard card) {
    return card.getCounter() > 0;
  }
}
