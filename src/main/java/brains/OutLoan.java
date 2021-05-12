package brains;

import Objects.Artikel;
import Objects.User;

import java.sql.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutLoan {
    static String dbUrl = "jdbc:mysql://localhost:3306/bobblan";
    static String dbUser = "root";
    static String dbPass = "Lösenord";
    static Scanner input = new Scanner(System.in);

    public static List searchLoans(User user) throws SQLException{
        List<Artikel> testLista = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            PreparedStatement ps = con.prepareStatement("select * from loan where userName = ?");
            ps.setString(1,user.getUserName());

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                testLista.add(new Artikel(rs.getInt("artikelNr"),rs.getString("artikelNamn")));
            }
            return testLista;

        } catch (SQLException throwables){
            return null;
        }
    }

    public static void CreateLoan(User user, String artikelID,int loanTime) throws SQLException {

        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            /*PreparedStatement checkAmount = con.prepareStatement("select antal from artiklar where artikelID = ?");
            checkAmount.setString(1,artikelID);
            ResultSet rs = checkAmount.executeQuery();

            //TODO fixa antal grejen
            if(rs.getInt("antal") <= 1){

            }*/

            PreparedStatement ps = con.prepareStatement("insert into loan(articleID,userName,loanDuration,startDate,active) values(?,?,?,?,?)");
            ps.setString(1,artikelID);
            ps.setString(2,user.getUserName());
            ps.setInt(3,loanTime);
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setBoolean(5,true);

            ps.executeUpdate();

            System.out.println("Loan created!");

            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
