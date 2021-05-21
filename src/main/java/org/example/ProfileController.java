package org.example;

import Objects.Artikel;
import Objects.Loan;
import Objects.User;
import brains.OutLoan;
import brains.Search;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfileController {

    public Label fNameLabel;
    public Label lNameLabel;
    public Label telNrLabel;
    public Label activeLoansLabel;
    public VBox VBoxActiveLoan;
    public ListView profileListView;

    private User user = App.globalCurrentUser;
    private List<Loan> loanIDs = new ArrayList<>();

    public void homeButtonPressed(ActionEvent actionEvent) throws IOException {
        App.setRoot("Start");
    }

    public void initialize() throws SQLException {
        fNameLabel.setText(user.getfName());
        lNameLabel.setText(user.getlName());
        telNrLabel.setText(user.getTelNr());
        activeLoansLabel.setText(String.valueOf(user.getActiveLoans()));

        List<Artikel> testLista = OutLoan.searchLoansArticles(user);
        List<Loan> loanList = OutLoan.searchLoans(user);

        if (!(testLista == null)){
            for(Loan l: loanList){
                loanIDs.add(l);
                profileListView.getItems().add("Låne ID: " + l.getLoanID() + ", Artikel: " + l.getArticle() + ", Utlåningsdatum " + l.getLoanStartDate());
            }

            /*for(Artikel a: testLista){
                for(Loan l: loanList){
                    profileListView.getItems().add("Låne ID: " + l.getLoanID() + " ArtikelNamn: " + a.getArtikelNr() + l.getArticle());
                }
                //VBoxActiveLoan.getChildren().add(new Label("Artikel: " +a.getArtikelNamn()));
                //profileListView.getItems().add("Artikelnummer: "+a.getArtikelNr()+", Artikelnamn: "+a.getArtikelNamn());
            }*/
        }
    }

    public void loanBack(ActionEvent actionEvent) {
        System.out.println(profileListView.getSelectionModel().getSelectedItem());
        String hela = (String) profileListView.getSelectionModel().getSelectedItem();
        int n = profileListView.getSelectionModel().getSelectedIndex();
        String loanID = String.valueOf(loanIDs.get(n).getLoanID());
        System.out.println(loanID);



        profileListView.getItems().remove(n);
    }
}
