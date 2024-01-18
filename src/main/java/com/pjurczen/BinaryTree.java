package com.pjurczen;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private Node<Integer> root;
    
    public void add(Integer value) {
        if (root == null) {
            this.root = new Node<>(value);
        } else {
            addToFirstFreeNode(value);
        }
    }

    public String renderDepthFirst() {
        final var strBuilder = new StringBuilder();
        strBuilder.append(root);
        visitRecursively(root.left, strBuilder);
        visitRecursively(root.right, strBuilder);
        return strBuilder.toString();
    }

    private void visitRecursively(Node<Integer> node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        stringBuilder.append(node);
        visitRecursively(node.left, stringBuilder);
        visitRecursively(node.right, stringBuilder);
    }

    public String renderBreadthFirst() {
        final var strBuilder = new StringBuilder();
        final Queue<Node<Integer>> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
             final var node = nodes.poll();
             if (node.left != null) {
                 nodes.add(node.left);
             }
             if (node.right != null) {
                 nodes.add(node.right);
             }
             strBuilder.append(node);
        }
        return strBuilder.toString();
    }

    private void addToFirstFreeNode(Integer value) {
        final Queue<Node<Integer>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            final var node = nodes.poll();
            if (node.left == null) {
                node.left = new Node<>(value);
                return;
            }
            if (node.right == null) {
                node.right = new Node<>(value);
                return;
            }
            nodes.add(node.left);
            nodes.add(node.right);
        }
    }

    static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[value=" + this.value + ", left=" + (this.left != null ? this.left.value : null) + ", right=" + (this.right != null ? this.right.value : null) + "]";
        }
    }
}
