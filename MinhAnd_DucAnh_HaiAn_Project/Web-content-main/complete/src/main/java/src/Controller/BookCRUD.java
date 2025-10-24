package src.Controller;

import java.util.HashMap;
import java.util.Map;

import src.Model.Book;

public class BookCRUD {
    // "Database giả lập"
    private static Map<String, Book> books = new HashMap<>();

    // CREATE
    public static boolean addBook(Book book) {
        if (books.containsKey(book.getId())) {
            System.out.println("❌ Sách đã tồn tại với ID: " + book.getId());
            return false;
        }
        books.put(book.getId(), book);
        System.out.println("✅ Thêm sách thành công: " + book.getTitle());
        return true;
    }

    // READ
    public static Book getBook(String id) {
        Book b = books.get(id);
        if (b == null) {
            System.out.println("❌ Không tìm thấy sách với ID: " + id);
        } else {
            System.out.println("📖 " + b);
        }
        return b;
    }

    // UPDATE
    public static boolean updateBook(String id, String newTitle, String newAuthor, int newYear, int newQuantity) {
        Book b = books.get(id);
        if (b == null) {
            System.out.println("❌ Không tìm thấy sách để cập nhật với ID: " + id);
            return false;
        }
        b.setTitle(newTitle);
        b.setAuthor(newAuthor);
        b.setYear(newYear);
        b.setQuantity(newQuantity);
        System.out.println("🔄 Cập nhật thành công sách: " + id);
        return true;
    }

    // DELETE
    public static boolean removeBook(String id) {
        if (!books.containsKey(id)) {
            System.out.println("❌ Không tìm thấy sách để xóa với ID: " + id);
            return false;
        }
        books.remove(id);
        System.out.println("🗑️ Đã xóa sách với ID: " + id);
        return true;
    }

    // LIST ALL
    public static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("⚠️ Không có sách nào trong thư viện.");
        } else {
            System.out.println("📚 Danh sách tất cả sách:");
            for (Book b : books.values()) {
                System.out.println("- " + b);
            }
        }
    }
}