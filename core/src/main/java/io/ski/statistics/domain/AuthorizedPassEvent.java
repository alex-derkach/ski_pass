package io.ski.statistics.domain;

import io.ski.card.Card;

import java.time.LocalDateTime;

public class AuthorizedPassEvent extends PassEvent {
  public AuthorizedPassEvent(LocalDateTime localDateTime, Card card) {
    super(PassStatus.AUTHORIZED, localDateTime, card);
  }
}
