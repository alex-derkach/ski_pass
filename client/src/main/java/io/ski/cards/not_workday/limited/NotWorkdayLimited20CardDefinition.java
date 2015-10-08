package io.ski.cards.not_workday.limited;

import io.ski.cards.not_workday.limited.support.AbstractNotWorkdayLimitedCardDefinition;

public class NotWorkdayLimited20CardDefinition extends AbstractNotWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayLimited20CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 20L;

  public NotWorkdayLimited20CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
