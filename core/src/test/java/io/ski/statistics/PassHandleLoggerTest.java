package io.ski.statistics;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.Card;
import io.ski.statistics.domain.PassEvent;
import io.ski.statistics.repository.PassEventRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class PassHandleLoggerTest extends AbstractMockitoTest {

  @Mock private PassEventRepository passEventRepository;
  @Mock private Card card;

  private HandleLogger logger;

  @Before
  public void setup() {
    logger = new HandleLogger(passEventRepository);
  }

  @Test
  public void shouldPersistEventWhenCalled() {
    logger.postHandle(card);

    verify(passEventRepository).persist(any(PassEvent.class));
  }

}