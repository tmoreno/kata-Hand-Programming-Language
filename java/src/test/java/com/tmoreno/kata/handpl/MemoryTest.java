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
      memory.incrementCurrentValue();
    }

    assertThat(memory.getCurrentValue()).isEqualTo((char) expectedValue);
  }

  private static Stream<Arguments> argumentsForDecrements() {
    return Stream.of(
      Arguments.of(0, 0),
      Arguments.of(1, 255),
      Arguments.of(2, 254),
      Arguments.of(255, 1),
      Arguments.of(256, 0),
      Arguments.of(257, 255),
      Arguments.of(258, 254)
    );
  }

  @MethodSource("argumentsForDecrements")
  @ParameterizedTest
  void should_decrement_as_expected(int times, int expectedValue) {
    Memory memory = new Memory();

    for (int i = 0; i < times; i++) {
      memory.decrementCurrentValue();
    }

    assertThat(memory.getCurrentValue()).isEqualTo((char) expectedValue);
  }

  @Test
  void should_be_zero_when_initialize_memory() {
    Memory memory = new Memory();

    assertThat(memory.getPointerPosition()).isEqualTo(0);
  }

  @Test
  void should_be_one_when_increment_position() {
    Memory memory = new Memory();

    memory.incrementPointer();

    assertThat(memory.getPointerPosition()).isEqualTo(1);
  }

  @Test
  void should_increment_two_memory_positions() {
    Memory memory = new Memory();

    memory.incrementCurrentValue();
    assertThat(memory.getCurrentValue()).isEqualTo((char) 1);

    memory.incrementPointer();
    memory.incrementCurrentValue();
    memory.incrementCurrentValue();
    assertThat(memory.getCurrentValue()).isEqualTo((char) 2);
  }

  @Test
  void should_be_zero_when_decrement_position_in_initial_state() {
    Memory memory = new Memory();

    memory.decrementPointer();

    assertThat(memory.getPointerPosition()).isEqualTo(0);
  }

  @Test
  void should_decrease_pointer_position() {
    Memory memory = new Memory();

    memory.incrementPointer();
    memory.incrementPointer();
    memory.decrementPointer();

    assertThat(memory.getPointerPosition()).isEqualTo(1);
  }

  @Test
  void should_decrease_pointer_to_max_position() {
    Memory memory = new Memory();

    memory.incrementPointer();
    memory.incrementPointer();
    memory.incrementPointer();
    memory.incrementPointer();
    memory.decrementPointer();
    memory.decrementPointer();
    memory.decrementPointer();
    memory.decrementPointer();
    memory.decrementPointer();
    memory.decrementPointer();
    memory.decrementPointer();

    assertThat(memory.getPointerPosition()).isEqualTo(2);
  }
}
