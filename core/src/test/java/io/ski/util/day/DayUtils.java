package io.ski.util.day;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DayUtils {

  private static final ZoneOffset ZERO_ZONE_OFFSET = ZoneOffset.UTC;

  private DayUtils() {
  }

  public static Instant dateToInstant(LocalDate date) {
    return dateTimeToInstant(date.atStartOfDay());
  }

  public static Instant dateTimeToInstant(LocalDateTime time) {
    return time.toInstant(ZERO_ZONE_OFFSET);
  }
}
