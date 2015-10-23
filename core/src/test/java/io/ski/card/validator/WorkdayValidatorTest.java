package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.support.validation.ValidationResult;
import io.ski.util.day.AbstractDayValidatorTest;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.Clock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WorkdayValidatorTest extends AbstractDayValidatorTest {

  protected WorkdayValidator<Card> validator;
  protected ValidationResult validationResult;

  @Before
  public void before() {
    validator = new WorkdayValidator<>(getClock());
    validationResult = new ValidationResult();
  }

  @Test
  public void shouldAddErrorOnSaturday() {
    validateOnSaturday(validator, validationResult);

    assertTrue(validationResult.hasErrors());
  }

  @Test
  public void shouldAddErrorOnSunday() {
    validateOnSunday(validator, validationResult);

    assertTrue(validationResult.hasErrors());
  }

  @Test
  public void shouldAddErrorOnHoliday() {
    validateOnHoliday(validator, validationResult);

    assertTrue(validationResult.hasErrors());
  }

  @Test
  public void shouldInstantiateWithSystemDefaultZoneClockByDefault() throws NoSuchFieldException, IllegalAccessException {
    WorkdayValidator<Card> workdayValidator = new WorkdayValidator<>();
    Field clockField = workdayValidator.getClass().getDeclaredField("clock");
    clockField.setAccessible(true);
    Clock givenClock = (Clock) clockField.get(workdayValidator);
    assertEquals(Clock.systemDefaultZone(), givenClock);
  }
}