package com.tmoreno.kata.handpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HandPLTest {

  @Test
  void should_print_A() {
    Memory memory = new Memory();
    Printer printer = mock(Printer.class);
    HandPL handPL = new HandPL(memory, printer);

    String instructions = "👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👆👊";
    handPL.execute(instructions);

    verify(printer).print('A');
  }
}
