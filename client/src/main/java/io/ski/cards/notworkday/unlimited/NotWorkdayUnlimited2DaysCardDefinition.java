package io.ski.cards.notworkday.unlimited;

import io.ski.cards.notworkday.unlimited.support.AbstractNotWorkdayUnlimitedCardDefinition;

public class NotWorkdayUnlimited2DaysCardDefinition extends AbstractNotWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayUnlimited2DaysCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 9;
  public static final int CARD_VALIDITY_HOURS = 24 * 2;

  public NotWorkdayUnlimited2DaysCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
