package io.ski.card.validator.support;

import io.ski.support.validation.HolidayResolver;

public interface HolidayResolverAware {
  void setHolidayResolver(HolidayResolver holidayResolver);
}
