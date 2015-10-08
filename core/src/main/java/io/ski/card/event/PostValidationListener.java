package io.ski.card.event;

import io.ski.card.Card;
import io.ski.support.validation.BindingResult;

public interface PostValidationListener {
  void postValidation(Card card, BindingResult bindingResult);
}
