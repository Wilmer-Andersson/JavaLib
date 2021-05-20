package org.example;

import brains.EditDB;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;

public class AddMovieController {
    public TextField addMovieArticleID;
    public TextField addMovieArticleName;
    public TextField addMovieLoanTime;
    public TextField addMovieShelf;
    public TextField addMovieAmount;
    public TextField addMovieDescription;
    public TextField addMovieGenre;
    public TextField addMovieLanguage;
    public TextField addMovieReleaseDate;
    public TextField addMovieDirector;

    public void homeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void addMovieAddButtonPressed(ActionEvent actionEvent) {
        EditDB.createMovie(addMovieArticleName.getText(),Integer.parseInt(addMovieLoanTime.getText()),addMovieShelf.getText(),Integer.parseInt(addMovieAmount.getText()),addMovieDescription.getText(),Integer.parseInt(addMovieArticleID.getText()),addMovieGenre.getText(),addMovieLanguage.getText(), Date.valueOf(addMovieReleaseDate.getText()),addMovieDirector.getText());
    }

    public void addMovieCancelButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }
}
