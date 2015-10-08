package io.ski.cards.workday.unlimited;

import io.ski.cards.workday.unlimited.support.AbstractWorkdayUnlimitedCardDefinition;

public class WorkdayUnlimitedSecondHalfOfDayCardDefinition extends AbstractWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = WorkdayUnlimitedSecondHalfOfDayCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 13;
  public static final int CARD_VALIDITY_HOURS = 4;

  public WorkdayUnlimitedSecondHalfOfDayCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
