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

    // Danh sách nhân viên
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> list = employeeService.getAllEmployees();
        model.addAttribute("employees", list);
        return "employee-list";
    }

    // Thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee e) {
        employeeService.saveEmployee(e); // ✅ Sửa createEmployee -> saveEmployee
        return "redirect:/employees";
    }

    // Chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id.intValue())); // ✅ ép kiểu sang int
        return "employee-form";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee e) {
        employeeService.updateEmployee(id.intValue(), e); // ✅ ép kiểu sang int
        return "redirect:/employees";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id.intValue()); // ✅ ép kiểu sang int
        return "redirect:/employees";
    }

    // Login
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest req, Model model) {
        Employee emp = employeeService.login(req.getUsername(), req.getPassword()); // ✅ sửa getEmail -> getUsername
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
