package com.example.javafx.datastructures.LinkedList;

import com.example.javafx.Node;
import com.example.javafx.StudentComparator;
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

    public void buildLinkedList()
    {
        for(Student student : this.students)
        {
            this.add(student);
        }
    }

    public void add(Student student) {
            // create new node
            Node<T> newNode = new Node(student);

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

    public <T> boolean delete(T studentData) {

        Node currentNode = this.head;
        Node prevNode = null;

        while (currentNode != null) {
            String firstName = currentNode.getValue().getFirstName();
            String lastName = currentNode.getValue().getLastName();
            int studentNumber = currentNode.getValue().getStudentNumber();

            if (studentData instanceof String) {
                String searchName = (String) studentData;

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
                int searchNumber = (int) studentData;

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

    //linear search
    public <T> boolean search(T studentData)
    {
        Node currentNode = this.head;

        while(currentNode != null) {
            String firstName = currentNode.getValue().getFirstName();
            String lastName = currentNode.getValue().getLastName();

            if(studentData instanceof String)
            {
                if(firstName.equals(studentData) || lastName.equals(studentData))
                {
                    return true;
                }
            }else if(studentData instanceof Integer)
            {
                int studentNumber = currentNode.getValue().getStudentNumber();
                if(studentNumber == (int) studentData)
                {
                    return true;
                }
            }

            currentNode = currentNode.getNext();
        }
        return false;
    }

    public String print()
    {
        StringBuilder studentData = new StringBuilder();
        Node<T> currentNode = this.head;

        //looping through all the nodes.
        while(currentNode != null)
        {
            Student student = (Student) currentNode.getValue();
            studentData.append("<First name: " + student.getFirstName() + ", Last Name: " + student.getLastName() + ", Student Number: " + student.getStudentNumber() + "> ");

            currentNode = currentNode.getNext();
        }


        return studentData.toString();
    }

    public void bubbleSort(String compareBy) {
        boolean swapped = true;

        if (this.head == null) {
            return;
        }

        while (swapped) {
            swapped = false;

            Node<T> currentNode = this.head;
            Node<T> nextNode = this.head.getNext();
            Node<T> prevNode = null;

            while (currentNode != null && nextNode!= null) {
                Student currentStudent = (Student) currentNode.getValue();
                Student nextStudent = (Student) nextNode.getValue();

                if (new StudentComparator(compareBy).compare(currentStudent, nextStudent) > 0) {
                    //swap
                    Node<T> temp = nextNode.getNext();
                    nextNode.setNext(currentNode);
                    currentNode.setNext(temp);

                    //update tail/head
                    if (currentNode == this.head) {
                        this.head = nextNode;
                    }
                    if (temp == this.tail) {
                        this.tail = currentNode;
                    }
                    if(prevNode != null)
                    {
                        prevNode.setNext(nextNode);
                    }

                    prevNode = nextNode;
                    nextNode = currentNode.getNext();

                    swapped = true;
                }else{
                    prevNode = currentNode;
                    currentNode = nextNode;
                    nextNode = nextNode.getNext();
                }
            }
        }
    }
}
