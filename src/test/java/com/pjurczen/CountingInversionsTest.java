package com.pjurczen;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CountingInversionsTest {

    private final CountingInversions testee = new CountingInversions();

    @Test
    void simpleTest() {
        // given
        final var input = new int[]{1, 3, 5, 2, 4, 6};
        // when
        final var result = testee.sortAndCountInv(input);
        // then
        assertThat(result.inversionsCount).isEqualTo(3);
    }

    @Test
    void fileInput() throws IOException {
        // given
        final var input = readFile();
        // when
        final var result = testee.sortAndCountInv(input);
        // then
        assertThat(result.inversionsCount).isEqualTo(3);
    }

    private int[] readFile() throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(CountingInversionsTest.class.getClassLoader().getResourceAsStream("input.txt")))) {
            return reader.lines()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .mapToInt(v -> v)
                    .toArray();
        }
    }
}