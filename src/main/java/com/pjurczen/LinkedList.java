package com.pjurczen;

public class LinkedList<T> {

    private Node<T> head;

    public void add(T value) {
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

    public T get(int index) {
        var node = head;
        for (int i=0; i < index; i++) {
            node = node.next;
        }
        return node.value;
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
            return stringBuilder.append("[value=").append(this.value).append(", next=").append(this.next != null ? this.next.value : null).append("]").toString();
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
