package io.ski.cards.notworkday.limited;

import io.ski.cards.notworkday.limited.support.AbstractNotWorkdayLimitedCardDefinition;

public class NotWorkdayLimited10CardDefinition extends AbstractNotWorkdayLimitedCardDefinition {

  public static final String CARD_DISCRIMINATOR = NotWorkdayLimited10CardDefinition.class.getSimpleName();
  public static final long TRIP_COUNT = 10L;

  @Override
  protected Long getTripCount() {
    return TRIP_COUNT;
  }

  @Override
  public String getDiscriminator() {
    return CARD_DISCRIMINATOR;
  }
}
