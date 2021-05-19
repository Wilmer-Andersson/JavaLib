package org.example;

import Objects.Artikel;
import brains.EditDB;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;

public class AddBookController {

    Artikel.Bok currentBook = (Artikel.Bok) App.currentArticle;

    public TextField addBookArticleID;
    public TextField addBookArticleName;
    public TextField addBookLoanTime;
    public TextField addBookShelf;
    public TextField addBookAmount;
    public TextField addBookDescription;
    public TextField addBookGenre;
    public TextField addBookLanguage;
    public TextField addBookReleaseDate;
    public TextField addBookPublisher;
    public TextField addBookISBN;
    public TextField addBookAuthor;
    public TextField addBookEdition;

    public void initialize(){
        /* addBookArticleID.setText(String.valueOf(currentBook.getArtikelNr()));
        addBookArticleName.setText(currentBook.getArtikelNamn());
        addBookLoanTime.setText(String.valueOf(currentBook.getLaneTid()));
        addBookShelf.setText(currentBook.getLagerPlats());
        addBookAmount.setText(String.valueOf(currentBook.getAntal()));
        addBookDescription.setText("DESCRIPTION");
        addBookGenre.setText(currentBook.getGenre());
        addBookLanguage.setText(currentBook.getSpråk());
        addBookReleaseDate.setText(currentBook.getUtgivningsÅr());
        addBookPublisher.setText(currentBook.getFörlag());
        addBookISBN.setText(currentBook.getIsbn());
        addBookAuthor.setText(currentBook.getFörfattare());
        addBookEdition.setText(currentBook.getUpplaga()); */
    }

    public void registerHomeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void addBookAddButtonPressed(ActionEvent actionEvent) {
        EditDB.createBook(
                addBookArticleName.getText(),
                Integer.parseInt(addBookLoanTime.getText()),
                addBookShelf.getText(),
                Integer.parseInt(addBookAmount.getText()),
                addBookDescription.getText(),
                Integer.parseInt(addBookArticleID.getText()),
                addBookGenre.getText(),
                addBookLanguage.getText(),
                Date.valueOf(addBookReleaseDate.getText()),
                addBookPublisher.getText(),
                addBookISBN.getText(),
                addBookAuthor.getText(),
                Integer.parseInt(addBookEdition.getText()));
    }

    public void addBookCancelButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }
}
