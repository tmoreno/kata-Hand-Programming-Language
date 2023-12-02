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
        case "🤜" -> {
          if (memory.getCurrentValue() == (char) 0) {
            i = findInstructionPositionFrom("🤛", i, instructionsList);
          }
        }
        case "👊" -> printer.print(memory.getCurrentValue());
      }
    }
  }

  private int findInstructionPositionFrom(String instruction, int fromPosition, List<String> instructions) {
    for (int i = fromPosition + 1; i < instructions.size(); i++) {
      if (instructions.get(i).equals(instruction)) {
        return i;
      }
    }

    return instructions.size();
  }
}
