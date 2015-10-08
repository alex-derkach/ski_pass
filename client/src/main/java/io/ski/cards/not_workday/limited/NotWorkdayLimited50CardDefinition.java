package io.ski.cards.not_workday.limited;

import io.ski.cards.not_workday.limited.support.AbstractNotWorkdayLimitedCardDefinition;

public class NotWorkdayLimited50CardDefinition extends AbstractNotWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayLimited50CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 50L;

  public NotWorkdayLimited50CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
