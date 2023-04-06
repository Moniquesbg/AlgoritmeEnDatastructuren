package com.example.javafx;

import com.example.javafx.dataset.Student;

public class Node<T> {
    private Student value;
    private Node<T> next;

    public Node(T value) {
        this.value = (Student) value;
        this.next = null;
    }

    public Student getValue() {
        return this.value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}