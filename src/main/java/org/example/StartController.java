package org.example;

import Objects.Artikel;
import brains.OutLoan;
import brains.Search;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StartController {

    public Button startRegisterButtonPressed;
    public Button startLoginButtonPressed;
    public ScrollPane libraryScrollPane;
    public BorderPane buttonHolder;
    public VBox articleVBox;
    public TextField searchTextBox;
    public RadioButton radioButtonBook;
    public RadioButton radioButtonMovie;
    public RadioButton radioButtonArticle;
    public VBox manageStuffButtons;
    public Button addArticlesButton;


    private String selected = "Book";

    public void initialize(){
        manageStuffButtons.setVisible(false);
        manageStuffButtons.setManaged(false);
        if(!(App.globalCurrentUser == null)){
            buttonHolder.getChildren().clear();
            Button profileButton = new Button("Profile");
            Button logoutButton = new Button("Logga ut");
            BorderPane.setAlignment(profileButton, Pos.CENTER_RIGHT);
            BorderPane.setAlignment(logoutButton, Pos.CENTER_LEFT);
            profileButton.setOnAction(actionEvent -> {
                try {
                    startProfileButtonPressed();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            logoutButton.setOnAction(actionEvent -> {
                try{
                    startLogoutButtonPressed();
                } catch (IOException e){
                    e.printStackTrace();
                }
            });
            buttonHolder.setLeft(logoutButton);
            buttonHolder.setRight(profileButton);
            System.out.println(App.globalCurrentUser.getAccessLevel());

            if(App.globalCurrentUser.getAccessLevel() == 3){
                manageStuffButtons.setVisible(true);
                manageStuffButtons.setManaged(true);
                //manageStuffButtons.setOpacity(1); //Finns nog bättre lösningar, detta får duga för tillfället med tanke på tidsramen
            }
        } else {

        }
    }

    public void startProfileButtonPressed() throws IOException {
        App.setRoot("Profil");
    }

    public void StartloginButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Logga_in");
    }

    public void movetoSearch(ActionEvent actionEvent) throws IOException {
        App.setRoot("Sokresultat");
    }

    public void startRegisterButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Registrering");
    }

    public void startAdminButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Admin");
    }

    public void startLogoutButtonPressed() throws IOException {
        App.globalCurrentUser = null;
        App.setRoot("Start");
    }

    public void SearchArticle(ActionEvent actionEvent) {

        /*ToggleGroup group = new ToggleGroup();
        radioButtonBook.setToggleGroup(group);
        radioButtonArticle.setToggleGroup(group);
        radioButtonMovie.setToggleGroup(group);
        radioButtonBook.setSelected(true);
        */

        int articleType = 0;

        if(radioButtonBook.isSelected()){
            articleType = 1;
            System.out.println("Book");
        } if(radioButtonMovie.isSelected()){
            articleType = 2;
            System.out.println("Movie");
        } if(radioButtonArticle.isSelected()){
            articleType = 3;
            System.out.println("Article");
        }

        List<Object> articleList = Search.articlev2(searchTextBox.getText(),articleType);

        List<Artikel> testLista = Search.article(searchTextBox.getText());


        List<Object> test = new ArrayList<>();
        test.add(new Artikel.Bok(
                1337,"testBok",15,"lagerPlats",1,"genre","språk","utgivningsår","förlag","isbn","författare","upplaga"
        ));

        for(Object o : articleList){
            if(o instanceof Artikel.Bok){
                Artikel.Bok a = (Artikel.Bok) o;
                    HBox articleHBox = new HBox();
                    HBox labelHBox = new HBox();
                    VBox labelVBox = new VBox();
                    VBox buttonVBox = new VBox();
                    HBox buttonHBox = new HBox();

                    //Add and setup things
                    Label titleLabel = new Label(a.getArtikelNamn());
                    Label authorLabel = new Label(a.getFörfattare());
                    Label pages = new Label(a.getFörfattare());
                    Label genre = new Label(a.getGenre());

                    labelVBox.getChildren().add(titleLabel);
                    labelVBox.getChildren().add(authorLabel);
                    labelVBox.getChildren().add(pages);
                    labelVBox.getChildren().add(genre);

                    Button favorite = new Button("Test");
                    Button loan = new Button("Låna artikeln");

                    //Sätter vad som ska hända när man klickar på knappen :=)
                    loan.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {
                                OutLoan.CreateLoan(App.globalCurrentUser,String.valueOf(a.getArtikelNr()),a.getLaneTid());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
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
                }

            if(o instanceof Artikel.Film){
                Artikel.Film a = (Artikel.Film) o;
                    HBox articleHBox = new HBox();
                    HBox labelHBox = new HBox();
                    VBox labelVBox = new VBox();
                    VBox buttonVBox = new VBox();
                    HBox buttonHBox = new HBox();

                    //Add and setup things



                    Label titleLabel = new Label(a.getArtikelNamn());
                    Label authorLabel = new Label(a.getRegissör());
                    Label pages = new Label(a.getSpråk());
                    Label genre = new Label(a.getGenre());

                    labelVBox.getChildren().add(titleLabel);
                    labelVBox.getChildren().add(authorLabel);
                    labelVBox.getChildren().add(pages);
                    labelVBox.getChildren().add(genre);

                    Button favorite = new Button(a.getArtikelNamn());
                    Button loan = new Button(a.getArtikelNamn());

                    //Sätter vad som ska hända när man klickar på knappen :=)
                    loan.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {
                                OutLoan.CreateLoan(App.globalCurrentUser,String.valueOf(a.getArtikelNr()),a.getLaneTid());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
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
                }
            if(o instanceof Artikel.Tidsskrift){
                Artikel.Tidsskrift a = (Artikel.Tidsskrift) o;
                    HBox articleHBox = new HBox();
                    HBox labelHBox = new HBox();
                    VBox labelVBox = new VBox();
                    VBox buttonVBox = new VBox();
                    HBox buttonHBox = new HBox();

                    //Add and setup things
                    Label titleLabel = new Label(a.getArtikelNamn());
                    Label authorLabel = new Label(a.getLagerPlats());
                    Label pages = new Label(a.getKälla());
                    Label genre = new Label(a.getGenre());

                    labelVBox.getChildren().add(titleLabel);
                    labelVBox.getChildren().add(authorLabel);
                    labelVBox.getChildren().add(pages);
                    labelVBox.getChildren().add(genre);

                    Button favorite = new Button(a.getArtikelNamn());
                    Button loan = new Button(a.getArtikelNamn());

                    //Sätter vad som ska hända när man klickar på knappen :=)
                    loan.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {
                                OutLoan.CreateLoan(App.globalCurrentUser,String.valueOf(a.getArtikelNr()),a.getLaneTid());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
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
                }
            }
        }

    public void manageArticlesButton(ActionEvent actionEvent) {
        System.out.println("Hantera artiklar knapp1");
        if(selected.equals("Book")){
            System.out.println("Skapar en bok");
        } if(selected.equals("Movie")){
            System.out.println("Skapar en film");
        } if(selected.equals("Journal")){
            System.out.println("Skapar en tidsskrift");
        }
    }

    public void manageUsersButton(ActionEvent actionEvent) {
        System.out.println("Hantera användare knapp1");
    }

    public void radioSelectBook(ActionEvent actionEvent) {
        selected = "Book";
        addArticlesButton.setText("Lägg till böcker");
    }

    public void radioSelectMovie(ActionEvent actionEvent) {
        selected = "Movie";
        addArticlesButton.setText("Lägg till filmer");
    }

    public void radioSelectJournal(ActionEvent actionEvent) {
        selected = "Journal";
        addArticlesButton.setText("Lägg till tidsskrifter");
    }
}
