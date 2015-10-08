package io.ski.cards.workday.unlimited.support;

import io.ski.card.ComplexValidator;
import io.ski.card.type.UnlimitedCard;
import io.ski.card.validator.BlockedValidator;
import io.ski.card.validator.TimeRangeValidator;
import io.ski.card.validator.WorkdayValidator;
import io.ski.card.validator.support.HolidayResolverAware;
import io.ski.support.validation.HolidayResolver;

public class WorkdayUnlimitedComplexValidator<T extends UnlimitedCard> extends ComplexValidator<T> implements HolidayResolverAware {

  @Override
  protected void registerValidators() {
    registerValidators(
        new BlockedValidator<>(),
        new TimeRangeValidator<>(),
        new WorkdayValidator<>()
    );
  }

  @Override
  public void setHolidayResolver(HolidayResolver holidayResolver) {
    getValidators().parallelStream().forEach(validator -> {
      if (validator instanceof HolidayResolverAware) {
        ((HolidayResolverAware) validator).setHolidayResolver(holidayResolver);
      }
    });
  }
}
