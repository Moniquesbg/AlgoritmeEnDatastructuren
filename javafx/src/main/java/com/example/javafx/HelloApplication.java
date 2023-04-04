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

        BinarySearchTree<Student> tree = new BinarySearchTree<>();
        tree.insert(new Student("Jesse", "Vugteveen", 19, 10));
        tree.insert(new Student("Monique", "Sabong", 13, 0));
        tree.insert(new Student("Jan", "Bakker", 1, 5));
        tree.insert(new Student("DfDF", "dfadf", 29, 1));
//        tree.insert(10);
//        tree.insert(1);
//        tree.insert(12);
//        tree.insert(84);



        tree.traverse();

        launch();
    }
}