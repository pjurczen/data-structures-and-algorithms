package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    @Test
    void stack() {
        final var linkedList = new Stack<String>();
        linkedList.add("Test");
        linkedList.add("Test1");
        linkedList.add("Test2");
        assertThat(linkedList.poll()).isEqualTo("Test2");
        assertThat(linkedList.poll()).isEqualTo("Test1");
        assertThat(linkedList.poll()).isEqualTo("Test");
    }
}
