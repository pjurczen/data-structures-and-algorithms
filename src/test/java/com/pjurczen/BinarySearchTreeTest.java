package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

    @Test
    void addAndSearch() {
        final var binaryTree = new BinarySearchTree();
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(8);
        binaryTree.add(10);
        binaryTree.add(7);
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(-1);
        binaryTree.add(7);
        binaryTree.add(2);
        final var result = binaryTree.search(2);
        assertThat(result).isEqualTo(3);
    }
}
