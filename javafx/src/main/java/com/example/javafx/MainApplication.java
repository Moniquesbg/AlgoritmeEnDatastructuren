package com.example.javafx;

import com.example.javafx.dataset.Student;
import com.example.javafx.datastructures.LinkedList.CustomLinkedList;
import com.example.javafx.datastructures.Queue.CustomQueue;
import com.example.javafx.datastructures.Stack.CustomStack;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Algoritmen en datastructuren eindopdracht - Jesse & Monique");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        // Binary search tree
        CustomQueue<Student> queue = new CustomQueue<>();
        queue.enqueue(new Student("dfsd", "Dfd", 39));
        queue.enqueue(new Student("dfsd", "Dfd", 40));
        queue.enqueue(new Student("dfsd", "Dfd", 41));
        queue.print();

        launch();
    }
}