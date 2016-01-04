DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer ( `id` int(11) NOT NULL AUTO_INCREMENT, `address` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,`cc_number` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL, `city_region` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL, `email` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL, `name` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL, `phone` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

DROP TABLE IF EXISTS Permission;
CREATE TABLE Permission (`id` int(11) NOT NULL AUTO_INCREMENT, `permission` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

DROP TABLE IF EXISTS User;
CREATE TABLE User ( `id` int(11) NOT NULL AUTO_INCREMENT, `password` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL, `username` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL, `permission` int(11) DEFAULT NULL, PRIMARY KEY (`id`), KEY `FK_User_permission` (`permission`), CONSTRAINT `FK_User_permission` FOREIGN KEY (`permission`) REFERENCES `Permission` (`id`)) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;