package com.tmoreno.kata.handpl;

import java.util.ArrayList;
import java.util.List;

public final class Memory {

  private int pointerPosition;
  private final List<Integer> values;

  public Memory() {
    pointerPosition = 0;
    values = new ArrayList<>();
    values.add(0);
  }

  public void incrementCurrentValue() {
    int currentValue = values.get(pointerPosition);
    int newValue = Math.floorMod(currentValue + 1, 256);
    values.set(pointerPosition, newValue);
  }

  public void decrementCurrentValue() {
    int currentValue = values.get(pointerPosition);
    int newValue = Math.floorMod(currentValue - 1, 256);
    values.set(pointerPosition, newValue);
  }

  public void incrementPointer() {
    pointerPosition++;
    values.add(0);
  }

  public char getCurrentValue() {
    return (char) values.get(pointerPosition).intValue();
  }

  public int getPointerPosition() {
    return pointerPosition;
  }
}
