package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    @Test
    void stack() {
        final var linkedList = new Stack<String>();
        linkedList.push("Test");
        linkedList.push("Test1");
        linkedList.push("Test2");
        assertThat(linkedList.pop()).isEqualTo("Test2");
        assertThat(linkedList.pop()).isEqualTo("Test1");
        assertThat(linkedList.pop()).isEqualTo("Test");
    }
}
