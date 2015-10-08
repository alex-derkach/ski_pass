package io.ski.card.handler;

import io.ski.card.Handler;
import io.ski.card.type.UnlimitedCard;

public class UnlimitedHandler<T extends UnlimitedCard> implements Handler<T> {

  @Override
  public void handle(T card) { }
}
