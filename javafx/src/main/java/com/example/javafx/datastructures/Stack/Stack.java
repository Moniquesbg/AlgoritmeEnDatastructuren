package com.example.javafx.datastructures.Stack;

import com.example.javafx.Node;
import com.example.javafx.dataset.Data;
import com.example.javafx.dataset.Student;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top;
    private ArrayList<Student> students;
    private int size;

    public Stack()
    {
        this.students = Data.createDataSet(5);
        this.size = 0;
    }

    public int getSize()
    {
        return this.size;
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
        return top.getValue();
    }

    //Returns the last inserted element without removing it.
    public Student peek()
    {
        return top.getValue();
    }
}
