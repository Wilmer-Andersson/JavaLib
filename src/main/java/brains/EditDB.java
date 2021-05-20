package brains;

import Objects.User;
import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.*;

public class EditDB {
    static String dbUrl = "jdbc:mysql://localhost:3306/bobblan";
    static String dbUser = "root";
    static String dbPass = "Lösenord";



    public static void editJournal(String ArticleName, int LoanTime, String StorageSpace, int Amount, String Description, int ArticleID, String Genre, String Language, Date ReleaseDate, String ISSN, String Source){
        String loantime = String.valueOf(LoanTime);
        String amunt = String.valueOf(Amount);
        String articleid = String.valueOf(ArticleID);

        try {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String statement1 = "update articles set articleName = '" + ArticleName + "', loanTime = " + loantime + ", storageSpace = '" + StorageSpace + "', amount = " + amunt + ", description = '" + Description + "' where articleID = " + articleid;
            String statement2 = "update journal set genre = '" + Genre + "', language = '" + Language + "', releaseDate = '" + ReleaseDate + "', ISSN = '" + ISSN + "', source = '" + Source + "' where articleID = " + articleid;;

            System.out.println(statement1);
            System.out.println(statement2);

            PreparedStatement ps1 = con.prepareStatement(statement1);
            PreparedStatement ps2 = con.prepareStatement(statement2);

            ps1.executeUpdate();
            ps2.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }









    public static void createMovie(String ArticleName, int LoanTime, String StorageSpace, int Amount, String Description, int ArticleID, String Genre, String Language, Date ReleaseDate, String Director){

        String loantime = String.valueOf(LoanTime);
        String amunt = String.valueOf(Amount);
        String articleid = String.valueOf(ArticleID);

        try {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String statement1 = "insert into articles(articleID, articleName, loanTime, storageSpace, amount, description) values (" + articleid + ", '"+ ArticleName + "', " + loantime + ", '" + StorageSpace + "', " + amunt + ", '" + Description +"')";
            String statement2 = "insert into movie(articleID, genre, language, releaseDate, director) values( '" + articleid + "', '" + Genre + "', '" + Language + "','" + ReleaseDate + "','" + Director + "')";

            System.out.println(statement1);
            System.out.println(statement2);

            PreparedStatement ps1 = con.prepareStatement(statement1);
            PreparedStatement ps2 = con.prepareStatement(statement2);

            ps1.executeUpdate();
            ps2.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteMovie(int ArticleID){
        String article = String.valueOf(ArticleID);

        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String statement1 = "delete from articles where articleID = " + article;
            String statement2 = "delete from movie where articleID = " + article;

            PreparedStatement ps1 = con.prepareStatement(statement1);
            PreparedStatement ps2 = con.prepareStatement(statement2);

            ps1.executeUpdate();
            ps2.executeUpdate();

            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void editMovie(String ArticleName, int LoanTime, String StorageSpace, int Amount, String Description, int ArticleID, String Genre, String Language, Date ReleaseDate, String Director){

        String loantime = String.valueOf(LoanTime);
        String amunt = String.valueOf(Amount);
        String articleid = String.valueOf(ArticleID);

        try {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String statement1 = "update articles set articleName = '" + ArticleName + "', loanTime = " + loantime + ", storageSpace = '" + StorageSpace + "', amount = " + amunt + ", description = '" + Description + "' where articleID = " + articleid;
            String statement2 = "update movie set genre = '" + Genre + "', language = '" + Language + "', releaseDate = '" + ReleaseDate + "', director = '" + Director + "' where articleID = " + articleid;

            System.out.println(statement1);
            System.out.println(statement2);

            PreparedStatement ps1 = con.prepareStatement(statement1);
            PreparedStatement ps2 = con.prepareStatement(statement2);

            ps1.executeUpdate();
            ps2.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createBook(String ArticleName, int LoanTime, String StorageSpace, int Amount, String Description, int ArticleID, String Genre, String Language, Date ReleaseDate, String Publisher, String ISBN, String Author, int Edition){
        String loantime = String.valueOf(LoanTime);
        String amunt = String.valueOf(Amount);
        String articleid = String.valueOf(ArticleID);
        String edition = String.valueOf(Edition);

        try {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String statement1 = "insert into articles(articleID, articleName, loanTime, storageSpace, amount, description) values (" + articleid + ", '"+ ArticleName + "', " + loantime + ", '" + StorageSpace + "', " + amunt + ", '" + Description +"')";
            String statement2 = "insert into book(articleID, genre, language, releaseDate, publisher, ISBN, author, edition) values (" + articleid + ", '" + Genre + "', '"+Language+"', '"+ReleaseDate+"', '"+Publisher+"', '"+ISBN+"', '"+Author+"', "+edition + ")";

            System.out.println(statement1);
            System.out.println(statement2);

            PreparedStatement ps1 = con.prepareStatement(statement1);
            PreparedStatement ps2 = con.prepareStatement(statement2);

            ps1.executeUpdate();
            ps2.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void editBooks(String ArticleName, int LoanTime, String StorageSpace, int Amount, String Description, int ArticleID, String Genre, String Language, Date ReleaseDate, String Publisher, String ISBN, String Author, int Edition) {

        String loantime = String.valueOf(LoanTime);
        String amunt = String.valueOf(Amount);
        String articleid = String.valueOf(ArticleID);
        String edition = String.valueOf(Edition);

        try {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String statement1 = "update articles set articleName = '" + ArticleName + "', loanTime = " + loantime + ", storageSpace = '" + StorageSpace + "', amount = " + amunt + ", description = '" + Description + "' where articleID = " + articleid;
            String statement2 = "update book set genre = '" + Genre + "', language = '" + Language + "', releaseDate = '" + ReleaseDate + "', publisher = '" + Publisher + "', ISBN = '" + ISBN + "', author = '" + Author + "', edition = " + edition + " where articleID = " + articleid;

            System.out.println(statement1);
            System.out.println(statement2);

            PreparedStatement ps1 = con.prepareStatement(statement1);
            PreparedStatement ps2 = con.prepareStatement(statement2);

            ps1.executeUpdate();
            ps2.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(int articleID){
        String article = String.valueOf(articleID);

        try{
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String statement1 = "delete from articles where articleID = " + article;
            String statement2 = "delete from book where articleID = " + article;

            PreparedStatement ps1 = con.prepareStatement(statement1);
            PreparedStatement ps2 = con.prepareStatement(statement2);

            ps1.executeUpdate();
            ps2.executeUpdate();

            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
