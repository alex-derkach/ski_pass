package io.ski.exception;

public class AlreadyRegisteredCardTypeException extends RuntimeException {
  public AlreadyRegisteredCardTypeException(String cardType) {
    super(String.format("Card of type %s is already registered in the system", cardType));
  }
}
