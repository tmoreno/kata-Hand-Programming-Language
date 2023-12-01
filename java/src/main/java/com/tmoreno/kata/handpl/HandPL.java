package com.tmoreno.kata.handpl;

public final class HandPL {

  private final Memory memory;
  private final Printer printer;

  public HandPL(Memory memory, Printer printer) {
    this.memory = memory;
    this.printer = printer;
  }

  public void execute(String instructions) {
    instructions
      .codePoints()
      .mapToObj(Character::toString)
      .forEach(instruction -> {
        switch (instruction) {
          case "👆" -> memory.increment();
          case "👇" -> memory.decrement();
          case "👉" -> memory.incrementPointer();
          case "👊" -> printer.print(memory.currentValuePosition());
        }
      });
  }
}
