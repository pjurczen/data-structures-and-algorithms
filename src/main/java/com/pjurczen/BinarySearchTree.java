package com.pjurczen;

import java.util.Objects;

public class BinarySearchTree {

    private Node<Integer> root;

    public void add(Integer value) {
        this.root = addRecursive(root, value);
    }

    public int search(Integer value) {
        return searchRecursive(root, value);
    }

    private int searchRecursive(Node<Integer> current, Integer value) {
        if (current == null) {
            return 0;
        } else if (Objects.equals(current.value, value)) {
            return current.count;
        } else if (value < current.value) {
            return searchRecursive(current.left, value);
        } else { // value > rootNode.value
            return searchRecursive(current.right, value);
        }
    }

    private Node<Integer> addRecursive(Node<Integer> current, Integer value) {
        if (current == null) {
            return new Node<>(value);
        } else if (Objects.equals(current.value, value)) {
            current.count++;
            return current;
        } else if (value < current.value) {
            current.left = addRecursive(current.left, value);
            return current;
        } else { // value > rootNode.value
            current.right = addRecursive(current.right, value);
            return current;
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
