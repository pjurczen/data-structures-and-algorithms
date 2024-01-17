package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueTest {

    @Test
    void queue() {
        final var linkedList = new Queue<String>();
        linkedList.add("Test");
        linkedList.add("Test1");
        linkedList.add("Test2");
        assertThat(linkedList.poll()).isEqualTo("Test");
        assertThat(linkedList.poll()).isEqualTo("Test1");
        assertThat(linkedList.poll()).isEqualTo("Test2");
    }
}
