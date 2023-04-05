package com.example.javafx;

import com.example.javafx.dataset.Student;

import java.util.List;

public class TreeSort {
    private final List<Student> treeElements;

    public TreeSort(List<Student> treeElements) {
        this.treeElements = treeElements;
    }

    public void sort(String compareBy) {
        BinarySearchTree<Student> binarySearchTree = new BinarySearchTree<>(new StudentComparator(compareBy));
        for (Student treeElement : treeElements) {
            binarySearchTree.insert(treeElement);
        }
        binarySearchTree.traverse();
    }
}
