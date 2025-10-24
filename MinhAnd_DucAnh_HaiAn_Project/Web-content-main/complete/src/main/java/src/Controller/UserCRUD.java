package src.Controller;

import java.util.HashMap;
import java.util.Map;

import src.Model.User;


public class UserCRUD {
    // Giả lập database (tách riêng khỏi User để dễ quản lý)
    private static Map<String, User> users = new HashMap<>();

    // CREATE
    public static boolean createUser(String username, String password, String role) {
        if (users.containsKey(username)) {
            System.out.println("❌ User đã tồn tại!");
            return false;
        }
        User newUser = new User(username, password, role);
        users.put(username, newUser);
        System.out.println("✅ Tạo user thành công: " + username);
        return true;
    }

    // READ
    public static User readUser(String username) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("❌ Không tìm thấy user: " + username);
        } else {
            System.out.println("👤 Thông tin user: " + username + ", Role: " + user.getRole());
        }
        return user;
    }

    // UPDATE
    public static boolean updateUser(String username, String newPassword, String newRole) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("❌ Không tìm thấy user để cập nhật: " + username);
            return false;
        }
        user.password = newPassword;
        user.role = newRole;
        System.out.println("🔄 Cập nhật thành công cho user: " + username);
        return true;
    }

    // DELETE
    public static boolean deleteUser(String username) {
        if (!users.containsKey(username)) {
            System.out.println("❌ Không tìm thấy user để xóa: " + username);
            return false;
        }
        users.remove(username);
        System.out.println("🗑️ Đã xóa user: " + username);
        return true;
    }

    // Hiển thị tất cả user
    public static void listUsers() {
        if (users.isEmpty()) {
            System.out.println("⚠️ Chưa có user nào.");
        } else {
            System.out.println("📋 Danh sách users:");
            for (String key : users.keySet()) {
                User u = users.get(key);
                System.out.println("- " + key + " | Role: " + u.getRole());
            }
        }
    }
}