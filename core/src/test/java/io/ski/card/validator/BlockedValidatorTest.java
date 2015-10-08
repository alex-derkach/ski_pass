package io.ski.card.validator;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.Card;
import io.ski.support.validation.BindingResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class BlockedValidatorTest extends AbstractMockitoTest {

  private static final boolean BLOCKED_CARD_STATE = true;
  private static final boolean NON_BLOCKED_CARD_STATE = false;

  @Mock
  private Card card;

  private BlockedValidator<Card> validator;
  private BindingResult bindingResult;

  @Before
  public void setup() {
    validator = new BlockedValidator<>();
    bindingResult = new BindingResult();
  }

  @Test
  public void shouldAddErrorWhenCardIsBlocked() {
    when(card.isBlocked()).thenReturn(BLOCKED_CARD_STATE);

    validator.validate(card, bindingResult);

    assertTrue(bindingResult.hasErrors());
  }

  @Test
  public void shouldNotAddErrorWhenCardIsNotBlocked() {
    when(card.isBlocked()).thenReturn(NON_BLOCKED_CARD_STATE);

    validator.validate(card, bindingResult);

    assertFalse(bindingResult.hasErrors());
  }
}