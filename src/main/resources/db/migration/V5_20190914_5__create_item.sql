CREATE TABLE test.item (
	item_id INT NULL AUTO_INCREMENT COMMENT '商品id',
	name varchar(256) NULL COMMENT '商品名',
	insert_time DATETIME NULL COMMENT '登録時間',
	update_time DATETIME NULL COMMENT '更新時間',
	CONSTRAINT item_PK PRIMARY KEY (item_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;
