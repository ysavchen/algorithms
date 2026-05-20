package org.example.data.structures.tree;

public class BinaryTreeTraversal {

    private static class Node {

        private final int value;
        private Node left = null;
        private Node right = null;

        Node(int value) {
            this.value = value;
        }
    }

    private static Node findNode(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            return findNode(root.left, value);
        } else if (value == root.value) {
            return root;
        } else { // value > root.value
            return findNode(root.right, value);
        }
    }

    /**
     * Центрированный обход (left-middle-right traversal)<br/>
     * При обходе LMR элементы будут отсортированы по возрастанию.
     */
    private static void printLMR(Node node) {
        if (node.left != null) {
            printLMR(node.left);
        }
        System.out.println(node.value);
        if (node.right != null) {
            printLMR(node.right);
        }
    }

    /**
     * Центрированный обход (right-middle-left traversal)<br/>
     * При обходе RML элементы будут отсортированы по убыванию.
     */
    private static void printRML(Node node) {
        if (node.right != null) {
            printRML(node.right);
        }
        System.out.println(node.value);
        if (node.left != null) {
            printRML(node.left);
        }
    }

    public static void main(String[] args) {
        var root = new Node(7);
        var four = new Node(4);
        var three = new Node(3);
        var five = new Node(5);
        var eight = new Node(8);

        root.left = four;
        four.left = three;
        four.right = five;
        root.right = eight;

        var node = findNode(root, 5);
        System.out.println("Result: " + node.value);

        printLMR(root);
    }
}
