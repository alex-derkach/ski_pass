package io.ski.support.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BindingResult {
  private final List<String> errors;

  public BindingResult() {
    errors = new LinkedList<>();
  }

  public void reject(String message) {
    errors.add(message);
  }

  public boolean hasErrors() {
    return !errors.isEmpty();
  }

  public Collection<String> getErrors() {
    return Collections.unmodifiableList(errors);
  }
}
