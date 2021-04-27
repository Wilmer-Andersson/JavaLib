package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartController {

    public Button startRegisterButtonPressed;
    public Button startLoginButtonPressed;

    @FXML
    public void startRegisterButtonPressed(ActionEvent actionEvent) throws IOException {

    }

    public void StartloginButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Logga_in");
    }
}
