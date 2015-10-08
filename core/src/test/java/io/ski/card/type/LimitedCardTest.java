package io.ski.card.type;

import junitx.extensions.EqualsHashCodeTestCase;

public class LimitedCardTest extends EqualsHashCodeTestCase {

  private static final String PRIMARY_CARD_DISCRIMINATOR = "primaryCard";
  private static final long PRIMARY_CARD_ID = 1L;
  private static final boolean PRIMARY_CARD_BLOCKED_STATUS = false;
  private static final long PRIMARY_CARD_COUNTER = 1L;

  private static final String OTHER_CARD_DISCRIMINATOR = "otherCard";
  private static final long OTHER_CARD_ID = 2L;
  private static final boolean OTHER_CARD_BLOCKED_STATUS = false;
  private static final long OTHER_CARD_COUNTER = 2L;

  public LimitedCardTest() {
    super(LimitedCardTest.class.getCanonicalName());
  }

  @Override
  protected Object createInstance() throws Exception {
    LimitedCard primaryCard = new LimitedCard(PRIMARY_CARD_DISCRIMINATOR);
    primaryCard.setId(PRIMARY_CARD_ID);
    primaryCard.setBlocked(PRIMARY_CARD_BLOCKED_STATUS);
    primaryCard.setCounter(PRIMARY_CARD_COUNTER);
    return primaryCard;
  }

  @Override
  protected Object createNotEqualInstance() throws Exception {
    LimitedCard otherCard = new LimitedCard(OTHER_CARD_DISCRIMINATOR);
    otherCard.setId(OTHER_CARD_ID);
    otherCard.setBlocked(OTHER_CARD_BLOCKED_STATUS);
    otherCard.setCounter(OTHER_CARD_COUNTER);
    return otherCard;
  }
}