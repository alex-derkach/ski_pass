package io.ski.card;

import io.ski.support.validation.BindingResult;

public interface Validator<T extends Card> {

  void validate(T card, BindingResult bindingResult);
}
