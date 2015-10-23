package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.support.validation.ValidationResult;
import io.ski.util.day.AbstractDayValidatorTest;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.Clock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class NotWorkdayValidatorTest extends AbstractDayValidatorTest {

  private NotWorkdayValidator<Card> validator;
  private ValidationResult validationResult;

  @Before
  public void before() {
    validator = new NotWorkdayValidator<>(getClock());
    validationResult = new ValidationResult();
  }

  @Test
  public void shouldNotAddErrorOnSaturday() {
    validateOnSaturday(validator, validationResult);

    assertFalse(validationResult.hasErrors());
  }

  @Test
  public void shouldNotAddErrorOnSunday() {
    validateOnSunday(validator, validationResult);

    assertFalse(validationResult.hasErrors());
  }

  @Test
  public void shouldNotAddErrorOnHoliday() {
    validateOnHoliday(validator, validationResult);

    assertFalse(validationResult.hasErrors());
  }

  @Test
  public void shouldInstantiateWithSystemDefaultZoneClockByDefault() throws NoSuchFieldException, IllegalAccessException {
    NotWorkdayValidator<Card> notWorkdayValidator = new NotWorkdayValidator<>();
    Field clockField = notWorkdayValidator.getClass().getDeclaredField("clock");
    clockField.setAccessible(true);
    Clock givenClock = (Clock) clockField.get(notWorkdayValidator);
    assertEquals(Clock.systemDefaultZone(), givenClock);
  }
}