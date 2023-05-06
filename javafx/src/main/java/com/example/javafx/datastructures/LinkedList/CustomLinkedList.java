package com.example.javafx.datastructures.LinkedList;

import com.example.javafx.Node;
import com.example.javafx.dataset.Data;
import com.example.javafx.dataset.Student;

import java.util.ArrayList;

public class CustomLinkedList<T extends Student> {

    private Node head;
    private Node tail;
    private int size;
    private ArrayList<T> students;

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.students = Data.createDataSet(5);
    }

    //Getters & setters
    public int getSize() {
        return this.size;
    }

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

    public ArrayList<T> getStudents()
    {
        return this.students;
    }

    //methods
    /**
     *Build linked list
     *
     * method that makes a linkedlist
     */
    public void buildLinkedList()
    {
        for(Student s : students)
        {
            this.add(s);
        }
    }

    /**
     * add
     *
     * @param value, able to add a studentobject
     */
    public void add(Student value) {
            // create new node
            Node<T> newNode = new Node(value);

            if (this.size == 0) {
                this.head = newNode;
                this.tail = newNode;
                this.size++;
            } else if (this.size > 0) {
                Node temp = this.head;

                while(temp.getNext() != null)
                {
                    temp = temp.getNext();
                }

                temp.setNext(newNode);
                this.tail = temp;
                this.size++;
            }
    }

    /**
     * delete
     *
     * @param studentData able to fill in a first name, last name and student number
     * @return true of false if the studentnode is deleted.
     */
    public <T> boolean delete(T studentData) {

        Node currentNode = this.head;
        Node prevNode = null;

        while (currentNode != null) {
            String firstName = currentNode.getValue().getFirstName();
            String lastName = currentNode.getValue().getLastName();
            int studentNumber = currentNode.getValue().getStudentNumber();

            if (studentData instanceof String) {
                if (firstName.equals(studentData) || lastName.equals(studentData)) {
                    //remove node
                    if (prevNode == null) {
                        this.head = currentNode.getNext();
                    } else {
                        prevNode.setNext(currentNode.getNext());
                    }
                    return true;
                }
            } else if (studentData instanceof Integer) {
                if (studentNumber == (int) studentData) {
                    //remove node
                    if (prevNode == null) {
                        this.head = currentNode.getNext();
                    } else {
                        prevNode.setNext(currentNode.getNext());
                    }
                    return true;
                }
            }

            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /**
     * search
     *
     * @param studentData able to fill in a first name, last name and student number
     * @return true or false if the studentData you filled in is in the linked list.
     */
    public <S> boolean search(S studentData)
    {
        Node currentNode = this.head;

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
     * @return a string of all the student nodes and their values: first name, last name and studentnumber
     */
    public String print()
    {
        StringBuilder studentData = new StringBuilder();
        Node<T> currentNode = this.head;

        //looping through all the nodes.
        while(currentNode != null)
        {
            Student student = currentNode.getValue();
            studentData.append("<First name: " + student.getFirstName() + ", Last Name: " + student.getLastName() + ", Student Number: " + student.getStudentNumber() + "> ");

            currentNode = currentNode.getNext();
        }

        return studentData.toString();
    }

    /**
     * bubbleSort
     *
     * @param compareBy comparing by firstName, lastName or studentnumber
     * @return nothing, only sorts the custom linked list. to see the sorted list u can use the print() method.
     */
    public void bubbleSort(String compareBy) {
        boolean swapped = true;

        //checks if linked list is not empty
        if (this.head == null) {
            return;
        }

        while (swapped) {
            swapped = false;

            Node<T> currentNode = this.head;
            Node<T> nextNode = this.head.getNext();
            Node<T> prevNode = null;

            while (currentNode != null && nextNode!= null) {
                Student currentStudent = currentNode.getValue();
                Student nextStudent = nextNode.getValue();

//                if (new StudentComparator(compareBy).compare(currentStudent, nextStudent) > 0) {
//                    //swap
//                    Node<T> temp = nextNode.getNext();
//                    nextNode.setNext(currentNode);
//                    currentNode.setNext(temp);
//
//                    //update tail/head
//                    if (currentNode == this.head) {
//                        this.head = nextNode;
//                    }
//                    if (temp == this.tail) {
//                        this.tail = currentNode;
//                    }
//                    if(prevNode != null)
//                    {
//                        prevNode.setNext(nextNode);
//                    }
//
//                    prevNode = nextNode;
//                    nextNode = currentNode.getNext();
//
//                    swapped = true;
//                }else{
//                    prevNode = currentNode;
//                    currentNode = nextNode;
//                    nextNode = nextNode.getNext();
//                }
            }
        }
    }
}
