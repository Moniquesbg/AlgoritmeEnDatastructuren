package com.example.javafx;

public class BinarySearchTree<T> {
    public class Node<T> {
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


    public Node<T> addNode(Node<T> node, T value) {
        if (node == null) {
            node = new Node<>(value);
            return node;
        }
        if (value < node.value) {
            node.left = addNode(node, value);
        }
        if (value > node.value) {
            node.right = addNode(node, value);
        }
        return node;
    }
}
