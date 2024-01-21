package com.pjurczen;

import org.junit.jupiter.api.Test;

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
}