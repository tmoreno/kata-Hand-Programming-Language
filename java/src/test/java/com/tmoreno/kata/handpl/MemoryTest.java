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

  @Test
  void should_be_255_when_increment_255_times() {
    Memory memory = new Memory();

    for (int i = 0; i < 255; i++) {
      memory.increment();
    }

    assertThat(memory.currentValuePosition()).isEqualTo((char) 255);
  }

  @Test
  void should_be_zero_when_increment_256_times() {
    Memory memory = new Memory();

    for (int i = 0; i < 256; i++) {
      memory.increment();
    }

    assertThat(memory.currentValuePosition()).isEqualTo((char) 0);
  }

  @Test
  void should_decrement_current_value_by_one() {
    Memory memory = new Memory();

    memory.decrement();

    assertThat(memory.currentValuePosition()).isEqualTo((char) 255);
  }

  @Test
  void should_decrement_current_value_by_two() {
    Memory memory = new Memory();

    memory.decrement();
    memory.decrement();

    assertThat(memory.currentValuePosition()).isEqualTo((char) 254);
  }

  @Test
  void should_be_1_when_decrement_255_times() {
    Memory memory = new Memory();

    for (int i = 0; i < 255; i++) {
      memory.decrement();
    }

    assertThat(memory.currentValuePosition()).isEqualTo((char) 1);
  }

  @Test
  void should_be_zero_when_decrement_256_times() {
    Memory memory = new Memory();

    for (int i = 0; i < 256; i++) {
      memory.decrement();
    }

    assertThat(memory.currentValuePosition()).isEqualTo((char) 0);
  }
}
