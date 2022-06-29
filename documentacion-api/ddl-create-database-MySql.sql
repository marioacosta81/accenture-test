-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.5.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para accenture-album
CREATE DATABASE IF NOT EXISTS `accenture-album` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `accenture-album`;

-- Volcando estructura para tabla accenture-album.address
CREATE TABLE IF NOT EXISTS `address` (
  `street` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `suite` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`street`),
  KEY `FKeaqti54bpy0lw7p7axoa9wk6a` (`lat`,`lng`),
  CONSTRAINT `FKeaqti54bpy0lw7p7axoa9wk6a` FOREIGN KEY (`lat`, `lng`) REFERENCES `geo` (`lat`, `lng`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla accenture-album.album
CREATE TABLE IF NOT EXISTS `album` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmi5m81x9aswan1ci0wnw04dq1` (`user_id`),
  CONSTRAINT `FKmi5m81x9aswan1ci0wnw04dq1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla accenture-album.albums_users
CREATE TABLE IF NOT EXISTS `albums_users` (
  `read_permission` tinyint(1) DEFAULT 0,
  `write_permission` tinyint(1) DEFAULT 0,
  `user_id` bigint(20) NOT NULL,
  `album_id` bigint(20) NOT NULL,
  PRIMARY KEY (`album_id`,`user_id`),
  KEY `FKe2gg4mnatbnn6d5500bxytfox` (`user_id`),
  CONSTRAINT `FKe2gg4mnatbnn6d5500bxytfox` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKj84spvuu5nwqvdkq7w31c8slb` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla accenture-album.comment
CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint(20) NOT NULL,
  `body` varchar(500) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`),
  CONSTRAINT `FKs1slvnkuemjsq2kj4h3vhx7i1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla accenture-album.company
CREATE TABLE IF NOT EXISTS `company` (
  `name` varchar(255) NOT NULL,
  `bs` varchar(255) DEFAULT NULL,
  `catch_phrase` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla accenture-album.geo
CREATE TABLE IF NOT EXISTS `geo` (
  `lat` varchar(255) NOT NULL,
  `lng` varchar(255) NOT NULL,
  PRIMARY KEY (`lat`,`lng`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla accenture-album.photo
CREATE TABLE IF NOT EXISTS `photo` (
  `id` bigint(20) NOT NULL,
  `thumbnail_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `album_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpy64km2p72eoy5rwh31ria0vx` (`album_id`),
  CONSTRAINT `FKpy64km2p72eoy5rwh31ria0vx` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla accenture-album.post
CREATE TABLE IF NOT EXISTS `post` (
  `id` bigint(20) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK72mt33dhhs48hf9gcqrq4fxte` (`user_id`),
  CONSTRAINT `FK72mt33dhhs48hf9gcqrq4fxte` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla accenture-album.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `addres_id` varchar(255) DEFAULT NULL,
  `company_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoxw3rrpsgpancyg3m8g6c2m0v` (`addres_id`),
  KEY `FK2yuxsfrkkrnkn5emoobcnnc3r` (`company_id`),
  CONSTRAINT `FK2yuxsfrkkrnkn5emoobcnnc3r` FOREIGN KEY (`company_id`) REFERENCES `company` (`name`),
  CONSTRAINT `FKoxw3rrpsgpancyg3m8g6c2m0v` FOREIGN KEY (`addres_id`) REFERENCES `address` (`street`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
