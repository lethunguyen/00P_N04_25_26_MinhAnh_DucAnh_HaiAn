# 00P_N04_25_26_MinhAnh_DucAnh_HaiAn
# Thành viên:
| Họ và tên          | MSSV        |  Khoá  | Ngành |      Hệ     |
|--------------------|-------------|--------|-------|-------------|
| Nguyễn Minh Ánh    |  23010718   |  K17   |  CNTT |  Chính quy  |
| Nguyễn Lê Đức Anh  |  23010246   |  K17   |  CNTT |  Chính quy  |
| Vũ Hải An          |  23011987   |  K17   |  CNTT |  Chính quy  |

---
# Project: Xây dựng ứng dụng quản lý thư viện.
### Yêu cầu chính:
- Giao diện <b>Java Spring Boot</b>.
- Có chức năng quản lý thư viện, người đọc.
- Và các chức năng khác.

### Cụ thể: 
- Có chức năng quản lý nhân viên: 
  + Thêm, sửa, xoá nhân viên.
  + Liệt kê thông tin về nhân viên, có thể lọc ra các nhân viên theo chức vụ.
- Có chức năng quản lý sách:
  + Thêm, sửa, xoá sách.
  + Liệt kê thông tin về sách, có thể lọc sách theo nhiều cách (Ex: thể loại, chuyên ngành, ngôn ngữ, năm phát hành...)
- Có chức năng quản lý khách hàng - người đọc:
  + Thêm, xoá, sửa khách hàng.
  + Liệt kê các thông tin về khách hàng, phân loại và tìm khách hàng theo nhiều cách (Ex: tên, tuổi, địa chỉ, sách mượn,...)
- Có chức năng cho mượn/trả sách:
  + Mượn/trả sách nhanh gọn trên hệ thống.
  + Hỗ trợ gia hạn thời gian mượn sách.

## Sơ đồ khối yêu cầu


### 1.1 UML Class Diagram
<img width="985" height="680" alt="image" src="https://github.com/user-attachments/assets/899e6e8a-b909-4ff1-8880-b9e35ca5dfbe" />




### 1.2 UML Sequence Diagram
<img width="968" height="576" alt="image" src="https://github.com/user-attachments/assets/0dbd54e7-e3c6-4ebc-b3e9-e489cc95ba6f" />

## Sơ đồ thuật toán

### 2.1 CRUD Activity Diagram của Guest

| Create | Read | Update | Delete |
|--------|------|--------|--------|
| <img src="https://github.com/user-attachments/assets/de5434c6-c9be-42c9-8ce1-a40fd3882d07" width="200"/> | <img src="https://github.com/user-attachments/assets/968beab7-4d8a-4619-90da-3e289786a3c1" width="200"/> | <img src="https://github.com/user-attachments/assets/9d067b8d-b731-4f6f-ae9d-81b9c49eb14d" width="200"/> | <img src="https://github.com/user-attachments/assets/f3211aae-c2fa-4855-940e-395f7cca30d3" width="200"/> |
