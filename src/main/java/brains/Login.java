package brains;

import Objects.User;
import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.*;
import java.util.Scanner;


public class Login {
    static String dbUrl = "jdbc:mysql://localhost:3306/bobblan";
    static String dbUser = "root";
    static String dbPass = "Lösenord";

    public static User authUser(String userName, String password){
        String passHash = BCrypt.withDefaults().hashToString(12,password.toCharArray());

        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            PreparedStatement ps = con.prepareStatement("select * from user where userName = ?");
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String pw = rs.getString("password");

                BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),pw);

                if(result.verified){
                    int amountActive = 0;
                    System.out.println("Login succesfull");

                   /* PreparedStatement ps1 = con.prepareStatement("select count(*) from loan where userName = ?");
                    ps1.setString(1,userName);
                    ResultSet rs1 = ps1.executeQuery();

                    while(rs.next()){
                        amountActive = rs.getInt("count(*)");
                    }*/


                    return new User(rs.getString("userName"),rs.getString("fName"),rs.getString("lName"),rs.getString("email"),rs.getString("telNr"),rs.getInt("accesLevel"), amountActive);
                }
                else{
                    System.out.println("Login failed");
                    throw new Exception("Nått error typ, idk");
                }
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("Login failed succesfully!");
        return null;
    }

    public static void registerTermial(){
        String userName;
        String fName;
        String lName;
        int accessLevel;
        String password;

        Scanner input = new Scanner(System.in);
        System.out.println("REGISTRERING!");
        System.out.println("Mata in användarnamn: ");
        userName = input.next();
        System.out.println("Mata in förnamn: ");
        fName = input.next();
        System.out.println("Mata in efternamn: ");
        lName = input.next();
        System.out.println("Mata in accessLevel: ");
        accessLevel = input.nextInt();
        System.out.println("Mata in lösenord: ");
        password = input.next();
        password = BCrypt.withDefaults().hashToString(12,password.toCharArray());

        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            PreparedStatement ps = con.prepareStatement("insert into Users(userName,fName,lName,accessLevel,password) values(?,?,?,?,?)");
            ps.setString(1,userName);
            ps.setString(2,fName);
            ps.setString(3,lName);
            ps.setInt(4,accessLevel);
            ps.setString(5,password);

            ps.executeUpdate();

            System.out.println("Registration complete!");

            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static boolean register(String userName,String fName,String lName,String telNr,String mail,String password){

        password = BCrypt.withDefaults().hashToString(12,password.toCharArray());

        try{
            Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
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
            return false;
        }
    }
}