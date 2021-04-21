package Objects;

public class User {
    String userName;
    String fName;
    String lName;
    int accessLevel;
    String password;

    public User(String userName, String fName, String lName, int accessLevel, String password) {
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.accessLevel = accessLevel;
        this.password = password;
    }

    public User(){ }

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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
