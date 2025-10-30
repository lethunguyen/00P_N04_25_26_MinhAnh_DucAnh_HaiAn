
package Test;

import src.Model.Book;

public class BookTest {
    public static void runTests() {
        System.out.println("===== BẮT ĐẦU TEST Book =====");

        // Tạo sách mới
        Book b1 = new Book("B001", "Lập trình Java", "Nguyen Van A", 2020, 5);

        // In thông tin sách
        System.out.println(b1);

        // Kiểm thử getter
        System.out.println("ID: " + b1.getId());
        System.out.println("Title: " + b1.getTitle());
        System.out.println("Author: " + b1.getAuthor());
        System.out.println("Year: " + b1.getYear());
        System.out.println("Quantity: " + b1.getQuantity());

        // Kiểm thử setter
        b1.setTitle("Java Cơ Bản");
        b1.setQuantity(10);

        System.out.println("Sau khi cập nhật: " + b1);

        System.out.println("===== KẾT THÚC TEST Book =====");
    }
}
