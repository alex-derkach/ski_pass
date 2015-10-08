package io.ski.statistics.domain;

import io.ski.card.Card;

import java.time.LocalDateTime;

public abstract class PassEvent {
  private final PassStatus passStatus;
  private final LocalDateTime createdAt;
  private final Card card;

  public PassEvent(PassStatus passStatus, LocalDateTime createdAt, Card card) {
    this.passStatus = passStatus;
    this.createdAt = createdAt;
    this.card = card;
  }

  public PassStatus getPassStatus() {
    return passStatus;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public Card getCard() {
    return card;
  }
}
