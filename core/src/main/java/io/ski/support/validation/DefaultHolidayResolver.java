package io.ski.support.validation;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

public class DefaultHolidayResolver implements HolidayResolver {
  private static final Collection<DefaultHolidays> HOLIDAYS = Arrays.asList(DefaultHolidays.values());

  @Override
  public boolean isHoliday(LocalDate date) {
    return HOLIDAYS.stream().anyMatch(holiday -> holiday.getDate().equals(date));
  }
}
