package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyHashSetTest {

    @Test
    void simpleCase() {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        assertThat(myHashSet.contains(1)).isTrue(); // return True
        assertThat(myHashSet.contains(3)).isFalse(); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        assertThat(myHashSet.contains(2)).isTrue(); // return True
        myHashSet.remove(2);   // set = [1]
        assertThat(myHashSet.contains(2)).isFalse(); // return False, (already removed)
    }
}