package brains;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseStuff {
    public static List<Artikel> testLista = new ArrayList<>();

    static String dbUrl = "jdbc:mysql://localhost:3306/db2_upp1_v4";
    static String dbUser = "root";
    static String dbPass = "Lösenord";

    public static void editDB(){
        Scanner input = new Scanner(System.in);

        System.out.println("Mata in ArtikelNr:");
        int aNr = input.nextInt();
        System.out.println("Mata in ArtikelNamn:");
        String aNamn = input.next();
        System.out.println("Mata in pris:");
        int aPris = input.nextInt();

        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            PreparedStatement psW = con.prepareStatement("insert into javaTestDB.Artiklar values (?,?,?)");
            psW.setInt(1,aNr);
            psW.setString(2,aNamn);
            psW.setInt(3,aPris);
            psW.executeUpdate();

            //psW.executeQuery();
            //ResultSet rs = psW.executeQuery();


            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeDB(){
        Scanner input = new Scanner(System.in);

        System.out.println("Mata in ArtikelNr:");
        int aNr = input.nextInt();
        System.out.println("Mata in ArtikelNamn:");
        String aNamn = input.next();
        System.out.println("Mata in pris:");
        int aPris = input.nextInt();

        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            PreparedStatement psW = con.prepareStatement("insert into javaTestDB.Artiklar values (?,?,?)");
            psW.setInt(1,aNr);
            psW.setString(2,aNamn);
            psW.setInt(3,aPris);
            psW.executeUpdate();

            //psW.executeQuery();
            //ResultSet rs = psW.executeQuery();


            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void readDB(){


        Scanner input = new Scanner(System.in);
        System.out.println("Sök på artikelNamn:");
        String sok = input.nextLine();

        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            PreparedStatement ps = con.prepareStatement("select * from javaTestDB.artiklar where artikelNamn = ?");
            ps.setString(1,sok);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
                testLista.add(new Artikel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }

            con.close();

            System.out.println("------------------------");

            for(Artikel a : testLista){
                System.out.println(a.getArtikelNr() + ", " + a.getArtikelNamn()+", " + a.getPris());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
