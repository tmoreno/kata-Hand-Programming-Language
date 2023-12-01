package com.tmoreno.kata.handpl;

public final class Memory {

  private int currentValuePosition;
  private int currentPointerPosition;

  public Memory() {
    currentValuePosition = 0;
    currentPointerPosition = 0;
  }

  public void increment() {
    currentValuePosition = Math.floorMod(currentValuePosition + 1, 256);
  }

  public void decrement() {
    currentValuePosition = Math.floorMod(currentValuePosition - 1, 256);
  }

  public void incrementPointer() {
    currentPointerPosition++;
  }

  public char currentValuePosition() {
    return (char) currentValuePosition;
  }

  public int currentPointerPosition() {
    return currentPointerPosition;
  }
}
