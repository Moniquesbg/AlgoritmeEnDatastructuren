package com.example.javafx.datastructures.Stack;

import com.example.javafx.Node;
import com.example.javafx.StudentComparator;
import com.example.javafx.dataset.Data;
import com.example.javafx.dataset.Student;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CustomStack<T> {
    private Node<T> top;
    private ArrayList<Student> students;
    private int size;

    public CustomStack() {
        this.students = Data.createDataSet(5);
        this.size = 0;
        this.top = null;
    }

    public int getSize() {
        return this.size;
    }

    public Node getTop() {
        return this.top;
    }

    public void buildStack() {
        for (Student student : this.students) {
            this.push((T) student);
        }
    }

    //add
    public void push(T value) {
        Node<T> newNode = new Node(value);

        newNode.setNext(top);
        top = newNode;
        this.size++;
    }

    //pop: deleting the head node and making the next node the top.
    public Student pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T node = (T) top.getValue();
        top = top.getNext();
        size--;

        return (Student) node;
    }

    //Returns the last inserted element without removing it.
    public Student peek() {
        return top.getValue();
    }

    public <T> boolean search(T studentData) {
        Node currentNode = this.top;

        while (currentNode != null) {
            String firstName = currentNode.getValue().getFirstName();
            String lastName = currentNode.getValue().getLastName();

            if (studentData instanceof String) {
                if (firstName.equals(studentData) || lastName.equals(studentData)) {
                    return true;
                }
            } else if (studentData instanceof Integer) {
                int studentNumber = currentNode.getValue().getStudentNumber();
                if (studentNumber == (int) studentData) {
                    return true;
                }
            }

            currentNode = currentNode.getNext();
        }
        return false;
    }

    public String print() {
        StringBuilder studentData = new StringBuilder();
        Node<T> currentNode = this.top;

        //looping through all the nodes.
        while (currentNode != null) {
            Student student = (Student) currentNode.getValue();
            studentData.append("<First name: " + student.getFirstName() + ", Last Name: " + student.getLastName() + ", Student Number: " + student.getStudentNumber() + "> ");

            currentNode = currentNode.getNext();
        }

        return studentData.toString();
    }

    public void bubbleSort(String compareBy) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            Node<T> currentNode = this.top;
            Node<T> previousNode = null;

            while (currentNode != null && currentNode.getNext() != null) {
                Student student1 = (Student) currentNode.getValue();
                Student student2 = (Student) currentNode.getNext().getValue();

                if (new StudentComparator(compareBy).compare(student1, student2) > 0) {
                    Node<T> temp = currentNode;
                    currentNode = currentNode.getNext();
                    temp.setNext(currentNode.getNext());
                    currentNode.setNext(temp);

                    if(previousNode == null)
                    {
                        this.top = currentNode;
                    }else{
                        previousNode.setNext(currentNode);
                    }

                    swapped = true;
                }else{
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
            }
        }
    }
}
