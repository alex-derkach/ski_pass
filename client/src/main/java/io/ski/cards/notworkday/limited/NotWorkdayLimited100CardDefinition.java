package io.ski.cards.notworkday.limited;

import io.ski.cards.notworkday.limited.support.AbstractNotWorkdayLimitedCardDefinition;

public class NotWorkdayLimited100CardDefinition extends AbstractNotWorkdayLimitedCardDefinition {

  public static final String CARD_DISCRIMINATOR = NotWorkdayLimited100CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 100L;

  @Override
  protected Long getTripCount() {
    return TRIP_COUNT;
  }

  @Override
  public String getDiscriminator() {
    return CARD_DISCRIMINATOR;
  }
}
