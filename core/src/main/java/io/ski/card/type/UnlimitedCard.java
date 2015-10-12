package io.ski.card.type;

import io.ski.card.Card;

import java.time.LocalDateTime;
import java.util.Objects;

public class UnlimitedCard extends Card {
  private LocalDateTime startPoint;
  private LocalDateTime endPoint;

  public UnlimitedCard(String discriminator) {
    super(discriminator);
  }

  public LocalDateTime getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(LocalDateTime startPoint) {
    this.startPoint = startPoint;
  }

  public LocalDateTime getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(LocalDateTime endPoint) {
    this.endPoint = endPoint;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof UnlimitedCard))
      return false;
    if (!super.equals(o))
      return false;
    UnlimitedCard that = (UnlimitedCard) o;
    return Objects.equals(getStartPoint(), that.getStartPoint()) &&
        Objects.equals(getEndPoint(), that.getEndPoint());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getStartPoint(), getEndPoint());
  }
}
