package com.example.javafx;

import com.example.javafx.dataset.Student;
import com.example.javafx.datastructures.LinkedList.CustomLinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        CustomLinkedList<Student> studentList = new CustomLinkedList();
        Student student1 = new Student("Kaas", "Meep", 89283);
        Student student2 = new Student("Aaron", "Bleep", 89283);
        Student student3 = new Student("Meep", "Jansen", 89283);
        Student student4 = new Student("Bloop", "Smit", 89283);

        studentList.add(0, student1);
        studentList.add(1, student2);
        studentList.add(2, student3);
        studentList.add(3, student4);

        System.out.println(studentList.getSize());

        Student[] studentArray = new Student[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            studentArray[i] = studentList.getNode(i).getValue();
        }
        System.out.println("old list:");
        for (Student student : studentArray) {
            System.out.println(student.getLastName());
        }

        StudentComparator comparator = new StudentComparator("lastName");
        BubbleSort.sort(studentArray, comparator);
        System.out.println("New list: ");
        for (Student student : studentArray) {
            System.out.println(student.getLastName());
        }

        launch();
    }
}