package io.ski.repository;

import io.ski.card.Card;

public interface CardRepository {
  void persist(Card card);
  Card get(Long id);
  boolean contains(Card card);
}
