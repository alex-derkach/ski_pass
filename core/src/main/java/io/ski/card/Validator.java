package io.ski.card;

import io.ski.support.validation.ValidationResult;

public interface Validator<T extends Card> {

  void validate(T card, ValidationResult validationResult);
}
