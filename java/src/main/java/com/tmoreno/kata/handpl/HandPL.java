package com.tmoreno.kata.handpl;

public final class HandPL {

  private final Memory memory;
  private final Printer printer;

  public HandPL(Memory memory, Printer printer) {
    this.printer = printer;
    this.memory = memory;
  }

  public void execute(String instructions) {
    for (String instruction : instructions.split("")) {
      switch (instruction) {
        case "👆" -> memory.increment();
        case "👊" -> printer.print(memory.currentValuePosition());
      }
    }
  }
}
