package com.example.javafx.dataset;
public class Student{

    public String firstName;
    public String lastName;
    public int studentNumber;

    public Student(String firstName, String lastName, int studentNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
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
}
