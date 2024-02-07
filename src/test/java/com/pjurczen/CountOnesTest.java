package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountOnesTest {

    private final CountOnes testee = new CountOnes();

    @Test
    void countOnes() {
        // given
        int num = 6;
        // when
        var result = testee.countOnes(num);
        // then
        assertThat(result).isEqualTo(2);
    }
}