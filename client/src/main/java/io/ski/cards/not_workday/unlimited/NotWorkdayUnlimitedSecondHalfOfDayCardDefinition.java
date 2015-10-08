package io.ski.cards.not_workday.unlimited;

import io.ski.cards.not_workday.unlimited.support.AbstractNotWorkdayUnlimitedCardDefinition;

public class NotWorkdayUnlimitedSecondHalfOfDayCardDefinition extends AbstractNotWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayUnlimitedSecondHalfOfDayCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 13;
  public static final int CARD_VALIDITY_HOURS = 4;

  public NotWorkdayUnlimitedSecondHalfOfDayCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
