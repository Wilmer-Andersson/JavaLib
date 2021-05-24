package org.example;

import brains.Login;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class RegistrerController {

    public TextField registerFnameField;
    public TextField registerEnameField;
    public TextField registerUsernameField;
    public TextField registerPhoneNrField;
    public TextField registerMailField;
    public TextField registerPasswordField;
    public TextField registerPasswordRepeatField;
    public Button registerButton;
    public VBox registerBox;


    public void registerHomeButton() throws IOException {
        App.setRoot("Start");
    }

    public void registerButtonPressed() throws Exception {

             try {
                  regButton();
             } catch (Exception e) {
                 e.printStackTrace();
                 HBox hBox = new HBox();
                 Label label = new Label(e.getMessage());
             }


    }

    public void regButton() throws Exception {
            String fName = registerFnameField.getText();
                   String eName = registerEnameField.getText();
                   String username = registerUsernameField.getText();
                   String phoneNr = registerPhoneNrField.getText();
                   String eMail = registerMailField.getText();
                   String password = registerPasswordField.getText();
                   String passwordRepeat = registerPasswordRepeatField.getText();

                   //Kikar så att alla fällt är ifyllda och att mailen innehåller @
                   if(eMail.contains("@")
                           && !fName.equals("")
                           && !eName.equals("")
                           && !username.equals("")
                           && !phoneNr.equals("")
                           && !password.equals("")
                           && !passwordRepeat.equals("")) {

                       //Kikar så att lösenorden matchar, om det stämmer skapa ett konto med all info
                       if (password.equals(passwordRepeat)) {

                               if (Login.register(
                                       username,
                                       fName,
                                       eName,
                                       phoneNr,
                                       eMail,
                                       password)) {
                                   App.setRoot("Start");
                               }
                           }
                       } else {
                       Alert alert = new Alert(Alert.AlertType.WARNING);
                       alert.setContentText("Felinmatning, vänligen korrigera");
                       alert.show();
                   }
                   }
    }