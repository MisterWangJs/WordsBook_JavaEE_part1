/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.20-log : Database - wordsbook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wordsbook` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wordsbook`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`password`) values (1,'admin','admin'),(2,'wjs',''),(3,'ls',''),(4,'www','www'),(5,'w','w'),(6,'ee','ee'),(7,'gg','gg'),(8,'kk','kk'),(9,'sdsd','s'),(10,'admin1','admin1'),(11,'admin4','admin4'),(12,'12345','123456');

/*Table structure for table `words` */

DROP TABLE IF EXISTS `words`;

CREATE TABLE `words` (
  `wid` int(10) NOT NULL AUTO_INCREMENT,
  `word` varchar(30) DEFAULT NULL,
  `pronounce` varchar(30) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

/*Data for the table `words` */

insert  into `words`(`wid`,`word`,`pronounce`,`description`) values (1,'apple','唉pou','苹果'),(2,'banana','不难那','香蕉'),(3,'panda','潘达','熊猫'),(4,'tiger','泰哥','老虎'),(18,'face','飞思','脸'),(19,'77','77','77'),(21,'9','9','9'),(22,'10','10','10'),(23,'11','11','11'),(24,'12','12','12'),(25,'13','13','13'),(26,'14','14','14'),(27,'15','15','15'),(29,'wwwww','wwwww','wwwww'),(33,'adad','adadad','adada'),(34,'111111','111111111111111','111111111111111'),(35,'www','ww','ww'),(36,'dsd','sds','sdds'),(37,'1','1','1'),(38,'dd','dd','dd'),(39,'7777','7777','7777'),(41,'8888','8888','8888'),(42,'1','1','1'),(43,'1','1','1'),(44,'1','1','1'),(45,'1','1','1'),(46,'1','1','1'),(47,'1','1','1'),(48,'1','1','1'),(49,'1','1','1'),(50,'1','1','1'),(51,'1','1','1'),(52,'1','1','1'),(53,'1','1','1'),(54,'1','1','1'),(55,'1','1','1'),(56,'hh','hh','hh'),(58,'1','2','3'),(59,'123','123','123'),(60,'11','11','11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
