package com.library.management.integration;

import com.library.management.LibraryManagementApplication;
import com.library.management.model.Book;
import com.library.management.repository.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Order(1)
    void addAndFind() {
        Book b = new Book();
        b.setTitle("Integration Book");
        b.setAuthor("Tester");
        b.setPublishYear(2020);
        b.setQuantity(1);
        bookRepository.save(b);

        List<Book> all = bookRepository.findAll();
        Assertions.assertFalse(all.isEmpty());
    }

    @Test
    @Order(2)
    void updateBook() {
        List<Book> all = bookRepository.findAll();
        Book b = all.get(0);
        b.setTitle("Updated Title");
        bookRepository.save(b);

        Book upd = bookRepository.findById(b.getId()).orElseThrow();
        Assertions.assertEquals("Updated Title", upd.getTitle());
    }

    @Test
    @Order(3)
    void deleteBook() {
        List<Book> all = bookRepository.findAll();
        Book b = all.get(0);
        bookRepository.deleteById(b.getId());
        Assertions.assertTrue(bookRepository.findAll().isEmpty());
    }
}
