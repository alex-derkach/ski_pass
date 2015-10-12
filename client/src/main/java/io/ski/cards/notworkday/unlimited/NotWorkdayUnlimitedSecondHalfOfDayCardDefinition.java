package io.ski.cards.notworkday.unlimited;

import io.ski.cards.notworkday.unlimited.support.AbstractNotWorkdayUnlimitedCardDefinition;

public class NotWorkdayUnlimitedSecondHalfOfDayCardDefinition extends AbstractNotWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayUnlimitedSecondHalfOfDayCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 13;
  public static final int CARD_VALIDITY_HOURS = 4;

  public NotWorkdayUnlimitedSecondHalfOfDayCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
