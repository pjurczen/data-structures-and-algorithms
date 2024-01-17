package com.pjurczen;

import org.junit.jupiter.api.Test;

class DoubleLinkedListTest {

    @Test
    void insert() {
        final var linkedList = new DoubleLinkedList<String>();
        linkedList.insert("Test");
        linkedList.insert("Test1");
        linkedList.insert("Test2");
        System.out.println(linkedList);
    }
}
