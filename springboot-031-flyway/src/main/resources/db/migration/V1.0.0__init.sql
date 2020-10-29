CREATE TABLE test_flyway (
	id INT UNSIGNED auto_increment NOT NULL COMMENT '自增id',
	name varchar(100) NULL COMMENT '名称',
	create_time DATETIME NULL,
	CONSTRAINT test_flyway_PK PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
