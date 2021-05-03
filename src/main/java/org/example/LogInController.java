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
    @FXML private Button loginButtonGrej;

    public void logInButtonPressed(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        currentUser = Login.authUser(username,password);
        if(currentUser == null){
            loginButtonGrej.setText("Login failed!");
            loginButtonGrej.getStyleClass().add(".errorAids"); //Verkar inte göra nått vettigt asså
        } else{
            loginButtonGrej.setText("Login Successful!");
            App.globalCurrentUser = currentUser;
            App.setRoot("Start");
        }
    }
}
