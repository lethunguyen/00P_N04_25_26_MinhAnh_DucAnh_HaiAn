📚 Dự án Quản lý Thư viện — Java JDK 11
🧠 Giới thiệu

Dự án Quản lý Thư viện được phát triển bằng Java 11, sử dụng MySQL làm cơ sở dữ liệu và tuân theo mô hình MVC (Model - View - Controller).
Ứng dụng chạy hoàn toàn trong GitHub Codespaces, có thể kết nối trực tiếp với cơ sở dữ liệu Aiven Cloud hoặc MySQL cục bộ.

Dự án hỗ trợ:

Hệ thống quản lý khách (Guest), nhân viên (Staff), quản lý (Manager).

Xử lý lỗi thống nhất bằng Runtime Exception.

Ẩn thông tin kết nối cơ sở dữ liệu qua file .env để đảm bảo an toàn khi commit lên GitHub.

⚙️ Yêu cầu môi trường

Trước khi chạy, hãy đảm bảo bạn có:

☕ Java JDK 11 (hoặc tương thích)

🧱 Apache Maven 3.8+

🐬 MySQL Database hoặc tài khoản Aiven DB

📁 File cấu hình .env

🧩 Cấu trúc dự án

📦 Library-Management
┣ 📂 src/
┃  ┣ 📂 Controller/      # CRUD và điều khiển luồng dữ liệu
┃  ┣ 📂 Model/           # Các lớp đối tượng: Guest, Book, Staff...
┃  ┣ 📂 Database/        # Kết nối DB, xử lý lỗi, runtime exception
┃  ┗ 📜 App.java         # Chạy chính (main)
┣ 📜 pom.xml             # Cấu hình Maven & dependency
┣ 📜 .env.example        # Mẫu file cấu hình môi trường
┣ 📜 .gitignore          # Ẩn thông tin nhạy cảm (.env, target, v.v.)
┗ 📜 MUST_READ.md        # Hướng dẫn dự án

🧰 Cách chạy trên Codespaces hoặc máy cục bộ

1️⃣ Tạo file .env

Tại thư mục gốc của project (/complete/ hoặc tương đương), tạo file .env với nội dung như sau:
DB_URL=jdbc:mysql://<aiven-host>:<port>/<database>
DB_USER=<service-user>
DB_PASSWORD=<service-password>

2️⃣ Kiểm tra Maven và Java
java -version
mvn -v

Kết quả mong đợi:
openjdk version "11.0.x"
Apache Maven 3.8.x

3️⃣ Build dự án
mvn clean compile
✅ Nếu thấy “BUILD SUCCESS” là bạn đã sẵn sàng chạy!

🧩 Xử lý lỗi và Runtime Exception

Tất cả lớp trong src/Database và src/Controller đều có xử lý ngoại lệ runtime.

Nếu không tìm thấy biến môi trường (.env) hoặc không thể kết nối DB → chương trình sẽ báo lỗi rõ ràng và dừng an toàn.

Khi thao tác CRUD bị lỗi (ví dụ: nhập ID sai hoặc lỗi SQL), ứng dụng vẫn tiếp tục chạy nhưng hiển thị thông báo cụ thể.

💬 Tác giả & Liên hệ

👨‍💻 Nhóm 1
📧 Liên hệ hỗ trợ: 23010246@phenikaa-uni.edu.vn/@dav449.
🌐 Hướng dẫn sử dụng chi tiết và script SQL tạo bảng sẽ được bổ sung trong thư mục /docs/.