package be.pxl.ja.javafx.controller;

import be.pxl.ja.javafx.model.Counter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppController {
    @FXML
    private Label infoLabel;
    private Counter counter = new Counter();

    public void buttonPressed(ActionEvent actionEvent) {
        counter.add();
        infoLabel.setText("Count: " + counter.getValue());
    }
}
