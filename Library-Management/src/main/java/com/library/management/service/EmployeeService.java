package com.library.management.service;

import com.library.management.model.Employee;
import com.library.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById((long) id).orElse(null);
    }

    public Employee findByUsername(String username) {
        return employeeRepository.findAll().stream()
                .filter(e -> e.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public void saveEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    // ✅ Thêm alias để tránh lỗi gọi từ controller cũ
    public void createEmployee(Employee emp) {
        saveEmployee(emp);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById((long) id);
    }

    public Employee updateEmployee(int id, Employee updated) {
        Employee existing = getEmployeeById(id);
        if (existing != null) {
            existing.setFullName(updated.getFullName());
            existing.setUsername(updated.getUsername());
            existing.setPassword(updated.getPassword());
            existing.setRole(updated.getRole());
            return employeeRepository.save(existing);
        }
        return null;
    }

    // ✅ Đăng nhập bằng username
    public Employee login(String username, String password) {
        Employee emp = findByUsername(username);
        if (emp != null && emp.getPassword().equals(password)) {
            return emp;
        }
        return null;
    }
}
