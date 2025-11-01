package com.library.management.service;

import com.library.management.model.Employee;
import com.library.management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee updated) {
        return employeeRepository.findById(id)
                .map(existing -> {
                    existing.setFullName(updated.getFullName());
                    existing.setUsername(updated.getUsername());
                    existing.setPassword(updated.getPassword());
                    existing.setRole(updated.getRole());
                    return employeeRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // ✅ Login logic cơ bản (tạm thời)
    public Employee login(String username, String password) {
        return employeeRepository.findAll().stream()
                .filter(e -> e.getUsername().equalsIgnoreCase(username)
                        && e.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
