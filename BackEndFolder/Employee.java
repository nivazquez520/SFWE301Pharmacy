public class Employee extends Account { //sub class of account
    private int authLevel;
    public Employee() {
        super();
        authLevel = -1;
    }
    public Employee(String userName, String ID, String password, int authLevel) {
        super(userName, ID, password);
        this.authLevel = authLevel;
    }
    public void setAuthLevel(int level) {
        this.authLevel = level;
    }
    public int getAuthLevel() {
        return authLevel;
    }
    public boolean validateEmployee() { //if the employee object is actually an employee, they will be validated. 
        return authLevel != -1;
    }
}
