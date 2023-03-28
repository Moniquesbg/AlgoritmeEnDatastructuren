package com.example.javafx;

import java.util.Comparator;

public class BubbleSort {

    public static void sort(Student[] arr, Comparator<Student> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j+1]) > 0) {
                    Student temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}