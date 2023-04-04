package com.example.javafx.dataset;

import java.util.ArrayList;
import java.util.Random;

public class Data {

    private static final String[] FIRST_NAMES = {"Monique", "Jesse", "Bob", "Gert", "Herman", "Gerda"};
    private static final String[] LAST_NAMES = {"Jansen", "Hunze", "Laan", "Bakker", "Visser", "Smit"};
    private static final int[] STUDENT_NUMBER = {5000742, 5000800, 5000241, 5000527, 5000362, 5000261};

    public static ArrayList<Student> createDataSet(int size)
    {
        Random RANDOM = new Random();
        ArrayList<Student> studentSet = new ArrayList();

        for(int i = 0; i < size; i++)
        {
            String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
            int studentNumber = STUDENT_NUMBER[RANDOM.nextInt(STUDENT_NUMBER.length)];

            studentSet.add(new Student(firstName, lastName, studentNumber));
        }
        return studentSet;
    }
}