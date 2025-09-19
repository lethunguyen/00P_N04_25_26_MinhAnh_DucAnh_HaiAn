package UserAndBook.src;

import UserAndBook.test.*;
//import UserAndBook.test.BookTest;

public class Main {
    public static void main(String[] args) {
        // Gọi test User
        UserTest.runTests();

        // Gọi test Book
        BookTest.runTests();
    }
}
