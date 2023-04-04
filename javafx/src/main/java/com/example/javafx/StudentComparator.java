package com.example.javafx;

import com.example.javafx.dataset.Student;

import java.util.Comparator;
public class StudentComparator implements Comparator<Student> {

    private String compareBy;

    public StudentComparator(String compareBy) {
        this.compareBy = compareBy;
    }

    @Override
    public int compare(Student s1, Student s2) {
        switch (compareBy) {
            case "firstName":
                return s1.getFirstName().compareTo(s2.getFirstName());
            case "lastName":
                return s1.getLastName().compareTo(s2.getLastName());
            case "studentNumber":
                return Integer.compare(s1.getStudentNumber(), s2.getStudentNumber());
            default:
                throw new IllegalArgumentException("Invalid compareBy argument");
        }
    }
}