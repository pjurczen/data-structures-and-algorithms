package com.pjurczen;

import java.util.Objects;

public class BinaryTree {

    private Node<Integer> root;

    public void add(Integer value) {
        this.root = addRecursive(root, value);
    }

    private Node<Integer> addRecursive(Node<Integer> current, Integer value) {
        if (current == null) {
            return new Node<>(value);
        } else if (Objects.equals(current.value, value)) {
            current.count++;
            return current;
        } else if (value < current.value) {
            return addRecursive(current.left, value);
        } else { // value > rootNode.value
            return addRecursive(current.right, value);
        }
    }

    static class Node<T> {
        T value;
        int count;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
            count = 1;
        }
    }
}
