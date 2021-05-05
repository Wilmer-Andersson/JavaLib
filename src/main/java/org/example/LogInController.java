package org.example;

import Objects.User;
import brains.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInController {

    User currentUser;

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    public Button loginPasswordButton;
    public Button loginCancelButton;

    public void logInButtonPressed(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        currentUser = Login.authUser(username,password);
        if(currentUser == null){
            loginPasswordButton.setText("Login failed!");
            loginPasswordButton.getStyleClass().add(".errorAids"); //Verkar inte göra nått vettigt asså
        } else{
            loginPasswordButton.setText("Login Successful!");
            App.globalCurrentUser = currentUser;
            App.setRoot("Start");
        }
    }

    public void escapeButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }
}
