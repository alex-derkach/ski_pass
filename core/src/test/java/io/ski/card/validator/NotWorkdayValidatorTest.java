package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.support.validation.BindingResult;
import io.ski.util.day.AbstractDayValidatorTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class NotWorkdayValidatorTest extends AbstractDayValidatorTest {

  private NotWorkdayValidator<Card> validator;
  private BindingResult bindingResult;

  @Before
  public void before() {
    validator = new NotWorkdayValidator<>(getClock());
    bindingResult = new BindingResult();
  }

  @Test
  public void shouldNotAddErrorOnSaturday() {
    validateOnSaturday(validator, bindingResult);

    assertFalse(bindingResult.hasErrors());
  }

  @Test
  public void shouldNotAddErrorOnSunday() {
    validateOnSunday(validator, bindingResult);

    assertFalse(bindingResult.hasErrors());
  }

  @Test
  public void shouldNotAddErrorOnHoliday() {
    validateOnHoliday(validator, bindingResult);

    assertFalse(bindingResult.hasErrors());
  }

  @Test
  public void shouldNotThrowExceptionWhenCalledDefaultConstructor() {
    try {
      new NotWorkdayValidator<>();
    } catch (Exception exception) {
      fail("Unexpected exception occurred during construction: " + exception.getMessage());
    }
  }
}