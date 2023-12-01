package com.tmoreno.kata.handpl;

public final class Memory {

  private int currentValuePosition;

  public Memory() {
    currentValuePosition = 0;
  }

  public void increment() {
    currentValuePosition = (currentValuePosition + 1) % 256;
  }

  public void decrement() {
    throw new UnsupportedOperationException();
  }

  public char currentValuePosition() {
    return (char) currentValuePosition;
  }
}
