package io.ski.repository;

import io.ski.card.Card;
import io.ski.repository.generator.IdentifierGenerator;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionBasedCardRepository implements CardRepository {

  private final IdentifierGenerator identifierGenerator;
  private final Collection<Card> cards;

  public CollectionBasedCardRepository(IdentifierGenerator identifierGenerator) {
    this.cards = new ArrayList<>();
    this.identifierGenerator = identifierGenerator;
  }

  @Override
  public void persist(Card card) {
    card.setId(identifierGenerator.generate());
    cards.add(card);
  }

  @Override
  public Card get(Long id) {
    return cards.parallelStream()
        .filter(passCard -> passCard.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  @Override
  public boolean contains(Card card) {
    return get(card.getId()) != null;
  }

}
