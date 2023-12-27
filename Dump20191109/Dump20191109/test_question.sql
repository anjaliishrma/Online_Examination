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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `Qid` int(11) NOT NULL AUTO_INCREMENT,
  `Question` varchar(200) NOT NULL,
  `OptionA` varchar(200) NOT NULL,
  `OptionB` varchar(200) NOT NULL,
  `OptionC` varchar(200) NOT NULL,
  `OptionD` varchar(200) NOT NULL,
  `Correctanswer` varchar(200) NOT NULL,
  `Category` varchar(200) NOT NULL,
  PRIMARY KEY (`Qid`),
  KEY `fk1` (`Category`),
  CONSTRAINT `fk1` FOREIGN KEY (`Category`) REFERENCES `add_category` (`catname`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Which of the following type of class allows only one object of it to be created?','Virtual class','Abstract class','Singleton class','Friend class','OptionC','C++'),(2,'Which of the following is not a type of constructor?','Copy constructor','Friend constructor','Default constructor','Parameterized constructor','OptionB','C++'),(3,'Which of the following statements is correct?','Base class pointer cannot point to derived class.','Derived class pointer cannot point to base class.','Pointer to derived class cannot be created.','Pointer to base class cannot be created.','OptionB','C++'),(4,'Which of the following is not the member of class?','Static function','Friend function','Const function','Virtual function','OptionB','C++'),(5,'Which of the following concepts means determining at runtime what method to invoke?','Data hiding','Dynamic Typing','Dynamic binding','Dynamic loading','OptionC','C++'),(6,'Which of the following term is used for a function defined inside a class?','Member Variable','Member Variable','Class function','Classic function','OptionB','C++'),(7,'Which of the following concept of oops allows compiler to insert arguments in a function call if it is not specified?','Call by value','Call by reference','Default arguments','Call by pointer','OptionC','C++'),(8,'How many instances of an abstract class can be created?','1','5','13','0','OptionD','C++'),(9,'Which of the following cannot be friend?','Function','Class','Object','Operator function','OptionC','C++'),(10,'Which of the following concepts of OOPS means exposing only necessary information to client?','Encapsulation','Abstraction','Data hiding','Data binding','OptionC','C++'),(11,'Why reference is not same as a pointer?','A reference can never be null.','A reference once established cannot be changed.','Reference doesn\'t need an explicit dereferencing mechanism.','All of the above.','OptionD','C++'),(12,'cout is a/an.','operator','function','object','macro','OptionC','C++'),(13,'Which of the following concepts provides facility of using object of one class inside another class?','Encapsulation','Abstraction','Composition','Inheritance','OptionC','C++'),(14,'How many types of polymorphisms are supported by C++?','1','2','3','4','OptionB','C++'),(15,'Which of the following is an abstract data type?','int','double','string','Class','OptionD','C++'),(16,'Which of the following concepts means adding new components to a program as it runs?','Data hiding','Dynamic typing','Dynamic binding','Dynamic loading','OptionD','C++'),(17,'Which of the following statement is correct?','A constructor is called at the time of declaration of an object.','A constructor is called at the time of use of an object.','A constructor is called at the time of declaration of a class.','A constructor is called at the time of use of a class.','OptionA','C++'),(18,'Which of the following correctly describes overloading of functions?','Virtual polymorphism','Transient polymorphism','Ad-hoc polymorphism','Pseudo polymorphism','OptionC','C++'),(19,'Which of the following approach is adapted by C++?','Top-down','Bottom-up','Right-left','Left-right','OptionB','C++'),(20,'Which of the following is correct about function overloading?','The types of arguments are different.','The order of argument is different.','The number of argument is same.','Both A and B.','OptionD','C++'),(21,'Which of the following is correct about class and structure?','class can have member functions while structure cannot.','class data members are public by default while that of structure are private.','Pointer to structure or classes cannot be declared.','class data members are private by default while that of structure are public by default.','OptionD','C++'),(22,'Which of the following concepts means wrapping up of data and functions together?','Abstraction.','Encapsulation.','Inheritance','Polymorphism','OptionB','C++'),(23,'Which of the following concepts means waiting until runtime to determine which function to call?','Data hiding','Dynamic casting','Dynamic binding','Dynamic loading','OptionC','C++'),(24,'How \"Late binding\" is implemented in C++?','Using C++ tables','Using Virtual tables','Using Indexed virtual tables','Using polymorphic tables','OptionB','C++'),(25,'Which of the following operator is overloaded for object cout?','>>','<<','+','=','OptionB','C++'),(26,'Which of the following is the correct class of the object cout?','iostream','istream','ostream','ifstream','OptionC','C++'),(27,'Which of the following cannot be used with the keyword virtual?','class','member functions','constructor','destructor','OptionC','C++'),(28,'Which of the following functions are performed by a constructor?','Construct a new class','Construct a new object','Construct a new function','Initialize objects','OptionD','C++'),(29,'Which of the following problem causes an exception?','Missing semicolon in statement in main().','A problem in calling function.','A syntax error.','A run-time error.','OptionD','C++'),(30,'Which one of the following options is correct about the statement given below? The compiler checks the type of reference in the object and not the type of object.','Inheritance','Polymorphism','Abstraction','Encapsulation','OptionB','C++');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-09 19:43:24
