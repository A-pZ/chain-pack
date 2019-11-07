CREATE TABLE operation_log (
	id BIGINT auto_increment NOT NULL AUTO_INCREMENT COMMENT '自動採番',
	model varchar(32) NOT NULL COMMENT '対象モデル',
	item_id INT COMMENT '商品id',
	store_id INT COMMENT '拠点id',
	operation_type varchar(32) NOT NULL COMMENT 'データ更新タイプ',
	hash_code varchar(128) NOT NULL COMMENT 'chain_pack移送ログハッシュ',
	CONSTRAINT operation_log_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;
