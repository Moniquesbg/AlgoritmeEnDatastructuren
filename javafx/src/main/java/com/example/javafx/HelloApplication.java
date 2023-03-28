package com.example.javafx;

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
        Student student1 = new Student("Kaas", "blep", 89283, 8);
        Student student2 = new Student("Aaron", "boop", 89283, 8);
        Student student3 = new Student("Meep", "blap", 89283, 8);
        Student student4 = new Student("Bloop", "blap", 89283, 8);

        studentList.add(0, student1);
        studentList.add(1, student2);
        studentList.add(2, student3);
        studentList.add(3, student4);

        System.out.println(studentList.getSize());

        Student[] studentArray = new Student[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            studentArray[i] = studentList.getNode(i).getValue();
        }

        StudentComparator comparator = new StudentComparator("firstName");
        BubbleSort.sort(studentArray, comparator);
        for (Student student : studentArray) {
            System.out.println(student.getFirstName());
        }

        launch();
    }
}