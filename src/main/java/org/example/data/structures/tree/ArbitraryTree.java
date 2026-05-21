package org.example.data.structures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Произвольное дерево
 */
public class ArbitraryTree {

    private static class Node<T> {
        private final T value;
        private final List<Node<T>> children = new ArrayList<>();

        Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
}
