package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    @Test
    void linkedList() {
        final var linkedList = new LinkedList<String>();
        linkedList.add("Test");
        linkedList.add("Test1");
        linkedList.add("Test2");
        assertThat(linkedList.get(0)).isEqualTo("Test");
        assertThat(linkedList.get(1)).isEqualTo("Test1");
        assertThat(linkedList.get(2)).isEqualTo("Test2");
        assertThat(linkedList.toString()).isEqualTo("[[value=Test, next=Test1], [value=Test1, next=Test2], [value=Test2, next=null]]");
    }
}
