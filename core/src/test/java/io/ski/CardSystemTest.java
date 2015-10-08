package io.ski;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class CardSystemTest extends AbstractCardSystemTest {

  private static final boolean BLOCKED_CARD_STATE = true;
  private static final boolean UNBLOCKED_CARD_STATE = false;

  @Test
  public void shouldPersistCardWhenCalledCreate() {
    cardSystem.create(DEFAULT_DISCRIMINATOR);

    verify(cardRepository).persist(defaultCard);
  }

  @Test
  public void shouldReturnValidUserCardWhenCalledCreate() {
    UserCard userCard = cardSystem.create(DEFAULT_DISCRIMINATOR);

    assertTrue(Objects.nonNull(userCard));
    assertTrue(Objects.equals(userCard.getId(), DEFAULT_CARD_ID));
  }

  @Test
  public void shouldBlockCardWhenCalledBlock() {
    UserCard userCard = cardSystem.create(DEFAULT_DISCRIMINATOR);
    cardSystem.block(userCard);

    verify(defaultCard).setBlocked(BLOCKED_CARD_STATE);
  }

  @Test
  public void shouldUnblockCardWhenCalledUnblock() {
    UserCard userCard = cardSystem.create(DEFAULT_DISCRIMINATOR);
    cardSystem.unblock(userCard);

    verify(defaultCard).setBlocked(UNBLOCKED_CARD_STATE);
  }

  @Test
  public void shouldCreateNonNullEventQueryView() {
    assertNotNull(cardSystem.createEventQueryView());
  }
}