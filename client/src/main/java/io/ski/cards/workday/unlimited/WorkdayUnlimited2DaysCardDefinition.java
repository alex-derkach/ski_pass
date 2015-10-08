package io.ski.cards.workday.unlimited;

import io.ski.cards.workday.unlimited.support.AbstractWorkdayUnlimitedCardDefinition;

public class WorkdayUnlimited2DaysCardDefinition extends AbstractWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = WorkdayUnlimited2DaysCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 9;
  public static final int CARD_VALIDITY_HOURS = 24 * 2;

  public WorkdayUnlimited2DaysCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
