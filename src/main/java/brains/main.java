package brains;

import java.sql.*;
import java.util.Scanner;

public class main {



    public static void main(String[] args) throws SQLException {
        while(true){
            choice();
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
}
