package com.library.management.controller;

import com.library.management.model.Customer;
import com.library.management.model.Employee;
import com.library.management.model.LoginRequest;
import com.library.management.service.CustomerService;
import com.library.management.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, HttpSession session, Model model) {
        // Check employee
        Employee emp = employeeService.findByUsername(loginRequest.getUsername());
        if (emp != null && emp.getPassword().equals(loginRequest.getPassword())) {
            session.setAttribute("userRole", "EMPLOYEE");
            return "redirect:/books/list";
        }

        // Check customer
        Customer cust = customerService.findByUsername(loginRequest.getUsername());
        if (cust != null && cust.getPassword().equals(loginRequest.getPassword())) {
            session.setAttribute("userRole", "CUSTOMER");
            return "redirect:/requests/list";
        }

        model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
