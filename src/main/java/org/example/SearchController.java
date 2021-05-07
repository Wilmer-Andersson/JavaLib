package org.example;

import Objects.Artikel;
import Objects.Loan;
import brains.OutLoan;
import brains.Search;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class SearchController {
    public TextField SearchbarThingy;
    public VBox articleVBox;
    public Label titelLabel;
    public Label authorLabel;
    public Label pagesLabel;
    public Label genreLabel;
    public Button favoriteButton;
    public Button loanButton;
    public HBox articlesHBox;

    public EventHandler<ActionEvent> initialize() {

        return null;
    }

    public void SearchArticle(ActionEvent actionEvent) {
        List<Artikel> testLista = Search.article(SearchbarThingy.getText());

        /*HBox articleHBox = new HBox();
        HBox labelHBox = new HBox();
        VBox labelVBox = new VBox();
        VBox buttonVBox = new VBox();
        HBox buttonHBox = new HBox();

        //Add and setup things


        Label titleLabel = new Label("Title");
        Label authorLabel = new Label("Author");
        Label pages = new Label("Pages");
        Label genre = new Label("Genre");

        labelVBox.getChildren().add(titleLabel);
        labelVBox.getChildren().add(authorLabel);
        labelVBox.getChildren().add(pages);
        labelVBox.getChildren().add(genre);

        Button favorite = new Button("Favvis");
        Button loan = new Button("Låna");
        favorite.setPrefHeight(30.0);
        favorite.setPrefWidth(152.0);
        loan.setPrefHeight(30.0);
        loan.setPrefWidth(152.0);

        BorderPane bp = new BorderPane();
        bp.setBottom(loan);
        bp.setTop(favorite);

        //Set heights and widths

        articleHBox.setPrefHeight(68.0);
        articleHBox.setPrefWidth(575.0);

        labelVBox.setPrefWidth(100.0);
        labelVBox.setPrefHeight(200.0);
        labelHBox.setPrefWidth(273.0);
        labelHBox.setPrefHeight(62.0);

        bp.setPrefHeight(200.0);
        bp.setPrefWidth(200.0);

        buttonVBox.setPrefHeight(62.0);
        buttonVBox.setPrefWidth(326.0);

        //Add stuff

        buttonVBox.getChildren().add(bp);
        buttonHBox.getChildren().add(buttonVBox);

        labelHBox.getChildren().add(labelVBox);

        articleHBox.getChildren().add(labelHBox);
        articleHBox.getChildren().add(buttonVBox);

        //Add to whole thingy
        articleVBox.getChildren().add(articleHBox);
        */

        for (Artikel a : testLista) {
            HBox articleHBox = new HBox();
            HBox labelHBox = new HBox();
            VBox labelVBox = new VBox();
            VBox buttonVBox = new VBox();
            HBox buttonHBox = new HBox();

            //Add and setup things


            Label titleLabel = new Label(a.getArtikelNamn());
            Label authorLabel = new Label(a.getArtikelNamn());
            Label pages = new Label(a.getArtikelNamn());
            Label genre = new Label(a.getArtikelNamn());

            labelVBox.getChildren().add(titleLabel);
            labelVBox.getChildren().add(authorLabel);
            labelVBox.getChildren().add(pages);
            labelVBox.getChildren().add(genre);

            Button favorite = new Button(a.getArtikelNamn());
            Button loan = new Button(a.getArtikelNamn());

            //Såtter vad som ska hända när man klickar på knappen :=)
            loan.setOnAction(new EventHandler() {
                @Override
                public void handle(Event event) {
                    System.out.println("LIGMA NUTZ");
                    OutLoan.CreateLoan(App.globalCurrentUser,String.valueOf(a.getArtikelNr()),14);
                }
            });

            favorite.setPrefHeight(30.0);
            favorite.setPrefWidth(152.0);
            loan.setPrefHeight(30.0);
            loan.setPrefWidth(152.0);

            BorderPane bp = new BorderPane();
            bp.setBottom(loan);
            bp.setTop(favorite);

            //Set heights and widths

            articleHBox.setPrefHeight(68.0);
            articleHBox.setPrefWidth(575.0);

            labelVBox.setPrefWidth(100.0);
            labelVBox.setPrefHeight(200.0);
            labelHBox.setPrefWidth(273.0);
            labelHBox.setPrefHeight(62.0);

            bp.setPrefHeight(200.0);
            bp.setPrefWidth(200.0);

            buttonVBox.setPrefHeight(62.0);
            buttonVBox.setPrefWidth(326.0);

            //Add stuff

            buttonVBox.getChildren().add(bp);
            buttonHBox.getChildren().add(buttonVBox);

            labelHBox.getChildren().add(labelVBox);

            articleHBox.getChildren().add(labelHBox);
            articleHBox.getChildren().add(buttonVBox);

            //Add to whole thingy
            articleVBox.getChildren().add(articleHBox);

            // System.out.println(a.getArtikelNamn() + ", " + a.getArtikelNr() + ", " + a.getPris());
            //}
        }
    }
}
