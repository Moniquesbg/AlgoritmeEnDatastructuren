package com.example.javafx.datastructures.LinkedList;

import com.example.javafx.dataset.Data;
import com.example.javafx.dataset.Student;

import java.util.ArrayList;

public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;
    private ArrayList<Student> students;

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.students = Data.createDataSet(5);
    }

    public int size() {
        return this.size;
    }

    //Getters & setters
    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public Node<T> getNode(int index) {
        Node<T> currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }
    public int getSize()
    {
        return this.size;
    }

    public ArrayList<Student> getStudents()
    {
        return this.students;
    }

    public boolean checkIfIndexIsOutOfBounds(int index) {
        if (this.head != null || this.size == 0) {
            if (index >= 0 && index <= this.size) {
                return true;
            }
            return false;

        }

        return false;
    }

    public boolean add(int index, Student student) {
        //Check if index is out of bounds
        if (this.checkIfIndexIsOutOfBounds(index)) {
            // create new node
            Node<T> newNode = new Node(student);

            if (index == 0 && this.size == 0) {
                this.head = newNode;
                this.tail = newNode;
            } else if (index == 0 && this.size > 0) {
                newNode.setNext(this.head);
                this.head = newNode;
            } else {
                //Get previous node and get the reference to the next node
                Node<T> previousNode = this.getNode(index - 1);
                Node<T> nextNode = previousNode.getNext();

                //Put new node in reference of previous node and set the next node refrence to the old next node
                previousNode.setNext(newNode);
                newNode.setNext(nextNode);

                //Update the tail reference if the new node is added at the end
                if (index == this.size) {
                    this.tail = newNode;
                }
            }
            this.size++;

            return true;
        }
        return false;
    }

    public boolean delete(int index) {
        if (checkIfIndexIsOutOfBounds(index)) {
            if (index == 0) {
                this.head = this.head.getNext();
                this.size--;
            } else {
                if (index == this.size) {
                    return false;
                } else {

                    Node<T> previousNode = this.getNode(index - 1);
                    Node<T> nextNode = previousNode.getNext().getNext();

                    previousNode.setNext(nextNode);
                    this.tail = previousNode;
                    this.size--;
                }
            }

            return true;
        }

        return false;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
