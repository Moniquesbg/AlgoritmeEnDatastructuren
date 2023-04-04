package com.example.javafx;

public class BinarySearchTree<T extends Comparable<T>> {
    public static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void traverse() {
        traverseInOrder(this.root);
    }

    public void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.getValue());
            traverseInOrder(node.right);
        }
    }

    public void insert(T data)
    {
        this.root = addNode(this.root, data);
    }


    public Node<T> addNode(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = addNode(node.left, value);
        }
        if (value.compareTo(node.value) > 0) {
            node.right = addNode(node.right, value);
        }
        return node;
    }
}
