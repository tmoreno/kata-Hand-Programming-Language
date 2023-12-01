package com.tmoreno.kata.handpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryTest {

  private static Stream<Arguments> argumentsForIncrements() {
    return Stream.of(
      Arguments.of(0, 0),
      Arguments.of(1, 1),
      Arguments.of(2, 2),
      Arguments.of(254, 254),
      Arguments.of(255, 255),
      Arguments.of(256, 0),
      Arguments.of(257, 1)
    );
  }

  @MethodSource("argumentsForIncrements")
  @ParameterizedTest
  void should_increment_as_expected(int times, int expectedValue) {
    Memory memory = new Memory();

    for (int i = 0; i < times; i++) {
      memory.increment();
    }

    assertThat(memory.currentValuePosition()).isEqualTo((char) expectedValue);
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
