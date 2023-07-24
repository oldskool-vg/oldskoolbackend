package com.cfVanguardBackend.oldskoolbackend.exceptions;

public class CardNotFoundException extends RuntimeException{
  private static final String MESSAGE = "Could not find card with name: %s";

  public CardNotFoundException(String name) {
    super(String.format(MESSAGE, name));
  }
}
