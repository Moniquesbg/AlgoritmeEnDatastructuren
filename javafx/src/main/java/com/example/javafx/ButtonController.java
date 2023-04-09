package com.example.javafx;

import com.example.javafx.dataset.Data;
import com.example.javafx.datastructures.LinkedList.CustomLinkedList;
import com.example.javafx.datastructures.Stack.CustomStack;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ButtonController {
    @FXML
    private Label datasetLabel;
    @FXML
    private Label datasetLabelStack;
    @FXML
    private Label sortedDatasetLabel;
    @FXML
    private TextField linkedListInputSearchField;
    private CustomLinkedList customLinkedList;
    private CustomStack customStack;
    private BubbleSort bubbleSort;
    private StudentComparator compare;


    public ButtonController()
    {
        this.customLinkedList = new CustomLinkedList();
        this.customStack = new CustomStack();
        this.bubbleSort = new BubbleSort();
    }

    public void createDatasetButton(ActionEvent e)
    {
        customLinkedList.buildLinkedList();
        String result = customLinkedList.print();
        datasetLabel.setText(result);
        datasetLabelStack.setText(result);
    }

    public void sortingButton(ActionEvent e)
    {
        Button button = (Button) e.getSource();
        String buttonText = button.getText();
        String result = "error";

        switch (buttonText)
        {
            case "First name":
                this.customLinkedList.bubbleSort("firstName");
                result = customLinkedList.print();
                sortedDatasetLabel.setText(result);
                System.out.println("meep");
                break;
            case "Last name":
                this.customLinkedList.bubbleSort("lastName");
                result = customLinkedList.print();
                sortedDatasetLabel.setText(result);
                System.out.println("bleep");
                break;
            case "Student number":
                this.customLinkedList.bubbleSort("studentNumber");
                result = customLinkedList.print();
                sortedDatasetLabel.setText(result);
                System.out.println("bloop");
                break;
            default:
                break;
        }
    }
    public boolean isNumeric(String input)
    {
        if(input == null)
        {
            return false;
        }
        try{
           Integer.parseInt(input);
        }catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public void searchLinkedList(ActionEvent e)
    {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String input = linkedListInputSearchField.getText();

        if(isNumeric(input))
        {
            int studentNumber = Integer.parseInt(input);
            if(this.customLinkedList.search(studentNumber))
            {
                alert.setContentText("Studentnumber exists");
            }else{
                alert.setContentText("Studentnumber does not exist");
            }
        }else{
            if(this.customLinkedList.search(input))
            {
                alert.setContentText("Student exists");
            }else{
                alert.setContentText("Student does not exist");
            }
        }
        alert.showAndWait();
    }
}