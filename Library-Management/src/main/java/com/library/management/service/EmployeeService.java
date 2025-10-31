package com.library.management.service;

import com.library.management.model.Employee;
import com.library.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    public Employee updateEmployee(Long id, Employee updated) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(updated.getName());
            emp.setEmail(updated.getEmail());
            emp.setPassword(updated.getPassword());
            emp.setRole(updated.getRole());
            return employeeRepository.save(emp);
        }).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee login(String email, String password) {
        Employee e = employeeRepository.findByEmail(email);
        if (e != null && e.getPassword().equals(password)) {
            return e;
        }
        return null;
    }
}
