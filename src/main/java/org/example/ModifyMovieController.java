package org.example;

import Objects.Artikel;
import brains.EditDB;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Date;

public class ModifyMovieController {

    Artikel.Film currentMovie = (Artikel.Film) App.currentArticle;

    public TextField modifyMovieArticleID;
    public TextField modifyMovieArticleName;
    public TextField modifyMovieLoanTime;
    public TextField modifyMovieShelf;
    public TextField modifyMovieAmount;
    public TextField modifyMovieDescription;
    public TextField modifyMovieGenre;
    public TextField modifyMovieLanguage;
    public TextField modifyMovieReleaseDate;
    public TextField modifyMovieDirector;

    public void initialize(){
        modifyMovieArticleID.setText(String.valueOf(currentMovie.getArtikelNr()));
        modifyMovieArticleName.setText(currentMovie.getArtikelNamn());
        modifyMovieLoanTime.setText(String.valueOf(currentMovie.getLaneTid()));
        modifyMovieShelf.setText(currentMovie.getLagerPlats());
        modifyMovieAmount.setText(String.valueOf(currentMovie.getAntal()));
        modifyMovieDescription.setText("Description");
        modifyMovieGenre.setText(currentMovie.getGenre());
        modifyMovieLanguage.setText(currentMovie.getSpråk());
        modifyMovieReleaseDate.setText(currentMovie.getUtgivningsÅr());
        modifyMovieDirector.setText(currentMovie.getRegissör());
    }

    public void homeButton(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void modifyMovieAddButtonPressed(ActionEvent actionEvent) {
        EditDB.editMovie(modifyMovieArticleName.getText(),Integer.parseInt(modifyMovieLoanTime.getText()),modifyMovieShelf.getText(),Integer.parseInt(modifyMovieAmount.getText()),modifyMovieDescription.getText(),Integer.parseInt(modifyMovieArticleID.getText()),modifyMovieGenre.getText(),modifyMovieLanguage.getText(), Date.valueOf(modifyMovieReleaseDate.getText()),modifyMovieDirector.getText());
    }

    public void modifyMovieCancelButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void modifyMovieDeleteButtonPressed(ActionEvent actionEvent) throws IOException {
        EditDB.deleteMovie(Integer.parseInt(modifyMovieArticleID.getText()));
        App.setRoot("Start");
    }
}
