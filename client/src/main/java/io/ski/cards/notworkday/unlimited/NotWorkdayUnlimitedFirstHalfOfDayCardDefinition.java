package io.ski.cards.notworkday.unlimited;

import io.ski.cards.notworkday.unlimited.support.AbstractNotWorkdayUnlimitedCardDefinition;

public class NotWorkdayUnlimitedFirstHalfOfDayCardDefinition extends AbstractNotWorkdayUnlimitedCardDefinition {

  private static final String CARD_DISCRIMINATOR = NotWorkdayUnlimitedFirstHalfOfDayCardDefinition.class.getSimpleName();
  private static final int START_HOUR = 9;
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
