CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthDate` datetime DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `resumeUrl` varchar(255) DEFAULT NULL,
  `standingYear` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;