package org.example.data.structures.tree;

/**
 * Двоичное дерево поиска
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root = null;

    public BinarySearchTree() {
    }

    public void insert(T data) {
        var currentNode = root;
        if (currentNode == null) {
            root = new Node<>(data);
        } else {
            while (currentNode != null) {
                if (data.compareTo(currentNode.data) <= 0) {
                    if (currentNode.left == null) {
                        currentNode.left = new Node<>(data);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else if (currentNode.right == null) {
                    currentNode.right = new Node<>(data);
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    private static class Node<T> {

        private final T data;
        private Node<T> left = null;
        private Node<T> right = null;

        Node(T data) {
            this.data = data;
        }
    }
}
