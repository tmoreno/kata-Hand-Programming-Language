package com.tmoreno.kata.handpl;

import java.util.List;

public final class HandPL {

  private final Memory memory;
  private final Printer printer;

  public HandPL(Memory memory, Printer printer) {
    this.memory = memory;
    this.printer = printer;
  }

  public void execute(String instructions) {
    List<String> instructionsList = instructions
      .codePoints()
      .mapToObj(Character::toString)
      .toList();

    for (int i = 0; i < instructionsList.size(); i++) {
      switch (instructionsList.get(i)) {
        case "👆" -> memory.incrementCurrentValue();
        case "👇" -> memory.decrementCurrentValue();
        case "👉" -> memory.incrementPointer();
        case "👈" -> memory.decrementPointer();
        case "👊" -> printer.print(memory.getCurrentValue());
      }
    }
  }
}
