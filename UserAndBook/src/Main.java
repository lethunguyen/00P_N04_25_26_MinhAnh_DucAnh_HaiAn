package UserAndBook.src;

import UserAndBook.test.UserTest;
import UserAndBook.test.BookTest;

public class Main {
    public static void main(String[] args) {
        // Gọi test User
        UserTest.runTests();

        // Gọi test Book
        BookTest.runTests();
    }
}
