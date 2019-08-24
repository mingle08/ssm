CREATE TABLE tb_book_category (
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(32)
);
INSERT INTO tb_book_category (NAME) VALUES ('java');
INSERT INTO tb_book_category (NAME) VALUES ('python');
INSERT INTO tb_book_category (NAME) VALUES ('go');

CREATE TABLE tb_book (
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(32),
price FLOAT,
category_id INT,
FOREIGN KEY (category_id) REFERENCES tb_book_category(id)
);

INSERT INTO tb_book (NAME, price, category_id) VALUES ('Spring源码深度解析', 99.00, 1);
INSERT INTO tb_book (NAME, price, category_id) VALUES ('SpringBoot编程思想', 118.00, 1);
INSERT INTO tb_book (NAME, price, category_id) VALUES ('码农翻身', 69.00, 1);
INSERT INTO tb_book (NAME, price, category_id) VALUES ('Python核心编程', 75.00, 2);
INSERT INTO tb_book (NAME, price, category_id) VALUES ('go语言编程', 49.00, 3);

