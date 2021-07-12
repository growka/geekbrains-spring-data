BEGIN;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO users (name) VALUES
('Bob'),
('John'),
('Ann'),
('James'),
('Ivan');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES
('apple', 100),
('banana', 80),
('pear', 70),
('lemon', 40),
('mango', 90),
('melon', 50),
('orange', 60);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (user_id bigint, product_id bigint, FOREIGN KEY (user_id) REFERENCES users (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO orders (user_id, product_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 4),
(2, 2),
(3, 5),
(3, 6);

COMMIT;