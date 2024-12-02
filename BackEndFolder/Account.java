public class Account { //Super class for all accounts including customer, employee
    private String userName;
    private String ID;
    private String password;
    public Account() {
        this.userName = "";
        this.ID = "";
        this.password = "";
    }
    public Account (String userName, String ID, String password) {
        this.userName = userName;
        this.ID = ID;
        this.password = password;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String setPassword() {
        return password;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
}
