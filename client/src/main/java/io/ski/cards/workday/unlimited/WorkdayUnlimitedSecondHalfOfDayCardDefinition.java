package io.ski.cards.workday.unlimited;

import io.ski.cards.workday.unlimited.support.AbstractWorkdayUnlimitedCardDefinition;

public class WorkdayUnlimitedSecondHalfOfDayCardDefinition extends AbstractWorkdayUnlimitedCardDefinition {

  private static final String CARD_DISCRIMINATOR = WorkdayUnlimitedSecondHalfOfDayCardDefinition.class.getSimpleName();
  private static final int START_HOUR = 13;
  private static final int CARD_VALIDITY_HOURS = 4;

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
