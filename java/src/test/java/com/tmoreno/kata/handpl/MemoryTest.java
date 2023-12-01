package com.tmoreno.kata.handpl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryTest {

  @Test
  void should_be_zero_when_memory_is_initialized() {
    Memory memory = new Memory();

    assertThat(memory.currentValuePosition()).isEqualTo((char) 0);
  }

  @Test
  void should_increment_current_value_by_one() {
    Memory memory = new Memory();

    memory.increment();

    assertThat(memory.currentValuePosition()).isEqualTo((char) 1);
  }

  @Test
  void should_increment_current_value_by_two() {
    Memory memory = new Memory();

    memory.increment();
    memory.increment();

    assertThat(memory.currentValuePosition()).isEqualTo((char) 2);
  }
}
