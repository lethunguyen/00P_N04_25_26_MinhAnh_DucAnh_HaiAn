package UserAndBook.test;

import UserAndBook.src.UserCRUD;

public class UserCRUDTest {
    public static void runTests() {
        System.out.println("===== BẮT ĐẦU KIỂM THỬ UserCRUD =====");

        // Test Create
        UserCRUD.createUser("nv01", "1234", "nhanvien");
        UserCRUD.createUser("kh01", "abcd", "khachhang");
        UserCRUD.createUser("admin", "admin", "admin");

        // Test Read
        UserCRUD.readUser("nv01");
        UserCRUD.readUser("notfound");

        // Test Update
        UserCRUD.updateUser("kh01", "newpass", "vip_khachhang");
        UserCRUD.updateUser("fakeUser", "1234", "test");

        // Test Delete
        UserCRUD.deleteUser("admin");
        UserCRUD.deleteUser("notfound");

        // Test List
        UserCRUD.listUsers();

        System.out.println("===== KẾT THÚC KIỂM THỬ UserCRUD =====");
    }
}
