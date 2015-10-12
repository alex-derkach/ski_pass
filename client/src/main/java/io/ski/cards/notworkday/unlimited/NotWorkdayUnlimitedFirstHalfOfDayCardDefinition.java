package io.ski.cards.notworkday.unlimited;

import io.ski.cards.notworkday.unlimited.support.AbstractNotWorkdayUnlimitedCardDefinition;

public class NotWorkdayUnlimitedFirstHalfOfDayCardDefinition extends AbstractNotWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayUnlimitedFirstHalfOfDayCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 9;
  public static final int CARD_VALIDITY_HOURS = 4;

  public NotWorkdayUnlimitedFirstHalfOfDayCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
