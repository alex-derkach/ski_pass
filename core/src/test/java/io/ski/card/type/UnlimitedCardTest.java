package io.ski.card.type;

import junitx.extensions.EqualsHashCodeTestCase;

import java.time.LocalDateTime;
import java.time.Month;

public class UnlimitedCardTest extends EqualsHashCodeTestCase {

  private static final String PRIMARY_CARD_DISCRIMINATOR = "primaryCard";
  private static final long PRIMARY_CARD_ID = 1L;
  private static final boolean PRIMARY_CARD_BLOCKED_STATUS = false;
  private static final LocalDateTime PRIMARY_CARD_START_POINT = LocalDateTime.of(2015, Month.JANUARY, 1, 0, 0);
  private static final LocalDateTime PRIMARY_CARD_END_POINT = LocalDateTime.of(2015, Month.FEBRUARY, 1, 0, 0);

  private static final String OTHER_CARD_DISCRIMINATOR = "otherCard";
  private static final long OTHER_CARD_ID = 2L;
  private static final boolean OTHER_CARD_BLOCKED_STATUS = false;
  private static final LocalDateTime OTHER_CARD_START_POINT = LocalDateTime.of(2015, Month.JULY, 1, 0, 0);
  private static final LocalDateTime OTHER_CARD_END_POINT = LocalDateTime.of(2015, Month.AUGUST, 1, 0, 0);

  public UnlimitedCardTest() {
    super(UnlimitedCardTest.class.getCanonicalName());
  }

  @Override
  protected Object createInstance() throws Exception {
    UnlimitedCard primaryCard = new UnlimitedCard(PRIMARY_CARD_DISCRIMINATOR);
    primaryCard.setId(PRIMARY_CARD_ID);
    primaryCard.setBlocked(PRIMARY_CARD_BLOCKED_STATUS);
    primaryCard.setStartPoint(PRIMARY_CARD_START_POINT);
    primaryCard.setEndPoint(PRIMARY_CARD_END_POINT);
    return primaryCard;
  }

  @Override
  protected Object createNotEqualInstance() throws Exception {
    UnlimitedCard otherCard = new UnlimitedCard(OTHER_CARD_DISCRIMINATOR);
    otherCard.setId(OTHER_CARD_ID);
    otherCard.setBlocked(OTHER_CARD_BLOCKED_STATUS);
    otherCard.setStartPoint(OTHER_CARD_START_POINT);
    otherCard.setEndPoint(OTHER_CARD_END_POINT);
    return otherCard;
  }
}