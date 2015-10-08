package io.ski.card.handler;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.type.LimitedCard;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LimitedCardHandlerTest extends AbstractMockitoTest {

  private static final long CARD_STARTER_COUNTER_VALUE = 10L;
  private static final long CARD_DECREMENTED_COUNTER_VALUE = CARD_STARTER_COUNTER_VALUE - 1;

  @Mock
  private LimitedCard limitedCard;

  private LimitedHandler<LimitedCard> limitedCardHandler;

  @Before
  public void setup() {
    limitedCardHandler = new LimitedHandler<>();
  }

  @Test
  public void shouldDecrementCardCounterWhenCalledHandle() {
    when(limitedCard.getCounter()).thenReturn(CARD_STARTER_COUNTER_VALUE);

    limitedCardHandler.handle(limitedCard);

    verify(limitedCard).setCounter(CARD_DECREMENTED_COUNTER_VALUE);

  }
}