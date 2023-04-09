package com.example.javafx.datastructures.BinarySearchTree;

import java.util.Comparator;

public class BinarySearchTree<T> {
    public static class Node<T> {
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
    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
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
        if (this.comparator.compare(value, node.value) < 0) {
            node.left = addNode(node.left, value);
        }
        if (this.comparator.compare(value, node.value) > 0) {
            node.right = addNode(node.right, value);
        }
        return node;
    }

    public boolean search(T value) {
        return searchTree(this.root, value);
    }

    public boolean searchTree(Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        if (comparator.compare(value, node.value) < 0) {
            return searchTree(node.left, value);
        }
        return searchTree(node.right, value);
    }
}
