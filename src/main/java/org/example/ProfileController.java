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
import java.util.Calendar;
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
        List<Artikel> testLista = OutLoan.searchLoansArticles(user);
        List<Loan> loanList = OutLoan.searchLoans(user);

        fNameLabel.setText(user.getfName());
        lNameLabel.setText(user.getlName());
        telNrLabel.setText(user.getTelNr());
        activeLoansLabel.setText(String.valueOf(loanList.size()));



        System.out.println(testLista.size());
        System.out.println(loanList.size());

        if (!(testLista == null)){
            int i = 0;
            for(Loan l: loanList){

                // Dagens datum
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(l.getLoanStartDate());
                calendar.add(Calendar.DAY_OF_MONTH, l.getLoanDuration());

                Date returnByDate = calendar.getTime();

                loanIDs.add(l);
                profileListView.getItems().add("Låne ID: " + l.getLoanID() + ", Artikel: " + testLista.get(i).getArtikelNamn() + ", Återlämningsdatum:  " + returnByDate);
                i++;
            }
        }
    }

    public void loanBackButton(ActionEvent actionEvent) {
        System.out.println(profileListView.getSelectionModel().getSelectedItem());
        int n = profileListView.getSelectionModel().getSelectedIndex();
        String loanID = String.valueOf(loanIDs.get(n).getLoanID());
        System.out.println(loanID);

        OutLoan.loanBack(loanIDs.get(n).getLoanID(),loanIDs.get(n).getArticle());

        profileListView.getItems().remove(n);
    }
}
