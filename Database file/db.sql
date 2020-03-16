-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: java_project
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friends` (
  `RelatingUserEmail` varchar(50) NOT NULL,
  `RelatedUserEmail` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`RelatingUserEmail`,`RelatedUserEmail`),
  KEY `RelatedUserEmail` (`RelatedUserEmail`),
  KEY `RelatingUserEmail` (`RelatingUserEmail`),
  CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`RelatedUserEmail`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`RelatingUserEmail`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES ('arun@gmail.com','davindersharma@gmail.com',1),('arun@gmail.com','hanhao@gmail.com',1),('arun@gmail.com','urvish7597@gmail.com',0),('davindersharma@gmail.com','kanwarpal@gmail.com',1),('davindersharma@gmail.com','roneetparida@gmail.com',1),('davindersharma@gmail.com','rupindervirdi@gmail.com',1),('hanhao@gmail.com','arun@gmail.com',1),('kanwarpal@gmail.com','davindersharma@gmail.com',1),('lijijiji@gmail.com','roneetparida@gmail.com',1),('nitin@gmail.com','roneetparida@gmail.com',1),('roneetparida@gmail.com','davindersharma@gmail.com',1),('roneetparida@gmail.com','lijijiji@gmail.com',1),('roneetparida@gmail.com','nitin@gmail.com',1),('roneetparida@gmail.com','shivampatel@gmail.com',1),('rupindervirdi@gmail.com','davindersharma@gmail.com',1),('shivampatel@gmail.com','davindersharma@gmail.com',1),('shivampatel@gmail.com','roneetparida@gmail.com',1),('sumitparida@gmail.com','urvish7597@gmail.com',0),('urvish7597@gmail.com','davindersharma@gmail.com',1);
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `postID` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`postID`,`email`),
  KEY `likes_ibfk_2` (`email`),
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`email`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `likes_ibfk_3` FOREIGN KEY (`postID`) REFERENCES `posts` (`postID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES ('1583786336648','davindersharma@gmail.com'),('51103','davindersharma@gmail.com'),('81122','davindersharma@gmail.com'),('81683','davindersharma@gmail.com'),('23104','hanhao@gmail.com'),('26395','hanhao@gmail.com'),('36263','hanhao@gmail.com'),('40197','hanhao@gmail.com'),('70266','hanhao@gmail.com'),('88130','hanhao@gmail.com'),('90527','hanhao@gmail.com'),('44828','kanwarpal@gmail.com'),('90295','lijijiji@gmail.com'),('26395','roneetparida@gmail.com'),('40173','roneetparida@gmail.com'),('40197','roneetparida@gmail.com'),('65322','roneetparida@gmail.com'),('70266','roneetparida@gmail.com'),('90295','roneetparida@gmail.com'),('40173','rupindervirdi@gmail.com'),('65322','rupindervirdi@gmail.com'),('34164','s@gmail.com'),('40173','s@gmail.com'),('70266','shivampatel@gmail.com'),('1584322035845','urvish7597@gmail.com');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `fromUser` varchar(50) NOT NULL,
  `toUser` varchar(50) NOT NULL,
  `message` varchar(50) NOT NULL,
  `date` datetime NOT NULL,
  `seen` tinyint(1) NOT NULL,
  PRIMARY KEY (`fromUser`,`toUser`,`date`),
  KEY `fromUser` (`fromUser`),
  KEY `message_ibfk_2_idx` (`toUser`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`fromUser`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`toUser`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES ('davindersharma@gmail.com','roneetparida@gmail.com','hello','2019-12-05 02:45:24',1),('davindersharma@gmail.com','roneetparida@gmail.com','he sup?','2019-12-05 03:45:24',0),('davindersharma@gmail.com','roneetparida@gmail.com','nothing much','2020-03-15 21:16:19',0),('davindersharma@gmail.com','rupindervirdi@gmail.com','        oye','2019-12-03 01:02:14',1),('davindersharma@gmail.com','rupindervirdi@gmail.com','        kuj ni','2019-12-03 01:03:11',1),('davindersharma@gmail.com','rupindervirdi@gmail.com','        hello','2019-12-03 02:44:50',1),('davindersharma@gmail.com','rupindervirdi@gmail.com','hwloo dear','2020-03-15 18:25:30',0),('davindersharma@gmail.com','urvish7597@gmail.com','heyy there','2020-03-15 22:19:39',0),('davindersharma@gmail.com','urvish7597@gmail.com','nothing much','2020-03-15 22:20:21',0),('roneetparida@gmail.com','davindersharma@gmail.com','hi','2019-12-05 02:45:23',0),('rupindervirdi@gmail.com','davindersharma@gmail.com','        han ki ae','2019-12-03 01:02:54',1),('rupindervirdi@gmail.com','davindersharma@gmail.com','        fer kyu dimaag khada','2019-12-03 01:03:40',1),('rupindervirdi@gmail.com','davindersharma@gmail.com','        hi','2019-12-03 02:45:23',0),('urvish7597@gmail.com','davindersharma@gmail.com','hii','2020-03-15 22:18:04',0),('urvish7597@gmail.com','davindersharma@gmail.com','hwloo dear','2020-03-15 22:20:11',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `email` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`email`,`type`),
  CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES ('davindersharma@gmail.com','like81683','2019-12-03 07:48:42'),('davindersharma@gmail.com','requestSent,vinayrao@gmail.com','2019-12-03 07:49:48'),('lijijiji@gmail.com','like71253','2019-12-03 01:09:25'),('rupindervirdi@gmail.com','requestSent,dara@gmail.com','2019-12-03 02:45:33');
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `postID` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`postID`),
  KEY `posts_ibfk_1` (`email`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES ('1583786336648','davindersharma@gmail.com','hello tejasree','2020-03-09 16:38:57'),('1583795631195','davindersharma@gmail.com','tvybh urvish','2020-03-09 19:13:51'),('1583796267289','davindersharma@gmail.com','im good','2020-03-09 19:24:27'),('1583879177655','davindersharma@gmail.com','hii rajdeep','2020-03-10 18:26:18'),('1584050955418','davindersharma@gmail.com','hii ridham','2020-03-12 18:09:15'),('1584322035845','urvish7597@gmail.com','hello every one!!','2020-03-15 21:27:16'),('23104','vinayrao@gmail.com','new','2019-11-22 06:06:02'),('26395','arun@gmail.com','why so serious??','2019-11-21 08:50:30'),('28918','johndoe@gmail.com','hello','2019-11-30 06:47:37'),('31732','roneetparida@gmail.com','hello','2019-11-30 10:42:37'),('34164','s@gmail.com','hello','2019-11-28 08:18:46'),('36263','vinayrao@gmail.com','seconf post','2019-11-22 06:04:26'),('40173','roneetparida@gmail.com','javascipt is awesome','2019-11-21 00:00:00'),('40197','vinayrao@gmail.com','old','2019-11-22 06:07:29'),('44828','kanwarpal@gmail.com','yaaay!','2019-11-21 06:21:38'),('51103','davindersharma@gmail.com','hello ','2019-11-22 11:08:39'),('62674','lijijiji@gmail.com','hello','2019-12-03 01:12:10'),('65322','rupindervirdi@gmail.com','hail hydra','2019-11-21 00:00:00'),('70266','shivampatel@gmail.com','jai modi','2019-11-22 12:34:32'),('81122','davindersharma@gmail.com','new date today ','2019-11-21 08:26:20'),('81683','davindersharma@gmail.com','new post again','2019-12-03 05:11:24'),('88130','hanhao@gmail.com','echo','2019-11-22 01:43:19'),('90295','lijijiji@gmail.com','HAII','2019-11-28 09:30:31'),('90527','vinayrao@gmail.com','this is my first post','2019-11-22 05:58:27');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savedposts`
--

DROP TABLE IF EXISTS `savedposts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `savedposts` (
  `postID` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`postID`,`email`),
  KEY `email` (`email`),
  KEY `postID` (`postID`),
  CONSTRAINT `savedposts_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `savedposts_ibfk_2` FOREIGN KEY (`postID`) REFERENCES `posts` (`postID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savedposts`
--

LOCK TABLES `savedposts` WRITE;
/*!40000 ALTER TABLE `savedposts` DISABLE KEYS */;
INSERT INTO `savedposts` VALUES ('40173','davindersharma@gmail.com'),('40197','davindersharma@gmail.com'),('65322','davindersharma@gmail.com'),('65322','urvish7597@gmail.com');
/*!40000 ALTER TABLE `savedposts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Arun','Reddy','arun@gmail.com','arun123'),('Davinder','Sharma','davindersharma@gmail.com','123'),('Emad','Mohammad','emad@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Gaurav','Kumar','gauravkumar@gmail.com','b59c67bf196a4758191e42f76670ceba'),('han','hao','hanhao@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Jane','Doe','jane@gmail.com','b59c67bf196a4758191e42f76670ceba'),('John ','Joe','johndoe@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Kanwar','Pal Singh','kanwarpal@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Liji','Anna Jiji','lijijiji@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Nitin','Joy','nitin@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Nitisha','Kalra','nitisha@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Ravinder','Pal Singh','rav@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Roneet','Kumar','roneetparida@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Rupinder','Virdi','rupindervirdi@gmail.com','b59c67bf196a4758191e42f76670ceba'),('karan','sood','s@gmail.com','202cb962ac59075b964b07152d234b70'),('Shivam','Patel','shivampatel@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Sumit','Parida','sumitparida@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Sunil','Chatla','sunilchatla@gmail.com','b59c67bf196a4758191e42f76670ceba'),('Urvish','Patel','urvish7597@gmail.com','Myageis20now'),('Vinay','Rao','vinayrao@gmail.com','b59c67bf196a4758191e42f76670ceba');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-15 22:43:39
