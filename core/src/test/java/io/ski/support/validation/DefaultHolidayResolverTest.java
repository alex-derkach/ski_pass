package io.ski.support.validation;

import io.ski.util.AbstractMockitoTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DefaultHolidayResolverTest extends AbstractMockitoTest {

  private DefaultHolidayResolver defaultHolidayResolver;

  @Before
  public void setup() {
    defaultHolidayResolver = new DefaultHolidayResolver();
  }

  @Test
  public void shouldConsiderChristmasAsHoliday() {
    assertTrue(defaultHolidayResolver.isHoliday(DefaultHolidays.CHRISTMAS.getDate()));
  }

}