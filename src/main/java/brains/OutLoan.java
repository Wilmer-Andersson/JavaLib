package brains;

import Objects.Artikel;
import Objects.User;

import java.sql.*;
import java.time.*;
import java.util.Scanner;

public class OutLoan {
    static String dbUrl = "jdbc:mysql://localhost:3306/javaTestDB";
    static String dbUser = "root";
    static String dbPass = "Lösenord";
    static Scanner input = new Scanner(System.in);

    public static void CreateLoan(User user, String artikelID,int loanTime){


        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            PreparedStatement ps = con.prepareStatement("insert into Loans(artikelID,userName,loanDuration,loanStartDate) values(?,?,?,?)");
            ps.setString(1,artikelID);
            ps.setString(2,user.getUserName());
            ps.setInt(3,loanTime);
            ps.setDate(4, Date.valueOf(LocalDate.now()));

            ps.executeUpdate();

            System.out.println("Loan created!");

            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
