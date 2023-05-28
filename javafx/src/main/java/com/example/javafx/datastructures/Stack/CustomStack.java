package com.example.javafx.datastructures.Stack;

import com.example.javafx.Node;
import com.example.javafx.dataset.Data;
import com.example.javafx.dataset.Student;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CustomStack<T extends Student> {
    private Node<T> top;
    private ArrayList<T> students;
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

    /**
     * buildStack
     *
     * @return generates a stack
     */
    public void buildStack() {
        for (Student s : this.students) {
            this.push(s);
        }
    }

    /**
     * push
     *
     * @param value (studentobject)
     * @return pushes a new node on top of the stack.
     */
    public void push(Student value) {
        Node<T> newNode = new Node(value);

        newNode.setNext(top);
        top = newNode;
        this.size++;
    }

    /**
     * pop
     *
     * @return pops the current top node and make the next top node the top. (delete)
     */
    public void pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        Node currentTop = this.top;
        currentTop = top.getNext();
        size--;
    }

    /**
     * peek
     *
     * @return peeks into the currrent top node
     */
    public Student peek() {
        return top.getValue();
    }

    /**
     * search
     *
     * @param studentData able to fill in a first name, last name and student number
     * @return true of false if the studentnode exists in the stack
     */

    public <S> boolean search(S studentData)
    {
        Node currentNode = this.top;

        while(currentNode != null) {

            Integer studentNumber = currentNode.getValue().getStudentNumber();
            String firstName = currentNode.getValue().getFirstName();
            String lastName = currentNode.getValue().getLastName();

            if(firstName.equals(studentData) || lastName.equals(studentData)|| studentNumber.equals(studentData)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /**
     * print
     *
     * @return a String of all the student nodes and its values in the stack.
     */
    public String print() {
        StringBuilder studentData = new StringBuilder();
        Node<T> currentNode = this.top;

        //looping through all the nodes.
        while (currentNode != null) {
            Student student = currentNode.getValue();
            studentData.append("<First name: " + student.getFirstName() + ", Last Name: " + student.getLastName() + ", Student Number: " + student.getStudentNumber() + "> ");
            studentData.append("\n");

            currentNode = currentNode.getNext();
        }

        return studentData.toString();
    }



    /**
     * Insertion sort
     *
     * @param type - sorting based on firstname, lastname or studentnumber
     */

    public void insertionSort(String type) {
        Node<T> sortedPart = null;
        Node<T> current = this.top;

        while (current != null) {
            Node<T> nextNode = current.getNext();
            current.setNext(null);

            sortedPart = insertIntoSortedPart(sortedPart, current, type);

            current = nextNode;
        }

        this.top = sortedPart;
    }

    /**
     * plaats node in juiste positie in de stack
     *
     * @return een gesorteerde stack
     */

    public Node<T> insertIntoSortedPart(Node<T> sortedPart, Node<T> nodeToInsert, String type) {
        if (sortedPart == null || getComparison(type, nodeToInsert, sortedPart)) {
            nodeToInsert.setNext(sortedPart);
            return nodeToInsert;
        }

        Node<T> current = sortedPart;
        //loops through the sorted stack and inserts it at the right spot.
        while (current.getNext() != null && !getComparison(type, nodeToInsert, current.getNext())) {
            current = current.getNext();
        }

        nodeToInsert.setNext(current.getNext());
        current.setNext(nodeToInsert);

        return sortedPart;
    }

    /**
     * Compares the nodes based on firstname, lastname or studentnumber
     *
     * @return true or false
     */

    public boolean getComparison(String type, Node<T> nodeToInsert, Node<T> currentNode) {
        if (type.equalsIgnoreCase("studentnumber")) {
            return nodeToInsert.getValue().getStudentNumber() < currentNode.getValue().getStudentNumber();
        } else if (type.equalsIgnoreCase("firstname")) {
            return nodeToInsert.getValue().getFirstName().compareTo(currentNode.getValue().getFirstName()) < 0;
        } else if (type.equalsIgnoreCase("lastname")) {
            return nodeToInsert.getValue().getLastName().compareTo(currentNode.getValue().getLastName()) < 0;
        }

        return false;
    }
}
