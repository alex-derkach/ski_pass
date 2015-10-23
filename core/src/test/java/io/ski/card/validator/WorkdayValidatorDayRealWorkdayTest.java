package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.support.validation.ValidationResult;
import io.ski.util.day.AbstractDayRealWorkdayTest;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;

public class WorkdayValidatorDayRealWorkdayTest extends AbstractDayRealWorkdayTest {

  protected WorkdayValidator<Card> validator;
  protected ValidationResult validationResult;

  // pass data to parent
  public WorkdayValidatorDayRealWorkdayTest(LocalDate realWorkday) {
    super(realWorkday);
  }

  @Before
  public void before() {
    validator = new WorkdayValidator<>(getClock());
    validationResult = new ValidationResult();
  }

  @Test
  public void shouldNotAddErrorOnRealWorkday() {
    validateOnRealWorkday(validator, validationResult);

    assertFalse(validationResult.hasErrors());
  }
}