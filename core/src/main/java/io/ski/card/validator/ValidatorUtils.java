package io.ski.card.validator;

import io.ski.support.validation.HolidayResolver;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ValidatorUtils {

  private ValidatorUtils() {
  }

  public static boolean isNotWorkingDay(HolidayResolver holidayResolver, LocalDate localDate) {
    DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    return dayOfWeek.equals(DayOfWeek.SATURDAY)
        || dayOfWeek.equals(DayOfWeek.SUNDAY)
        || (holidayResolver != null && holidayResolver.isHoliday(localDate));
  }

  public static boolean isWorkingDay(HolidayResolver holidayResolver, LocalDate localDate) {
    return !isNotWorkingDay(holidayResolver, localDate);
  }
}
