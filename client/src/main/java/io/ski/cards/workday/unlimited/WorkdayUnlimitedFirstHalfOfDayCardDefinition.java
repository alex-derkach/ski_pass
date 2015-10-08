package io.ski.cards.workday.unlimited;

import io.ski.cards.workday.unlimited.support.AbstractWorkdayUnlimitedCardDefinition;

public class WorkdayUnlimitedFirstHalfOfDayCardDefinition extends AbstractWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = WorkdayUnlimitedFirstHalfOfDayCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 9;
  public static final int CARD_VALIDITY_HOURS = 4;

  public WorkdayUnlimitedFirstHalfOfDayCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
