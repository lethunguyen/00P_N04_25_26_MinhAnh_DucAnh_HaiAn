package Test;
import Controller.EmployeeManager;
import Model.Employee;

public class EmployeeTest {
    public static void test() {
        EmployeeManager manager = new EmployeeManager();

        // CREATE
        Employee e1 = new Employee("E001", "Nguyen Van A", 25, "0123456789", false);
        Employee e2 = new Employee("E002", "Tran Thi B", 30, "9876543210", true);

        manager.addEmployee(e1);
        manager.addEmployee(e2);

        // READ
        manager.listEmployees();

        // UPDATE
        manager.updateEmployee("E001", "Nguyen Van A (Updated)", 26, "1111111111", true);

        // READ agian
        manager.listEmployees();

        // DELETE
        manager.removeEmployee("E002");

        // READ last
        manager.listEmployees();
    }
}
