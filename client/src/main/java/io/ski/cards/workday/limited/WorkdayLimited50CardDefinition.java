package io.ski.cards.workday.limited;

import io.ski.cards.workday.limited.support.AbstractWorkdayLimitedCardDefinition;

public class WorkdayLimited50CardDefinition extends AbstractWorkdayLimitedCardDefinition {

  public static final String CARD_DISCRIMINATOR = WorkdayLimited50CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 50L;

  @Override
  public Long getTripCount() {
    return TRIP_COUNT;
  }

  @Override
  public String getDiscriminator() {
    return CARD_DISCRIMINATOR;
  }
}
