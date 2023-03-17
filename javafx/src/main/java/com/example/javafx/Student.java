package com.example.javafx;

public class Student {

    public String firstName;
    public String lastName;
    public int studentNumber;
    public int gpa;

    public Student(String firstName, String lastName, int studentNumber, int gpa)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.gpa = gpa;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getStudentNumber()
    {
        return this.studentNumber;
    }

    public void setStudentNumber(int studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    public int getGpa()
    {
        return this.gpa;
    }

    public void setGpa(int gpa)
    {
        this.gpa = gpa;
    }
}
