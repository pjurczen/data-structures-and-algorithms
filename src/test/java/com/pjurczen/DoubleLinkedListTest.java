package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoubleLinkedListTest {

    @Test
    void insert() {
        final var linkedList = new DoubleLinkedList<String>();
        linkedList.add("Test");
        linkedList.add("Test1");
        linkedList.add("Test2");
        assertThat(linkedList.toString()).isEqualTo("[[value=Test, previous=null, next=Test1], [value=Test1, previous=Test, next=Test2], [value=Test2, previous=Test1, next=null]]");
    }
}
