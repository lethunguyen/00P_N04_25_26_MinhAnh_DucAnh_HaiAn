-- V1__init.sql
CREATE TABLE IF NOT EXISTS users (
  user_id SERIAL PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255),
  role VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS customers (
  user_id BIGINT PRIMARY KEY,
  phone_number VARCHAR(50),
  full_name VARCHAR(200),
  age INT,
  address VARCHAR(500),
  CONSTRAINT fk_customer_user FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS librarians (
  user_id BIGINT PRIMARY KEY,
  librarian_id VARCHAR(50),
  full_name VARCHAR(200),
  age INT,
  citizen_id VARCHAR(100),
  CONSTRAINT fk_librarian_user FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS books (
  id SERIAL PRIMARY KEY,
  title VARCHAR(500),
  author VARCHAR(255),
  publish_year INT,
  quantity INT,
  borrowed_count INT
);

CREATE TABLE IF NOT EXISTS borrow_requests (
  request_id SERIAL PRIMARY KEY,
  request_date DATE,
  return_date DATE,
  status VARCHAR(50),
  customer_id BIGINT,
  book_id BIGINT,
  approved_by BIGINT,
  CONSTRAINT fk_req_customer FOREIGN KEY(customer_id) REFERENCES customers(user_id) ON DELETE SET NULL,
  CONSTRAINT fk_req_book FOREIGN KEY(book_id) REFERENCES books(id) ON DELETE SET NULL,
  CONSTRAINT fk_req_librarian FOREIGN KEY(approved_by) REFERENCES librarians(user_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS guests (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200),
  phone VARCHAR(50),
  address VARCHAR(500)
);
