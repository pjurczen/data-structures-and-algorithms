package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixMultiplicationTest {

    private final MatrixMultiplication testee = new MatrixMultiplication();

    @Test
    void multiplySmall() {
        // given
        final int[][] X = { {1, 2, 3, 4},
                            {4, 3, 0, 1},
                            {5, 6, 1, 1},
                            {0, 2, 5, 6}};
        final int[][] Y = { {1, 0, 5, 1},
                            {1, 2, 0, 2},
                            {0, 3, 2, 3},
                            {1, 2, 1, 2}};

        final int[][] expectedResult = {{7, 21, 15, 22},
                                        {8, 8, 21, 12},
                                        {12, 17, 28, 22},
                                        {8, 31, 16, 31}};
        // when
        final var result = testee.multiply(X, Y);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}