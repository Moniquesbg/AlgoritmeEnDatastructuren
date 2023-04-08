package com.example.javafx;

import com.example.javafx.dataset.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class ButtonController {
    @FXML
    private Label welcomeText;
    private Data dataset;
    

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void createDataset(ActionEvent e)
    {
        dataset.createDataSet(5);
    }
}