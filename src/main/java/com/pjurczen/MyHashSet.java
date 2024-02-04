package com.pjurczen;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    private List<Integer>[] values;
    private int size;

    public MyHashSet() {
        this.size = 10000;
        this.values = new ArrayList[this.size];
    }

    public void add(int key) {
        var hash = key % this.size;
        if (this.values[hash] == null) {
            this.values[hash] = new ArrayList<>();
        }
        if (!this.values[hash].contains(key)) {
            this.values[hash].add(key);
        }
    }

    public void remove(int key) {
        var hash = key % this.size;
        if (this.values[hash] != null) {
            this.values[hash].remove((Object) key);
        }
    }

    public boolean contains(int key) {
        var hash = key % this.size;
        if (this.values[hash] != null) {
            return this.values[hash].contains(key);
        }
        return false;
    }
}

