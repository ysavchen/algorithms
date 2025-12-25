package org.example.data.structures.linkedlist;

/**
 * Несортированный односвязный список
 */
public class SinglyLinkedList<T> {

    private Node<T> head = null;

    public SinglyLinkedList() {
    }

    public void insertToFront(T data) {
        var node = new Node<>(data);
        if (head != null) {
            node.appendNode(head);
        }
        head = node;
    }

    public void insertToBack(T data) {
        var node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> currentNode = head;
            while (currentNode.hasNextNode()) {
                currentNode = currentNode.nextNode();
            }
            currentNode.appendNode(node);
        }
    }

    private static class Node<T> {

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

        public Node<T> nextNode() {
            return nextNode;
        }
    }
}
