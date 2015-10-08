package io.ski.util.day;

import io.ski.card.Card;
import io.ski.card.Validator;
import io.ski.card.validator.support.HolidayResolverAware;
import io.ski.support.validation.BindingResult;
import io.ski.support.validation.HolidayResolver;
import io.ski.util.AbstractMockitoTest;
import org.junit.Before;
import org.mockito.Mock;

import java.time.*;

import static org.mockito.Mockito.when;

public abstract class AbstractDayValidatorTest extends AbstractMockitoTest {

  private static final LocalDate SATURDAY_DATE = LocalDate.of(2015, Month.OCTOBER, 3);
  private static final LocalDate SUNDAY_DATE = LocalDate.of(2015, Month.OCTOBER, 4);
  private static final LocalDate HOLIDAY_DATE = LocalDate.of(2015, Month.DECEMBER, 25);

  private static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("UTC");

  @Mock private Card card;
  @Mock private Clock clock;
  @Mock private HolidayResolver holidayResolver;

  @Before
  public void setup() {
    when(clock.getZone()).thenReturn(DEFAULT_ZONE_ID);
  }

  protected void validateOnSaturday(Validator<Card> validator, BindingResult bindingResult) {
    Instant saturdayInstant = DayUtils.dateToInstant(SATURDAY_DATE);
    when(clock.instant()).thenReturn(saturdayInstant);

    validator.validate(card, bindingResult);
  }

  protected void validateOnSunday(Validator<Card> validator, BindingResult bindingResult) {
    Instant sundayInstant = DayUtils.dateToInstant(SUNDAY_DATE);
    when(clock.instant()).thenReturn(sundayInstant);

    validator.validate(card, bindingResult);
  }

  protected void validateOnHoliday(Validator<Card> validator, BindingResult bindingResult) {
    Instant saturdayInstant = DayUtils.dateToInstant(HOLIDAY_DATE);
    when(clock.instant()).thenReturn(saturdayInstant);
    when(holidayResolver.isHoliday(HOLIDAY_DATE)).thenReturn(true);

    ((HolidayResolverAware)validator).setHolidayResolver(holidayResolver);

    validator.validate(card, bindingResult);
  }

  protected Clock getClock() {
    return clock;
  }
}
