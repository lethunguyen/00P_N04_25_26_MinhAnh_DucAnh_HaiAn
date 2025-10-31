package Test;

import src.Controller.EmployeeManager;
import src.Model.Employee;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        // 1️⃣ Thêm nhân viên mới
        System.out.println("=== ADD EMPLOYEE ===");
        Employee emp1 = new Employee("E001", "Nguyen Van A", "Librarian", 12000000);
        Employee emp2 = new Employee("E002", "Tran Thi B", "Manager", 18000000);
        manager.add(emp1);
        manager.add(emp2);

        // 2️⃣ Đọc toàn bộ danh sách
        System.out.println("\n=== LIST ALL EMPLOYEES ===");
        List<Employee> employees = manager.getAll();
        for (Employee e : employees) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getRole() + " | " + e.getSalary());
        }

        // 3️⃣ Cập nhật thông tin
        System.out.println("\n=== UPDATE EMPLOYEE (E001) ===");
        manager.update("E001", "Nguyen Van A", "Senior Librarian", 13500000);

        // 4️⃣ In lại danh sách sau update
        System.out.println("\n=== AFTER UPDATE ===");
        employees = manager.getAll();
        for (Employee e : employees) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getRole() + " | " + e.getSalary());
        }

        // 5️⃣ Xóa nhân viên
        System.out.println("\n=== DELETE EMPLOYEE (E002) ===");
        manager.delete("E002");

        // 6️⃣ Danh sách cuối cùng
        System.out.println("\n=== FINAL EMPLOYEE LIST ===");
        employees = manager.getAll();
        for (Employee e : employees) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getRole() + " | " + e.getSalary());
        }

        // Kết thúc
        System.out.println("\n✅ Test completed!");
    }
}
