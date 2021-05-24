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
import java.lang.reflect.Type;
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

    //Laddar olika knappar etc beroende på om en användare är inloggad eller inte.
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

            if(App.globalCurrentUser.getAccessLevel() == 4){
                manageStuffButtons.setVisible(true);
                manageStuffButtons.setManaged(true);
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

    //Funktion som laddar artiklar beroende på vad som användaren har sökt på.
    public void SearchArticle(ActionEvent actionEvent) {


        //Håller koll på vilken radioknapp som är vald.
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

        articleVBox.getChildren().clear();

        //Forloop som går igenom alla artiklar som matchar det som användaren sökte på. Skapar sedan varje objekt en för en.
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
                    Label amount = new Label(String.valueOf(a.getAntal()));
                    Label genre = new Label(a.getGenre());

                    labelVBox.getChildren().add(titleLabel);
                    labelVBox.getChildren().add(authorLabel);
                    labelVBox.getChildren().add(amount);
                    labelVBox.getChildren().add(genre);

                    Button handle = new Button("Hantera");
                    Button loan = new Button("Låna artikeln");

                    //Sätter vad som ska hända när man klickar på knappen :=)
                    loan.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {
                                if(!(App.globalCurrentUser == null)){
                                    OutLoan.CreateLoan(App.globalCurrentUser,String.valueOf(a.getArtikelNr()),a.getLaneTid());
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setContentText("User not logged in, can't create loan");
                                    alert.show();
                                    System.out.println("User not logged in, can't create loan");
                                }
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    });

                handle.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try{
                            App.currentArticle = a;
                            App.setRoot("ModifyBooks");
                        } catch (IOException throwables){
                            throwables.printStackTrace();
                        }
                    }
                });

                    handle.setPrefHeight(30.0);
                    handle.setPrefWidth(60.0);
                    loan.setPrefHeight(30.0);
                    loan.setPrefWidth(60.0);

                    BorderPane bp = new BorderPane();
                    bp.setBottom(loan);

                    if(!(App.globalCurrentUser == null)){
                        if(App.globalCurrentUser.getAccessLevel() == 4) bp.setTop(handle);
                    }



                    //Set heights and widths

                    articleHBox.setPrefHeight(68.0);
                    articleHBox.getStyleClass().add("article");
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
                    Label director = new Label(a.getRegissör());
                    Label amount = new Label(String.valueOf(a.getAntal()));
                    Label genre = new Label(a.getGenre());

                    labelVBox.getChildren().add(titleLabel);
                    labelVBox.getChildren().add(director);
                    labelVBox.getChildren().add(amount);
                    labelVBox.getChildren().add(genre);

                    Button handle = new Button("Hantera");
                    Button loan = new Button("Låna artikeln");

                    //Sätter vad som ska hända när man klickar på knappen :=)
                    loan.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {
                                if(!(App.globalCurrentUser == null)){
                                OutLoan.CreateLoan(App.globalCurrentUser,String.valueOf(a.getArtikelNr()),a.getLaneTid());
                            } else {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setContentText("User not logged in, can't create loan");
                                    alert.show();
                                    System.out.println("User not logged in, can't create loan");
                                }
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    });

                handle.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try{
                            App.currentArticle = a;
                            App.setRoot("ModifyMovies");
                        } catch (IOException throwables){
                            throwables.printStackTrace();
                        }
                    }
                });

                    handle.setPrefHeight(30.0);
                    handle.setPrefWidth(152.0);
                    loan.setPrefHeight(30.0);
                    loan.setPrefWidth(152.0);

                    BorderPane bp = new BorderPane();
                    bp.setBottom(loan);
                    if(!(App.globalCurrentUser == null)){
                        if(App.globalCurrentUser.getAccessLevel() == 4) bp.setTop(handle);
                    }

                    //Set heights and widths

                    articleHBox.setPrefHeight(68.0);
                    articleHBox.getStyleClass().add("article");
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
                    Label source = new Label(a.getKälla());
                    Label amount = new Label(String.valueOf(a.getAntal()));
                    Label genre = new Label(a.getGenre());

                    labelVBox.getChildren().add(titleLabel);
                    labelVBox.getChildren().add(source);
                    labelVBox.getChildren().add(amount);
                    labelVBox.getChildren().add(genre);

                    Button handle = new Button("Hantera");
                    Button loan = new Button("Låna artikeln");

                    //Sätter vad som ska hända när man klickar på knappen :=)
                    loan.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {
                                if(!(App.globalCurrentUser == null)){
                                    OutLoan.CreateLoan(App.globalCurrentUser,String.valueOf(a.getArtikelNr()),a.getLaneTid());
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.WARNING);
                                    alert.setContentText("User not logged in, can't create loan");
                                    alert.show();
                                    System.out.println("User not logged in, can't create loan");
                                }
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    });

                handle.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try{
                            App.currentArticle = a;
                            App.setRoot("ModifyJournal");
                        } catch (IOException throwables){
                            throwables.printStackTrace();
                        }
                    }
                });

                    handle.setPrefHeight(30.0);
                    handle.setPrefWidth(152.0);
                    loan.setPrefHeight(30.0);
                    loan.setPrefWidth(152.0);

                    BorderPane bp = new BorderPane();
                    bp.setBottom(loan);
                    if(!(App.globalCurrentUser == null)){
                        if(App.globalCurrentUser.getAccessLevel() == 4) bp.setTop(handle);
                    }

                    //För att man inte kan låna en tidsskrift
                    loan.setManaged(false);
                    loan.setVisible(false);
                    //Set heights and widths

                    articleHBox.setPrefHeight(68.0);
                    articleHBox.getStyleClass().add("article");
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

    public void manageArticlesButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Hantera artiklar knapp1");
        if(selected.equals("Book")){
            System.out.println("Skapar en bok");
            App.setRoot("AddBooks");
        } if(selected.equals("Movie")){
            System.out.println("Skapar en film");
            App.setRoot("AddMovie");
        } if(selected.equals("Journal")){
            System.out.println("Skapar en tidsskrift");
            App.setRoot("AddJournal");
        }
    }

    public void manageUsersButton(ActionEvent actionEvent) throws IOException {
        System.out.println("Hantera användare knapp1");
        App.setRoot("ModifyUsers");
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
