-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eataholic
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT primary key,
  `belong_Passage` int(11) NOT NULL,
  `belong_User` varchar(20) NOT NULL,
  `content` varchar(100) NOT NULL,
  `remarkTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `belong_User` (`belong_User`),
  KEY `belong_Passage` (`belong_Passage`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`belong_User`) REFERENCES `users` (`userName`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`belong_Passage`) REFERENCES `passage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'我是一条咸鱼','真好玩！！！！','2017-05-29 13:20:45'),(1,'我是一条咸鱼','好文章，支持支持！！','2017-05-29 10:20:45'),(1,'我是一条咸鱼','回去就做试试看好不好吃~','2017-05-29 14:20:45'),(2,'我是一条咸鱼','123456','2017-05-31 14:48:56'),(2,'我是一条咸鱼','文章很棒！','2017-05-31 14:50:12'),(11,'我是一条咸鱼','测试评论1','2017-05-31 15:17:56'),(19,'我是一条咸鱼','123','2017-06-04 16:20:35'),(19,'我是一条咸鱼','123','2017-06-04 16:21:29'),(19,'我是一条咸鱼','123','2017-06-04 16:21:34');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passage`
--

DROP TABLE IF EXISTS `passage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(20) NOT NULL,
  `content` text(200000) DEFAULT NULL,
  `click` int(11) DEFAULT '0',
  `commentNum` int(11) DEFAULT '0',
  `likeNum` int(11) DEFAULT '0',
  `passageTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(30) NOT NULL,
  `passageType` varchar(10) NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `author` (`author`),
  CONSTRAINT `passage_ibfk_1` FOREIGN KEY (`author`) REFERENCES `users` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passage`
--

LOCK TABLES `passage` WRITE;
/*!40000 ALTER TABLE `passage` DISABLE KEYS */;
INSERT INTO `passage` VALUES (1,'我是一条咸鱼','fsfgss测试内容1',2,0,0,'2017-05-29 13:20:45','测试文章1','美食分享',NULL),(2,'我是一条咸鱼','fsfgss测试内容2',35,0,0,'2017-05-30 07:20:45','测试文章2','美食分享',NULL),(3,'我是一条咸鱼','fsfgss测试内容3',0,0,0,'2017-05-28 10:20:45','测试文章2','美食分享',NULL),(4,'我是一条咸鱼','fsfgss测试内容1',0,0,0,'2017-05-29 13:20:45','测试文章1','美食食谱',NULL),(5,'我是一条咸鱼','fsfgss测试内容2',2,0,0,'2017-05-30 07:20:45','测试文章2','美食食谱',NULL),(6,'我是一条咸鱼','fsfgss测试内容3',0,0,0,'2017-05-28 10:20:45','测试文章2','美食食谱',NULL),(7,'我是一条咸鱼','fsfgss测试内容1',0,0,0,'2017-05-29 13:20:45','测试文章1','美食趣事',NULL),(8,'我是一条咸鱼','fsfgss测试内容2',0,0,0,'2017-05-30 07:20:45','测试文章2','美食趣事',NULL),(9,'我是一条咸鱼','fsfgss测试内容3',0,0,0,'2017-05-28 10:20:45','测试文章2','美食趣事',NULL),(10,'我是一条咸鱼','fsfgss测试内容6',0,0,0,'2017-05-29 13:20:45','测试文章6','美食分享',NULL),(11,'我是一条咸鱼','fsfgss测试内容4',3,1,0,'2017-05-30 07:20:45','测试文章4','美食分享',NULL),(12,'我是一条咸鱼','fsfgss测试内容5',0,0,0,'2017-05-28 10:20:45','测试文章5','美食分享',NULL),(13,'我是一条咸鱼','fsfgss测试内容7',1,0,0,'2017-05-29 13:20:45','测试文章7','美食分享',NULL),(14,'我是一条咸鱼','fsfgss测试内容8',0,0,0,'2017-05-30 07:20:45','测试文章8','美食分享',NULL),(15,'我是一条咸鱼','fsfgss测试内容9',0,0,0,'2017-05-28 10:20:45','测试文章9','美食分享',NULL),(16,'我是一条咸鱼','fsfgss测试内容7',0,0,0,'2017-05-29 13:20:45','测试文章7','美食分享',NULL),(17,'我是一条咸鱼','fsfgss测试内容8',1,0,0,'2017-05-30 07:20:45','测试文章8','美食分享',NULL),(18,'我是一条咸鱼','fsfgss测试内容9',0,0,0,'2017-05-28 10:20:45','测试文章9','美食分享',NULL),(19,'我是一条咸鱼','<p>123</p>',45,3,0,'2017-06-04 15:23:12','123','美食食谱','ceshi');
/*!40000 ALTER TABLE `passage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userName` varchar(20) NOT NULL,
  `passCode` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `description` varchar(100) DEFAULT '这家伙很懒，什么都没留下...',
  `profil` varchar(50) DEFAULT 'images/default.jpg',
  `gender` varchar(10) DEFAULT '未知',
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('123','qq','315136649@qq.com',NULL,NULL,NULL),('全为','gg','315136649@qq.com',NULL,NULL,NULL),('我是一条咸鱼','qq123456','315136649@qq.com','这家伙很懒，什么都没留下~','img/a2.jpg','未知');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'eataholic'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-05  9:11:18
