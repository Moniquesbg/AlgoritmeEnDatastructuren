package com.example.javafx.datastructures.Queue;

import com.example.javafx.dataset.Data;
import com.example.javafx.dataset.Student;

import java.util.ArrayList;

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

    private ArrayList<T> students;

    public CustomQueue() {
        this.size = 0;
        this.first = null;
        this.last = null;
        this.students = Data.createDataSet(5);
    }

    public void buildStack() {
        for (T s : this.students) {
            this.enqueue(s);
        }
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

        return this.first.value;
    }

    public String print() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder studentData = new StringBuilder();

        Node<T> node = this.first;
        while (node != null) {
            T student = node.value;
            studentData.append("<First name: " + student.getFirstName() + ", Last Name: " + student.getLastName() + ", Student Number: " + student.getStudentNumber() + "> ");
            studentData.append("\n");
            node = node.next;
        }
        return studentData.toString();
    }

    public boolean search(T studentData)
    {
        Node<T> currentNode = this.first;

        while(currentNode != null) {

            Integer studentNumber = currentNode.value.getStudentNumber();
            String firstName = currentNode.value.getFirstName();
            String lastName = currentNode.value.getLastName();

            if (studentNumber.compareTo(studentData.getStudentNumber()) == 0
                    || firstName.compareTo(studentData.getFirstName()) == 0
                    || lastName.compareTo(studentData.getLastName()) == 0) {
                return true;
            }

            currentNode = currentNode.next;
        }
        return false;
    }

    public void sort(String type) {
        if (this.first == null || this.first.next == null) {
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
        Node<T> prev = null;
        Node<T> curr = this.first;
        Node<T> next = curr.next;

        while (next != null) {   //checks if next node exists
            if (getComparison(type, curr)) { //comparing current with next node
                swapped = true;

                if (prev != null) {
                    prev.next = next;
                } else {
                    this.first = next;
                }

                curr.next = next.next;
                next.next = curr;

                //swap
                Node<T> temp = curr;
                curr = next;
                next = temp;
            }

            prev = curr;
            curr = curr.next;
            next = next.next;
        }
        return swapped;
    }

    /**
     * get comparison string
     *
     * @return true or false
     */
    public Boolean getComparison(String type, Node<T> curr) {
        boolean result = false;

        result = type.equalsIgnoreCase("studentnumber") && curr.value.getStudentNumber() > curr.next.value.getStudentNumber();
        result = type.equalsIgnoreCase("firstname") ? curr.value.getFirstName().compareTo(curr.next.value.getFirstName()) > 0 : result;
        result = type.equalsIgnoreCase("lastname") ? curr.value.getLastName().compareTo(curr.next.value.getLastName()) > 0 : result;

        return result;
    }
}
