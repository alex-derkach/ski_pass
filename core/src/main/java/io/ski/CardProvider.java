package io.ski;

import io.ski.card.Handler;
import io.ski.card.Card;
import io.ski.card.CardFactory;
import io.ski.card.Validator;

public class CardProvider<T extends Card> {
  private final CardFactory<T> cardFactory;
  private final Validator<T> validator;
  private final Handler<T> handler;

  public CardProvider(CardFactory<T> cardFactory, Validator<T> validator, Handler<T> handler) {
    this.cardFactory = cardFactory;
    this.validator = validator;
    this.handler = handler;
  }

  public CardFactory<T> getCardFactory() {
    return cardFactory;
  }

  public Validator<T> getValidator() {
    return validator;
  }

  public Handler<T> getHandler() {
    return handler;
  }
}