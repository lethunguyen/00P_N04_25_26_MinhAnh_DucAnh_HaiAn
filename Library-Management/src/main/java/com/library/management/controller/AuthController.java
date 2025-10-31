package com.library.management.controller;

import com.library.management.model.Customer;
import com.library.management.model.Librarian;
import com.library.management.service.CustomerService;
import com.library.management.service.LibrarianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Simple session-based auth (no Spring Security).
 * Stores attribute "userRole" and "username" in session.
 */
@Controller
public class AuthController {

    private final CustomerService customerService;
    private final LibrarianService librarianService;

    public AuthController(CustomerService customerService, LibrarianService librarianService) {
        this.customerService = customerService;
        this.librarianService = librarianService;
    }

    @GetMapping("/login")
    public String loginPage() { return "auth/login"; }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        // Try librarian
        Librarian lib = librarianService.findByUsername(username);
        if (lib != null && lib.getPassword().equals(password)) {
            session.setAttribute("username", username);
            session.setAttribute("userRole", "LIBRARIAN");
            return "redirect:/books";
        }
        // Try customer
        Customer cust = customerService.findByUsername(username);
        if (cust != null && cust.getPassword().equals(password)) {
            session.setAttribute("username", username);
            session.setAttribute("userRole", "CUSTOMER");
            return "redirect:/books";
        }
        model.addAttribute("error", "Invalid credentials");
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
