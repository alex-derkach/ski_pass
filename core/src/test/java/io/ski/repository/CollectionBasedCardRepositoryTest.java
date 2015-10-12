package io.ski.repository;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.Card;
import io.ski.repository.generator.IdentifierGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CollectionBasedCardRepositoryTest extends AbstractMockitoTest {

  private static final long PERSISTED_CARD_ID = 1L;
  private static final long NOT_PERSISTED_CARD_ID = 2L;

  @Mock
  private IdentifierGenerator identifierGenerator;
  @Mock
  private Card card;

  private CollectionBasedCardRepository collectionBasedCardRepository;

  @Before
  public void setup() {
    collectionBasedCardRepository = new CollectionBasedCardRepository(identifierGenerator);
    collectionBasedCardRepository.persist(card);
    when(card.getId()).thenReturn(PERSISTED_CARD_ID);
  }

  @Test
  public void shouldCallIdentifierGeneratorWhenPersistIsCalled() {
    verify(identifierGenerator).generate();
  }

  @Test
  public void shouldContainCardWhenContainsIsCalled() {
    assertTrue(collectionBasedCardRepository.contains(card));
  }

  public void shouldFindCardWhenGetIsCalled() {
    assertNotNull(collectionBasedCardRepository.get(PERSISTED_CARD_ID));
  }

  public void shouldNotContainNotPersistentCard() {
    Card notPersistentCard = mock(Card.class);

    when(notPersistentCard.getId()).thenReturn(NOT_PERSISTED_CARD_ID);

    assertFalse(collectionBasedCardRepository.contains(notPersistentCard));
  }

  public void shouldNotFindNotPersistentCard() {
    Card notPersistentCard = mock(Card.class);

    when(notPersistentCard.getId()).thenReturn(NOT_PERSISTED_CARD_ID);

    assertNull(collectionBasedCardRepository.get(NOT_PERSISTED_CARD_ID));
  }

}