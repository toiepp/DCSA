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

INSERT INTO products (name, price) 
VALUES ('Shampoo', 148),
('Coconut', 50);

