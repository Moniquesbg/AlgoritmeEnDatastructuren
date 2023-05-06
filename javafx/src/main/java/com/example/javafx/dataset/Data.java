package com.example.javafx.dataset;

import java.util.ArrayList;
import java.util.Random;

public class Data{

    private static final String[] FIRST_NAMES = {"Monique", "Jesse", "Bob", "Gert", "Herman", "Gerda", "Jan", "Albert"};
    private static final String[] LAST_NAMES = {"Jansen", "Hunze", "Laan", "Bakker", "Visser", "Smit", "Huls", "Brandsen"};
    private static final int[] STUDENT_NUMBER = {5000742, 5000800, 5000241, 5000527, 5000362, 5000261, 5000325, 5000135};

    public static ArrayList createDataSet(int size)
    {
        Random RANDOM = new Random();
        ArrayList studentSet = new ArrayList();

        for(int i = 0; i < size; i++)
        {
            String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
            int studentNumber = STUDENT_NUMBER[RANDOM.nextInt(STUDENT_NUMBER.length)];

            Student s = new Student(firstName, lastName, studentNumber);
            studentSet.add(s);
        }
        return studentSet;
    }
}
