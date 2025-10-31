-- V2__sample_data.sql
-- insert a librarian user
INSERT INTO users (username, password, role) VALUES ('libadmin', 'password', 'LIBRARIAN') ON CONFLICT (username) DO NOTHING;
INSERT INTO librarians (user_id, librarian_id, full_name, age, citizen_id)
  SELECT user_id, 'L001', 'Admin Librarian', 35, 'CITIZEN001' FROM users WHERE username='libadmin' LIMIT 1;

-- insert customers
INSERT INTO users (username, password, role) VALUES ('alice', '123456', 'CUSTOMER') ON CONFLICT (username) DO NOTHING;
INSERT INTO users (username, password, role) VALUES ('bob', '123456', 'CUSTOMER') ON CONFLICT (username) DO NOTHING;

INSERT INTO customers (user_id, phone_number, full_name, age, address)
  SELECT user_id, '0123456789', 'Alice', 25, 'Hanoi' FROM users WHERE username='alice' LIMIT 1
  ON CONFLICT DO NOTHING;
INSERT INTO customers (user_id, phone_number, full_name, age, address)
  SELECT user_id, '0987654321', 'Bob', 28, 'HCMC' FROM users WHERE username='bob' LIMIT 1
  ON CONFLICT DO NOTHING;

-- books
INSERT INTO books (title, author, publish_year, quantity, borrowed_count)
 VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 1925, 3, 0),
        ('1984', 'George Orwell', 1949, 4, 0),
        ('Brave New World', 'Aldous Huxley', 1932, 2, 0);
