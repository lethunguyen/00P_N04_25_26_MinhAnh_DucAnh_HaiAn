import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Lớp này chứa một phương thức tĩnh để ghi nội dung vào một file.
 */
public class FileEdit {

    /**
     * Ghi một chuỗi nội dung vào file được chỉ định.
     * Nếu file đã tồn tại, nội dung cũ sẽ bị ghi đè.
     * Nếu file chưa tồn tại, một file mới sẽ được tạo.
     *
     * @param filename Tên của file (ví dụ: "data.txt").
     * @param content  Nội dung cần ghi vào file.
     */
    public static void writeToFile(String filename, String content) {
        // Sử dụng try-with-resources để đảm bảo writer được đóng tự động
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("Ghi file '" + filename + "' thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
            // In ra stack trace để dễ dàng gỡ lỗi
            e.printStackTrace();
        }
    }

    /**
     * Sửa nội dung của một file bằng cách ghi đè nội dung mới.
     * Nếu file chưa tồn tại, một file mới sẽ được tạo.
     *
     * @param filename   Tên của file cần sửa.
     * @param newContent Nội dung mới để ghi vào file.
     */
    public static void editFile(String filename, String newContent) {
        // Sử dụng try-with-resources để đảm bảo writer được đóng tự động
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(newContent);
            System.out.println("Sửa file '" + filename + "' thành công!");
        } catch (IOException e) {
            System.err.println("Lỗi khi sửa file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

