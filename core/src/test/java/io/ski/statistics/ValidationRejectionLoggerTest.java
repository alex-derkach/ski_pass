package io.ski.statistics;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.Card;
import io.ski.statistics.domain.PassEvent;
import io.ski.statistics.repository.PassEventRepository;
import io.ski.support.validation.BindingResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ValidationRejectionLoggerTest extends AbstractMockitoTest {

  private static final String ERROR_MESSAGE = "Some error";

  @Mock private PassEventRepository passEventRepository;
  @Mock private Card card;

  private ValidationRejectionLogger logger;
  private BindingResult bindingResult;

  @Before
  public void setup() {
    logger = new ValidationRejectionLogger(passEventRepository);
    bindingResult = new BindingResult();
  }

  @Test
  public void shouldPersistEventWhenCalledWithErrors() {
    bindingResult.reject(ERROR_MESSAGE);

    logger.postValidation(card, bindingResult);

    verify(passEventRepository).persist(any(PassEvent.class));
  }

  @Test
  public void shouldNotPersistEventWhenCalledWithoutErrors() {
    logger.postValidation(card, bindingResult);

    verifyNoMoreInteractions(passEventRepository);
  }
}