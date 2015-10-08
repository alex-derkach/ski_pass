package io.ski.card.validator;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.type.LimitedCard;
import io.ski.support.validation.BindingResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LimitedValidatorTest extends AbstractMockitoTest {

  private static final long LESS_THAN_ZERO_TRIPS_COUNT = -1000L;
  private static final long ZERO_TRIPS_COUNT = 0L;
  private static final long ONE_TRIP_COUNT = 1L;
  private static final long MORE_THAN_ONE_TRIP_COUNT = 1000L;

  @Mock
  private LimitedCard card;

  private LimitedValidator<LimitedCard> validator;
  private BindingResult bindingResult;

  @Before
  public void setup() {
    validator = new LimitedValidator<>();
    bindingResult = new BindingResult();
  }

  @Test
  public void shouldAddErrorWhenCardHasLessThanZeroTripsLeft() {
    when(card.getCounter()).thenReturn(LESS_THAN_ZERO_TRIPS_COUNT);

    validator.validate(card, bindingResult);

    assertTrue(bindingResult.hasErrors());
  }

  @Test
  public void shouldAddErrorWhenCardHasZeroTripsLeft() {
    when(card.getCounter()).thenReturn(ZERO_TRIPS_COUNT);

    validator.validate(card, bindingResult);

    assertTrue(bindingResult.hasErrors());
  }

  @Test
  public void shouldNotAddErrorWhenCardHasOneTripLeft() {
    when(card.getCounter()).thenReturn(ONE_TRIP_COUNT);

    validator.validate(card, bindingResult);

    assertFalse(bindingResult.hasErrors());
  }

  @Test
  public void shouldNotAddErrorWhenCardHasMoreThanOneTripLeft() {
    when(card.getCounter()).thenReturn(MORE_THAN_ONE_TRIP_COUNT);

    validator.validate(card, bindingResult);

    assertFalse(bindingResult.hasErrors());
  }
}