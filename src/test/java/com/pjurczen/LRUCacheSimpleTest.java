package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheSimpleTest {

    private final LRUCacheSimple testee = new LRUCacheSimple();

    @Test
    void cacheWorks() {
        // then
        testee.add(5);
        testee.add(4);
        testee.add(2);
        testee.add(6);
        testee.add(4);
        // when
        final var result = testee.getValues();
        // then
        assertThat(result).containsExactly(4, 6, 2);
    }
}