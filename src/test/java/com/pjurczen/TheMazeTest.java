package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheMazeTest {

    private final TheMaze testee = new TheMaze();

    @Test
    void positiveTestCase() {
        // given
        int[][] input = new int[][]{
                new int[]{0,0,1,0,0},
                new int[]{0,0,0,0,0},
                new int[]{0,0,0,1,0},
                new int[]{1,1,0,1,1},
                new int[]{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{4, 4};
        // when
        final var result = testee.hasPath(input, start, destination);
        // then
        assertThat(result).isTrue();
    }

    @Test
    void negativeTestCase() {
        // given
        int[][] input = new int[][]{
                new int[]{0,0,1,0,0},
                new int[]{0,0,0,0,0},
                new int[]{0,0,0,1,0},
                new int[]{1,1,0,1,1},
                new int[]{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{3, 2};
        // when
        final var result = testee.hasPath(input, start, destination);
        // then
        assertThat(result).isFalse();
    }
}