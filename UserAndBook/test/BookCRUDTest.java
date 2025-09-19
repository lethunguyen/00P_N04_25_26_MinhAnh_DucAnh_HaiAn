package UserAndBook.test;

import UserAndBook.src.Book;
import UserAndBook.src.BookCRUD;

public class BookCRUDTest {
    public static void runTests() {
        System.out.println("===== BẮT ĐẦU TEST BookCRUD =====");

        // CREATE
        BookCRUD.addBook(new Book("B001", "Lập trình Java", "Nguyen Van A", 2020, 5));
        BookCRUD.addBook(new Book("B002", "Cấu trúc dữ liệu", "Tran Thi B", 2019, 3));
        BookCRUD.addBook(new Book("B003", "Cơ sở dữ liệu", "Le Van C", 2021, 7));

        // READ
        BookCRUD.getBook("B002");
        BookCRUD.getBook("B010"); // không tồn tại

        // UPDATE
        BookCRUD.updateBook("B002", "Cấu trúc dữ liệu & Giải thuật", "Tran Thi B", 2022, 12);

        // DELETE
        BookCRUD.removeBook("B001");
        BookCRUD.removeBook("B999"); // không tồn tại

        // LIST ALL
        BookCRUD.listBooks();

        System.out.println("===== KẾT THÚC TEST BookCRUD =====");
    }
}
