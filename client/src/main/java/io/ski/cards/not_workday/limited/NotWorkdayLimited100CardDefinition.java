package io.ski.cards.not_workday.limited;

import io.ski.cards.not_workday.limited.support.AbstractNotWorkdayLimitedCardDefinition;

public class NotWorkdayLimited100CardDefinition extends AbstractNotWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayLimited100CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 100L;

  public NotWorkdayLimited100CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
