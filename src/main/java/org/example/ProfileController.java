package org.example;

import Objects.Artikel;
import Objects.User;
import brains.OutLoan;
import brains.Search;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProfileController {

    public Label fNameLabel;
    public Label lNameLabel;
    public Label telNrLabel;
    public Label activeLoansLabel;
    public VBox VBoxActiveLoan;

    private User user = App.globalCurrentUser;

    public void homeButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void initialize() throws SQLException {
        fNameLabel.setText(user.getfName());
        lNameLabel.setText(user.getlName());
        telNrLabel.setText(user.getTelNr());
        activeLoansLabel.setText(String.valueOf(user.getActiveLoans()));

        List<Artikel> testLista = OutLoan.searchLoans(user);

        if (!(testLista == null)){
            for(Artikel a: testLista){
                VBoxActiveLoan.getChildren().add(new Label("Artikel: " +a.getArtikelNamn()));
            }
        }
    }
}
