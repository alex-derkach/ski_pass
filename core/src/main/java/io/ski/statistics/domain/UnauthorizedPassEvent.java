package io.ski.statistics.domain;

import io.ski.card.Card;

import java.time.LocalDateTime;
import java.util.Collection;

public class UnauthorizedPassEvent extends PassEvent {
  private final Collection<String> errors;

  public UnauthorizedPassEvent(Collection<String> errors, LocalDateTime localDateTime, Card card) {
    super(PassStatus.UNAUTHORIZED, localDateTime, card);
    this.errors = errors;
  }

  public Collection<String> getErrors() {
    return errors;
  }
}
