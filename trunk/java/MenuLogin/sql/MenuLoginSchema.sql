-- DataBase Schema Untuk Contoh MenuLogin

CREATE DATABASE `menulogin`;

USE `menulogin`;

--
-- Table structure for table `T_USER`
--
DROP TABLE IF EXISTS `T_USER`;
CREATE TABLE `T_USER` (
  `id` int auto_increment not null,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `T_USER`
--
INSERT INTO `T_USER` (`username`,`password`) VALUES 
('martin', 'menulogin'), ('ahmad','ganteng'),('slackware','linux');
