package BackEndFolder;
import java.util.ArrayList;


public class PharmInfo { //class containing information about the pharmacy
    private String address;
    private String owner;
    private ArrayList<Employee> employees;
    int numEmployees;
    public PharmInfo() {
        this.address = "";
        this.owner = "";
        this.employees = new ArrayList<>();
        this.numEmployees = -1;
    }
    public PharmInfo(String address, String owner, int numEmploys) {
        this.address = address;
        this.owner = owner;
        this.employees = new ArrayList<>();
        this.numEmployees = numEmploys;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getOwner() {
        return owner;
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
        numEmployees++;
    }
    public void addEmployee(String userName, String ID, String password, int authLevel) { //add employee to pharmacy
        Employee newEmployee = new Employee(userName, ID, password, authLevel);
        employees.add(newEmployee);
        numEmployees++;
    }
    public void removeEmployee(Employee employee) { //removes any employee with the same ID as argument's ID
        int i;
        for (i = 0; i < employees.size(); i++) {
            if (employee.getID().equals(employees.get(i).getID())) {
                employees.remove(i);
                numEmployees--;
            }
        }
    }

}

