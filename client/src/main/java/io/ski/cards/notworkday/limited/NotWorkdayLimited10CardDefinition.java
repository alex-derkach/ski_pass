package io.ski.cards.notworkday.limited;

import io.ski.cards.notworkday.limited.support.AbstractNotWorkdayLimitedCardDefinition;

public class NotWorkdayLimited10CardDefinition extends AbstractNotWorkdayLimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayLimited10CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 10L;

  public NotWorkdayLimited10CardDefinition() {
    super(CARD_TYPE, TRIP_COUNT);
  }
}
