package src.Model;
import java.util.HashMap;
import java.util.Map;

public class User {
    // Database giả lập (dùng HashMap)
    private static Map<String, String> accounts = new HashMap<>();

    protected String username;
    public String password;
    public String role; // "nhanvien", "khachhang", "admin"

    // Constructor
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Tạo tài khoản (lưu vào accounts)
    public static boolean register(String username, String password) {
        if (accounts.containsKey(username)) {
            System.out.println("Tài khoản đã tồn tại!");
            return false;
        }
        accounts.put(username, password);
        System.out.println("Đăng ký thành công cho user: " + username);
        return true;
    }

    // Đăng nhập
    public static boolean login(String username, String password) {
        if (!accounts.containsKey(username)) {
            System.out.println("Tài khoản không tồn tại!");
            return false;
        }
        if (accounts.get(username).equals(password)) {
            System.out.println("Đăng nhập thành công!");
            return true;
        } else {
            System.out.println("Sai mật khẩu!");
            return false;
        }
    }

    public String getRole() {
        return role;
    }

    public void logout() {
        System.out.println(username + " đã đăng xuất.");
    }
}