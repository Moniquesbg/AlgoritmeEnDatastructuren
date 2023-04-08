package com.example.javafx;

import com.example.javafx.dataset.Data;
import com.example.javafx.datastructures.LinkedList.CustomLinkedList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class ButtonController {
    @FXML
    private Label datasetLabel;
    private CustomLinkedList customLinkedList;
    private Data dataset;
    

    public void createDatasetButton(ActionEvent e)
    {
        this.customLinkedList = new CustomLinkedList();
        customLinkedList.buildLinkedList();
        String result = customLinkedList.print();
        datasetLabel.setText(result);
    }
}