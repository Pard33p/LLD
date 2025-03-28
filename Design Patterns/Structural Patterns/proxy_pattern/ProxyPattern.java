package proxy_pattern;

public class ProxyPattern {

    public static void main(String[] args) {
        EmployeeService adminProxy = new EmployeeServiceProxy("ADMIN");
        EmployeeService userProxy = new EmployeeServiceProxy("EMPLOYEE");

        System.out.println("User viewing salary:");
        userProxy.viewSalary("John");

        System.out.println("User trying to modify salary:");
        userProxy.modifySalary("John", 100000);

        System.out.println("Admin trying to modify salary:");
        adminProxy.modifySalary("John", 100000);

    }

}

interface EmployeeService {
    void viewSalary(String employeeName);

    void modifySalary(String employeeName, double newSalary);
}

class RealEmployeeService implements EmployeeService {
    @Override
    public void viewSalary(String employeeName) {
        System.out.println(employeeName + "'s salary: $5000");
    }

    @Override
    public void modifySalary(String employeeName, double newSalary) {
        System.out.println("Salary of " + employeeName + " changed to $" + newSalary);
    }
}

class EmployeeServiceProxy implements EmployeeService {
    private RealEmployeeService realEmployeeService = new RealEmployeeService();
    private String userRole;

    public EmployeeServiceProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void viewSalary(String employeeName) {
        realEmployeeService.viewSalary(employeeName);
    }

    @Override
    public void modifySalary(String employeeName, double newSalary) {
        if (this.userRole.equals("ADMIN")) {
            realEmployeeService.modifySalary(employeeName, newSalary);
        } else {
            System.out.println("Accesss denied!");
        }
    }

}