CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.62

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
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `Resultid` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Total` varchar(50) NOT NULL,
  `Obtained` varchar(50) NOT NULL,
  `Percentage` varchar(45) NOT NULL,
  PRIMARY KEY (`Resultid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (1,'Nirbhay Sharma','C++','15','6','40'),(2,'Nirbhay Sharma','C++','15','4','26'),(3,'Mehak Sharma','C++','15','5','33'),(4,'abc','C++','15','5','33'),(5,'Nirbhay Sharma','C++','15','8','53'),(6,'abc','C++','15','2','13'),(7,'abc','C++','15','1','6'),(8,'abc','C++','15','0','0'),(9,'Nirbhay Sharma','C++','15','2','13'),(10,'Nirbhay Sharma','C++','15','3','20'),(11,'Nirbhay Sharma','C++','15','0','0'),(12,'Nirbhay Sharma','C++','15','6','40'),(13,'Mehak Sharma','C++','15','7','46'),(14,'Nirbhay Sharma','C++','15','3','20'),(15,'Nirbhay Sharma','C++','15','0','0'),(16,'Nirbhay Sharma','C++','15','0','0'),(17,'Nirbhay Sharma','C++','15','0','0'),(18,'Mehak Sharma','C++','15','0','0'),(19,'Nirbhay Sharma','C++','15','0','0'),(20,'Nirbhay Sharma','C++','15','0','0'),(21,'Nirbhay Sharma','C++','15','1','6'),(22,'Nirbhay Sharma','C++','15','1','6'),(23,'Nirbhay Sharma','C++','15','0','0'),(24,'Nirbhay sharma','C++','15','2','13');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-09 19:43:25
