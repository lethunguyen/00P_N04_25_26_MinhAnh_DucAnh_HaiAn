package com.library.management.controller;

import com.library.management.model.Book;
import com.library.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 📚 Danh sách
    @GetMapping("/list")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    // ➕ Form thêm mới
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    // ✏️ Form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/books/list";
        }
        model.addAttribute("book", book);
        return "books/form";
    }

    // 💾 Lưu dữ liệu (thêm hoặc sửa)
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books/list";
    }

    // 🗑️ Xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books/list";
    }
}
