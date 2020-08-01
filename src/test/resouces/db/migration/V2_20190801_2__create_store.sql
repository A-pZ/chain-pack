CREATE TABLE `store` (
	`store_id` int(8) AUTO_INCREMENT NOT NULL,
	`store_name` varchar(200) NOT NULL,
	`insert_time` datetime,
	`update_time` datetime,
	CONSTRAINT store_PK PRIMARY KEY (store_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;