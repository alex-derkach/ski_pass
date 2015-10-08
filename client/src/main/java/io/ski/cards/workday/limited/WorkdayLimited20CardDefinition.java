package io.ski.cards.workday.limited;

import io.ski.cards.workday.limited.support.AbstractWorkdayLimitedCardDefinition;

public class WorkdayLimited20CardDefinition extends AbstractWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = WorkdayLimited20CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 20L;

  public WorkdayLimited20CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
