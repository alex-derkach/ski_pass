package io.ski.cards.notworkday.limited;

import io.ski.cards.notworkday.limited.support.AbstractNotWorkdayLimitedCardDefinition;

public class NotWorkdayLimited50CardDefinition extends AbstractNotWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayLimited50CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 50L;

  public NotWorkdayLimited50CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
