-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `store_x_store`
--

LOCK TABLES `store_x_store` WRITE;
/*!40000 ALTER TABLE `store_x_store` DISABLE KEYS */;
INSERT INTO `store_x_store` VALUES (1,2),(1,3),(1,4),(2,6),(3,7),(4,8),(2,1),(4,1),(5,1),(9,5),(8,4),(3,1),(1,5),(11,6),(10,9),(5,9),(11,10),(11,16),(22,21),(23,12),(23,13);
/*!40000 ALTER TABLE `store_x_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `store_x_user`
--

LOCK TABLES `store_x_user` WRITE;
/*!40000 ALTER TABLE `store_x_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_x_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'商品管理本部','2019-09-26 11:26:56','2019-09-26 11:26:56'),(2,'文京区','2019-09-30 07:15:15','2019-09-30 07:15:15'),(3,'港区','2019-10-05 07:36:59','2019-10-05 07:36:59'),(4,'品川区','2019-10-05 07:37:05','2019-10-05 07:37:05'),(5,'大田区','2019-10-05 07:37:09','2019-10-05 07:37:09'),(6,'文京区食品センター','2019-10-05 07:38:17','2019-10-05 07:38:17'),(7,'港区食品センター','2019-10-05 07:38:26','2019-10-05 07:38:26'),(8,'品川区食品センター','2019-10-05 07:38:49','2019-10-05 07:38:49'),(9,'大田区食品センター','2019-10-05 07:38:57','2019-10-05 07:38:57'),(10,'千代田区食品センター','2019-10-22 23:16:08','2019-10-22 23:16:08'),(11,'杉並区食品センター','2019-10-22 23:17:02','2019-10-22 23:17:02'),(12,'品川区食品センター','2019-10-24 19:16:03','2019-10-24 19:16:03'),(13,'!\"#$%&\'\'()=\\_?><','2019-10-24 19:18:20','2019-10-24 19:18:20'),(14,'☆◇〇×▽ζ','2019-10-24 19:18:27','2019-10-24 19:18:27'),(15,'「！　”＃　　」','2019-10-24 19:18:38','2019-10-24 19:18:38'),(16,'亞','2019-10-24 19:19:47','2019-10-24 19:19:47'),(17,'彌','2019-10-24 19:20:13','2019-10-24 19:20:13'),(18,'亞','2019-10-25 14:00:58','2019-10-25 14:00:58'),(19,'?田','2019-10-25 14:01:02','2019-10-25 14:01:02'),(20,'?','2019-10-25 14:01:08','2019-10-25 14:01:08'),(21,'?????','2019-10-27 16:24:22','2019-10-27 16:24:22'),(22,'登録22X','2019-11-02 11:14:06','2019-11-02 11:14:06'),(23,'登録23XXX','2019-11-03 14:45:51','2019-11-03 14:45:51');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `operation_log`
--

LOCK TABLES `operation_log` WRITE;
/*!40000 ALTER TABLE `operation_log` DISABLE KEYS */;
INSERT INTO `operation_log` VALUES (4,'item',NULL,NULL,'INSERT','5cdb07ebf9639213680f522cb66a7f1637cb988c3e390bb80dd7bcbce6a384cb'),(5,'item',19,NULL,'UPDATE','7f048351d388e7110b68da88de09625f30dbe38e548d31cd9bee0622103e1ba2'),(6,'deposit',19,1,'INSERT','34669bb54f620fb48cf99a1bfa5ed7b4ff61d2cdba4d347a6b22a417b890f20b'),(7,'deposit',19,4,'INSERT','c994c1955e7db6b04ab8eb9a8d295eab761cc6afca537c8bf6ba14dc5aecb31c'),(8,'deposit',19,5,'INSERT','a77ef90997d9e3dd8ad33a423fa45f52a6a6c85045f8f6bab445871c5301702c'),(9,'deposit',19,5,'DELETE','c058f0c32ae307064e3b284fbb4e14d5145b24e4ed4c1c9fda421a1b523fce78'),(10,'deposit',19,5,'INSERT','a77ef90997d9e3dd8ad33a423fa45f52a6a6c85045f8f6bab445871c5301702c'),(11,'deposit',19,22,'INSERT','2a26825ecda57b9d20a4fca01f3b52a41ac5c9139e2e9af50cc18d3d8b91d7b3'),(12,'store',NULL,NULL,'INSERT','8a36da38866758075198a147b43178e0f3fc28cc78afbb941a1340c48bd3b365'),(13,'store',NULL,23,'UPDATE','a472e90b88541903081326bd9e53243914297235bdd8e8bd69c2caa480ee635c'),(14,'transfer',19,1,'DELETE','3d837e2711fb9803f723a20c8cad47cd1daf1c18284f49d187060d3b06fc0248'),(15,'transfer',19,2,'INSERT','ca501b6d29c4ca488d6a049ee2a74b255e6c03cefe9808da8abef2b138b6deec'),(16,'transfer',18,1,'DELETE','448d9a4d2eb01a23d79025717582ce1ad5a58d41a92bdd061bab7ea66af71d37'),(17,'transfer',18,2,'INSERT','5dd5d3748a27d1c5e2ed5311af1bee5c7a90a2b417b5c30a36fd57a1d4c5684a'),(18,'transfer',2,1,'DELETE','f3bc84468803f4eb1b9fa1a6074cc34a6d013c3616a3413f5fd313fe79ac4360'),(19,'transfer',2,3,'INSERT','e220446c48e298c6bc8696d012e4ae4ecd56f7bcf1338fe10612d427cc8819d8'),(20,'transfer',2,1,'DELETE','f3bc84468803f4eb1b9fa1a6074cc34a6d013c3616a3413f5fd313fe79ac4360'),(21,'transfer',2,2,'INSERT','4593d3525e7ef7afa1dce988a27280eea4ea429ce9db3a6750b98f9386223821'),(22,'transfer',2,1,'DELETE','f3bc84468803f4eb1b9fa1a6074cc34a6d013c3616a3413f5fd313fe79ac4360'),(23,'transfer',2,3,'INSERT','e220446c48e298c6bc8696d012e4ae4ecd56f7bcf1338fe10612d427cc8819d8'),(24,'transfer',2,1,'DELETE','f3bc84468803f4eb1b9fa1a6074cc34a6d013c3616a3413f5fd313fe79ac4360'),(25,'transfer',2,4,'INSERT','f752cd04b8ddd84f983e9e7d94d21052026d7cb5ea8f7aa0f1bd01e3021aec53'),(26,'transfer',1,1,'DELETE','94d5a2a03a7f6d36d05a3628da94e8cd896ed45f684a9643acd7dd227e52e5b7'),(27,'transfer',1,5,'INSERT','c681cb2c12a47ee57c135504a26ad6d7c50403f7448a32573b992fd45b53cc8e'),(28,'deposit',1,1,'INSERT','b2e62e0a9d876cabf21e44337778afbf498cfe4ec8ea70c27620524f038bdc7c'),(29,'deposit',1,2,'INSERT','10f87a3676e163f2890d3b6581f67635315dc056ae32858422cc5a30cb1a5ab6'),(30,'deposit',1,3,'INSERT','5738976883509796b176b248fb651ff5a7f8a4a167d836a35bbb5bcbe733f337'),(31,'deposit',1,4,'INSERT','94df8716b6594523c3d5a7bce3126455431767fca26e5fa32303008b6e044440'),(32,'transfer',1,1,'DELETE','94d5a2a03a7f6d36d05a3628da94e8cd896ed45f684a9643acd7dd227e52e5b7'),(33,'transfer',1,2,'INSERT','10f87a3676e163f2890d3b6581f67635315dc056ae32858422cc5a30cb1a5ab6'),(34,'transfer',1,2,'DELETE','530200062d8f368e3f5895280b2e8add3608ca724b23ba830f427563878169f8'),(35,'transfer',1,1,'INSERT','b2e62e0a9d876cabf21e44337778afbf498cfe4ec8ea70c27620524f038bdc7c'),(36,'transfer',2,2,'DELETE','0acaa77f3b3119d3f523a27d634da966a1e63de6c77a4a350a223126c3a7f97f'),(37,'transfer',2,1,'INSERT','55731db7fa303817721bcc01086f591c1319de148ea24c72e849c6ed2f12a4d3'),(38,'deposit',4,5,'INSERT','0b053ddc431bf50fcf02e555442788fc4f35f7c85c28ad5618c20ae9ae3e1fb8'),(39,'deposit',4,4,'INSERT','8a376df35e29efb95621f1c165cdd21d5be8f66b396f0f3457c7c40afda0690c'),(40,'deposit',4,8,'INSERT','3ddc86534679ecf3741b17b9012e1fc5c5105046f4d132ed66bf22a56ffc5cce'),(41,'deposit',4,9,'INSERT','179a2b296a2e4020103f3a72ac9c0b92cb10b95b6ced122f420f424ae70d8902'),(42,'deposit',4,10,'DELETE','053a5544f4649df6920e7b169b4fec33fd7c23f2931c4d542714dec038952c0a'),(43,'deposit',4,11,'INSERT','50daed2d9458377a69ac1cdfe5b0881211cab821a32a24b15e9135bcc823c364'),(44,'deposit',4,12,'INSERT','07688a51adb8e3af26759b74ab197ede63b87bb39e64cfa533a9301725bbc84d'),(45,'deposit',4,13,'INSERT','d2bacb4fc58c0e48dff3a69de6d133b5fd394fb13115fadb14e665d5852e8d8b'),(46,'deposit',4,10,'INSERT','bb772c1a87f06748e31b37b90c6590ea7dfffcaf0e5fa5d2e069092acc609273'),(47,'deposit',4,3,'INSERT','b2cdb284d0223777314664d6e0bba9cb857cfe385cff64b51303d79270eae898'),(48,'deposit',4,2,'INSERT','2b81d9d5d6780638eb124fae43a48445bf5c907d3ba919d4700a464e077518dd'),(49,'deposit',4,1,'INSERT','ad13dcd15caf75a5656994c0494bdc977b04134895d1e496011bd6c2e9e516eb');
/*!40000 ALTER TABLE `operation_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'茨城県産コシヒカリ5kg','2019-09-26 11:14:43','2019-10-06 19:49:46'),(2,'栃木県産大麦500g','2019-10-05 08:08:40','2019-10-05 08:08:40'),(3,'茨城県産コシヒカリ5kg','2019-10-22 15:21:17','2019-10-22 15:21:17'),(4,'鹿児島県産緑茶25kg','2019-10-22 15:22:14','2019-10-24 18:22:21'),(5,'!\"#$%&\'\'()=\\_?><','2019-10-24 17:47:44','2019-10-24 17:47:44'),(6,'☆◇〇×▽ζ','2019-10-24 17:50:21','2019-10-24 17:50:21'),(7,'?','2019-10-24 17:53:20','2019-10-25 14:02:18'),(8,'！　”＃　　','2019-10-24 17:54:46','2019-10-24 17:54:46'),(9,'榮','2019-10-24 17:56:38','2019-10-24 17:56:38'),(10,'圓','2019-10-24 17:57:08','2019-10-24 17:57:08'),(11,'渡邉','2019-10-24 18:03:41','2019-10-24 18:03:41'),(12,'壽','2019-10-24 18:06:42','2019-10-24 18:06:42'),(13,'榮','2019-10-25 13:56:10','2019-10-25 13:56:10'),(14,'渡邉','2019-10-25 13:56:20','2019-10-25 13:56:20'),(15,'圓','2019-10-25 13:56:27','2019-10-25 13:56:27'),(16,'?田','2019-10-25 13:56:35','2019-10-25 13:56:35'),(17,'?','2019-10-25 13:57:31','2019-10-25 13:57:31'),(18,'登録18番','2019-11-02 11:11:38','2019-11-03 10:22:00'),(19,'変更19','2019-11-03 14:33:18','2019-11-03 14:33:36');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `store_x_item`
--

LOCK TABLES `store_x_item` WRITE;
/*!40000 ALTER TABLE `store_x_item` DISABLE KEYS */;
INSERT INTO `store_x_item` VALUES (3,2),(4,2),(6,2),(7,2),(8,2),(7,4),(9,2),(6,4),(16,4),(6,2),(4,19),(5,19),(22,19),(2,19),(2,18),(3,2),(3,2),(4,2),(5,1),(3,1),(4,1),(1,1),(1,2),(5,4),(4,4),(8,4),(9,4),(11,4),(12,4),(13,4),(10,4),(3,4),(2,4),(1,4);
/*!40000 ALTER TABLE `store_x_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-08 22:02:34
