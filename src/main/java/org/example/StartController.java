package org.example;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartController {

    public Button startRegisterButtonPressed;
    public Button startLoginButtonPressed;
    public Button startProfileButtonPressed;

    public void initialize(){
        if(!(App.globalCurrentUser == null)){
            startLoginButtonPressed.relocate(-100,-100);
            startRegisterButtonPressed.relocate(-100,-100);
            startProfileButtonPressed.relocate(502.25,25);
        } else {

        }
    }

    public void startProfileButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Profil");
    }

    public void StartloginButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Logga_in");
    }

    public void movetoSearch(ActionEvent actionEvent) throws IOException {
        App.setRoot("Sokresultat");
    }

    public void startRegisterButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Registrering");
    }
}