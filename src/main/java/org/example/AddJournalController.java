package org.example;

import brains.EditDB;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;

public class AddJournalController {
    public TextField addJournalArticleID;
    public TextField addJournalArticleName;
    public TextField addJournalLoanTime;
    public TextField addJournalShelf;
    public TextField addJournalAmount;
    public TextField addJournalDescription;
    public TextField addJournalGenre;
    public TextField addJournalLanguage;
    public TextField addJournalReleaseDate;
    public TextField addJournalISSN;
    public TextField addJournalSource;

    public void homeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void addJournalAddButtonPressed(ActionEvent actionEvent) {
        EditDB.createJournal(addJournalArticleName.getText(),Integer.parseInt(addJournalLoanTime.getText()),addJournalShelf.getText(),Integer.parseInt(addJournalAmount.getText()),addJournalDescription.getText(),Integer.parseInt(addJournalArticleID.getText()),addJournalGenre.getText(),addJournalLanguage.getText(), Date.valueOf(addJournalReleaseDate.getText()),addJournalISSN.getText(),addJournalSource.getText());
    }

    public void addJournalCancelButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }
}
