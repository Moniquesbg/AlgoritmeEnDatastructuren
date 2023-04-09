package com.example.javafx.datastructures.Stack;

import com.example.javafx.Node;
import com.example.javafx.dataset.Data;
import com.example.javafx.dataset.Student;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CustomStack<T> {
    private Node<T> top;
    private ArrayList<Student> students;
    private int size;

    public CustomStack()
    {
        this.students = Data.createDataSet(5);
        this.size = 0;
        this.top = null;
    }

    public int getSize()
    {
        return this.size;
    }

    public Node getTop()
    {
        return this.top;
    }

    //add
    public void push(T value)
    {
        Node<T> newNode = new Node(value);

        newNode.setNext(top);
        top = newNode;
        this.size++;
    }

    //pop: deleting the head node and making the next node the top.
    public Student pop()
    {
        if(top == null)
        {
            throw new EmptyStackException();
        }

        T node = (T) top.getValue();
        top = top.getNext();
        size--;

        return (Student) node;
    }

    //Returns the last inserted element without removing it.
    public Student peek()
    {
        return top.getValue();
    }

    public <T> boolean search(T studentData)
    {
        Node currentNode = this.top;

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
}
