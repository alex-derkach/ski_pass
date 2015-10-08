package io.ski;

import io.ski.util.AbstractMockitoTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public class TurnstileTest extends AbstractMockitoTest {
  private static final long USER_CARD_ID = 1L;

  @Mock private CardSystem cardSystem;

  private UserCard userCard;
  private Turnstile turnstile;

  @Before
  public void setup() {
    turnstile = new Turnstile(cardSystem);
    userCard = new UserCard(USER_CARD_ID);
  }

  @Test
  public void shouldDelegatePassToSystem() {
    turnstile.pass(userCard);

    verify(cardSystem).pass(eq(userCard));
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowExceptionWhenCalledPassWithNull() {
    turnstile.pass(null);
  }
}