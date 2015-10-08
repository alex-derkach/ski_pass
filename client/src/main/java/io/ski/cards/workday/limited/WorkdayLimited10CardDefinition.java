package io.ski.cards.workday.limited;

import io.ski.cards.workday.limited.support.AbstractWorkdayLimitedCardDefinition;

public class WorkdayLimited10CardDefinition extends AbstractWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = WorkdayLimited10CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 10L;

  public WorkdayLimited10CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
