package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.card.Validator;
import io.ski.support.validation.BindingResult;

public class BlockedValidator<T extends Card> implements Validator<T> {

  public static final String YOUR_CARD_IS_BLOCKED_MESSAGE = "Your card is blocked.";

  @Override
  public void validate(T card, BindingResult bindingResult) {
    if (isBlocked(card)) {
      bindingResult.reject(YOUR_CARD_IS_BLOCKED_MESSAGE);
    }
  }

  private boolean isBlocked(T card) {
    return card.isBlocked();
  }
}
