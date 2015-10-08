package io.ski.card;

public interface Handler<T extends Card> {
  void handle(T card);
}
