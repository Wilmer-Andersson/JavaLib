package org.example;

import Objects.User;
import brains.EditDB;
import brains.Login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class ModifyUserController {
    public TextField modifyUserUsernameField;
    public TextField modifyUserFirstnameField;
    public TextField modifyUserLastnameField;
    public TextField modifyUserEmailField;
    public TextField modifyUserAgeField;
    public TextField modifyUserPhoneField;
    public ChoiceBox modifyUserAccesslevelBox;

    private User user = null;

    private String choice;

    public void initialize(){
        ArrayList<String> list = new ArrayList<>();

        list.add("Vanlig användare");
        list.add("Student");
        list.add("Forskare");
        list.add("Universitetsanställd");
        list.add("Biblioteksanställd");

        ObservableList<String> observableList = FXCollections.observableList(list);
        modifyUserAccesslevelBox.setItems(observableList);
    }

    public void modifyUserSaveButtonPressed(ActionEvent actionEvent) {

        int userLevel = 0;
        choice = String.valueOf(modifyUserAccesslevelBox.valueProperty().getValue());

        if (choice.equals("Vanlig användare")) userLevel = 0;
        if (choice.equals("Student")) userLevel = 1;
        if (choice.equals("Forskare")) userLevel = 2;
        if (choice.equals("Universitetsanställd")) userLevel = 3;
        if (choice.equals("Biblioteksanställd")) userLevel = 4;


        EditDB.editUser(modifyUserFirstnameField.getText(),modifyUserLastnameField.getText(),modifyUserEmailField.getText(),userLevel,modifyUserPhoneField.getText(),Integer.parseInt(modifyUserAgeField.getText()),modifyUserUsernameField.getText());
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

        if(user.getAccessLevel() == 0) modifyUserAccesslevelBox.setValue("Vanlig användare");
        if(user.getAccessLevel() == 1) modifyUserAccesslevelBox.setValue("Student");
        if(user.getAccessLevel() == 2) modifyUserAccesslevelBox.setValue("Forskare");
        if(user.getAccessLevel() == 3) modifyUserAccesslevelBox.setValue("Universitetsanställd");
        if(user.getAccessLevel() == 4) modifyUserAccesslevelBox.setValue("Biblioteksanställd");
    }
}
