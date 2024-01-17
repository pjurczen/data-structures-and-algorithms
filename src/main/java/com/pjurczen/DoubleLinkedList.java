package com.pjurczen;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void insert(T value) {
        final var node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.previous = tail;
            this.tail.next = node;
            this.tail = node;
        }
    }

    public static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("[value=").append(this.value).append(", previous=").append(this.previous != null ? this.previous.value : null).append(", next=").append(this.next != null ? this.next.value : null).append("]").toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        var tail = head;
        stringBuilder.append("[").append(head.toString());
        while (tail.next != null) {
            tail = tail.next;
            stringBuilder.append(", ").append(tail.toString());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
