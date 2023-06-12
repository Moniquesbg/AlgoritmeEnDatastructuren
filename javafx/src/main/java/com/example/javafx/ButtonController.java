package com.example.javafx;

import com.example.javafx.dataset.Student;
import com.example.javafx.datastructures.LinkedList.CustomLinkedList;
import com.example.javafx.datastructures.Queue.CustomQueue;
import com.example.javafx.datastructures.Stack.CustomStack;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class ButtonController {
    @FXML
    private TabPane tabPane;
    @FXML
    private Label datasetLabel;
    @FXML
    private Label datasetLabelStack;
    @FXML
    private Label sortedDatasetLabel;
    @FXML
    private Label sortedStackLabel;

    @FXML
    private Label queueSearchLabel;
    @FXML
    private TextField linkedListInputSearchField;
    @FXML
    private TextField stackInputSearchField;

    @FXML
    private TextField queueInputSearchField;
    @FXML
    private Label datasetLabelBST;
    @FXML
    private Label sortedBSTLabel;

    @FXML
    private Label linkedListTime;

    @FXML
    private Label BSTtime;

    @FXML
    private Label stackTime;
    private final CustomLinkedList<Student> customLinkedList;
    private final CustomStack<Student> customStack;
    private final CustomQueue<Student> customQueue;

    public ButtonController() {
        this.customLinkedList = new CustomLinkedList<>();
        this.customStack = new CustomStack<>();
        this.customQueue = new CustomQueue<>();
    }

    public void createDatasetButton(ActionEvent e) {

        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if (selectedTab.getText().equals("Linked List")) {
            this.customLinkedList.buildLinkedList();
            String resultList = customLinkedList.print();
            datasetLabel.setText(resultList);
        } else if (selectedTab.getText().equals("Stack")) {
            this.customStack.buildStack();
            String resultStack = customStack.print();
            datasetLabelStack.setText(resultStack);
        } else {
            this.customQueue.buildStack();
            String resultQueue = customQueue.print();
            datasetLabelBST.setText(resultQueue);
        }
    }


    public void sortingButton(ActionEvent e) {
        Button button = (Button) e.getSource();
        String buttonText = button.getText();
        String result;
        long startTime = -1;
        long endTime = -1;
        double execDuration;

        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if (selectedTab.getText().equals("Linked List")) {
            switch (buttonText) {
                case "First name" -> {
                    startTime = System.nanoTime();
                    this.customLinkedList.sort("firstname");
                    endTime = System.nanoTime();
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                }
                case "Last name" -> {
                    startTime = System.nanoTime();
                    this.customLinkedList.sort("lastname");
                    endTime = System.nanoTime();
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                }
                case "Student number" -> {
                    startTime = System.nanoTime();
                    this.customLinkedList.sort("studentnumber");
                    endTime = System.nanoTime();
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                }
                default -> {
                }
            }
                if (startTime != -1) {
                    execDuration = (endTime - startTime);
                    linkedListTime.setText(String.format("%.1f", execDuration / 1000000));
                }
        } else if (selectedTab.getText().equals("Stack")) {
            switch (buttonText) {
                case "First name" -> {
                    startTime = System.nanoTime();
                    this.customStack.insertionSort("firstname");
                    endTime = System.nanoTime();
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                }
                case "Last name" -> {
                    startTime = System.nanoTime();
                    this.customStack.insertionSort("lastname");
                    endTime = System.nanoTime();
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                }
                case "Student number" -> {
                    startTime = System.nanoTime();
                    this.customStack.insertionSort("studentnumber");
                    endTime = System.nanoTime();
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                }
                default -> {
                }
            }
            if (startTime != -1) {
                execDuration = (endTime - startTime);
                stackTime.setText(String.format("%.1f", execDuration / 1000000));
            }
        } else {
            switch (buttonText) {
                case "First name" -> {
                    startTime = System.nanoTime();
                    this.customQueue.sort("firstname");
                    endTime = System.nanoTime();
                    result = this.customQueue.print();
                    sortedBSTLabel.setText(result);
                    queueSearchLabel.setText("Binary search on first name:");
                }
                case "Last name" -> {
                    startTime = System.nanoTime();
                    this.customQueue.sort("lastname");
                    endTime = System.nanoTime();
                    result = this.customQueue.print();
                    sortedBSTLabel.setText(result);
                    queueSearchLabel.setText("Binary search on last name:");
                }
                case "Student number" -> {
                    startTime = System.nanoTime();
                    this.customQueue.sort("studentnumber");
                    endTime = System.nanoTime();
                    result = this.customQueue.print();
                    sortedBSTLabel.setText(result);
                    queueSearchLabel.setText("Binary search on student number:");
                }
                default -> {
                }
            }
            if (startTime != -1) {
                execDuration = (endTime - startTime);
                BSTtime.setText(String.format("%.1f", execDuration / 1000000));
            }
        }


    }

    public boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public void search(ActionEvent e) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();

        if (selectedTab.getText().equals("Linked List")) {
            String input = linkedListInputSearchField.getText();
            if (isNumeric(input)) {
                Student student = new Student("","", Integer.parseInt(input));
                if (this.customLinkedList.search(student)) {
                    alert.setContentText("Studentnumber exists");
                } else {
                    alert.setContentText("Studentnumber does not exist");
                }
            } else {
                Student student = new Student(input, input, 1);
                if (this.customLinkedList.search(student)) {
                    alert.setContentText("Student exists");
                } else {
                    alert.setContentText("Student does not exist");
                }
            }
            alert.showAndWait();
        } else if(selectedTab.getText().equals("Stack")) {
            String input = stackInputSearchField.getText();

            if (isNumeric(input)) {
                int studentNumber = Integer.parseInt(input);
                if (this.customStack.search(studentNumber)) {
                    alert.setContentText("Studentnumber exists");
                } else {
                    alert.setContentText("Studentnumber does not exist");
                }
            } else {
                if (this.customStack.search(input)) {
                    alert.setContentText("Student exists");
                } else {
                    alert.setContentText("Student does not exist");
                }
            }
            alert.showAndWait();
        } else {
            String input = queueInputSearchField.getText();

            if (isNumeric(input)) {
                int studentNumber = Integer.parseInt(input);
                if (this.customQueue.search(new Student("", "", studentNumber))) {
                    alert.setContentText("Studentnumber exists");
                } else {
                    alert.setContentText("Studentnumber does not exist");
                }
            } else {
                if (this.customQueue.search(new Student(input, input, -1))) {
                    alert.setContentText("Student exists");
                } else {
                    alert.setContentText("Student does not exist");
                }
            }
            alert.showAndWait();
        }
    }
}