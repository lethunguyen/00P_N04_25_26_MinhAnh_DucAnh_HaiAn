package com.library.management.integration;

import com.library.management.Controller.BookController;
import com.library.management.Database.DBInitializer;
import com.library.management.Model.Book;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(properties = "spring.profiles.active=test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookIntegrationTest {

    private static BookController bookController;

    @BeforeAll
    static void setup() {
        System.setProperty("spring.profiles.active", "test");
        DBInitializer.initDatabase();
        bookController = new BookController();
    }

    @Test
    @Order(1)
    void testAddBook() {
        Book b = new Book(0, "1984", "George Orwell", 1949, true);
        bookController.addBook(b);
        List<Book> books = bookController.getAllBooks();
        Assertions.assertFalse(books.isEmpty(), "Book list should not be empty after adding.");
    }

    @Test
    @Order(2)
    void testUpdateBook() {
        List<Book> books = bookController.getAllBooks();
        Book book = books.get(0);
        book.setTitle("Animal Farm");
        bookController.updateBook(book);
        List<Book> updated = bookController.getAllBooks();
        Assertions.assertEquals("Animal Farm", updated.get(0).getTitle());
    }

    @Test
    @Order(3)
    void testDeleteBook() {
        List<Book> books = bookController.getAllBooks();
        int id = books.get(0).getId();
        bookController.deleteBook(id);
        List<Book> afterDelete = bookController.getAllBooks();
        Assertions.assertTrue(afterDelete.isEmpty(), "All books should be deleted.");
    }
}
