
DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR(255));
insert into users (name) values
('Sasha'),
('Pasha'),
('Dasha');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price bigint);
insert into products (title, price) values
('Milk', 100),
('Bread', 200),
('Cola', 300),
('Meet', 400),
('Water', 500);

DROP TABLE IF EXISTS user_orders CASCADE;
CREATE TABLE user_orders (order_id bigserial, user_id bigint, product_id bigint, product_cost_at_order_time bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (user_id) REFERENCES users (id));
INSERT INTO user_orders (user_id, product_id, product_cost_at_order_time) VALUES
(1, 1, 50),
(1, 2, 50),
(1, 3, 50),
(2, 1, 50),
(2, 2, 50),
(2, 3, 50),
(2, 4, 50),
(2, 5, 50),
(3, 3, 50);


DROP TABLE IF EXISTS books CASCADE;
CREATE TABLE books (id bigserial PRIMARY KEY, title VARCHAR(255));
INSERT INTO books (title) VALUES
('Mistborn'),
('Neverwhere'),
('Ambers Chronicles'),
('Harry Potter'),
('Lockwood & Co.'),
('Foundation Trilogy'),
('Liveship Traders Trilogy'),
('A Night in the Lonesome October'),
('Da Vinci Code'),
('Lord of the Ring');

DROP TABLE IF EXISTS readers CASCADE;
CREATE TABLE readers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO readers (name) VALUES
('Alexander'),
('Bob');

DROP TABLE IF EXISTS books_readers CASCADE;
CREATE TABLE books_readers (book_id bigint, reader_id bigint, FOREIGN KEY (book_id) REFERENCES books (id), FOREIGN KEY (reader_id) REFERENCES readers (id));
INSERT INTO books_readers (book_id, reader_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(1, 2),
(2, 2);