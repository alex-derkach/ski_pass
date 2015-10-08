package io.ski.cards.workday.unlimited;

import io.ski.cards.workday.unlimited.support.AbstractWorkdayUnlimitedCardDefinition;

public class WorkdayUnlimited1DayCardDefinition extends AbstractWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = WorkdayUnlimited1DayCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 9;
  public static final int CARD_VALIDITY_HOURS = 24;

  public WorkdayUnlimited1DayCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
