package io.ski.card.validator;

import io.ski.util.AbstractMockitoTest;
import io.ski.card.type.UnlimitedCard;
import io.ski.support.validation.ValidationResult;
import io.ski.util.day.DayUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.lang.reflect.Field;
import java.time.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TimeRangeValidatorTest extends AbstractMockitoTest {

  private static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("UTC");

  private static final LocalDateTime TIME_MIDDLE_POINT = LocalDateTime.now();
  private static final LocalDateTime TIME_START_POINT = TIME_MIDDLE_POINT.minusHours(1);
  private static final LocalDateTime TIME_END_POINT = TIME_MIDDLE_POINT.plusHours(1);

  private static final LocalDateTime TIME_BEFORE_START_POINT = TIME_START_POINT.minusHours(1);
  private static final LocalDateTime TIME_AFTER_END_POINT = TIME_END_POINT.plusHours(1);

  @Mock private Clock clock;
  @Mock private UnlimitedCard card;

  private TimeRangeValidator<UnlimitedCard> validator;
  private ValidationResult validationResult;


  @Before
  public void setup() {
    validator = new TimeRangeValidator<>(clock);
    validationResult = new ValidationResult();

    when(clock.getZone()).thenReturn(DEFAULT_ZONE_ID);

    when(card.getStartPoint()).thenReturn(TIME_START_POINT);
    when(card.getEndPoint()).thenReturn(TIME_END_POINT);
  }

  @Test
  public void shouldConsiderTimeBeforeStartPointAsError() {
    Instant instant = DayUtils.dateTimeToInstant(TIME_BEFORE_START_POINT);
    when(clock.instant()).thenReturn(instant);

    validator.validate(card, validationResult);

    assertTrue(validationResult.hasErrors());
  }

  @Test
  public void shouldConsiderTimeStartPointAsGood() {
    Instant instant = DayUtils.dateTimeToInstant(TIME_START_POINT);
    when(clock.instant()).thenReturn(instant);

    validator.validate(card, validationResult);

    assertFalse(validationResult.hasErrors());
  }

  @Test
  public void shouldConsiderTimeMiddlePointAsGood() {
    Instant instant = DayUtils.dateTimeToInstant(TIME_MIDDLE_POINT);
    when(clock.instant()).thenReturn(instant);

    validator.validate(card, validationResult);

    assertFalse(validationResult.hasErrors());
  }

  @Test
  public void shouldConsiderTimeEndPointAsGood() {
    Instant instant = DayUtils.dateTimeToInstant(TIME_END_POINT);
    when(clock.instant()).thenReturn(instant);

    validator.validate(card, validationResult);

    assertFalse(validationResult.hasErrors());
  }

  @Test
  public void shouldConsiderTimeAfterEndPointAsError() {
    Instant instant = DayUtils.dateTimeToInstant(TIME_AFTER_END_POINT);
    when(clock.instant()).thenReturn(instant);

    validator.validate(card, validationResult);

    assertTrue(validationResult.hasErrors());
  }

  @Test
  public void shouldInstantiateWithSystemDefaultZoneClockByDefault() throws NoSuchFieldException, IllegalAccessException {
      TimeRangeValidator<UnlimitedCard> timeRangeValidator = new TimeRangeValidator<>();
      Field clockField = timeRangeValidator.getClass().getDeclaredField("clock");
      clockField.setAccessible(true);
      Clock givenClock = (Clock) clockField.get(timeRangeValidator);
      assertEquals(Clock.systemDefaultZone(), givenClock);
  }
}