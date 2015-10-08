package io.ski.exception;

public class UnregisteredCardTypeException extends RuntimeException {
  public UnregisteredCardTypeException(String cardType) {
    super(String.format("Card of type %s is not registered in the system", cardType));
  }
}
