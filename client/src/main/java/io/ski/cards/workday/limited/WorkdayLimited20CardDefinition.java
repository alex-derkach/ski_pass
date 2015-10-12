package io.ski.cards.workday.limited;

import io.ski.cards.workday.limited.support.AbstractWorkdayLimitedCardDefinition;

public class WorkdayLimited20CardDefinition extends AbstractWorkdayLimitedCardDefinition {

  private static final String CARD_DISCRIMINATOR = WorkdayLimited20CardDefinition.class.getSimpleName();
  private static final long TRIP_COUNT = 20L;

  @Override
  public Long getTripCount() {
    return TRIP_COUNT;
  }

  @Override
  public String getDiscriminator() {
    return CARD_DISCRIMINATOR;
  }
}
