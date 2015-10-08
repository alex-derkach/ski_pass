package io.ski.card.type;

import io.ski.card.Card;

import java.util.Objects;

public class LimitedCard extends Card {

  private Long counter;

  public LimitedCard(String discriminator) {
    super(discriminator);
  }

  public Long getCounter() {
    return counter;
  }

  public void setCounter(Long counter) {
    this.counter = counter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof LimitedCard)) return false;
    if (!super.equals(o)) return false;
    LimitedCard that = (LimitedCard) o;
    return Objects.equals(getCounter(), that.getCounter());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCounter());
  }
}
