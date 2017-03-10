/*
SQLyog Community Edition- MySQL GUI v6.14
MySQL - 5.6.30-0ubuntu0.14.04.1-log : Database - stdummy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `stdummy`;

USE `stdummy`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `handler_info` */

DROP TABLE IF EXISTS `handler_info`;

CREATE TABLE `handler_info` (
  `handler_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `handlerclass` varchar(10) DEFAULT NULL,
  `handlersubject` varchar(100) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `designation` varchar(100) NOT NULL,
  `school_id` int(11) NOT NULL,
  PRIMARY KEY (`handler_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `handler_info` */

/*Table structure for table `priviledge` */

DROP TABLE IF EXISTS `priviledge`;

CREATE TABLE `priviledge` (
  `priviledge_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`priviledge_id`),
  UNIQUE KEY `unique_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `priviledge` */

insert  into `priviledge`(`priviledge_id`,`code`,`display_name`,`description`) values (1,'addPriviledge','Add Priviledge',NULL),(2,'addStudent','add student','add student');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `unique_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`role_id`,`code`,`display_name`,`description`) values (1,'system','System User','System user for support and backened work.'),(2,'admin','school admin','school admin'),(7,'test','t','ttttt');

/*Table structure for table `role_priviledge` */

DROP TABLE IF EXISTS `role_priviledge`;

CREATE TABLE `role_priviledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) NOT NULL,
  `priviledge_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`role_id`,`priviledge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `role_priviledge` */

insert  into `role_priviledge`(`id`,`role_id`,`priviledge_id`) values (1,'1','1');

/*Table structure for table `route_info` */

DROP TABLE IF EXISTS `route_info`;

CREATE TABLE `route_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `routenumber` varchar(10) NOT NULL,
  `seatcapacity` int(10) DEFAULT NULL,
  `routearea` varchar(255) NOT NULL,
  `busplatenumber` varchar(100) DEFAULT NULL,
  `seatsleft` int(10) DEFAULT NULL,
  `school_id` int(11) NOT NULL,
  `tripstatus` enum('Started','Stopped') NOT NULL DEFAULT 'Stopped',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `route_info` */

/*Table structure for table `route_tracking` */

DROP TABLE IF EXISTS `route_tracking`;

CREATE TABLE `route_tracking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currentlattitude` varchar(100) NOT NULL,
  `currentlongitude` varchar(100) NOT NULL,
  `route_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `route_id` (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `route_tracking` */

/*Table structure for table `school_info` */

DROP TABLE IF EXISTS `school_info`;

CREATE TABLE `school_info` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) NOT NULL,
  `contactnumber1` varchar(100) NOT NULL,
  `contactnumber2` varchar(100) NOT NULL,
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `school_info` */

/*Table structure for table `stop_info` */

DROP TABLE IF EXISTS `stop_info`;

CREATE TABLE `stop_info` (
  `stop_id` int(11) NOT NULL AUTO_INCREMENT,
  `stoplattitude` varchar(100) NOT NULL,
  `stoplongitude` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`stop_id`,`stoplattitude`,`stoplongitude`,`address`),
  UNIQUE KEY `stop_id` (`stop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stop_info` */

/*Table structure for table `stop_route` */

DROP TABLE IF EXISTS `stop_route`;

CREATE TABLE `stop_route` (
  `stop_route_id` int(11) NOT NULL AUTO_INCREMENT,
  `route_id` int(11) NOT NULL,
  `stop_id` int(11) NOT NULL,
  PRIMARY KEY (`stop_route_id`),
  UNIQUE KEY `route_id` (`route_id`,`stop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stop_route` */

/*Table structure for table `student_info` */

DROP TABLE IF EXISTS `student_info`;

CREATE TABLE `student_info` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `registrationnumber` varchar(255) NOT NULL,
  `studentclass` varchar(10) NOT NULL,
  `studentsection` varchar(10) NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `route_id` int(11) DEFAULT NULL,
  `stop_id` int(11) DEFAULT NULL,
  `school_id` int(11) NOT NULL,
  `referencenumber` varchar(100) NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `referencenumber` (`referencenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_info` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`firstname`,`lastname`,`role_id`) values (1,'manoj','singh',NULL),(2,'test','s',NULL);

/*Table structure for table `user_login` */

DROP TABLE IF EXISTS `user_login`;

CREATE TABLE `user_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `passwordhash` varchar(255) NOT NULL,
  `passwordsalt` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user_login` */

insert  into `user_login`(`login_id`,`email`,`passwordhash`,`passwordsalt`,`user_id`) values (1,'manoj@singh.com','4998cc240c8b00b180045437198382c6','ecc49d01d102a9bbbde92fc950769704',1),(2,'test@s.com','61d5217883277b96b5d105aa5f8a4b7b','9fca2264c9a1e7b3e9f135185444b4ce',2);

/*Table structure for table `user_student` */

DROP TABLE IF EXISTS `user_student`;

CREATE TABLE `user_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_student` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
