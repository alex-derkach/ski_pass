package io.ski.cards.notworkday.limited.support;

import io.ski.card.ComplexValidator;
import io.ski.card.type.LimitedCard;
import io.ski.card.validator.BlockedValidator;
import io.ski.card.validator.LimitedValidator;
import io.ski.card.validator.NotWorkdayValidator;
import io.ski.card.validator.support.HolidayResolverAware;
import io.ski.support.validation.HolidayResolver;

public class NotWorkdayLimitedComplexValidator<T extends LimitedCard> extends ComplexValidator<T> implements HolidayResolverAware {

  @Override
  protected void registerValidators() {
    registerValidators(
        new BlockedValidator<>(),
        new LimitedValidator<>(),
        new NotWorkdayValidator<>()
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
