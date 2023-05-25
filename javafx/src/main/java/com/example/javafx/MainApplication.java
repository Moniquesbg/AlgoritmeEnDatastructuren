package com.example.javafx;

import com.example.javafx.dataset.Student;
import com.example.javafx.datastructures.LinkedList.CustomLinkedList;
import com.example.javafx.datastructures.Stack.CustomStack;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Algoritme en datastructuren eindopdracht - Jesse & Monique");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        // Binary search tree
        List<Student> bstList = new ArrayList<>() {{
            add(new Student("Jesse", "Vugteveen", 19));
            add(new Student("Monique", "Sabong", 13));
            add(new Student("Jan", "Bakker", 1));
        }};
        TreeSort treeSort = new TreeSort(bstList);
        treeSort.sort("firstName");

        CustomLinkedList linklist = new CustomLinkedList();

        linklist.add(new Student("Jesse", "Vugteveen", 3));
        linklist.add(new Student("Monique", "Sabong", 13));
        linklist.add(new Student("Bart", "Bakker", 10));

        System.out.println(linklist.print());

        linklist.sort("firstname");
        System.out.println(linklist.print());
//
//        System.out.println(linklist.search(13));

//        CustomStack stack = new CustomStack();
//
//        stack.push(new Student("Jesse", "Vugteveen", 19));
//        stack.push(new Student("Monique", "Sabong", 13));
//        stack.push(new Student("Jan", "Bakker", 1));
//
//        System.out.println(stack.print());
//        System.out.println(stack.search(1));

        launch();
    }
}