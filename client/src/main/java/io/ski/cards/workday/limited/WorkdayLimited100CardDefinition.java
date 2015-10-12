package io.ski.cards.workday.limited;

import io.ski.cards.workday.limited.support.AbstractWorkdayLimitedCardDefinition;

public class WorkdayLimited100CardDefinition extends AbstractWorkdayLimitedCardDefinition {

  public static final String CARD_DISCRIMINATOR = WorkdayLimited100CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 100L;

  @Override
  public Long getTripCount() {
    return TRIP_COUNT;
  }

  @Override
  public String getDiscriminator() {
    return CARD_DISCRIMINATOR;
  }
}
