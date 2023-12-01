package com.tmoreno.kata.handpl;

import java.util.ArrayList;
import java.util.List;

public final class Memory {

  private final List<Integer> values;
  private int currentValuePosition;
  private int currentPointerPosition;

  public Memory() {
    currentValuePosition = 0;
    currentPointerPosition = 0;
    values = new ArrayList<>();
    values.add(0);
  }

  public void increment() {
    int currentValue = values.get(currentPointerPosition);
    int newValue = Math.floorMod(currentValue + 1, 256);
    values.set(currentPointerPosition, newValue);
  }

  public void decrement() {
    int currentValue = values.get(currentPointerPosition);
    int newValue = Math.floorMod(currentValue - 1, 256);
    values.set(currentPointerPosition, newValue);
  }

  public void incrementPointer() {
    currentPointerPosition++;
    values.add(0);
  }

  public char currentValuePosition() {
    return (char) values.get(currentPointerPosition).intValue();
  }

  public int currentPointerPosition() {
    return currentPointerPosition;
  }
}
