package io.ski.card.validator;

import io.ski.card.Card;
import io.ski.support.validation.BindingResult;
import io.ski.util.day.AbstractDayRealWorkdayTest;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class NotWorkdayValidatorDayRealWorkdayTest extends AbstractDayRealWorkdayTest {

  private NotWorkdayValidator<Card> validator;
  private BindingResult bindingResult;

  // pass data to parent
  public NotWorkdayValidatorDayRealWorkdayTest(LocalDate realWorkday) {
    super(realWorkday);
  }

  @Before
  public void before() {
    validator = new NotWorkdayValidator<>(getClock());
    bindingResult = new BindingResult();
  }

  @Test
  public void shouldAddErrorOnRealWorkday() {
    validateOnRealWorkday(validator, bindingResult);

    assertTrue(bindingResult.hasErrors());
  }
}