package com.pjurczen;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, CacheEntry> cache = new HashMap<>();
    private CacheEntry newest;
    private CacheEntry oldest;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.newest = new CacheEntry(0, 0);
        this.oldest = new CacheEntry(0, 0);
        this.newest.next = this.oldest;
        this.oldest.previous = this.newest;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            var cacheEntry = cache.get(key);
            remove(cacheEntry);
            insertFirst(cacheEntry);
            return cacheEntry.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            var cacheEntry = cache.get(key);
            cacheEntry.value = value;
            remove(cacheEntry);
            insertFirst(cacheEntry);
        } else {
            var cacheEntry = new CacheEntry(key, value);
            cache.put(key, cacheEntry);
            insertFirst(cacheEntry);
            if (cache.size() > capacity) {
                var toPurge = oldest.previous;
                cache.remove(toPurge.key);
                remove(toPurge);
            }
        }
    }

    private void remove(CacheEntry cacheEntry) {
        var prev = cacheEntry.previous;
        var next = cacheEntry.next;
        prev.next = next;
        next.previous = prev;
    }

    private void insertFirst(CacheEntry cacheEntry) {
        cacheEntry.previous = this.newest;
        cacheEntry.next = this.newest.next;
        this.newest.next.previous = cacheEntry;
        this.newest.next = cacheEntry;
    }

    static class CacheEntry {
        public int key;
        public int value;
        public CacheEntry previous;
        public CacheEntry next;

        public CacheEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
