package org.example.data.structures.tree;

/**
 * Сбалансированное дерево поиска (АВЛ-дерево)
 */
public class BalancedSearchTree {

    private static class Node {
        private final int value;
        private int height = 1;

        private Node left = null;
        private Node right = null;

        Node(int value) {
            this.value = value;
        }
    }
}
