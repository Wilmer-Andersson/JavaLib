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
    public static List article(String searchString, Object objectType){

        Object o = objectType;
        List<Artikel> testLista = new ArrayList<>();
        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            PreparedStatement ps = con.prepareStatement("select * from javaTestDB.artiklar where artikelNamn like ?");
            ps.setString(1,"%"+searchString+"%");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int testHärj = rsmd.getColumnCount();

            while(rs.next()) {
                String[] ligma = new String[testHärj];
                for (int i = 0; i <= testHärj - 1; i++){
                    ligma[i] = rs.getString(i + 1);
                }
                System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
                System.out.println(
                        rs.getObject(1));
                testLista.add(new Artikel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                testLista.add(new Artikel());
            }

            con.close();

            System.out.println("------------------------");

            for(Artikel a : testLista){
                System.out.println(a.getArtikelNr() + ", " + a.getArtikelNamn()+", " + a.getPris());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return testLista;
    }
}
