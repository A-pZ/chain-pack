-- --------------------------------------------------------
-- ホスト:                          127.0.0.1
-- サーバーのバージョン:                   10.3.11-MariaDB - mariadb.org binary distribution
-- サーバー OS:                      Win64
-- HeidiSQL バージョン:               9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- テーブル test.item: ~17 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`item_id`, `name`, `insert_time`, `update_time`) VALUES
	(1, '茨城県産コシヒカリ5kg', '2019-09-26 11:14:43', '2019-10-06 19:49:46'),
	(2, '栃木県産大麦500g', '2019-10-05 08:08:40', '2019-10-05 08:08:40'),
	(3, '茨城県産コシヒカリ5kg', '2019-10-22 15:21:17', '2019-10-22 15:21:17'),
	(4, '鹿児島県産緑茶25kg', '2019-10-22 15:22:14', '2019-10-24 18:22:21'),
	(5, '!"#$%&\'\'()=\\_?><', '2019-10-24 17:47:44', '2019-10-24 17:47:44'),
	(6, '☆◇〇×▽ζ', '2019-10-24 17:50:21', '2019-10-24 17:50:21'),
	(7, '🥙', '2019-10-24 17:53:20', '2019-10-25 14:02:18'),
	(8, '！　”＃　　', '2019-10-24 17:54:46', '2019-10-24 17:54:46'),
	(9, '榮', '2019-10-24 17:56:38', '2019-10-24 17:56:38'),
	(10, '圓', '2019-10-24 17:57:08', '2019-10-24 17:57:08'),
	(11, '渡邉', '2019-10-24 18:03:41', '2019-10-24 18:03:41'),
	(12, '壽', '2019-10-24 18:06:42', '2019-10-24 18:06:42'),
	(13, '榮', '2019-10-25 13:56:10', '2019-10-25 13:56:10'),
	(14, '渡邉', '2019-10-25 13:56:20', '2019-10-25 13:56:20'),
	(15, '圓', '2019-10-25 13:56:27', '2019-10-25 13:56:27'),
	(16, '𠮷田', '2019-10-25 13:56:35', '2019-10-25 13:56:35'),
	(17, '🎁', '2019-10-25 13:57:31', '2019-10-25 13:57:31');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- テーブル test.store: ~20 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` (`store_id`, `store_name`, `insert_time`, `update_time`) VALUES
	(1, '商品管理本部', '2019-09-26 11:26:56', '2019-09-26 11:26:56'),
	(2, '文京区', '2019-09-30 07:15:15', '2019-09-30 07:15:15'),
	(3, '港区', '2019-10-05 07:36:59', '2019-10-05 07:36:59'),
	(4, '品川区', '2019-10-05 07:37:05', '2019-10-05 07:37:05'),
	(5, '大田区', '2019-10-05 07:37:09', '2019-10-05 07:37:09'),
	(6, '文京区食品センター', '2019-10-05 07:38:17', '2019-10-05 07:38:17'),
	(7, '港区食品センター', '2019-10-05 07:38:26', '2019-10-05 07:38:26'),
	(8, '品川区食品センター', '2019-10-05 07:38:49', '2019-10-05 07:38:49'),
	(9, '大田区食品センター', '2019-10-05 07:38:57', '2019-10-05 07:38:57'),
	(10, '千代田区食品センター', '2019-10-22 23:16:08', '2019-10-22 23:16:08'),
	(11, '杉並区食品センター', '2019-10-22 23:17:02', '2019-10-22 23:17:02'),
	(12, '品川区食品センター', '2019-10-24 19:16:03', '2019-10-24 19:16:03'),
	(13, '!"#$%&\'\'()=\\_?><', '2019-10-24 19:18:20', '2019-10-24 19:18:20'),
	(14, '☆◇〇×▽ζ', '2019-10-24 19:18:27', '2019-10-24 19:18:27'),
	(15, '「！　”＃　　」', '2019-10-24 19:18:38', '2019-10-24 19:18:38'),
	(16, '亞', '2019-10-24 19:19:47', '2019-10-24 19:19:47'),
	(17, '彌', '2019-10-24 19:20:13', '2019-10-24 19:20:13'),
	(18, '亞', '2019-10-25 14:00:58', '2019-10-25 14:00:58'),
	(19, '𠮷田', '2019-10-25 14:01:02', '2019-10-25 14:01:02'),
	(20, '🎁', '2019-10-25 14:01:08', '2019-10-25 14:01:08');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;

-- テーブル test.store_x_item: ~14 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `store_x_item` DISABLE KEYS */;
INSERT INTO `store_x_item` (`store_id`, `item_id`) VALUES
	(1, 2),
	(2, 2),
	(3, 2),
	(4, 2),
	(6, 2),
	(7, 2),
	(8, 2),
	(1, 1),
	(7, 4),
	(9, 2),
	(6, 4),
	(10, 4),
	(16, 4),
	(6, 2);
/*!40000 ALTER TABLE `store_x_item` ENABLE KEYS */;

-- テーブル test.store_x_store: ~17 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `store_x_store` DISABLE KEYS */;
INSERT INTO `store_x_store` (`store_id`, `relation_store_id`) VALUES
	(1, 2),
	(1, 3),
	(1, 4),
	(2, 6),
	(3, 7),
	(4, 8),
	(2, 1),
	(4, 1),
	(5, 1),
	(9, 5),
	(8, 4),
	(3, 1),
	(1, 5),
	(11, 6),
	(10, 9),
	(5, 9),
	(11, 10),
	(11, 16);
/*!40000 ALTER TABLE `store_x_store` ENABLE KEYS */;

-- テーブル test.store_x_user: ~0 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `store_x_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_x_user` ENABLE KEYS */;

-- テーブル test.user: ~0 rows (approximately) のデータをダンプしています
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
