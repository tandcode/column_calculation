-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: steel
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `ccwbcalculation`
--

DROP TABLE IF EXISTS `ccwbcalculation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccwbcalculation` (
  `id` bigint NOT NULL,
  `input_id` bigint DEFAULT NULL,
  `result_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `creation_date_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK391kqjon47xi8r7dmoum37unk` (`user_id`),
  KEY `FK9qttx2uxlfxq8p0yhbreqv86i` (`result_id`),
  KEY `FKonqqbvrseqhemdr0nix6okpde` (`input_id`),
  CONSTRAINT `FK391kqjon47xi8r7dmoum37unk` FOREIGN KEY (`user_id`) REFERENCES `usr` (`id`),
  CONSTRAINT `FK9qttx2uxlfxq8p0yhbreqv86i` FOREIGN KEY (`result_id`) REFERENCES `ccwbresult` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FKonqqbvrseqhemdr0nix6okpde` FOREIGN KEY (`input_id`) REFERENCES `ccwbinput` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccwbcalculation`
--

LOCK TABLES `ccwbcalculation` WRITE;
/*!40000 ALTER TABLE `ccwbcalculation` DISABLE KEYS */;
INSERT INTO `ccwbcalculation` VALUES (164,162,163,1,'2021-06-21 22:57:58.777000'),(167,165,166,1,'2021-06-21 22:59:44.374000'),(170,168,169,1,'2021-06-21 23:01:10.244000'),(173,171,172,1,'2021-06-22 21:49:58.088000'),(176,174,175,1,'2021-06-22 21:50:43.034000'),(179,177,178,1,'2021-06-22 21:51:17.236000'),(182,180,181,1,'2021-06-23 22:41:32.054000'),(186,184,185,183,'2021-06-28 20:01:05.692000'),(189,187,188,1,'2021-06-28 20:54:56.711000'),(192,190,191,1,'2021-06-28 20:55:44.362000'),(195,193,194,1,'2021-06-28 21:43:07.217000');
/*!40000 ALTER TABLE `ccwbcalculation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccwbinput`
--

DROP TABLE IF EXISTS `ccwbinput`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccwbinput` (
  `id` bigint NOT NULL,
  `estimated_length_factor` double DEFAULT NULL,
  `flange_thickness` double DEFAULT NULL,
  `flange_width` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `moment` double DEFAULT NULL,
  `normal_force` double DEFAULT NULL,
  `own_weight_included` bit(1) DEFAULT NULL,
  `reliability_factor_for_responsibility` double DEFAULT NULL,
  `section_number` varchar(255) DEFAULT NULL,
  `section_standard` varchar(255) DEFAULT NULL,
  `section_type` varchar(255) DEFAULT NULL,
  `steel` varchar(255) DEFAULT NULL,
  `traverse_force` double DEFAULT NULL,
  `web_depth` double DEFAULT NULL,
  `web_thickness` double DEFAULT NULL,
  `working_conditions_factor` double DEFAULT NULL,
  `is_saved` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccwbinput`
--

LOCK TABLES `ccwbinput` WRITE;
/*!40000 ALTER TABLE `ccwbinput` DISABLE KEYS */;
INSERT INTO `ccwbinput` VALUES (141,1,NULL,NULL,8,NULL,-5,_binary '\0',1,'5П','gost8240-89-parallel-flange','U_PROFILE','S235',NULL,NULL,NULL,1,_binary '\0'),(144,1,NULL,NULL,5,NULL,-8,_binary '\0',1,'5П','gost8240-89-parallel-flange','U_PROFILE','S235',NULL,NULL,NULL,1,_binary '\0'),(147,1,NULL,NULL,5,NULL,-8,_binary '\0',1,'5П','gost8240-89-parallel-flange','U_PROFILE','S235',NULL,NULL,NULL,1,_binary '\0'),(150,1,NULL,NULL,5,NULL,-7,_binary '\0',1,'16','gost8240-89-slope-flange','U_PROFILE','S235',NULL,NULL,NULL,1,_binary '\0'),(154,1,NULL,NULL,5,NULL,-6,_binary '\0',1,'14П','gost8240-89-parallel-flange','U_PROFILE','S235',NULL,NULL,NULL,1,_binary '\0'),(158,1,NULL,NULL,1,NULL,1,_binary '\0',1,'10','gost8239-89','I_BEAM','S235',NULL,NULL,NULL,1,_binary '\0'),(162,1,NULL,NULL,1,NULL,1,_binary '\0',1,'10','gost8239-89','I_BEAM','S235',NULL,NULL,NULL,1,_binary '\0'),(165,1,NULL,NULL,1,NULL,1,_binary '\0',1,'10','gost8239-89','I_BEAM','S235',NULL,NULL,NULL,1,_binary ''),(168,1,NULL,NULL,5,NULL,-5,_binary '\0',1,'100x60x5','gost302245-94-rectangle','HOLLOW','S235',NULL,NULL,NULL,1,_binary ''),(171,1,NULL,NULL,8,NULL,2.2,_binary '\0',1,'22','gost8239-89','I_BEAM','S235',NULL,NULL,NULL,1,_binary '\0'),(174,1,NULL,NULL,5,NULL,5,_binary '\0',1,'50x2','gost302245-94-square','HOLLOW','S235',NULL,NULL,NULL,1,_binary '\0'),(177,1,NULL,NULL,6,NULL,12,_binary '\0',1,'16','gost8239-89','I_BEAM','S235',NULL,NULL,NULL,1,_binary '\0'),(180,1,NULL,NULL,2,NULL,5,_binary '\0',1,'10','gost8239-89','I_BEAM','S235',NULL,NULL,NULL,1,_binary '\0'),(184,1,NULL,NULL,2,NULL,5,_binary '\0',1,'60x40x2','gost302245-94-rectangle','HOLLOW','S235',NULL,NULL,NULL,1,_binary ''),(187,1,NULL,NULL,2,NULL,-55,_binary '\0',1,'120x80x3','gost302245-94-rectangle','HOLLOW','S235',NULL,NULL,NULL,1,_binary ''),(190,1,NULL,NULL,5,NULL,4,_binary '\0',1,'14П','gost8240-89-parallel-flange','U_PROFILE','S235',NULL,NULL,NULL,1,_binary '\0'),(193,1,NULL,NULL,5,NULL,-5,_binary '\0',1,'16аП','gost8240-89-parallel-flange','U_PROFILE','S235',NULL,NULL,NULL,1,_binary '\0');
/*!40000 ALTER TABLE `ccwbinput` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccwbresult`
--

DROP TABLE IF EXISTS `ccwbresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccwbresult` (
  `id` bigint NOT NULL,
  `axial_comression_res` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccwbresult`
--

LOCK TABLES `ccwbresult` WRITE;
/*!40000 ALTER TABLE `ccwbresult` DISABLE KEYS */;
INSERT INTO `ccwbresult` VALUES (142,8.827),(145,5.517),(148,5.517),(151,0.26),(155,0.29),(159,0.036),(163,0.036),(166,0.036),(169,0.417),(172,0.031),(175,0.547),(178,0.253),(181,0.178),(185,0.561),(188,2.174),(191,0.109),(194,0.17);
/*!40000 ALTER TABLE `ccwbresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (196),(196);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hollow_section`
--

DROP TABLE IF EXISTS `hollow_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hollow_section` (
  `inside_radius` double DEFAULT NULL,
  `web_thick` double DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKj0y3qvrtnfwedtjby55gyvgtr` FOREIGN KEY (`id`) REFERENCES `shaped_section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hollow_section`
--

LOCK TABLES `hollow_section` WRITE;
/*!40000 ALTER TABLE `hollow_section` DISABLE KEYS */;
INSERT INTO `hollow_section` VALUES (4,2,66),(5,2.5,67),(6,3,68),(8,4,69),(10,5,70),(5,2.5,71),(6,3,72),(8,4,73),(10,5,74),(12,6,75),(6,3,76),(8,4,77),(10,5,78),(12,6,79),(14,7,80),(6,3,81),(8,4,82),(10,5,83),(12,6,84),(8,4,85),(10,5,86),(12,6,87),(14,7,88),(16,8,89),(8,4,90),(10,5,91),(12,6,92),(14,7,93),(16,8,94),(10,5,95),(12,6,96),(14,7,97),(16,8,98),(18,9,99),(20,10,100),(10,5,101),(12,6,102),(14,7,103),(16,8,104),(18,9,105),(20,10,106),(22,11,107),(24,12,108),(26,13,109),(28,14,110),(16,8,111),(18,9,112),(20,10,113),(22,11,114),(24,12,115),(26,13,116),(28,14,117),(16,8,118),(18,9,119),(20,10,120),(22,11,121),(24,12,122),(26,13,123),(28,14,124),(4,2,125),(5,2.5,126),(6,3,127),(8,4,128),(10,5,129),(6,3,130),(8,4,131),(10,5,132),(12,6,133),(6,3,134),(8,4,135),(10,5,136),(12,6,137),(14,7,138),(8,4,139),(10,5,140),(12,6,141),(6,3,142),(8,4,143),(10,5,144),(12,6,145),(14,7,146),(6,3,147),(8,4,148),(10,5,149),(12,6,150),(8,4,151),(10,5,152),(12,6,153),(14,7,154),(16,8,155),(10,5,156),(12,6,157),(10,5,158),(12,6,159),(14,7,160),(16,8,161),(8,4,162),(10,5,163),(12,6,164),(14,7,165),(16,8,166),(8,4,167),(10,5,168),(12,6,169),(14,7,170),(16,8,171),(18,9,172),(20,10,173),(16,8,174),(18,9,175),(20,10,176),(22,11,177),(24,12,178),(26,13,179),(28,14,180),(16,8,181),(20,10,182),(24,12,183),(28,14,184),(18,9,185),(20,10,186),(24,12,187),(28,14,188),(20,10,189),(24,12,190),(28,14,191),(20,10,192),(24,12,193),(28,14,194),(20,10,195),(24,12,196),(28,14,197);
/*!40000 ALTER TABLE `hollow_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ibeam_rounded_flange_section`
--

DROP TABLE IF EXISTS `ibeam_rounded_flange_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ibeam_rounded_flange_section` (
  `outside_radius` double DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKmc2bgcs0eo7ptce0k28lfvjc3` FOREIGN KEY (`id`) REFERENCES `ibeam_section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ibeam_section`
--

DROP TABLE IF EXISTS `ibeam_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ibeam_section` (
  `first_moment_aboutyaxis` double DEFAULT NULL,
  `flange_thick` double DEFAULT NULL,
  `inside_radius` double DEFAULT NULL,
  `web_thick` double DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKnt8jiaiu90ldnx1nwwmhwv0fb` FOREIGN KEY (`id`) REFERENCES `shaped_section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ibeam_section`
--

LOCK TABLES `ibeam_section` WRITE;
/*!40000 ALTER TABLE `ibeam_section` DISABLE KEYS */;
INSERT INTO `ibeam_section` VALUES (23,7.2,7,4.5,1),(33.7,7.3,7.5,4.8,2),(46.8,7.5,8,4.9,3),(62.3,7.8,8.5,5,4),(81.4,8.1,9,5.1,5),(104,8.4,9.5,5.2,6),(131,8.7,10,5.4,7),(163,9.5,10.5,5.6,8),(210,9.8,11,6,9),(268,10.2,12,6.5,10),(339,11.2,13,7,11),(423,12.3,14,7.5,12),(545,13,15,8.3,13),(708,14.2,16,9,14),(919,15.2,17,10,15),(1181,16.5,18,11,16),(1491,17.8,20,12,17),(58.4,9.1,7.5,5.5,18),(113,12,9,7,19),(136,11.4,9,7,20),(146,11.4,9,9,21),(178,12.3,9.5,7.5,22),(223,14,10.5,8.2,23),(279,13.7,10.5,8.5,24),(297,13.7,10.5,10.5,25),(364,15,12,9,26),(493,16,14,9.5,27),(574,15.8,12,11,28),(821,18,16,10.5,29);
/*!40000 ALTER TABLE `ibeam_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shaped_section`
--

DROP TABLE IF EXISTS `shaped_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shaped_section` (
  `id` int NOT NULL,
  `area` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `depth` double DEFAULT NULL,
  `profile_number` varchar(255) DEFAULT NULL,
  `radius_of_gyrationyaxis` double DEFAULT NULL,
  `radius_of_gyrationzaxis` double DEFAULT NULL,
  `second_moment_aboutyaxis` double DEFAULT NULL,
  `second_moment_aboutzaxis` double DEFAULT NULL,
  `section_modulus_aboutyaxis` double DEFAULT NULL,
  `section_modulus_aboutzaxis` double DEFAULT NULL,
  `standard` varchar(255) DEFAULT NULL,
  `weight_per_length` double DEFAULT NULL,
  `section_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shaped_section`
--

LOCK TABLES `shaped_section` WRITE;
/*!40000 ALTER TABLE `shaped_section` DISABLE KEYS */;
INSERT INTO `shaped_section` VALUES (1,12,55,100,'10',40.6,12.2,198,17.9,39.7,6.49,'gost8239-89',9.46,'I_BEAM'),(2,14.7,64,120,'12',48.8,13.8,350,27.9,58.4,8.72,'gost8239-89',11.5,'I_BEAM'),(3,17.4,73,140,'14',57.3,15.5,572,41.9,81.7,11.5,'gost8239-89',13.7,'I_BEAM'),(4,20.2,81,160,'16',65.7,17,873,58.6,109,14.5,'gost8239-89',15.9,'I_BEAM'),(5,23.4,90,180,'18',74.2,18.8,1290,82.6,143,18.4,'gost8239-89',18.4,'I_BEAM'),(6,26.8,100,200,'20',82.8,20.7,1840,115,184,23.1,'gost8239-89',21,'I_BEAM'),(7,30.6,110,220,'22',91.3,22.7,2550,157,232,28.6,'gost8239-89',24,'I_BEAM'),(8,34.8,115,240,'24',99.7,23.7,3460,198,289,34.5,'gost8239-89',27.3,'I_BEAM'),(9,40.2,125,270,'27',112,25.4,5010,260,371,41.5,'gost8239-89',31.5,'I_BEAM'),(10,46.5,135,300,'30',123,26.9,7080,337,472,49.9,'gost8239-89',36.5,'I_BEAM'),(11,53.8,140,330,'33',135,27.9,9840,419,597,59.9,'gost8239-89',42.2,'I_BEAM'),(12,61.9,145,360,'36',147,28.9,13380,516,743,71.1,'gost8239-89',48.6,'I_BEAM'),(13,72.6,155,400,'40',162,30.3,19062,667,953,86.1,'gost8239-89',57,'I_BEAM'),(14,84.7,160,450,'45',181,30.9,27696,808,1231,101,'gost8239-89',66.5,'I_BEAM'),(15,100,170,500,'50',199,32.3,39727,1043,1589,123,'gost8239-89',78.5,'I_BEAM'),(16,118,180,550,'55',218,33.9,55962,1356,2035,151,'gost8239-89',92.6,'I_BEAM'),(17,138,190,600,'60',236,35.4,76806,1725,2560,182,'gost8239-89',108,'I_BEAM'),(18,21.5,80,140,'14C',57.5,17.4,712,64.8,102,16.2,'gost19425-74-i-beam',16.9,'I_BEAM'),(19,32.9,90,180,'18M',73.2,19.9,1760,130,196,28.9,'gost19425-74-i-beam',25.8,'I_BEAM'),(20,35.6,100,200,'20C',81.6,21.1,2370,159,237,31.8,'gost19425-74-i-beam',27.9,'I_BEAM'),(21,39.6,102,200,'20Ca',79.5,20.7,2500,170,250,33.3,'gost19425-74-i-beam',31.1,'I_BEAM'),(22,42.1,110,220,'22C',90,23.2,3400,228,310,41.5,'gost19425-74-i-beam',33.1,'I_BEAM'),(23,48.7,110,240,'24M',97.5,23.8,4640,276,387,50.2,'gost19425-74-i-beam',38.3,'I_BEAM'),(24,51.5,122,270,'27C',110,25.2,6550,346,485,56.7,'gost19425-74-i-beam',42.8,'I_BEAM'),(25,59.9,124,270,'27Ca',107,24.7,6870,366,507,59,'gost19425-74-i-beam',47,'I_BEAM'),(26,64,130,300,'30M',122,27.4,9500,480,633,73.9,'gost19425-74-i-beam',50.2,'I_BEAM'),(27,73.8,130,360,'36M',144,26.5,15340,518,852,79.7,'gost19425-74-i-beam',57.9,'I_BEAM'),(28,90.9,140,350,'36C',138,26.1,17360,618,964,88.3,'gost19425-74-i-beam',71.3,'I_BEAM'),(29,98.8,150,450,'45M',180,30,31900,892,1420,119,'gost19425-74-i-beam',77.6,'I_BEAM'),(30,6.16,32,50,'5П',19.2,9.8,22.8,5.95,9.1,2.99,'gost8240-89-parallel-flange',4.84,'U_PROFILE'),(31,7.51,36,65,'6.5П',25.5,11.2,48.8,9.35,15,4.06,'gost8240-89-parallel-flange',5.9,'U_PROFILE'),(32,8.98,40,80,'8П',31.6,12.4,89.9,13.9,22.5,3.31,'gost8240-89-parallel-flange',7.05,'U_PROFILE'),(33,10.9,46,100,'10П',39.9,14.4,175,22.6,34.9,7.37,'gost8240-89-parallel-flange',8.59,'U_PROFILE'),(34,13.3,52,120,'12П',47.9,16.2,305,34.9,50.8,9.84,'gost8240-89-parallel-flange',10.4,'U_PROFILE'),(35,15.6,58,140,'14П',56.1,18.1,493,51.5,70.4,12.9,'gost8240-89-parallel-flange',12.3,'U_PROFILE'),(36,18.1,64,160,'16П',64.4,20,750,72.8,93.8,16.4,'gost8240-89-parallel-flange',14.2,'U_PROFILE'),(37,19.5,68,160,'16аП',65.1,21.5,827,90.5,103,19.6,'gost8240-89-parallel-flange',15.3,'U_PROFILE'),(38,20.7,70,180,'18П',72.6,22,1090,100,121,20.6,'gost8240-89-parallel-flange',16.3,'U_PROFILE'),(39,22.2,74,180,'18аП',73.4,23.5,1200,123,133,24.3,'gost8240-89-parallel-flange',17.4,'U_PROFILE'),(40,23.4,76,200,'20П',80.8,23.9,1530,134,153,25.2,'gost8240-89-parallel-flange',18.4,'U_PROFILE'),(41,26.7,82,220,'22П',89,25.8,2120,178,193,31,'gost8240-89-parallel-flange',21,'U_PROFILE'),(42,30.6,90,240,'24П',97.5,28.5,2910,248,243,39.5,'gost8240-89-parallel-flange',24,'U_PROFILE'),(43,35.2,95,270,'27П',109,29.9,4180,314,310,46.7,'gost8240-89-parallel-flange',27.7,'U_PROFILE'),(44,40.5,100,300,'30П',120,31.2,5830,393,389,54.8,'gost8240-89-parallel-flange',31.8,'U_PROFILE'),(45,46.5,105,330,'33П',131,32.5,8010.8,491,486,64.6,'gost8240-89-parallel-flange',36.5,'U_PROFILE'),(46,53.4,110,360,'36П',143,33.8,10850.001,611,603,76.3,'gost8240-89-parallel-flange',41.9,'U_PROFILE'),(47,61.5,115,400,'40П',158,35.1,15260.001,760,763,89.9,'gost8240-89-parallel-flange',48.3,'U_PROFILE'),(48,6.16,32,50,'5',19.2,9.5,22.8,5.61,9.1,2.75,'gost8240-89-slope-flange',4.84,'U_PROFILE'),(49,7.51,36,65,'6.5',25.4,10.8,48.6,8.7,15,3.68,'gost8240-89-slope-flange',5.9,'U_PROFILE'),(50,8.98,40,80,'8',31.6,11.9,89.4,12.8,22.4,4.75,'gost8240-89-slope-flange',7.05,'U_PROFILE'),(51,10.9,46,100,'10',39.9,13.7,174,20.4,34.8,6.46,'gost8240-89-slope-flange',8.59,'U_PROFILE'),(52,13.3,52,120,'12',47.8,15.3,304,31.2,50.6,8.52,'gost8240-89-slope-flange',10.4,'U_PROFILE'),(53,15.6,58,140,'14',56,17,491,45.4,70.2,11,'gost8240-89-slope-flange',12.3,'U_PROFILE'),(54,18.1,64,160,'16',64.2,18.7,747,63.3,93.4,13.8,'gost8240-89-slope-flange',14.2,'U_PROFILE'),(55,19.5,68,160,'16a',64.9,20.1,823,78.8,103,16.4,'gost8240-89-slope-flange',15.3,'U_PROFILE'),(56,20.7,70,180,'18',72.4,20.4,1090,86,121,17,'gost8240-89-slope-flange',16.3,'U_PROFILE'),(57,22.2,74,180,'18a',73.2,21.8,1190,105,132,20,'gost8240-89-slope-flange',17.4,'U_PROFILE'),(58,23.4,76,200,'20',80.7,22,1520,113,152,20.5,'gost8240-89-slope-flange',18.4,'U_PROFILE'),(59,26.7,82,220,'22',88.9,23.7,2110,151,192,25.1,'gost8240-89-slope-flange',21,'U_PROFILE'),(60,30.6,90,240,'24',97.3,26,2900,208,242,31.6,'gost8240-89-slope-flange',24,'U_PROFILE'),(61,35.2,95,270,'27',109,27.3,4160,262,308,37.3,'gost8240-89-slope-flange',27.7,'U_PROFILE'),(62,40.5,100,300,'30',120,28.4,5810,327,387,43.6,'gost8240-89-slope-flange',31.8,'U_PROFILE'),(63,46.5,105,330,'33',131,29.7,7980,410,484,51.8,'gost8240-89-slope-flange',36.5,'U_PROFILE'),(64,53.4,110,360,'36',142,31,10820.001,513,601,61.7,'gost8240-89-slope-flange',41.9,'U_PROFILE'),(65,61.5,115,400,'40',157,32.3,15220.001,642,761,73.4,'gost8240-89-slope-flange',48.3,'U_PROFILE'),(66,3.9,50,50,'50x2',19.6,19.6,14.4,14.4,5.7,5.7,'gost302245-94-square',3,'HOLLOW'),(67,4.7,50,50,'50x2.5',19.3,19.3,17.2,17.2,6.8,6.8,'gost302245-94-square',3.6,'HOLLOW'),(68,5.5,50,50,'50x3',19.1,19.1,19.9,19.9,7.9,7.9,'gost302245-94-square',4.3,'HOLLOW'),(69,7.1,50,50,'50x4',18.6,18.6,24.5,24.5,9.8,9.8,'gost302245-94-square',5.5,'HOLLOW'),(70,8.6,50,50,'50x5',18.1,18.1,28.3,28.3,11.3,11.3,'gost302245-94-square',6.7,'HOLLOW'),(71,7.7,80,80,'80x2.5',31.2,31.2,74.6,74.6,18.7,18.7,'gost302245-94-square',6,'HOLLOW'),(72,9.2,80,80,'80x3',31.2,31.2,89.5,89.5,22.4,22.4,'gost302245-94-square',7.2,'HOLLOW'),(73,12.2,80,80,'80x4',30.7,30.7,115.3,115.3,28.8,28.8,'gost302245-94-square',9.6,'HOLLOW'),(74,15,80,80,'80x5',30.3,30.3,138,138,34.5,34.5,'gost302245-94-square',11.8,'HOLLOW'),(75,17.8,80,80,'80x6',29.8,29.8,158.1,158.1,39.5,39.5,'gost302245-94-square',14,'HOLLOW'),(76,11.6,100,100,'100x3',39.4,39.4,180.2,180.2,36,36,'gost302245-94-square',9.1,'HOLLOW'),(77,15.3,100,100,'100x4',38.9,38.9,231.3,231.3,46.3,46.3,'gost302245-94-square',12,'HOLLOW'),(78,18.9,100,100,'100x5',38.4,38.4,278.7,278.7,55.7,55.7,'gost302245-94-square',14.8,'HOLLOW'),(79,22.6,100,100,'100x6',38,38,326.3,326.3,65.3,65.3,'gost302245-94-square',17.7,'HOLLOW'),(80,26.2,100,100,'100x7',37.5,37.5,373.9,373.9,74.8,74.8,'gost302245-94-square',20.5,'HOLLOW'),(81,14,120,120,'120x3',47.6,47.6,315.1,315.1,52.5,52.5,'gost302245-94-square',11,'HOLLOW'),(82,18.5,120,120,'120x4',47.1,47.1,408.5,408.5,68.1,68.1,'gost302245-94-square',14.5,'HOLLOW'),(83,22.9,120,120,'120x5',46.6,46.6,497.9,497.9,83,83,'gost302245-94-square',18,'HOLLOW'),(84,27.4,120,120,'120x6',46.1,46.1,583.4,583.4,97.2,97.2,'gost302245-94-square',21.5,'HOLLOW'),(85,21.6,140,140,'140x4',55.2,55.2,657.9,657.9,94,94,'gost302245-94-square',17,'HOLLOW'),(86,26.9,140,140,'140x5',54.8,54.8,808.4,808.4,115.5,115.5,'gost302245-94-square',21.1,'HOLLOW'),(87,32.1,140,140,'140x6',54.3,54.3,947.1,947.1,135.3,135.3,'gost302245-94-square',25.2,'HOLLOW'),(88,37.2,140,140,'140x7',53.8,53.8,1077.1,1077.1,153.9,153.9,'gost302245-94-square',29.2,'HOLLOW'),(89,42.3,140,140,'140x8',53.3,53.3,1201.7,1201.7,171.7,171.7,'gost302245-94-square',33.2,'HOLLOW'),(90,24.7,160,160,'160x4',63.3,63.3,989.7,989.7,123.7,123.7,'gost302245-94-square',19.4,'HOLLOW'),(91,30.7,160,160,'160x5',62.9,62.9,1214.6,1214.6,151.8,151.8,'gost302245-94-square',24.1,'HOLLOW'),(92,36.8,160,160,'160x6',62.4,62.4,1435.1,1435.1,179.4,179.4,'gost302245-94-square',28.9,'HOLLOW'),(93,42.8,160,160,'160x7',62,62,1640.8,1640.8,205.1,205.1,'gost302245-94-square',33.6,'HOLLOW'),(94,48.7,160,160,'160x8',61.5,61.5,1836.9,1836.9,229.6,229.6,'gost302245-94-square',38.2,'HOLLOW'),(95,34.6,180,180,'180x5',71.1,71.1,1749.1,1749.1,194.3,194.3,'gost302245-94-square',27.2,'HOLLOW'),(96,41.4,180,180,'180x6',70.6,70.6,2063.5,2063.5,229.3,229.3,'gost302245-94-square',32.5,'HOLLOW'),(97,48.2,180,180,'180x7',70.1,70.1,2372.1,2372.1,263.6,263.6,'gost302245-94-square',37.8,'HOLLOW'),(98,54.8,180,180,'180x8',69.7,69.7,2663.3,2663.3,295.9,295.9,'gost302245-94-square',43,'HOLLOW'),(99,61.5,180,180,'180x9',69.1,69.1,2976.5,2976.5,326.2,326.2,'gost302245-94-square',48.3,'HOLLOW'),(100,68.2,180,180,'180x10',68.6,68.6,3300.7,3300.7,353.5,353.5,'gost302245-94-square',53.5,'HOLLOW'),(101,38.4,200,200,'200x5',79.3,79.3,2410,2410,241,241,'gost302245-94-square',30.1,'HOLLOW'),(102,45.6,200,200,'200x6',78.8,78.8,2832,2832,283,283,'gost302245-94-square',35.8,'HOLLOW'),(103,52.8,200,200,'200x7',78.3,78.3,3236,3236,324,324,'gost302245-94-square',41.4,'HOLLOW'),(104,59.8,200,200,'200x8',77.8,77.8,3621,3621,362,362,'gost302245-94-square',46.9,'HOLLOW'),(105,66.7,200,200,'200x9',77.3,77.3,3987,3987,399,399,'gost302245-94-square',52.3,'HOLLOW'),(106,73.4,200,200,'200x10',76.8,76.8,4336,4336,434,434,'gost302245-94-square',57.6,'HOLLOW'),(107,80,200,200,'200x11',76.4,76.4,4667,4667,467,467,'gost302245-94-square',62.8,'HOLLOW'),(108,86.5,200,200,'200x12',75.9,75.9,4980,4980,498,498,'gost302245-94-square',67,'HOLLOW'),(109,92.9,200,200,'200x13',75.4,75.4,4685,4685,527,527,'gost302245-94-square',72.9,'HOLLOW'),(110,99.2,200,200,'200x14',74.9,74.9,4408,4408,554,554,'gost302245-94-square',77.9,'HOLLOW'),(111,75.8,250,250,'250x8',98.2,98.2,7315,7315,585,585,'gost302245-94-square',59.5,'HOLLOW'),(112,84.7,250,250,'250x9',97.8,97.8,8092,8092,647,647,'gost302245-94-square',66.5,'HOLLOW'),(113,93.4,250,250,'250x10',97.3,97.3,8840,8840,707,707,'gost302245-94-square',73.3,'HOLLOW'),(114,102,250,250,'250x11',96.8,96.8,9559,9559,765,765,'gost302245-94-square',80.1,'HOLLOW'),(115,111,250,250,'250x12',96.3,96.3,10251,10251,820,820,'gost302245-94-square',86.8,'HOLLOW'),(116,119,250,250,'250x13',95.8,95.8,10917.001,10917.001,872,872,'gost302245-94-square',93.4,'HOLLOW'),(117,127,250,250,'250x14',95.3,95.3,11550.001,11550.001,924,924,'gost302245-94-square',99.8,'HOLLOW'),(118,89.9,300,300,'300x8',119.4,119.4,12812,12812,846,846,'gost302245-94-square',70.5,'HOLLOW'),(119,101,300,300,'300x9',119,119,14302.001,14302.001,949,949,'gost302245-94-square',79.3,'HOLLOW'),(120,113,300,300,'300x10',117.9,117.9,15712.001,15712.001,1047,1047,'gost302245-94-square',89,'HOLLOW'),(121,124,300,300,'300x11',117.4,117.4,17080,17080,1139,1139,'gost302245-94-square',97.3,'HOLLOW'),(122,135,300,300,'300x12',116.5,116.5,18330,18330,1222,1222,'gost302245-94-square',106,'HOLLOW'),(123,145,300,300,'300x13',116.2,116.2,19580,19580,1309,1309,'gost302245-94-square',113.8,'HOLLOW'),(124,155,300,300,'300x14',115.8,115.8,20784.002,20784.002,1386,1386,'gost302245-94-square',122,'HOLLOW'),(125,3.8,40,60,'60x40x2',22.3,16.3,18.8,10,6.2,5,'gost302245-94-rectangle',3,'HOLLOW'),(126,4.7,40,60,'60x40x2.5',22,16,22.4,11.8,7.4,5.9,'gost302245-94-rectangle',3.6,'HOLLOW'),(127,5.5,40,60,'60x40x3',21.8,15.8,26,13.7,8.6,6.8,'gost302245-94-rectangle',4.3,'HOLLOW'),(128,7.1,40,60,'60x40x4',21.3,15.4,32.2,16.7,10.7,8.3,'gost302245-94-rectangle',5.5,'HOLLOW'),(129,8.6,40,60,'60x40x5',20.8,14.9,37.1,19.1,12.3,9.5,'gost302245-94-rectangle',6.7,'HOLLOW'),(130,9.2,60,100,'100x60x3',36.6,24.6,123.2,55.6,24.6,18.5,'gost302245-94-rectangle',7.2,'HOLLOW'),(131,12.2,60,100,'100x60x4',35.9,24.1,157.6,70.8,31.5,23.6,'gost302245-94-rectangle',9.6,'HOLLOW'),(132,15,60,100,'100x60x5',35.4,23.6,187.8,83.8,37.6,27.9,'gost302245-94-rectangle',11.8,'HOLLOW'),(133,17.8,60,100,'100x60x6',34.8,23.2,216.3,96.2,43.3,32.1,'gost302245-94-rectangle',14,'HOLLOW'),(134,11.6,80,120,'120x80x3',44.8,32.7,233.4,124.8,38.9,31.2,'gost302245-94-rectangle',9.1,'HOLLOW'),(135,15.3,80,120,'120x80x4',44.2,32.3,299,159.7,49.8,39.9,'gost302245-94-rectangle',12,'HOLLOW'),(136,18.9,80,120,'120x80x5',43.7,31.9,361.4,192.4,60.2,48.1,'gost302245-94-rectangle',14.8,'HOLLOW'),(137,22.6,80,120,'120x80x6',43.3,31.5,423.2,224.1,70.5,56,'gost302245-94-rectangle',17.7,'HOLLOW'),(138,26.3,80,120,'120x80x7',42.8,31,483.2,254.6,80.4,63.8,'gost302245-94-rectangle',20.6,'HOLLOW'),(139,15.3,60,140,'140x60x4',48.6,25,362.1,95.4,51.7,31.8,'gost302245-94-rectangle',12,'HOLLOW'),(140,18.9,60,140,'140x60x5',48,24.5,436.1,113.6,62.3,37.9,'gost302245-94-rectangle',14.8,'HOLLOW'),(141,22.6,60,140,'140x60x6',47.5,24.1,509.7,131.3,72.8,43.8,'gost302245-94-rectangle',17.7,'HOLLOW'),(142,14.2,100,140,'140x100x3',53.1,41,404.2,241.2,57.7,48.2,'gost302245-94-rectangle',11.1,'HOLLOW'),(143,18.5,100,140,'140x100x4',52.6,40.5,511.3,304.3,73,60.9,'gost302245-94-rectangle',14.5,'HOLLOW'),(144,22.9,100,140,'140x100x5',52,40.1,619.7,368,88.5,73.6,'gost302245-94-rectangle',18,'HOLLOW'),(145,27.4,100,140,'140x100x6',51.6,39.7,729.2,432.4,104.2,86.5,'gost302245-94-rectangle',21.5,'HOLLOW'),(146,32,100,140,'140x100x7',51.1,39.2,839.8,497.5,120,99.5,'gost302245-94-rectangle',25.1,'HOLLOW'),(147,13.9,80,160,'160x80x3',57,33.4,455,155.2,56.9,38.8,'gost302245-94-rectangle',10.9,'HOLLOW'),(148,18.5,80,160,'160x80x4',57.3,33.4,606.7,206.9,75.8,51.7,'gost302245-94-rectangle',14.5,'HOLLOW'),(149,22.9,80,160,'160x80x5',56.7,32.9,735.9,248.7,92,62.2,'gost302245-94-rectangle',18,'HOLLOW'),(150,27.4,80,160,'160x80x6',56.2,32.6,864.7,280.7,108.1,72.7,'gost302245-94-rectangle',21.5,'HOLLOW'),(151,21.6,120,160,'160x120x4',60.8,48.8,799.2,514,99.9,85.7,'gost302245-94-rectangle',17,'HOLLOW'),(152,26.9,120,160,'160x120x5',60.3,48.3,978.2,628.4,122.3,104.7,'gost302245-94-rectangle',21.1,'HOLLOW'),(153,32.1,120,160,'160x120x6',59.9,47.9,1150.5,736.9,143.8,122.8,'gost302245-94-rectangle',25.2,'HOLLOW'),(154,37.2,120,160,'160x120x7',59.3,47.4,1307.4,836.6,163.4,139.4,'gost302245-94-rectangle',29.2,'HOLLOW'),(155,42.3,120,160,'160x120x8',58.8,46.9,1461,932.5,182.6,155.4,'gost302245-94-rectangle',33.2,'HOLLOW'),(156,22.9,60,180,'180x60x5',60.3,25.1,833.8,144.7,92.6,48.2,'gost302245-94-rectangle',18,'HOLLOW'),(157,27.4,60,180,'180x60x6',59.7,24.6,978.5,166.5,108.7,55.5,'gost302245-94-rectangle',21.5,'HOLLOW'),(158,26.9,100,180,'180x100x5',65.2,41.3,1143,459.6,127,91.9,'gost302245-94-rectangle',21.1,'HOLLOW'),(159,32.1,100,180,'180x100x6',64.7,40.9,1344.4,537.8,149.4,107.6,'gost302245-94-rectangle',25.2,'HOLLOW'),(160,37.2,100,180,'180x100x7',64.1,40.4,1527.9,607.9,169.8,121.6,'gost302245-94-rectangle',29.2,'HOLLOW'),(161,42.3,100,180,'180x100x8',63.5,40,1706.1,676,189.6,135.2,'gost302245-94-rectangle',33.2,'HOLLOW'),(162,24.6,140,180,'180x140x4',69.1,57,1165,782.4,128.2,111.8,'gost302245-94-rectangle',19.3,'HOLLOW'),(163,30.7,140,180,'180x140x5',68.5,56.5,1443,981.2,160.3,140.2,'gost302245-94-rectangle',24.1,'HOLLOW'),(164,36.8,140,180,'180x140x6',68.1,56.1,1706.8,1158.9,189.6,165.6,'gost302245-94-rectangle',28.9,'HOLLOW'),(165,42.8,140,180,'180x140x7',67.5,55.6,1952,1322.9,216.9,189,'gost302245-94-rectangle',33.6,'HOLLOW'),(166,48.7,140,180,'180x140x8',67,55.1,2187.3,1480.6,243,211.5,'gost302245-94-rectangle',38.2,'HOLLOW'),(167,27.7,120,200,'200x120x4',76.8,64.7,1631.8,1160,163.2,145,'gost302245-94-rectangle',21.8,'HOLLOW'),(168,34.6,160,200,'200x160x5',76.7,64.6,2039.7,1450,204,181.2,'gost302245-94-rectangle',27.2,'HOLLOW'),(169,41.4,160,200,'200x160x6',76.3,64.3,2412.4,1712.3,241.2,214,'gost302245-94-rectangle',32.5,'HOLLOW'),(170,48.2,160,200,'200x160x7',75.8,63.8,2767.1,1962,276.7,245.2,'gost302245-94-rectangle',37.8,'HOLLOW'),(171,54.8,160,200,'200x160x8',75.3,63.3,3104.3,2199,310.4,274.9,'gost302245-94-rectangle',43,'HOLLOW'),(172,61.3,160,200,'200x160x9',74.8,62.8,3424,2436,342.3,303.3,'gost302245-94-rectangle',48.1,'HOLLOW'),(173,67.7,160,200,'200x160x10',74.3,62.3,3726.7,2211.7,372.4,330.4,'gost302245-94-rectangle',53.1,'HOLLOW'),(174,75.8,200,300,'300x200x8',112,82,9512,5069,634,510,'gost302245-94-rectangle',59.5,'HOLLOW'),(175,84.7,200,300,'300x200x9',111.5,81.5,10527.001,5630,702,563,'gost302245-94-rectangle',66.5,'HOLLOW'),(176,93.4,200,300,'300x200x10',111,81.1,11505.001,6143,767,614,'gost302245-94-rectangle',73.3,'HOLLOW'),(177,102,200,300,'300x200x11',110.5,80.6,12446.001,6634,830,663,'gost302245-94-rectangle',80.1,'HOLLOW'),(178,111,200,300,'300x200x12',110,80.1,13351,7104,890,710,'gost302245-94-rectangle',86.8,'HOLLOW'),(179,119,200,300,'300x200x13',109.5,79.6,12482.001,7553,945,755,'gost302245-94-rectangle',93.4,'HOLLOW'),(180,127,200,300,'300x200x14',109,79.2,15054.001,7983,1004,798,'gost302245-94-rectangle',99.8,'HOLLOW'),(181,75.8,180,320,'320x180x8',117,74.9,10341.001,4248,646,472,'gost302245-94-rectangle',59.5,'HOLLOW'),(182,93.4,180,320,'320x180x10',116,74,12506.001,5111,782,568,'gost302245-94-rectangle',73.3,'HOLLOW'),(183,111,180,320,'320x180x12',115,73.1,14511.001,5899,907,655,'gost302245-94-rectangle',86.8,'HOLLOW'),(184,127,180,320,'320x180x14',113,72.1,16359.001,6617,1022,735,'gost302245-94-rectangle',99.8,'HOLLOW'),(185,84.7,160,340,'340x160x9',121,66.9,12306.001,3793,724,474,'gost302245-94-rectangle',66.5,'HOLLOW'),(186,93.4,160,340,'340x160x10',120,66.5,13446.001,4130,791,516,'gost302245-94-rectangle',73.3,'HOLLOW'),(187,111,160,340,'340x160x12',119,65.6,15596.001,4755,917,594,'gost302245-94-rectangle',86.8,'HOLLOW'),(188,127,160,340,'340x160x14',118,64.7,17576,5319,1034,655,'gost302245-94-rectangle',99.8,'HOLLOW'),(189,113,260,340,'340x260x10',129,105,18892,12510.001,1111,962,'gost302245-94-rectangle',89,'HOLLOW'),(190,135,260,340,'340x260x12',128,104,22054.002,14577.001,1297,1121,'gost302245-94-rectangle',106,'HOLLOW'),(191,155,260,340,'340x260x14',127,103,25020.002,16508,1472,1269,'gost302245-94-rectangle',122,'HOLLOW'),(192,113,220,380,'380x220x10',139,91.1,21925.002,9416,1154,856,'gost302245-94-rectangle',89,'HOLLOW'),(193,135,220,380,'380x220x12',138,90.2,25594,10948.001,1347,995,'gost302245-94-rectangle',106,'HOLLOW'),(194,155,220,380,'380x220x14',137,89.3,29037,12370,1528,1125,'gost302245-94-rectangle',122,'HOLLOW'),(195,113,200,400,'400x200x10',143,83.7,23345.002,7949,1167,795,'gost302245-94-rectangle',89,'HOLLOW'),(196,135,200,400,'400x200x12',142,82.8,27248.002,9227,1362,923,'gost302245-94-rectangle',10.6,'HOLLOW'),(197,155,200,400,'400x200x14',141,81.9,30907,10409.001,1545,1041,'gost302245-94-rectangle',122,'HOLLOW');
/*!40000 ALTER TABLE `shaped_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `steel`
--

DROP TABLE IF EXISTS `steel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `steel` (
  `id` int NOT NULL,
  `steel_name` varchar(45) NOT NULL,
  `steel_thick_low_lim` float DEFAULT NULL,
  `steel_thick_upp_lim` float DEFAULT NULL,
  `char_yield_strange_sheet` int DEFAULT NULL,
  `char_ultimate_strange_sheet` int DEFAULT NULL,
  `char_yield_strange_shape` int DEFAULT NULL,
  `char_ultimate_strange_shape` int DEFAULT NULL,
  `design_yield_strange_sheet` int DEFAULT NULL,
  `design_ultimate_strange_sheet` int DEFAULT NULL,
  `design_yield_strange_shape` int DEFAULT NULL,
  `design_ultimate_strange_shape` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `steel`
--

LOCK TABLES `steel` WRITE;
/*!40000 ALTER TABLE `steel` DISABLE KEYS */;
INSERT INTO `steel` VALUES (1,'S235',2,20,235,360,235,360,230,350,230,350),(2,'S235',20.1,40,225,360,225,360,220,350,220,350),(3,'S235',40.1,100,215,360,NULL,NULL,210,350,NULL,NULL),(4,'S235',100.1,200,195,360,NULL,NULL,190,350,NULL,NULL),(5,'S245',2,20,245,370,245,370,240,360,240,360),(6,'S245',20.1,30,NULL,NULL,235,370,NULL,NULL,230,360),(7,'S255',2,3.9,255,380,NULL,NULL,250,370,NULL,NULL),(8,'S255',4,10,245,370,255,380,240,360,250,370),(9,'S255',10.1,20,245,370,245,370,240,360,240,360),(10,'S255',20.1,40,235,370,235,370,230,360,230,360),(11,'S275',2,10,275,380,275,390,270,370,270,380),(12,'S275',10.1,20,265,370,275,380,260,360,270,370),(13,'S285',2,3.9,285,390,NULL,NULL,280,380,NULL,NULL),(14,'S285',4,10,275,390,285,400,270,380,280,390),(15,'S285',10.1,20,265,380,275,390,260,370,270,380),(16,'S295',2,100,295,430,295,430,285,420,285,420),(17,'S325',10,20,325,470,325,470,315,460,315,460),(18,'S325',20.1,40,305,460,305,460,300,450,300,450),(19,'S325',40.1,60,285,450,NULL,NULL,280,440,NULL,NULL),(20,'S325',60.1,80,275,440,NULL,NULL,270,430,NULL,NULL),(21,'S325',80.1,100,265,430,NULL,NULL,260,420,NULL,NULL),(22,'S345',2,10,345,490,345,490,335,480,335,480),(23,'S345',10.1,20,325,470,325,470,315,460,315,460),(24,'S345',20.1,40,305,460,305,460,300,450,300,450),(25,'S345K',4,10,345,470,345,470,335,460,335,460),(26,'S355',8,50,355,450,NULL,NULL,350,440,NULL,NULL),(27,'S375',2,10,375,510,375,510,365,500,365,500),(28,'S375',10.1,20,355,490,355,490,345,480,345,480),(29,'S375',20.1,40,335,480,335,480,325,470,325,470),(30,'S390',4,50,390,540,NULL,NULL,380,530,NULL,NULL),(31,'S390K',4,30,390,540,NULL,NULL,380,530,NULL,NULL),(32,'S420',4,16,420,540,NULL,NULL,410,530,NULL,NULL),(33,'S420',16.1,40,400,530,NULL,NULL,390,515,NULL,NULL),(34,'S420',40.1,63,390,530,NULL,NULL,380,515,NULL,NULL),(35,'S420',63.1,80,370,520,NULL,NULL,360,505,NULL,NULL),(36,'S440',4,30,440,590,NULL,NULL,430,575,NULL,NULL),(37,'S440',30.1,50,410,570,NULL,NULL,400,555,NULL,NULL),(38,'S460',4,16,460,570,NULL,NULL,445,555,NULL,NULL),(39,'S460',16.1,40,440,560,NULL,NULL,430,545,NULL,NULL),(40,'S460',40.1,63,430,560,NULL,NULL,420,545,NULL,NULL),(41,'S460',63.1,80,410,540,NULL,NULL,400,530,NULL,NULL),(42,'S490',8,50,490,590,NULL,NULL,475,575,NULL,NULL);
/*!40000 ALTER TABLE `steel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uprofile_section`
--

DROP TABLE IF EXISTS `uprofile_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uprofile_section` (
  `first_moment_aboutyaxis` double DEFAULT NULL,
  `flange_thick` double DEFAULT NULL,
  `inside_radius` double DEFAULT NULL,
  `center_of_the_weight` double DEFAULT NULL,
  `outside_radius` double DEFAULT NULL,
  `web_thick` double DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK7w9nruhdow6e8xciq2olh0oi` FOREIGN KEY (`id`) REFERENCES `shaped_section` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uprofile_section`
--

LOCK TABLES `uprofile_section` WRITE;
/*!40000 ALTER TABLE `uprofile_section` DISABLE KEYS */;
INSERT INTO `uprofile_section` VALUES (5.61,7,6,12.1,3.5,4.4,30),(9.02,7.2,6,12.9,3.5,4.4,31),(13.3,7.4,6.5,13.8,3.5,4.5,32),(20.5,7.6,7,15.3,4,4.5,33),(29.7,7.8,7.5,16.6,4.5,4.8,34),(40.9,8.1,8,18.2,4.5,4.9,35),(54.3,8.4,8.5,19.7,5,5,36),(59.5,9,8.5,21.9,5,5,37),(70,8.7,9,21.4,5,5.1,38),(76.3,9.3,9,23.6,5,5.1,39),(88,9,9.5,23,5.5,5.2,40),(111,9.5,10,24.7,6,5.4,41),(139,10,10.5,27.2,6,5.6,42),(178,10.5,11,27.8,6.5,6,43),(224,11,12,28.3,7,6.5,44),(281,11.7,13,29,7.5,7,45),(350,12.6,14,29.9,8.5,7.5,46),(445,13.5,15,30.5,9,8,47),(5.59,7,6,11.6,2.5,4.4,48),(9,7.2,6,12.4,2.5,4.4,49),(23.3,7.4,6.5,13.1,2.5,4.5,50),(20.4,7.6,7,14.4,3,4.5,51),(29.6,7.8,7.5,15.4,3,4.8,52),(40.8,8.1,8,16.7,3,4.9,53),(54.1,8.4,8.5,18,3.5,5,54),(59.4,9,8.5,20,3.5,5,55),(69.8,8.7,9,19.4,3.5,5.1,56),(76.1,9.3,9,21.3,3.5,5.1,57),(87.8,9,9.5,20.7,4,5.2,58),(110,9.5,10,22.1,4,5.4,59),(139,10,10.5,24.2,4,5.6,60),(178,10.5,11,24.7,4.5,6,61),(224,11,12,25.2,5,6.5,62),(281,11.7,13,25.9,5,7,63),(350,12.6,14,26.8,6,7.5,64),(444,13.5,15,27.5,6,8,65);
/*!40000 ALTER TABLE `uprofile_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FKfpm8swft53ulq2hl11yplpr5` (`user_id`),
  CONSTRAINT `FKfpm8swft53ulq2hl11yplpr5` FOREIGN KEY (`user_id`) REFERENCES `usr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'USER'),(183,'USER'),(183,'ADMIN');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr`
--

DROP TABLE IF EXISTS `usr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usr` (
  `id` bigint NOT NULL,
  `active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dfui7gxngrgwn9ewee3ogtgym` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr`
--

LOCK TABLES `usr` WRITE;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;
INSERT INTO `usr` VALUES (1,_binary '','u@test.com','$2a$10$BDZQHMiIWjA302vEZPkE5ui3OxwUC5SWwqLbS7voLXZqJkI.A516K','u'),(183,_binary '','admin@mail.com','$2a$10$Yxl4E68JbMAihU.HFCXstef1OSfY6.ufE0R3NayOBkc/XgthEikfC','a');
/*!40000 ALTER TABLE `usr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-28 21:48:31
