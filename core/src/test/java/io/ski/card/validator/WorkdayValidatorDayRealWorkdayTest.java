package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.support.validation.BindingResult;
import io.ski.util.day.AbstractDayRealWorkdayTest;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;

public class WorkdayValidatorDayRealWorkdayTest extends AbstractDayRealWorkdayTest {

  protected WorkdayValidator<Card> validator;
  protected BindingResult bindingResult;

  // pass data to parent
  public WorkdayValidatorDayRealWorkdayTest(LocalDate realWorkday) {
    super(realWorkday);
  }

  @Before
  public void before() {
    validator = new WorkdayValidator<>(getClock());
    bindingResult = new BindingResult();
  }

  @Test
  public void shouldNotAddErrorOnRealWorkday() {
    validateOnRealWorkday(validator, bindingResult);

    assertFalse(bindingResult.hasErrors());
  }
}