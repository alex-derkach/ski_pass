package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.support.validation.BindingResult;
import io.ski.util.day.AbstractDayValidatorTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class WorkdayValidatorTest extends AbstractDayValidatorTest {

  protected WorkdayValidator<Card> validator;
  protected BindingResult bindingResult;

  @Before
  public void before() {
    validator = new WorkdayValidator<>(getClock());
    bindingResult = new BindingResult();
  }

  @Test
  public void shouldAddErrorOnSaturday() {
    validateOnSaturday(validator, bindingResult);

    assertTrue(bindingResult.hasErrors());
  }

  @Test
  public void shouldAddErrorOnSunday() {
    validateOnSunday(validator, bindingResult);

    assertTrue(bindingResult.hasErrors());
  }

  @Test
  public void shouldAddErrorOnHoliday() {
    validateOnHoliday(validator, bindingResult);

    assertTrue(bindingResult.hasErrors());
  }

  @Test
  public void shouldNotThrowExceptionWhenCalledDefaultConstructor() {
    try {
      new WorkdayValidator<>();
    } catch (Exception exception) {
      fail("Unexpected exception occurred during construction: " + exception.getMessage());
    }
  }
}