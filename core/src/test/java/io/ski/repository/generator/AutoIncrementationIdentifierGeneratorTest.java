package io.ski.repository.generator;

import io.ski.util.AbstractMockitoTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutoIncrementationIdentifierGeneratorTest extends AbstractMockitoTest {

  private static final long DEFAULT_COUNTER_VALUE = 0L;
  private static final long INCREMENTED_DEFAULT_COUNTER_VALUE = DEFAULT_COUNTER_VALUE + 1;


  private AutoIncrementationIdentifierGenerator generator;

  @Before
  public void setup() {
    generator = new AutoIncrementationIdentifierGenerator();
  }

  @Test
  public void shouldIncrementCounterWhenCalledGenerate() {
    generator.generate();
    assertEquals(generator.getCounter().longValue(), INCREMENTED_DEFAULT_COUNTER_VALUE);
  }

  @Test
  public void shouldHaveDefaultCounterValueZero() {
    assertEquals(generator.getCounter().longValue(), DEFAULT_COUNTER_VALUE);
  }
}