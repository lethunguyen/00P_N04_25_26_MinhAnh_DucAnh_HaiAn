package com.library.management.controller;

import com.library.management.model.BorrowRequest;
import com.library.management.service.BorrowRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/requests")
public class BorrowRequestController {

    @Autowired
    private BorrowRequestService requestService;

    @GetMapping("/list")
    public String listRequests(Model model) {
        model.addAttribute("requests", requestService.getAllRequests());
        return "requests/list";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("request", new BorrowRequest());
        return "requests/form";
    }

    @PostMapping("/save")
    public String saveRequest(@ModelAttribute("request") BorrowRequest request) {
        requestService.saveRequest(request);
        return "redirect:/requests/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteRequest(@PathVariable int id) {
        requestService.deleteRequest(id);
        return "redirect:/requests/list";
    }
}
