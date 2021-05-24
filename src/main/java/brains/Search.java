package brains;

import Objects.Artikel;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Search {
    static String dbUrl = "jdbc:mysql://localhost:3306/bobblan";
    static String dbUser = "root";
    static String dbPass = "Lösenord";


/* Requires a input string, returns a list with all matching rows */
    public static List article(String searchString){



        List<Object> testLista = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            String statement = "select * from articles a join book b on a.articleID = b.articleID where a.articleName like '%" + searchString + "%' or b.author like '%"+ searchString + "%' or b.publisher like '%"+ searchString + "%' or b.genre like '%"+ searchString + "%' or b.ISBN like '%"+ searchString + "%'";
            PreparedStatement ps = con.prepareStatement(statement);
            //ps.setString(1,"%"+searchString+"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                testLista.add(new Artikel(rs.getInt(1), rs.getString(2),rs.getInt("loanTime")));
            }

            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return testLista;
    }

//Inputs search string and object type, 1 = book, 2 = movie, 3 = journal
    public static List articlev2(String searchString,int type){

        List<Object> articleList = new ArrayList<>();

        String statement = "";

        if(type == 1) statement = "select * from articles a join book b on a.articleID = b.articleID where a.articleName like '%" + searchString + "%' or b.author like '%"+ searchString + "%' or b.publisher like '%"+ searchString + "%' or b.genre like '%"+ searchString + "%' or b.ISBN like '"+ searchString + "'";
        if(type == 2) statement = "select * from articles a join movie m on a.articleID = m.articleID where a.articleName like '%"+ searchString + "%' or m.director like '%"+ searchString + "%' or m.genre like '%"+ searchString + "%'";
        if(type == 3) statement = "select * from articles a join journal j on a.articleID = j.articleID where a.articleName like '%"+ searchString + "%' or j.source like '%"+ searchString + "%' or j.genre like '%"+ searchString + "%' or j.ISSN like '"+ searchString + "'";

        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            PreparedStatement ps = con.prepareStatement(statement);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            System.out.println(type);
            //Skapa en bok
            if(type == 1){
                while(rs.next()){
                    articleList.add(new Artikel.Bok(
                            rs.getInt("articleID"),
                            rs.getString("articleName"),
                            rs.getInt("loanTime"),
                            rs.getString("storageSpace"),
                            rs.getInt("amount"),
                            rs.getString("genre"),
                            rs.getString("language"),
                            rs.getString("releaseDate"),
                            rs.getString("publisher"),
                            rs.getString("ISBN"),
                            rs.getString("author"),
                            rs.getString("edition")
                    ));
                }
            }

            //Skapa en film
            if(type == 2){
                while(rs.next()){
                    articleList.add(new Artikel.Film(
                            rs.getInt("articleID"),
                            rs.getString("articleName"),
                            rs.getInt("loanTime"),
                            rs.getString("storageSpace"),
                            rs.getInt("amount"),
                            rs.getString("genre"),
                            rs.getString("language"),
                            rs.getString("releaseDate"),
                            rs.getString("director")
                    ));
                }
            }

            //Skapa en tidsskrift
            if(type == 3){
                while(rs.next()){
                    articleList.add(new Artikel.Tidsskrift(
                            rs.getInt("articleID"),
                            rs.getString("articleName"),
                            rs.getInt("loanTime"),
                            rs.getString("storageSpace"),
                            rs.getInt("amount"),
                            rs.getString("genre"),
                            rs.getString("language"),
                            rs.getString("releaseDate"),
                            rs.getString("ISSN"),
                            rs.getString("source")
                    ));
                }
            }

            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleList;
    }
}
