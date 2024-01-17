package com.pjurczen;

public class LinkedList<T> {

    private Node<T> head;

    public void insert(T value) {
        final var node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            var tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        var tail = head;
        stringBuilder.append(tail.value);
        while (tail.next != null) {
            tail = tail.next;
            stringBuilder.append(", ").append(tail.value);
        }
        return stringBuilder.toString();
    }

    public static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }
}
