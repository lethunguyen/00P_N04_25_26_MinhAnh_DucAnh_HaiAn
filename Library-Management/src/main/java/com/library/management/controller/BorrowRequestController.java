package com.library.management.controller;

import com.library.management.model.BorrowRequest;
import com.library.management.model.Book;
import com.library.management.model.Customer;
import com.library.management.service.BorrowRequestService;
import com.library.management.service.BookService;
import com.library.management.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/requests")
public class BorrowRequestController {

    private final BorrowRequestService svc;
    private final BookService bookService;
    private final CustomerRepository customerRepo;

    public BorrowRequestController(BorrowRequestService svc, BookService bookService, CustomerRepository customerRepo) {
        this.svc = svc;
        this.bookService = bookService;
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("requests", svc.findAll());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("customers", customerRepo.findAll());
        return "requests/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("request", new BorrowRequest());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("customers", customerRepo.findAll());
        return "requests/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BorrowRequest request, @RequestParam Long bookId, @RequestParam Long customerId) {
        Book book = bookService.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        request.setBook(book);
        request.setCustomer(customer);
        request.setRequestDate(LocalDate.now());
        svc.create(request);
        return "redirect:/requests";
    }

    @GetMapping("/approve/{id}")
    public String approve(@PathVariable Long id) {
        svc.approve(id);
        return "redirect:/requests";
    }

    @GetMapping("/return/{id}")
    public String markReturned(@PathVariable Long id) {
        svc.markReturned(id);
        return "redirect:/requests";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        svc.delete(id);
        return "redirect:/requests";
    }
}
