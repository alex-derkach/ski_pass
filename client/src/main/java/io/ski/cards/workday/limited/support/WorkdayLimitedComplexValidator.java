package io.ski.cards.workday.limited.support;

import io.ski.card.ComplexValidator;
import io.ski.card.type.LimitedCard;
import io.ski.card.validator.BlockedValidator;
import io.ski.card.validator.LimitedValidator;
import io.ski.card.validator.WorkdayValidator;
import io.ski.card.validator.support.HolidayResolverAware;
import io.ski.support.validation.HolidayResolver;

public class WorkdayLimitedComplexValidator<T extends LimitedCard> extends ComplexValidator<T> implements HolidayResolverAware {

  @Override
  protected void registerValidators() {
    registerValidators(
        new BlockedValidator<>(),
        new LimitedValidator<>(),
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
