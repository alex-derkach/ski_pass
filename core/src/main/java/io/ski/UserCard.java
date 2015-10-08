package io.ski;

import io.ski.card.Card;

public class UserCard {
  private final Long id;

  public UserCard(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public static UserCard of(Card card) {
    return new UserCard(card.getId());
  }
}
