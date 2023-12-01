package com.tmoreno.kata.handpl;

public final class Memory {

  private int currentValuePosition;

  public Memory() {
    currentValuePosition = 0;
  }

  public void increment() {
    currentValuePosition = (currentValuePosition + 1) % 255;
  }

  public char currentValuePosition() {
    return (char) currentValuePosition;
  }
}
