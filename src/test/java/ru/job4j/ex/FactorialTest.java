package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Factorial().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void when0Then1() {
        int result = new Factorial().calc(0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void when1Then1() {
        int result = new Factorial().calc(1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void when3Then6() {
        int result = new Factorial().calc(3);
        assertThat(result).isEqualTo(6);
    }
}