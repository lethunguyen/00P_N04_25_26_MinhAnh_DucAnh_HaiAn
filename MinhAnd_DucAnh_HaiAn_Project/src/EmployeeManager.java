
import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();

    // CREATE
    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Added Employee: " + e.getName());
    }

    // READ
    public void listEmployees() {
        System.out.println("Employee List:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    // UPDATE
    public void updateEmployee(String id, String newName, int newAge, String newCccd, boolean newRole) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                e.setName(newName);
                e.setAge(newAge);
                e.setCccd(newCccd);
                e.setIsManager(newRole);
                System.out.println("Updated Employee Information " + id);
                return;
            }
        }
        System.out.println("No Employee Found With ID: " + id);
    }

    // DELETE
    public void removeEmployee(String id) {
        employees.removeIf(e -> e.getId().equals(id));
        System.out.println("Deleted Employee With ID: " + id);
    }
}
