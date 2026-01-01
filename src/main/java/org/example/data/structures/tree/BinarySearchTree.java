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

    private NodeSearchResult<T> searchNode(T data) {
        Node<T> parentNode = null;
        Node<T> node = root;
        while (node != null) {
            if (data.equals(node.data)) {
                return new NodeSearchResult<>(parentNode, node);
            } else if (data.compareTo(node.data) < 0) {
                parentNode = node;
                node = node.left;
            } else {
                parentNode = node;
                node = node.right;
            }
        }
        return null;
    }

    private static class Node<T> {

        private final T data;
        private Node<T> left = null;
        private Node<T> right = null;

        Node(T data) {
            this.data = data;
        }
    }

    private static class NodeSearchResult<T> {
        private final Node<T> parentNode;
        private final Node<T> node;

        NodeSearchResult(Node<T> parentNode, Node<T> node) {
            this.parentNode = parentNode;
            this.node = node;
        }
    }
}
