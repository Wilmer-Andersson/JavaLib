package brains;

import Objects.Artikel;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Search {
    static String dbUrl = "jdbc:mysql://localhost:3306/javaTestDB";
    static String dbUser = "root";
    static String dbPass = "Lösenord";

    public <T> List<T> test(String searchString){
        List<T> returnList = new ArrayList<>();


        returnList.add((T) new Artikel());

        return returnList;
    }


/* Requires a input string, returns a list with all matching rows */
    public static List article(String searchString){

        List<Artikel> testLista = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            PreparedStatement ps = con.prepareStatement("select * from javaTestDB.artiklar where artikelNamn like ?");
            ps.setString(1,"%"+searchString+"%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                testLista.add(new Artikel(rs.getInt(1), rs.getString(2)));
            }

            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return testLista;
    }
}
