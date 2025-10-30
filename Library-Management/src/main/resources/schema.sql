-- ============================
-- 📘 Library Management Schema
-- ============================

CREATE DATABASE IF NOT EXISTS librarydb;
USE librarydb;

-- ----------------------------
-- Bảng lưu thông tin khách hàng
-- ----------------------------
CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20)
);

-- ----------------------------
-- Bảng lưu thông tin sách
-- ----------------------------
CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year INT,
    available BOOLEAN DEFAULT TRUE
);

-- ----------------------------
-- Bảng yêu cầu mượn sách
-- ----------------------------
CREATE TABLE IF NOT EXISTS borrow_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    book_id INT NOT NULL,
    status VARCHAR(50) DEFAULT 'pending',
    request_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

-- ----------------------------
-- Bảng khách vãng lai (guest)
-- ----------------------------
CREATE TABLE IF NOT EXISTS guest (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(200)
);

-- ----------------------------
-- Bảng nhân viên (employee)
-- ----------------------------
CREATE TABLE IF NOT EXISTS employee (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(50),
    salary DOUBLE
);

-- ----------------------------
-- Một ít dữ liệu mẫu (optional)
-- ----------------------------
INSERT INTO customers (username, password, email, phone)
VALUES ('alice', '123456', 'alice@example.com', '0123456789')
ON DUPLICATE KEY UPDATE username=username;

INSERT INTO books (title, author, year, available)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 1925, TRUE)
ON DUPLICATE KEY UPDATE title=title;

INSERT INTO guest (id, name, phone, address)
VALUES ('G001', 'Guest One', '0901234567', 'Hanoi')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO employee (id, name, role, salary)
VALUES ('E001', 'Admin', 'Manager', 15000000)
ON DUPLICATE KEY UPDATE id=id;
