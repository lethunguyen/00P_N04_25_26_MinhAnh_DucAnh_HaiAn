package com.library.management.controller;

import com.library.management.model.Guest;
import com.library.management.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final GuestService svc;

    public GuestController(GuestService svc) { this.svc = svc; }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("guests", svc.findAll());
        return "guests/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("guest", new Guest());
        return "guests/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Guest guest) {
        svc.save(guest);
        return "redirect:/guests";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Guest g = svc.findById(id).orElse(new Guest());
        model.addAttribute("guest", g);
        return "guests/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        svc.deleteById(id);
        return "redirect:/guests";
    }
}
