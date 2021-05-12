package Objects;

public class User {
    String userName;
    String fName;
    String lName;
    String password;
    String telNr;
    int accessLevel;
    int activeLoans;

    public User(){}

    public User(String userName, String fName, String lName, String password, String telNr, int accessLevel, int activeLoans) {
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.telNr = telNr;
        this.accessLevel = accessLevel;
        this.activeLoans = activeLoans;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(int activeLoans) {
        this.activeLoans = activeLoans;
    }
}
