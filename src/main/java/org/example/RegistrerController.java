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
    public TextField registerPasswordField;
    public TextField registerPasswordRepeatField;
    public Button registerButton;

    private String fName = registerFnameField.getText();
    private String eName = registerEnameField.getText();
    private String username = registerUsernameField.getText();
    private String phoneNr = registerPhoneNrField.getText();
    private String eMail = registerMailField.getText();
    private String password = registerPasswordField.getText();
    private String passwordRepeat = registerPasswordRepeatField.getText();

    public void registerHomeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void registerButtonPressed(ActionEvent actionEvent) throws IOException {
        //Kikar så att alla fällt är ifyllda och att mailen innehåller @
        if(eMail.contains("@")
                && !fName.equals("")
                && !eName.equals("")
                && !username.equals("")
                && !phoneNr.equals("")
                && !password.equals("")
                && !passwordRepeat.equals("")){

            //Kikar så att lösenorden matchar, om det stämmer skapa ett konto med all info
            if(password.equals(passwordRepeat)){
                if(Login.register(
                        username,
                        fName,
                        eName,
                        phoneNr,
                        eMail,
                        password)){
                    App.setRoot("Start");
                }
            }
        } else System.out.println("Inte fyllt i alla fällt etc");
    }

}
