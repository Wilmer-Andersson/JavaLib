package Objects;

public class User {
    String userName;
    String fName;
    String lName;
    String telNr;
    String email;
    int age;
    int accessLevel;
    int activeLoans;

    public User() { }

    public User(String userName, String fName, String lName, String telNr, String email, int age, int accessLevel, int activeLoans) {
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.telNr = telNr;
        this.email = email;
        this.age = age;
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

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
