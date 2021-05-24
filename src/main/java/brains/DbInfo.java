package brains;

public class DbInfo {

    //Sätt in egen info för databasen
    static String dbUrl = "jdbc:mysql://localhost:3306/bobblan";
    static String dbUser = "root";
    static String dbPass = "Lösenord";

    //Metoder för att hämta infon på alla ställen där det behövs.
    public static String getDbUrl() { return dbUrl; }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPass() {
        return dbPass;
    }
}
