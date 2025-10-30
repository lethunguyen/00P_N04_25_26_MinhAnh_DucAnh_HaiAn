package Test;

import src.Model.User;

public class UserTest {
    public static void runTests() {
        System.out.println("===== BẮT ĐẦU KIỂM THỬ USER =====");

        // Test đăng ký
        User.register("nv01", "1234");
        User.register("kh01", "abcd");
        User.register("nv01", "1111"); // trùng username

        // Test đăng nhập
        User.login("nv01", "1234"); // thành công
        User.login("kh01", "xyz");  // sai mật khẩu
        User.login("test", "0000"); // tài khoản không tồn tại

        // Test role + logout
        User nhanVien = new User("nv01", "1234", "nhanvien");
        System.out.println("Role của nv01 là: " + nhanVien.getRole());
        nhanVien.logout();

        System.out.println("===== KẾT THÚC KIỂM THỬ =====");
    }
}
