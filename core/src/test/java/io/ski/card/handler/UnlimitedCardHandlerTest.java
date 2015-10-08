package io.ski.card.handler;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.type.UnlimitedCard;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verifyZeroInteractions;

public class UnlimitedCardHandlerTest extends AbstractMockitoTest {

  @Mock
  private UnlimitedCard unlimitedCard;

  private UnlimitedHandler<UnlimitedCard> unlimitedCardHandler;

  @Before
  public void setup() {
    unlimitedCardHandler = new UnlimitedHandler<>();
  }

  @Test
  public void shouldNotModifyCardWhenCalledHandle() throws Exception {
    unlimitedCardHandler.handle(unlimitedCard);

    verifyZeroInteractions(unlimitedCard);
  }
}