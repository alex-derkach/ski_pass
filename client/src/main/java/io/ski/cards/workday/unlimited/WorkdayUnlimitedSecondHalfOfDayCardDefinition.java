package io.ski.cards.workday.unlimited;

import io.ski.cards.workday.unlimited.support.AbstractWorkdayUnlimitedCardDefinition;

public class WorkdayUnlimitedSecondHalfOfDayCardDefinition extends AbstractWorkdayUnlimitedCardDefinition {

  public static final String CARD_DISCRIMINATOR = WorkdayUnlimitedSecondHalfOfDayCardDefinition.class.getSimpleName();
  public static final int START_HOUR = 13;
  public static final int CARD_VALIDITY_HOURS = 4;

  @Override
  protected int getStartHour() {
    return START_HOUR;
  }

  @Override
  protected int getValidityHours() {
    return CARD_VALIDITY_HOURS;
  }

  @Override
  public String getDiscriminator() {
    return CARD_DISCRIMINATOR;
  }
}
