package io.ski.card.event;

import io.ski.card.Card;
import io.ski.support.validation.ValidationResult;

public interface PostValidationListener {
  void postValidation(Card card, ValidationResult validationResult);
}
