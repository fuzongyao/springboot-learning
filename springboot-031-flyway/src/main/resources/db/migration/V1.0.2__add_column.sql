ALTER TABLE test_flyway ADD status INT UNSIGNED NULL COMMENT '状态';
ALTER TABLE test_flyway MODIFY COLUMN create_time datetime NULL COMMENT '创建时间';
