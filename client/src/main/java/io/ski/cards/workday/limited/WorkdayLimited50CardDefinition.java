package io.ski.cards.workday.limited;

import io.ski.cards.workday.limited.support.AbstractWorkdayLimitedCardDefinition;

public class WorkdayLimited50CardDefinition extends AbstractWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = WorkdayLimited50CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 50L;

  public WorkdayLimited50CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
