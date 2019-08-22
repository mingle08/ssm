create table tb_emp(
	id int primary key auto_increment,#auto_increment只是MySQL特有的
	Name varchar(18),
	sex varchar(2),
	age INT,
	address varchar(200),
	email varchar(100)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='员工表';