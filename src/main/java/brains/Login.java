package brains;

import Objects.User;
import at.favre.lib.crypto.bcrypt.BCrypt;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.Scanner;


public class Login {

    //Funktion för att skapa en temporär användare, används för att kunna hämta en användare till hantera användar metoden
    public static User tempUser(String userName){
        try{
            Connection con = DriverManager.getConnection(DbInfo.getDbUrl(),DbInfo.getDbUser(),DbInfo.getDbPass());
            PreparedStatement ps = con.prepareStatement("select * from user where userName = ?");
            ps.setString(1,userName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                return new User(rs.getString("userName"),rs.getString("fName"),rs.getString("lName"),rs.getString("telNr"),rs.getString("email"),rs.getInt("age"),rs.getInt("accesLevel"),0);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    //Funktion för att autentisera användare med hjälp av BCrypt. Skickar tillbaka en användare om lösenordet matchar det i databasen.
    public static User authUser(String userName, String password){
        try{
            Connection con = DriverManager.getConnection(DbInfo.getDbUrl(),DbInfo.getDbUser(),DbInfo.getDbPass());

            PreparedStatement ps = con.prepareStatement("select * from user where userName = ?");
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String pw = rs.getString("password");

                BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),pw);


                //Hämtar antal aktiva lån, lite bug dock för att om man lånar när programmet är igång så uppdateras det inte typ :)
                if(result.verified){
                    int amountActive = 0;
                    System.out.println("Login succesfull");

                    PreparedStatement ps1 = con.prepareStatement("select count(*) from loan where userName = ?");
                    ps1.setString(1,userName);
                    ResultSet rs1 = ps1.executeQuery();

                    while(rs1.next()){
                        amountActive = rs1.getInt("count(*)");
                    }
                        return new User(rs.getString("userName"),rs.getString("fName"),rs.getString("lName"),rs.getString("telNr"),rs.getString("email"),rs.getInt("age"),rs.getInt("accesLevel"),amountActive);
                }
                else{
                    System.out.println("Login failed");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Användarnamnet och lösenordet tillhör inte ett konto, vänligen korrigera.");
                    alert.show();
                    return null;
                }
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Användarnamnet och lösenordet tillhör inte ett konto, vänligen korrigera.");
        alert.show();
        return null;
    }


    //Registrerar en användare, krypterar lösenordet med hjälp av BCrypt.
    public static boolean register(String userName,String fName,String lName,String telNr,String mail,String password)  {

        password = BCrypt.withDefaults().hashToString(12,password.toCharArray());

        try{
            Connection con = DriverManager.getConnection(DbInfo.getDbUrl(),DbInfo.getDbUser(),DbInfo.getDbPass());
            PreparedStatement ps = con.prepareStatement("insert into user(userName, fName, lName, email, password, accesLevel, telNr) values(?,?,?,?,?,?,?)");
            ps.setString(1,userName);
            ps.setString(2,fName);
            ps.setString(3,lName);
            ps.setString(4,mail);
            ps.setString(5,password);
            ps.setInt(6,0);
            ps.setString(7,telNr);

            ps.executeUpdate();

            System.out.println("Registration complete!");
            con.close();
            return true;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Felinmatning, vänligen korrigera");
            alert.show();
            return false;
        }
    }
}