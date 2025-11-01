package com.library.management.controller;

import com.library.management.model.Employee;
import com.library.management.model.LoginRequest;
import com.library.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // List view
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> list = employeeService.getAllEmployees();
        model.addAttribute("employees", list);
        return "employee-list";
    }

    // Add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee e) {
        employeeService.createEmployee(e);
        return "redirect:/employees";
    }

    // Edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id).orElse(new Employee()));
        return "employee-form";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee e) {
        employeeService.updateEmployee(id, e);
        return "redirect:/employees";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    // Login page
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest req, Model model) {
        Employee emp = employeeService.login(req.getEmail(), req.getPassword());
        if (emp != null) {
            model.addAttribute("employee", emp);
            return "redirect:/books";
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/employees/login";
    }
}
