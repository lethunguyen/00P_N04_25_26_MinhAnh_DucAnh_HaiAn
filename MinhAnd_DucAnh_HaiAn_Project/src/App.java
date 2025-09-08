import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập thông tin khách hàng
        System.out.print("Nhập tên khách hàng: ");
        String ten = sc.nextLine();

        System.out.print("Nhập mã khách hàng: ");
        String ma = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String sdt = sc.nextLine();

        System.out.print("Nhập địa chỉ: ");
        String diaChi = sc.nextLine();

        // Tạo đối tượng khách hàng từ dữ liệu nhập vào
        KhachHang kh = new KhachHang(ten, ma, sdt, diaChi);

        // In ra để kiểm tra
        System.out.println("\n--- Thông tin khách hàng ---");
        System.out.println(kh);

        sc.close();
    }
}
