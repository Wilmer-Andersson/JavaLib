package brains;

import Objects.Artikel;
import Objects.User;

import java.sql.*;
import java.util.Scanner;

public class main {
    private static User currentUser;

    public static void main(String[] args) throws SQLException {
        while(true){
            choice2();
        }
    }

    public static void choice(){
        Scanner input = new Scanner(System.in);
        System.out.println("Mata in [R]/[W]/[E]");
        String s = input.nextLine();
        if(s.equals("R")){
            DatabaseStuff.readDB();
        } if(s.equals("W")){
            DatabaseStuff.writeDB();
        } if(s.equals("E")){
            DatabaseStuff.editDB();
        }
    }

    public static void choice2(){
        Scanner input = new Scanner(System.in);
        System.out.println("Login: Mata in [Login]/[Register]/[Loan]/[Search]");
        String s = input.nextLine();
        if(s.equals("Login")){
            System.out.println("Mata in användarnamn:");
            String username = input.nextLine();
            System.out.println("Mata in lösenord:");
            String password = input.nextLine();
            currentUser = Login.authUser(username,password);
        } if(s.equals("Register")){
            Login.registerTerminal();
        } if(s.equals("Loan")){
            OutLoan.CreateLoan(currentUser);
        } if(s.equals("Search")){
            System.out.println("Mata in söksträng: ");
            Object o = new Artikel();
            Artikel a = new Artikel();
            Search.article(input.nextLine(),o.getClass());
        }
    }
}
