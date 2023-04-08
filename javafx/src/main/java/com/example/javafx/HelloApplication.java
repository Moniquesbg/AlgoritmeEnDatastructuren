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

        // Binary search tree
        List<Student> bstList = new ArrayList<>() {{
            add(new Student("Jesse", "Vugteveen", 19));
            add(new Student("Monique", "Sabong", 13));
            add(new Student("Jan", "Bakker", 1));
        }};
        TreeSort treeSort = new TreeSort(bstList);
        treeSort.sort("firstName");


        // Custom linked list
        CustomLinkedList<Student> studentList = new CustomLinkedList();
        Student student1 = new Student("Kaas", "Meep", 89283);
        Student student2 = new Student("Aaron", "Bleep", 89283);
        Student student3 = new Student("Meep", "Jansen", 89283);
        Student student4 = new Student("Bloop", "Smit", 89283);

        studentList.add(0, student1);
        studentList.add(1, student2);
        studentList.add(2, student3);
        studentList.add(3, student4);

        studentList.search(4353);
        System.out.println(studentList.search(89283));

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

        //stack
        CustomStack<Student> stack = new CustomStack();
        stack.push(student1);
        stack.push(student2);
        stack.push(student3);
        stack.push(student4);

        System.out.println("Size stack"+ stack.getSize());

        Student[] stackArray = new Student[stack.getSize()];

        int i = 0;

        for(Node<Student> node = stack.getTop(); node != null; node = node.getNext())
        {
            stackArray[i] = node.getValue();
            i++;
        }

        System.out.println("stack old:");
        for (Student student : stackArray) {
            System.out.println(student.getFirstName());
        }

        System.out.println("The top of the stack: " + stack.getTop().getValue().getFirstName());

        launch();
    }
}