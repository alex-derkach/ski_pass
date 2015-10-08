package io.ski.repository.generator;

public class AutoIncrementationIdentifierGenerator implements IdentifierGenerator {

  private static final long DEFAULT_COUNTER_VALUE = 0L;

  private Long counter;

  public AutoIncrementationIdentifierGenerator() {
    this.counter = DEFAULT_COUNTER_VALUE;
  }

  @Override
  public Long generate() {
    return ++counter;
  }

  public Long getCounter() {
    return counter;
  }
}
