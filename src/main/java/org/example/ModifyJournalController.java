package org.example;

import Objects.Artikel;
import brains.EditDB;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;

public class ModifyJournalController {

    Artikel.Tidsskrift currentJournal = (Artikel.Tidsskrift) App.currentArticle;

    public TextField modifyJournalSource;
    public TextField modifyJournalISSN;
    public TextField modifyJournalReleaseDate;
    public TextField modifyJournalLanguage;
    public TextField modifyJournalGenre;
    public TextField modifyJournalDescription;
    public TextField modifyJournalAmount;
    public TextField modifyJournalShelf;
    public TextField modifyJournalLoanTime;
    public TextField modifyJournalArticleName;
    public TextField modifyJournalArticleID;

    public void initialize(){
        modifyJournalArticleID.setText(String.valueOf(currentJournal.getArtikelNr()));
        modifyJournalArticleName.setText(currentJournal.getArtikelNamn());
        modifyJournalLoanTime.setText(String.valueOf(currentJournal.getLaneTid()));
        modifyJournalShelf.setText(currentJournal.getLagerPlats());
        modifyJournalAmount.setText(String.valueOf(currentJournal.getAntal()));
        modifyJournalDescription.setText("DESCRIPTION");
        modifyJournalGenre.setText(currentJournal.getGenre());
        modifyJournalLanguage.setText(currentJournal.getSpråk());
        modifyJournalReleaseDate.setText(currentJournal.getUtgivningsDatum());
        modifyJournalISSN.setText(currentJournal.getISSN());
        modifyJournalSource.setText(currentJournal.getKälla());
    }

    public void homeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void modifyJournalAddButtonPressed(ActionEvent actionEvent) {
        EditDB.editJournal(modifyJournalArticleName.getText(),Integer.parseInt(modifyJournalLoanTime.getText()),modifyJournalShelf.getText(),Integer.parseInt(modifyJournalAmount.getText()),modifyJournalDescription.getText(),Integer.parseInt(modifyJournalArticleID.getText()),modifyJournalGenre.getText(),modifyJournalLanguage.getText(), Date.valueOf(modifyJournalReleaseDate.getText()),modifyJournalISSN.getText(),modifyJournalSource.getText());
    }

    public void modifyJournalCancelButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void modifyJournalDeleteButtonPressed(ActionEvent actionEvent) throws IOException {
        EditDB.deleteJournal(currentJournal.getArtikelNr());
        App.setRoot("Start");
    }
}
