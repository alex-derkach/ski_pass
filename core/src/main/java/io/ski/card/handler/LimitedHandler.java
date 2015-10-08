package io.ski.card.handler;

import io.ski.card.Handler;
import io.ski.card.type.LimitedCard;

public class LimitedHandler<T extends LimitedCard> implements Handler<T> {

  @Override
  public void handle(T card) {
    card.setCounter(card.getCounter() - 1);
  }
}
