package io.ski.util;

import io.ski.card.Card;
import io.ski.card.Validator;
import io.ski.card.validator.support.HolidayResolverAware;

public interface HolidayResolverAwareValidator extends Validator<Card>, HolidayResolverAware {
}
