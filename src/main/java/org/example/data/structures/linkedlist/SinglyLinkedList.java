package org.example.data.structures.linkedlist;

/**
 * Несортированный односвязный список
 */
public class SinglyLinkedList<T> {

    private Node<T> head = null;

    private class Node<T> {

        private final T data;

        private Node<T> nextNode = null;

        Node(T data) {
            this.data = data;
        }

        T getData() {
            return data;
        }

        Node<T> getNextNode() {
            return nextNode;
        }

        boolean hasNextNode() {
            return nextNode != null;
        }

        void appendNode(Node<T> node) {
            nextNode = node;
        }
    }
}
