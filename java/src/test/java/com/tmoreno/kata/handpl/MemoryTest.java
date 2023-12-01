package com.tmoreno.kata.handpl;

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
      memory.decrement();
    }

    assertThat(memory.currentValuePosition()).isEqualTo((char) expectedValue);
  }
}
