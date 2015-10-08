package io.ski.card;

public interface CardDefinition<T extends Card> {
  String getDiscriminator();
  CardFactory<T> getCardFactory();
  Validator<T> getValidator();
  Handler<T> getHandler();
}
