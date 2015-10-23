package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.support.validation.ValidationResult;
import io.ski.util.day.AbstractDayRealWorkdayTest;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class NotWorkdayValidatorDayRealWorkdayTest extends AbstractDayRealWorkdayTest {

  private NotWorkdayValidator<Card> validator;
  private ValidationResult validationResult;

  // pass data to parent
  public NotWorkdayValidatorDayRealWorkdayTest(LocalDate realWorkday) {
    super(realWorkday);
  }

  @Before
  public void before() {
    validator = new NotWorkdayValidator<>(getClock());
    validationResult = new ValidationResult();
  }

  @Test
  public void shouldAddErrorOnRealWorkday() {
    validateOnRealWorkday(validator, validationResult);

    assertTrue(validationResult.hasErrors());
  }
}