package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {

    private final MergeSort testee = new MergeSort();

    @Test
    void mergeSort() {
        // given
        int[] input = new int[]{40, 10, 60, 20};
        // when
        testee.sort(input, 0, input.length - 1);
        // then
        assertThat(input).isSorted();
    }
}