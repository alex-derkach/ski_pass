package io.ski.cards.workday.limited;

import io.ski.cards.workday.limited.support.AbstractWorkdayLimitedCardDefinition;

public class WorkdayLimited100CardDefinition extends AbstractWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = WorkdayLimited100CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 100L;

  public WorkdayLimited100CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
