package com.library.management.controller;

import com.library.management.model.Book;
import com.library.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 📚 Danh sách
    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/list";
    }

    // ➕ Form thêm / sửa
    @GetMapping("/form")
    public String showForm(@RequestParam(value = "id", required = false) Long id, Model model) {
        Book book = (id != null) ? bookService.getBookById(id.intValue()) : new Book();
        model.addAttribute("book", book);
        return "books/form :: form";
    }

    // 💾 Lưu (AJAX)
    @PostMapping("/save")
    @ResponseBody
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "success";
    }

    // 🗑️ Xóa
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "success";
    }
}
