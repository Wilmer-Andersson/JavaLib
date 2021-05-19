package org.example;

import Objects.User;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ModifyUserController {
    public TextField modifyUserUsernameField;
    public TextField modifyUserFirstnameField;
    public TextField modifyUserLastnameField;
    public TextField modifyUserEmailField;
    public TextField modifyUserAgeField;
    public TextField modifyUserPhoneField;
    public TextField modifyUserAccesslevelField;

    private User user = App.globalCurrentUser;

    public void initialize(){
        modifyUserUsernameField.setText(user.getUserName());
        modifyUserFirstnameField.setText(user.getfName());
        modifyUserLastnameField.setText(user.getlName());
        modifyUserEmailField.setText(user.getEmail());
        modifyUserAgeField.setText(String.valueOf(user.getAge()));
        modifyUserPhoneField.setText(user.getTelNr());
        modifyUserAccesslevelField.setText(String.valueOf(user.getAccessLevel()));
    }

    public void modifyUserSaveButtonPressed(ActionEvent actionEvent) {

    }

    public void modifyUserCancelButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void registerHomeButton(ActionEvent actionEvent) {
    }
}
