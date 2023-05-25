package com.example.javafx.datastructures.Stack;

import com.example.javafx.Node;
import com.example.javafx.StudentComparator;
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
     * @return pops the current top node and make the next top node the top.
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
     * bubblesort
     *
     * @param compareBy first name, last name or student number
     * @return sorts the stack
     */
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
