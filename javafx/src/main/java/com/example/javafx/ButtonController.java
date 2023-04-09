package com.example.javafx;

import com.example.javafx.dataset.Data;
import com.example.javafx.datastructures.BinarySearchTree.BinarySearchTree;
import com.example.javafx.datastructures.LinkedList.CustomLinkedList;
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
    private TextField linkedListInputSearchField;
    @FXML
    private TextField stackInputSearchField;
    @FXML
    private Label datasetLabelBST;
    @FXML
    private Label sortedBSTLabel;

    @FXML
    private TextField BSTinputField;

    @FXML
    private Label linkedListTime;

    @FXML
    private Label BSTtime;

    @FXML
    private Label stackTime;
    private CustomLinkedList customLinkedList;
    private CustomStack customStack;
    private BinarySearchTree binarySearchTree;
    private BubbleSort bubbleSort;
    private StudentComparator compare;

    public ButtonController() {
        this.customLinkedList = new CustomLinkedList();
        this.customStack = new CustomStack();
        this.bubbleSort = new BubbleSort();
        this.binarySearchTree = new BinarySearchTree(new StudentComparator("firstName"));
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
            this.binarySearchTree.buildBST();
            String resultBST = binarySearchTree.traverse();
            datasetLabelBST.setText(resultBST);
        }
    }


    public void sortingButton(ActionEvent e) {
        Button button = (Button) e.getSource();
        String buttonText = button.getText();
        String result = "error";
        double startTime = -1;
        double endTime = -1;
        double execDuration;

        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if (selectedTab.getText().equals("Linked List")) {
            switch (buttonText) {
                case "First name":
                    startTime = System.nanoTime();
                    this.customLinkedList.bubbleSort("firstName");
                    endTime = System.nanoTime();
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                    break;
                case "Last name":
                    startTime = System.nanoTime();
                    this.customLinkedList.bubbleSort("lastName");
                    endTime = System.nanoTime();
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                    break;
                case "Student number":
                    startTime = System.nanoTime();
                    this.customLinkedList.bubbleSort("studentNumber");
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                    break;
                default:
                    break;
            }
            if (startTime != -1) {
                execDuration = (endTime - startTime);
                linkedListTime.setText(String.format("%.1f", execDuration / 1000000));
            }
        } else if (selectedTab.getText().equals("Stack")) {
            switch (buttonText) {
                case "First name":
                    startTime = System.nanoTime();
                    this.customStack.bubbleSort("firstName");
                    endTime = System.nanoTime();
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                    break;
                case "Last name":
                    startTime = System.nanoTime();
                    this.customStack.bubbleSort("lastName");
                    endTime = System.nanoTime();
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                    break;
                case "Student number":
                    startTime = System.nanoTime();
                    this.customStack.bubbleSort("studentNumber");
                    endTime = System.nanoTime();
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                    break;
                default:
                    break;
            }
            if (startTime != -1) {
                execDuration = (endTime - startTime);
                stackTime.setText(String.format("%.1f", execDuration / 1000000));
            }
        } else {
            switch (buttonText) {
                case "First name":
                    startTime = System.nanoTime();
                    result = this.binarySearchTree.traverse();
                    endTime = System.nanoTime();
                    sortedBSTLabel.setText(result);
                    break;
                case "Last name":
                    startTime = System.nanoTime();
                    this.binarySearchTree.setComparator(new StudentComparator("lastName"));
                    endTime = System.nanoTime();
                    result = this.binarySearchTree.traverse();
                    sortedBSTLabel.setText(result);
                    break;
                case "Student number":
                    startTime = System.nanoTime();
                    this.binarySearchTree.setComparator(new StudentComparator("studentNumber"));
                    endTime = System.nanoTime();
                    result = this.binarySearchTree.traverse();
                    sortedBSTLabel.setText(result);
                    break;
                default:
                    break;
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

    public void searchLinkedList(ActionEvent e) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);


        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if (selectedTab.getText().equals("Linked List")) {
            String input = linkedListInputSearchField.getText();
            if (isNumeric(input)) {
                int studentNumber = Integer.parseInt(input);
                if (this.customLinkedList.search(studentNumber)) {
                    alert.setContentText("Studentnumber exists");
                } else {
                    alert.setContentText("Studentnumber does not exist");
                }
            } else {
                if (this.customLinkedList.search(input)) {
                    alert.setContentText("Student exists");
                } else {
                    alert.setContentText("Student does not exist");
                }
            }
            alert.showAndWait();
        } else if (selectedTab.getText().equals("Stack")) {
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
        }
    }

    public void searchBST() {
        String input = BSTinputField.getText();
        boolean test = this.binarySearchTree.search(input);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (test) {
            alert.setContentText("true");
        } else {
            alert.setContentText("false");
        }
    }
}