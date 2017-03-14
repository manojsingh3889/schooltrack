

DROP TABLE IF EXISTS `busstop_info`;

CREATE TABLE `busstop_info` (
  `stop_id` int(11) NOT NULL AUTO_INCREMENT,
  `stoplattitude` varchar(100) NOT NULL,
  `stoplongitude` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`stop_id`,`stoplattitude`,`stoplongitude`,`address`),
  UNIQUE KEY `stop_id` (`stop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `busstop_info` */

/*Table structure for table `busstop_route` */

DROP TABLE IF EXISTS `busstop_route`;

CREATE TABLE `busstop_route` (
  `busstop_route_id` int(11) NOT NULL AUTO_INCREMENT,
  `route_id` int(11) NOT NULL,
  `stop_id` int(11) NOT NULL,
  PRIMARY KEY (`busstop_route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `busstop_route` */

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `priviledge` */

insert  into `priviledge`(`id`,`code`,`display_name`,`description`) values 
(3,'addPriviledge','add Priviledge','sdfsdf');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`code`,`display_name`,`description`) values 
(1,'system','System User','System user for support and backened work.'),
(2,'admin','school admin','school admin'),
(7,'test','t','ttttt'),
(8,'parent','parent','parent');

/*Table structure for table `role_based_worker` */

DROP TABLE IF EXISTS `role_based_worker`;

CREATE TABLE `role_based_worker` (
  `role_id` int(11) NOT NULL,
  `task` varchar(100) NOT NULL,
  `worker` varchar(100) NOT NULL,
  PRIMARY KEY (`role_id`,`task`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role_based_worker` */

insert  into `role_based_worker`(`role_id`,`task`,`worker`) values 
(8,'RoleBeanBuilder','ParentBuilder');

/*Table structure for table `role_priviledge` */

DROP TABLE IF EXISTS `role_priviledge`;

CREATE TABLE `role_priviledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) NOT NULL,
  `priviledge_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_role_priviledge` (`role_id`,`priviledge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `role_priviledge` */

insert  into `role_priviledge`(`id`,`role_id`,`priviledge_id`) values 
(1,'1','1');

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_school_route` (`routenumber`,`school_id`)
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

/*Table structure for table `routetracking` */

DROP TABLE IF EXISTS `routetracking`;

CREATE TABLE `routetracking` (
  `routetracking_id` int(11) NOT NULL AUTO_INCREMENT,
  `currentlattitude` varchar(100) NOT NULL,
  `currentlongitude` varchar(100) NOT NULL,
  `route_id` int(11) NOT NULL,
  PRIMARY KEY (`routetracking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `routetracking` */

/*Table structure for table `school_info` */

DROP TABLE IF EXISTS `school_info`;

CREATE TABLE `school_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) NOT NULL,
  `contactnumber1` varchar(100) NOT NULL,
  `contactnumber2` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `school_info` */

/*Table structure for table `stop_info` */

DROP TABLE IF EXISTS `stop_info`;

CREATE TABLE `stop_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lattitude` varchar(100) NOT NULL,
  `longitude` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stop_info` */

/*Table structure for table `stop_route` */

DROP TABLE IF EXISTS `stop_route`;

CREATE TABLE `stop_route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `route_id` int(11) NOT NULL,
  `stop_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `route_id` (`route_id`,`stop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stop_route` */

/*Table structure for table `student_info` */

DROP TABLE IF EXISTS `student_info`;

CREATE TABLE `student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `referencenumber` (`referencenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_info` */

/*Table structure for table `student_reference` */

DROP TABLE IF EXISTS `student_reference`;

CREATE TABLE `student_reference` (
  `reference_id` int(11) NOT NULL AUTO_INCREMENT,
  `referencenumber` varchar(255) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`reference_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_reference` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`firstname`,`lastname`,`role_id`) values 
(1,'manoj','singh',NULL),
(2,'test','s',NULL),
(3,'p','d','8');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user_login` */

insert  into `user_login`(`login_id`,`email`,`passwordhash`,`passwordsalt`,`user_id`) values 
(1,'manoj@singh.com','4998cc240c8b00b180045437198382c6','ecc49d01d102a9bbbde92fc950769704',1),
(2,'test@s.com','61d5217883277b96b5d105aa5f8a4b7b','9fca2264c9a1e7b3e9f135185444b4ce',2),
(3,'parent@test.com','e862eb9582dfd22e93bed8c8e92e8ae4','ad6531f12f0891c01c49523e327f73f6',3);

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
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
