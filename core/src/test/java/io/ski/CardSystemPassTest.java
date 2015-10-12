package io.ski;

import io.ski.card.event.PostHandleListener;
import io.ski.card.event.PostValidationListener;
import io.ski.support.validation.BindingResult;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CardSystemPassTest extends AbstractCardSystemTest {

  @Test
  public void shouldApplyValidatorWhenCalledPassWithValidUserCard() {
    cardSystem.pass(validUserCard);

    verify(validator).validate(eq(defaultCard), any(BindingResult.class));
  }

  @Test
  public void shouldApplyHandlerWhenCalledPassWithValidUserCard() {
    cardSystem.pass(validUserCard);

    verify(handler).handle(eq(defaultCard));
  }

  @Test
  public void shouldApplyPostHandleListenerWhenCalledPassWithValidUserCard() {
    PostHandleListener postHandleListener = mock(PostHandleListener.class);

    cardSystem.addPostPassHandleListener(postHandleListener);
    cardSystem.pass(validUserCard);

    verify(postHandleListener).postHandle(eq(defaultCard));
  }

  @Test
  public void shouldApplyPostValidationListenerWhenCalledPassWithValidUserCard() {
    PostValidationListener postValidationListener = mock(PostValidationListener.class);

    cardSystem.addPostValidationRejectionListener(postValidationListener);
    cardSystem.pass(validUserCard);

    verify(postValidationListener).postValidation(eq(defaultCard), any(BindingResult.class));
  }
}