package io.ski.cards.workday.limited;

import io.ski.cards.workday.limited.support.AbstractWorkdayLimitedCardDefinition;

public class WorkdayLimited10CardDefinition extends AbstractWorkdayLimitedCardDefinition {

  private static final String CARD_DISCRIMINATOR = WorkdayLimited10CardDefinition.class.getSimpleName();
  private static final long TRIP_COUNT = 10L;

  @Override
  public Long getTripCount() {
    return TRIP_COUNT;
  }

  @Override
  public String getDiscriminator() {
    return CARD_DISCRIMINATOR;
  }
}
