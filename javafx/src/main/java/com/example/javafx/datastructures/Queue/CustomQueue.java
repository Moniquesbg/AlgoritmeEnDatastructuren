package com.example.javafx.datastructures.Queue;

import com.example.javafx.Node;
import com.example.javafx.dataset.Student;

public class CustomQueue<T extends Student> {

    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
    private int size;
    private Node<T> first;
    private Node<T> last;

    public CustomQueue() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public int size() {
        return this.size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;

        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue item.");
            return null;
        }

        T dequeuedItem = this.first.value;
        this.first = this.first.next;

        if (this.first == null) {
            this.last = null;
        }

        size--;
        return dequeuedItem;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return (T) this.first.value;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }

        Node<T> node = this.first;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
