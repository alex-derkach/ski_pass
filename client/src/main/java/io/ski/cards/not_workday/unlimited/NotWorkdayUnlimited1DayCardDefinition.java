package io.ski.cards.not_workday.unlimited;

import io.ski.cards.not_workday.unlimited.support.AbstractNotWorkdayUnlimitedCardDefinition;

public class NotWorkdayUnlimited1DayCardDefinition extends AbstractNotWorkdayUnlimitedCardDefinition {

  public static final String CARD_TYPE = NotWorkdayUnlimited1DayCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 9;
  public static final int CARD_VALIDITY_HOURS = 24;

  public NotWorkdayUnlimited1DayCardDefinition() {
    super(CARD_TYPE, START_HOUR, CARD_VALIDITY_HOURS);
  }
}
