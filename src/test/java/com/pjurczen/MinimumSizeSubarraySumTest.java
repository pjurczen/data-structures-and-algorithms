package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MinimumSizeSubarraySumTest {

    private final MinimumSizeSubarraySum testee = new MinimumSizeSubarraySum();

    @Test
    void smallTestCase() {
        // given
        var given = new int[]{2,3,1,2,4,3};
        // when
        var result = testee.minSubArrayLen(7, given);
        // then
        assertThat(result).isEqualTo(2);
    }
}