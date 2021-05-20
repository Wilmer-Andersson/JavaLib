package org.example;

import Objects.User;
import brains.EditDB;
import brains.Login;
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

    private User user = null;

    public void initialize(){

    }

    public void modifyUserSaveButtonPressed(ActionEvent actionEvent) {
        EditDB.editUser(modifyUserFirstnameField.getText(),modifyUserLastnameField.getText(),modifyUserEmailField.getText(),Integer.parseInt(modifyUserAccesslevelField.getText()),modifyUserPhoneField.getText(),Integer.parseInt(modifyUserAgeField.getText()),modifyUserUsernameField.getText());
    }

    public void modifyUserCancelButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void registerHomeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void modifyUserSearchButtonPressed(ActionEvent actionEvent) {
        user = Login.tempUser(modifyUserUsernameField.getText());

        modifyUserUsernameField.setText(user.getUserName());
        modifyUserFirstnameField.setText(user.getfName());
        modifyUserLastnameField.setText(user.getlName());
        modifyUserEmailField.setText(user.getEmail());
        modifyUserAgeField.setText(String.valueOf(user.getAge()));
        modifyUserPhoneField.setText(user.getTelNr());
        modifyUserAccesslevelField.setText(String.valueOf(user.getAccessLevel()));
    }
}
