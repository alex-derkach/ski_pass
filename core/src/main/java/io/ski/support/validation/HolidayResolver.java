package io.ski.support.validation;

import java.time.LocalDate;

public interface HolidayResolver {
  boolean isHoliday(LocalDate date);
}
