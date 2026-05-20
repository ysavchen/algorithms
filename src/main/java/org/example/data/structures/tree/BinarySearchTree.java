package org.example.data.structures.tree;

import org.example.data.structures.stack.DynamicArrayStack;
import org.example.data.structures.stack.Stack;

import java.util.function.Consumer;

/**
 * Двоичное дерево поиска (BST)
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {
        private final T value;
        private Node<T> left = null;
        private Node<T> right = null;

        Node(T value) {
            this.value = value;
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

    private Node<T> root = null;

    public BinarySearchTree() {
    }

    public void insert(T value) {
        var current = root;
        if (current == null) {
            root = new Node<>(value);
        } else {
            while (current != null) {
                if (value.compareTo(current.value) <= 0) {
                    if (current.left == null) {
                        current.left = new Node<>(value);
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (current.right == null) {
                    current.right = new Node<>(value);
                } else {
                    current = current.right;
                }
            }
        }
    }

    /**
     * Обход двоичного дерева и выполнение операции с каждым элементом
     */
    public void traverse(Consumer<T> consumer) {
        Node<T> current = root;
        Stack<Node<T>> stack = new DynamicArrayStack<>();
        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                current = stack.pop();
                //todo: implement
                current = current.right;
            } else {
                while (current.left != null) {
                    stack.push(current);
                    current = current.left;
                    //todo: implement
                    current = current.right;
                }
            }
        }
    }

    public void delete(T value) {
        //todo: implement
    }

    private NodeSearchResult<T> searchNode(T value) {
        Node<T> parent = null;
        Node<T> current = root;
        while (current != null) {
            if (value.equals(current.value)) {
                return new NodeSearchResult<>(parent, current);
            } else if (value.compareTo(current.value) < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        return null;
    }
}
