package io.ski;

import java.util.Objects;

public class Turnstile {
  private final CardSystem cardSystem;

  public Turnstile(CardSystem cardSystem) {
    this.cardSystem = cardSystem;
  }

  public boolean pass(UserCard userCard) {
    Objects.requireNonNull(userCard);

    return cardSystem.pass(userCard);
  }
}
