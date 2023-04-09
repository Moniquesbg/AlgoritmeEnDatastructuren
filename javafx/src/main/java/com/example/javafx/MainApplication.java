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


        //stack
//        CustomStack<Student> stack = new CustomStack();
//        stack.push(student1);
//        stack.push(student2);
//        stack.push(student3);
//        stack.push(student4);
//
//        System.out.println("Size stack"+ stack.getSize());
//
//        Student[] stackArray = new Student[stack.getSize()];
//
//        int i = 0;
//
//        for(Node<Student> node = stack.getTop(); node != null; node = node.getNext())
//        {
//            stackArray[i] = node.getValue();
//            i++;
//        }
//
//        System.out.println("stack old:");
//        for (Student student : stackArray) {
//            System.out.println(student.getFirstName());
//        }
//
//        System.out.println("The top of the stack: " + stack.getTop().getValue().getFirstName());
//
//        System.out.println(stack.search("Bleep"));

        launch();
    }
}