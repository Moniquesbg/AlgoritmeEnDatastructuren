package com.example.javafx;

import com.example.javafx.dataset.Data;
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

        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if(selectedTab.getText().equals("Linked List"))
        {
            this.customLinkedList.buildLinkedList();
            String resultList = customLinkedList.print();
            datasetLabel.setText(resultList);
        }else if(selectedTab.getText().equals("Stack"))
        {
            this.customStack.buildStack();
            String resultStack = customStack.print();
            datasetLabelStack.setText(resultStack);
        }
        else if(selectedTab.getText().equals("Binary Search Tree"))
        {
            //code
        }
    }


    public void sortingButton(ActionEvent e)
    {
        Button button = (Button) e.getSource();
        String buttonText = button.getText();
        String result = "error";
        double startTime = -1;
        double endTime = -1;
        double execDuration;

        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if(selectedTab.getText().equals("Linked List"))
        {
            switch (buttonText)
            {
                case "First name":
                    this.customLinkedList.bubbleSort("firstName");
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                    break;
                case "Last name":
                    this.customLinkedList.bubbleSort("lastName");
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                    break;
                case "Student number":
                    this.customLinkedList.bubbleSort("studentNumber");
                    result = this.customLinkedList.print();
                    sortedDatasetLabel.setText(result);
                    break;
                default:
                    break;
            }
        }else if(selectedTab.getText().equals("Stack"))
        {
            switch (buttonText)
            {
                case "First name":
                    this.customStack.bubbleSort("firstName");
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                    break;
                case "Last name":
                    this.customStack.bubbleSort("lastName");
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                    break;
                case "Student number":
                    this.customStack.bubbleSort("studentNumber");
                    result = this.customStack.print();
                    sortedStackLabel.setText(result);
                    break;
                default:
                    break;
            }
        }

//        if (startTime != -1) {
//            execDuration = (endTime - startTime);
//            time.setText(String.format("%.1f",execDuration / 1000000));
//        }
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


        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if(selectedTab.getText().equals("Linked List"))
        {
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
        }else if(selectedTab.getText().equals("Stack"))
        {
            String input = stackInputSearchField.getText();
            if(isNumeric(input))
            {
                int studentNumber = Integer.parseInt(input);
                if(this.customStack.search(studentNumber))
                {
                    alert.setContentText("Studentnumber exists");
                }else{
                    alert.setContentText("Studentnumber does not exist");
                }
            }else{
                if(this.customStack.search(input))
                {
                    alert.setContentText("Student exists");
                }else{
                    alert.setContentText("Student does not exist");
                }
            }
            alert.showAndWait();
        }
    }
}