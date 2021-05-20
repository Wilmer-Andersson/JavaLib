package org.example;

import Objects.Artikel;
import brains.EditDB;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;

public class ModifyBooksController {
    Artikel.Bok currentBook = (Artikel.Bok) App.currentArticle;

    public Button modifyBookSaveDelete;
    public Button modifyBookSaveButton;
    public Button modifyBookCancelButton;
    public TextField modifyBookEdition;
    public TextField modifyBookAuthor;
    public TextField modifyBookISBN;
    public TextField modifyBookPublisher;
    public TextField modifyBookReleaseDate;
    public TextField modifyBookLanguage;
    public TextField modifyBookGenre;
    public TextField modifyBookDescription;
    public TextField modifyBookAmount;
    public TextField modifyBookShelf;
    public TextField modifyBookLoanTime;
    public TextField modifyBookArticleName;
    public TextField modifyBookArticleID;

    public void initialize(){
        modifyBookArticleID.setText(String.valueOf(currentBook.getArtikelNr()));
        modifyBookArticleName.setText(currentBook.getArtikelNamn());
        modifyBookLoanTime.setText(String.valueOf(currentBook.getLaneTid()));
        modifyBookShelf.setText(currentBook.getLagerPlats());
        modifyBookAmount.setText(String.valueOf(currentBook.getAntal()));
        modifyBookDescription.setText("DESCRIPTION");
        modifyBookGenre.setText(currentBook.getGenre());
        modifyBookLanguage.setText(currentBook.getSpråk());
        modifyBookReleaseDate.setText(currentBook.getUtgivningsÅr());
        modifyBookPublisher.setText(currentBook.getFörlag());
        modifyBookISBN.setText(currentBook.getIsbn());
        modifyBookAuthor.setText(currentBook.getFörfattare());
        modifyBookEdition.setText(currentBook.getUpplaga());
    }

    public void registerHomeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void modifyBookSaveButtonPressed(ActionEvent actionEvent) {

        EditDB.editBooks(
                modifyBookArticleName.getText(),
                Integer.parseInt(modifyBookLoanTime.getText()),
                modifyBookShelf.getText(),
                Integer.parseInt(modifyBookAmount.getText()),
                modifyBookDescription.getText(),
                Integer.parseInt(modifyBookArticleID.getText()),
                modifyBookGenre.getText(),
                modifyBookLanguage.getText(),
                Date.valueOf(modifyBookReleaseDate.getText()),
                modifyBookPublisher.getText(),
                modifyBookISBN.getText(),
                modifyBookAuthor.getText(),
                Integer.parseInt(modifyBookEdition.getText()));
    }

    public void modifyBookCancelButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void modifyBookDeletePressed(ActionEvent actionEvent) throws IOException {
        EditDB.deleteBook(Integer.parseInt(modifyBookArticleID.getText()));
        System.out.println("Successfully deleted " + modifyBookArticleID.getText());
        App.setRoot("Start");
    }
}
