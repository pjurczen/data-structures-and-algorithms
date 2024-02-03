package com.pjurczen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    private final CombinationSum testee = new CombinationSum();

    @Test
    void combinationSum() {
        // given
        var input = new int[]{2, 3, 6, 7};

        var expectedResult = new ArrayList<>();
        expectedResult.add(Arrays.asList(2, 2, 3));
        expectedResult.add(List.of(7));
        // when
        var result = testee.combinationSum(input, 7);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}