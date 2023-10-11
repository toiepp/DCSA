CREATE DATABASE IF NOT EXISTS appDB;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT SELECT,UPDATE,INSERT,DELETE ON appDB.* TO 'user'@'%';
FLUSH PRIVILEGES;

USE appDB;
CREATE TABLE IF NOT EXISTS products (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    price int NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS reviews (
    id INT(11) NOT NULL AUTO_INCREMENT,
    author VARCHAR(50) NOT NULL,
    content VARCHAR (300) NOT NULL,
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO products (name, price) VALUES 
('Shampoo', 149),
('Coca Cola', 89),
('Peanut Butter', 379);

INSERT INTO reviews (author, content, product_id) VALUES
('Jake', 'Super sweet', 2),
('Robert', 'Nice texture and taste', 3),
('Brad', 'Nice', 1);