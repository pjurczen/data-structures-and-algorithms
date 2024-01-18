package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private final QuickSort testee = new QuickSort();

    @Test
    void quickSort() {
        // given
        int[] input = new int[]{20, 10, 30, 40, 90, 50, 70, 25};
        // when
        testee.quickSort(input, 0, input.length - 1);
        // then
        assertThat(input).isSorted();
    }

}