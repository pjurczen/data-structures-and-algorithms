package com.pjurczen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTest {

    @Test
    void addBreadthFirst() {
        final var binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(6);
        binaryTree.add(7);
        final var out = binaryTree.renderBreadthFirst();
        assertThat(out).isEqualTo("[value=5, left=2, right=1][value=2, left=6, right=7][value=1, left=null, right=null][value=6, left=null, right=null][value=7, left=null, right=null]");
    }
}
