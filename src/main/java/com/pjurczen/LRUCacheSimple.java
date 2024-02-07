package com.pjurczen;

import java.util.LinkedList;
import java.util.List;

public class LRUCacheSimple {

    private final LinkedList<Integer> cache = new LinkedList<>();
    private final int capacity = 3;

    public void add(Integer value) {
        // O(N) iterates through all elements!
        cache.remove(value);
        if (cache.size() == capacity) {
            // O(1) has tail
            cache.removeLast();
        }
        // O (1) has head
        cache.addFirst(value);
    }

    public List<Integer> getValues() {
        return cache.stream().toList();
    }
}
