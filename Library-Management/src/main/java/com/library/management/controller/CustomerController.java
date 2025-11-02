package com.library.management.controller;

import com.library.management.model.Customer;
import com.library.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers/list";
    }
}
