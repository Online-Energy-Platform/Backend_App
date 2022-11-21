CREATE DATABASE  IF NOT EXISTS `online-platform` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `online-platform`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: online-platform
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `max_h_energy_consumption` int NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk92m2qj36vn62ctp5pgbt4982` (`user_id`),
  CONSTRAINT `FKk92m2qj36vn62ctp5pgbt4982` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES ('0827d1da-4227-4da8-a546-bf4438eb477f','Cluj-Napoca, str. Porii, nr. 12','Ultima inspectie: 2021',1200,'12234564-e99c-12d3-a456-556642440011'),('12234564-e99c-12d3-a456-556642440110','Floresti, str. Sportului, nr. 1','Ultima inspectie: 2022',1000,'2f1de9be-54b6-41d0-b95c-cba2d60c549f'),('1552a10b-7eee-4e9d-b019-0b436b1470d5','Cluj-Napoca, Str. Lalelelor, Nr. 120, Bl. B2, Ap. 6','Ultima inspectie: 2022',550,'0827d1da-4137-4da8-a546-bf4438eb477f'),('adebc2b3-b2a2-490c-b39f-dfe39ab0b2dd','Cluj-Napoca, Str. Lalelelor, Nr. 120, Bl. B2, Ap. 5','Ultima inspectie: 2021',700,'0827d1da-4137-4da8-a546-bf4438eb477f');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `energy_consumption`
--

DROP TABLE IF EXISTS `energy_consumption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `energy_consumption` (
  `id` varchar(255) NOT NULL,
  `energy_value` int NOT NULL,
  `timestamp` datetime NOT NULL,
  `device_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7cjx5e0uq41oxj8scflvtehny` (`device_id`),
  CONSTRAINT `FK7cjx5e0uq41oxj8scflvtehny` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `energy_consumption`
--

LOCK TABLES `energy_consumption` WRITE;
/*!40000 ALTER TABLE `energy_consumption` DISABLE KEYS */;
INSERT INTO `energy_consumption` VALUES ('0827d1da-4227-4da8-a546-bf4438eb466e',95,'2022-11-13 00:16:00','0827d1da-4227-4da8-a546-bf4438eb477f'),('0827d1da-4227-4da8-a546-bf4438eb477a',100,'2022-11-14 00:14:00','0827d1da-4227-4da8-a546-bf4438eb477f'),('0827d1da-4227-4da8-a546-bf4438eb477b',125,'2022-11-13 00:15:00','0827d1da-4227-4da8-a546-bf4438eb477f'),('0827d1da-4227-4da8-a546-bf4438eb477e',150,'2022-11-13 00:14:00','0827d1da-4227-4da8-a546-bf4438eb477f');
/*!40000 ALTER TABLE `energy_consumption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('122e4563-e95c-12d3-a456-556642440011','CLIENT'),('123e4564-e95c-12d3-a456-556642440011','ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0827d1da-4137-4da8-a546-bf4438eb477f','ana.muresan@yahoo.com','Alina','Muresan','parola4','122e4563-e95c-12d3-a456-556642440011'),('12234564-e99c-12d3-a456-556642440011','alexandru.pop@gmail.com','Alexandru','Pop','parola2','123e4564-e95c-12d3-a456-556642440011'),('2643b577-3ab7-428e-b6a4-5acdaba5f871','sabina.muresan@yahoo.com','Sabina','Muresan','parola11','122e4563-e95c-12d3-a456-556642440011'),('2f1de9be-54b6-41d0-b95c-cba2d60c549f','daria.itu@gmail.com','Daria','Itu','parola7','122e4563-e95c-12d3-a456-556642440011'),('42ffc0b3-66d4-4958-ad17-299a5322dcc1','renata.pop@gmail.com','Renata','Pop','parola0','123e4564-e95c-12d3-a456-556642440011'),('4b69c9b6-59fa-432e-b4d1-76862b97178b','arianna.leczfalvi@yahoo.com','Arianna','Leczfalvi','parola3','122e4563-e95c-12d3-a456-556642440011'),('4e5ed6c1-7492-4e09-bf55-711c547a6bec','manuel.tarta@yahoo.com','Manuel','Tarta','parola21','122e4563-e95c-12d3-a456-556642440011'),('77bafba8-6e37-4c1c-ab00-fe0c7a70992a','diana.popescu@gmail.com','Diana','Popescu','parola6','122e4563-e95c-12d3-a456-556642440011'),('78efdea3-125a-40ca-a052-4f64120274dc','gina.pistol@yahoo.ro','Gina','Pistol','parola15','122e4563-e95c-12d3-a456-556642440011'),('83350a63-92ed-4f87-acc6-b253da864675','delia.vaida@gmail.com','Delia','Vaida','parola8','122e4563-e95c-12d3-a456-556642440011'),('861b8561-3042-484d-9170-5833e5c025e8','alina.manole@gmail.com','Alina','Manole','parola22','122e4563-e95c-12d3-a456-556642440011'),('8d6ff9bd-94aa-41fa-b8ee-1cceaaa7bbf2','sara.parker33@gmail.com','Sara','Parker','parola12','122e4563-e95c-12d3-a456-556642440011'),('a1d1395f-9548-40a5-92ae-97d66f255e43','ardnaxela2@gmail.com','Ardnaxela','Opo','parola23','122e4563-e95c-12d3-a456-556642440011'),('d3ae7fd5-b5e7-48fa-85ea-925f03bca10e','gig.hadid12@gmail.com','Gigi','Hadid','parola13','122e4563-e95c-12d3-a456-556642440011'),('d48f7d70-d369-492e-951b-ca3f5b33e98b','tudor.orsan@gmail.com','Tudor','Orsan','parola16','122e4563-e95c-12d3-a456-556642440011'),('d7a39611-2030-45bc-ab8d-8632babe46d0','andreea.stan@gmail.com','Andreea','Stan','parola10','122e4563-e95c-12d3-a456-556642440011'),('e74845f1-c3b4-488b-bab0-22cf9bdf3eb2','sabina.muresan@yahoo.com','Sabina','Muresan','parola11','122e4563-e95c-12d3-a456-556642440011');
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

-- Dump completed on 2022-11-22  0:54:37
