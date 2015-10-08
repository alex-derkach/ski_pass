package io.ski.support.validation;

import java.time.LocalDate;
import java.time.Month;

import static java.time.LocalDate.of;

public enum DefaultHolidays {
  CHRISTMAS(of(2015, Month.APRIL, 21));

  private final LocalDate date;

  DefaultHolidays(LocalDate date) {
    this.date = date;
  }

  public LocalDate getDate() {
    return date;
  }
}