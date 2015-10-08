package io.ski.card.event;

import io.ski.card.Card;

public interface PostHandleListener {
  void postHandle(Card card);
}
