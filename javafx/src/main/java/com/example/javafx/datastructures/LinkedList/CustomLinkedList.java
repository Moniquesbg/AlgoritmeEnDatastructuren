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

    public ArrayList<T> getStudents() {
        return this.students;
    }

    //methods

    /**
     * Build linked list
     * <p>
     * method that makes a linkedlist
     */
    public void buildLinkedList() {
        for (Student s : students) {
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

            while (temp.getNext() != null) {
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
    public void remove(T studentData) {
        if (this.head == null) {
            return;
        }

        Node n = this.head;
        Node p = null;

        while (n != null) {
            Integer studentNumber = n.getValue().getStudentNumber();
            String firstName = n.getValue().getFirstName();
            String lastName = n.getValue().getLastName();

            if (studentNumber.equals(studentData) || firstName.equals(studentData) || lastName.equals(studentData)) {
                if (p == null) {
                    this.head = n.getNext();
                } else {
                    p.setNext(n.getNext());
                }

                if (n.getNext() == null) {
                    this.tail = p;
                }
                break;
            }

            p = n;
            n = n.getNext();
        }
    }

    public <S> boolean search(S studentData) {
        return binarySearch(studentData, "firstName")
                || binarySearch(studentData, "lastName")
                || binarySearch(studentData, "studentNumber");
    }

    /**
     * search
     *
     * @param studentData able to fill in a first name, last name and student number
     * @return true or false if the studentData you filled in is in the linked list.
     */
    public <S> boolean binarySearch(S studentData, String searchField) {
        Node start = this.head;
        Node end = null;

        do {
            Node<T> middleNode = getMiddleNode(start, end);
            if (middleNode == null) {
                return false;
            }

            if (middleNode.getValue().compareTo(studentData, searchField) == 0) {
                return true;
            } else if (middleNode.getValue().compareTo(studentData, searchField) < 0) {
                start = middleNode.getNext();
            } else {
                end = middleNode;
            }
        } while (end == null || end != start);
        return false;
    }

    private Node<T> getMiddleNode(Node start, Node end) {
        if (start == null)
            return null;

        Node slow = start;
        Node fast = start.getNext();

        while (fast != end)
        {
            fast = fast.getNext();
            if (fast != end)
            {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }
        return slow;
    }

    /**
     * print
     *
     * @return a string of all the student nodes and their values: first name, last name and studentnumber
     */
    public String print() {
        StringBuilder studentData = new StringBuilder();
        Node<T> currentNode = this.head;

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
     * calls the right sorting algorithm
     *
     * @param type
     */
    public void sort(String type) {
        if (this.head == null || this.head.getNext() == null) {
            return;
        }

        boolean swapped = true;

        while (swapped) {
            swapped = false;

            if (type.equals("studentnumber")) {
                swapped = this.bubbleSort(swapped, "studentnumber");
            } else if (type.equals("firstname")) {
                swapped = this.bubbleSort(swapped, "firstname");
            } else if (type.equals("lastname")) {
                swapped = this.bubbleSort(swapped, "lastname");
            }
        }
    }

    /**
     * bubble sort
     *
     * @param swapped true or false if swapped
     * @param type    type of sorting
     * @return return true or false and sorts list
     */

    private Boolean bubbleSort(Boolean swapped, String type) {
        Node prev = null;
        Node curr = this.head;
        Node next = curr.getNext();

        while (next != null) {   //checks if next node exists
            if (getComparison(type, curr)) { //comparing current with next node
                swapped = true;

                if (prev != null) {
                    prev.setNext(next);
                } else {
                    this.head = next;
                }

                curr.setNext(next.getNext());
                next.setNext(curr);

                //swap
                Node temp = curr;
                curr = next;
                next = temp;
            }

            prev = curr;
            curr = curr.getNext();
            next = next.getNext();
        }
        return swapped;
    }

    /**
     * get comparison string
     *
     * @return true or false
     */
    public static Boolean getComparison(String type, Object curr) {
        boolean result = false;

        if (curr instanceof Node n) {
            result = type.equalsIgnoreCase("studentnumber") && n.getValue().getStudentNumber() > n.getNext().getValue().getStudentNumber();
            result = type.equalsIgnoreCase("firstname") ? n.getValue().getFirstName().compareTo(n.getNext().getValue().getFirstName()) > 0 : result;
            result = type.equalsIgnoreCase("lastname") ? n.getValue().getLastName().compareTo(n.getNext().getValue().getLastName()) > 0 : result;
        }
        return result;
    }
}
