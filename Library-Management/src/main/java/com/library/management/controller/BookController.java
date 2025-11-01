package com.library.management.controller;

import com.library.management.model.Book;
import com.library.management.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService svc;

    public BookController(BookService svc) {
        this.svc = svc;
    }

    /**
     * Hiển thị danh sách sách.
     * Cho phép truy cập cả /books và /books/list để tương thích giao diện cũ.
     */
    @GetMapping
    @GetMapping({"", "/list"})
    public String list(Model model) {
        model.addAttribute("books", svc.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        svc.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Book b = svc.findById(id).orElse(new Book());
        model.addAttribute("book", b);
        return "books/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        svc.deleteById(id);
        return "redirect:/books";
    }

    // REST hỗ trợ Postman
    @PostMapping
    @ResponseBody
    public Book createRest(@RequestBody Book b) {
        return svc.save(b);
    }

    @GetMapping("/api")
    @ResponseBody
    public java.util.List<Book> listRest() {
        return svc.findAll();
    }
}
