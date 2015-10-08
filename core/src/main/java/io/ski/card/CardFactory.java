package io.ski.card;

public interface CardFactory<T extends Card> {
  T create();
}
