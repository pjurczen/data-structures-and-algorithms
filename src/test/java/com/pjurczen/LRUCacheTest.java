package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    @Test
    void simpleCase() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        assertThat(lRUCache.get(1)).isEqualTo(1); // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertThat(lRUCache.get(2)).isEqualTo(-1);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertThat(lRUCache.get(1)).isEqualTo(-1); // return -1 (not found)
        assertThat(lRUCache.get(3)).isEqualTo(3); // return 3
        assertThat(lRUCache.get(4)).isEqualTo(4); // return 4
    }
}