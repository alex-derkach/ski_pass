package io.ski.card;

import java.util.Objects;

public abstract class Card {

  private Long id;
  private boolean blocked;
  private final String discriminator;

  protected Card(String discriminator) {
    this.discriminator = discriminator;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isBlocked() {
    return blocked;
  }

  public void setBlocked(boolean blocked) {
    this.blocked = blocked;
  }

  public String getDiscriminator() {
    return discriminator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Card))
      return false;
    Card card = (Card) o;
    return Objects.equals(isBlocked(), card.isBlocked()) &&
        Objects.equals(getId(), card.getId()) &&
        Objects.equals(getDiscriminator(), card.getDiscriminator());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), isBlocked(), getDiscriminator());
  }
}
