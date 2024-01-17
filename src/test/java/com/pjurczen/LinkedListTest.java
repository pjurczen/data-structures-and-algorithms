package com.pjurczen;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void insert() {
        final var linkedList = new LinkedList<String>();
        linkedList.insert("Test");
        linkedList.insert("Test1");
        linkedList.insert("Test2");
        System.out.println(linkedList);
    }
}
