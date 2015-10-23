package io.ski.card;

import io.ski.support.validation.ValidationResult;

import java.util.*;

public abstract class ComplexValidator<T extends Card> implements Validator<T> {
  private Collection<Validator<T>> validators = new ArrayList<>();

  public ComplexValidator() {
    registerValidators();
  }

  protected abstract void registerValidators();

  protected final Collection<Validator<T>> getValidators() {
    return Collections.unmodifiableCollection(validators);
  }

  @SafeVarargs
  protected final void registerValidators(Validator<T>... validators) {
    List<Validator<T>> validatorList = Arrays.asList(validators);
    validatorList.forEach(Objects::requireNonNull);
    this.validators = validatorList;
  }

  @Override
  public final void validate(T card, ValidationResult validationResult) {
    this.validators.forEach(v -> v.validate(card, validationResult));
  }
}
