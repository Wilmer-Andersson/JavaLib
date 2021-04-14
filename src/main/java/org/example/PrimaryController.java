package org.example;

import java.io.IOException;

import brains.Artikel;
import brains.DatabaseStuff;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PrimaryController {
    public Label label1;
    public VBox sigmaVBox;
    int i;

    public Button primaryButton;

    public void ligmaLable(){
        i++;
        label1.setText(String.valueOf(i));
    }

    public void initialize(){
        DatabaseStuff.readDB();
        for(Artikel a : DatabaseStuff.testLista){
            HBox härj = new HBox();
            Button but1 = new Button(String.valueOf(a.getArtikelNr()));
            Button but2 = new Button(String.valueOf(a.getArtikelNamn()));
            Button but3 = new Button(String.valueOf(a.getPris()));
            härj.getChildren().add(but1);
            härj.getChildren().add(but2);
            härj.getChildren().add(but3);
            sigmaVBox.getChildren().add(härj);
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
