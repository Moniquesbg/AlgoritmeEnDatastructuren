package com.example.javafx;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    //Getters & setters
    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Node getNode(int index) {
        Node currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
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

    public boolean add(int index, int value) {
        //Check if index is out of bounds
        if (this.checkIfIndexIsOutOfBounds(index)) {
            // create new node
            Node newNode = new Node(value);

            if (index == 0 && this.size == 0) {
                this.head = newNode;
                this.tail = newNode;
            } else if (index == 0 && this.size > 0) {
                newNode.setNext(this.head);
                this.head = newNode;
            } else {
                //Get previous node and get the reference to the next node
                Node previousNode = this.getNode(index - 1);
                Node nextNode = previousNode.getNext();

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

                    Node previousNode = this.getNode(index - 1);
                    Node nextNode = previousNode.getNext().getNext();

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
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }


    public void addValueToTail(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }
}