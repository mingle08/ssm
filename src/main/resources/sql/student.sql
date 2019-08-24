
CREATE table tb_student (
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(32),
sex CHAR(1),
card_id INT UNIQUE,
FOREIGN KEY (card_id) REFERENCES tb_student_id_card(id)
);
INSERT INTO tb_student (NAME, sex, card_id) VALUES ('Rachel', 'f', 1);
INSERT INTO tb_student (NAME, sex, card_id) VALUES ('Jack', 'm', 2);


CREATE TABLE tb_student_id_card (
id INT PRIMARY KEY AUTO_INCREMENT,
CODE VARCHAR(8)
);

INSERT INTO tb_student_id_card (CODE) VALUES ('18030128');
INSERT INTO tb_student_id_card (CODE) VALUES ('18030135');