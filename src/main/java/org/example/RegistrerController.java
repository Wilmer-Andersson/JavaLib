package org.example;

import brains.Login;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrerController {

    public TextField registerFnameField;
    public TextField registerEnameField;
    public TextField registerUsernameField;
    public TextField registerPhoneNrField;
    public TextField registerMailField;
    public Button registerButton;

    public void registerHomeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void registerButtonPressed(ActionEvent actionEvent) {
        Login.register();
    }
}
