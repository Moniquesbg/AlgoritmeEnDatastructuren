package com.example.javafx;

import com.example.javafx.dataset.Data;
import com.example.javafx.datastructures.LinkedList.CustomLinkedList;
import com.example.javafx.datastructures.Stack.CustomStack;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class ButtonController {
    @FXML
    private Label datasetLabel;
    @FXML
    private Label sortedDatasetLabel;
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
}