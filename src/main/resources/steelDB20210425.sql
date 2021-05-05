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
INSERT INTO `hibernate_sequence` VALUES (1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hollow_rectangle_gost30245_94`
--

DROP TABLE IF EXISTS `hollow_rectangle_gost30245_94`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hollow_rectangle_gost30245_94` (
  `id` int DEFAULT NULL,
  `profileNumber` varchar(255) DEFAULT NULL,
  `height_h_mm` int DEFAULT NULL,
  `breadth_b_mm` int DEFAULT NULL,
  `webThick_s_mm` double DEFAULT NULL,
  `insideRadius_r1_mm` int DEFAULT NULL,
  `area_A_sm^2` double DEFAULT NULL,
  `secondMomentAboutYAxis_Iy_sm^4` double DEFAULT NULL,
  `sectionModulusAboutYAxis_Wy_sm^3` double DEFAULT NULL,
  `radiusOfGyrationYAxis_iy_mm` double DEFAULT NULL,
  `secondMomentAboutZAxis_Iz_sm^4` double DEFAULT NULL,
  `sectionModulusAboutZAxis_Wz_sm^3` double DEFAULT NULL,
  `radiusOfGyrationZAxis_iz_mm` double DEFAULT NULL,
  `weightPerLength_P_kg/m` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hollow_rectangle_gost30245_94`
--

LOCK TABLES `hollow_rectangle_gost30245_94` WRITE;
/*!40000 ALTER TABLE `hollow_rectangle_gost30245_94` DISABLE KEYS */;
INSERT INTO `hollow_rectangle_gost30245_94` VALUES (1,'60x40x2',60,40,2,4,3.8,18.8,6.2,22.3,10,5,16.3,3),(2,'60x40x2.5',60,40,2.5,5,4.7,22.4,7.4,22,11.8,5.9,16,3.6),(3,'60x40x3',60,40,3,6,5.5,26,8.6,21.8,13.7,6.8,15.8,4.3),(4,'60x40x4',60,40,4,8,7.1,32.2,10.7,21.3,16.7,8.3,15.4,5.5),(5,'60x40x5',60,40,5,10,8.6,37.1,12.3,20.8,19.1,9.5,14.9,6.7),(6,'100x60x3',100,60,3,6,9.2,123.2,24.6,36.6,55.6,18.5,24.6,7.2),(7,'100x60x4',100,60,4,8,12.2,157.6,31.5,35.9,70.8,23.6,24.1,9.6),(8,'100x60x5',100,60,5,10,15,187.8,37.6,35.4,83.8,27.9,23.6,11.8),(9,'100x60x6',100,60,6,12,17.8,216.3,43.3,34.8,96.2,32.1,23.2,14),(10,'120x80x3',120,80,3,6,11.6,233.4,38.9,44.8,124.8,31.2,32.7,9.1),(11,'120x80x4',120,80,4,8,15.3,299,49.8,44.2,159.7,39.9,32.3,12),(12,'120x80x5',120,80,5,10,18.9,361.4,60.2,43.7,192.4,48.1,31.9,14.8),(13,'120x80x6',120,80,6,12,22.6,423.2,70.5,43.3,224.1,56,31.5,17.7),(14,'120x80x7',120,80,7,14,26.3,483.2,80.4,42.8,254.6,63.8,31,20.6),(15,'140x60x4',140,60,4,8,15.3,362.1,51.7,48.6,95.4,31.8,25,12),(16,'140x60x5',140,60,5,10,18.9,436.1,62.3,48,113.6,37.9,24.5,14.8),(17,'140x60x6',140,60,6,12,22.6,509.7,72.8,47.5,131.3,43.8,24.1,17.7),(18,'140x100x3',140,100,3,6,14.2,404.2,57.7,53.1,241.2,48.2,41,11.1),(19,'140x100x4',140,100,4,8,18.5,511.3,73,52.6,304.3,60.9,40.5,14.5),(20,'140x100x5',140,100,5,10,22.9,619.7,88.5,52,368,73.6,40.1,18),(21,'140x100x6',140,100,6,12,27.4,729.2,104.2,51.6,432.4,86.5,39.7,21.5),(22,'140x100x7',140,100,7,14,32,839.8,120,51.1,497.5,99.5,39.2,25.1),(23,'160x80x3',160,80,3,6,13.9,455,56.9,57,155.2,38.8,33.4,10.9),(24,'160x80x4',160,80,4,8,18.5,606.7,75.8,57.3,206.9,51.7,33.4,14.5),(25,'160x80x5',160,80,5,10,22.9,735.9,92,56.7,248.7,62.2,32.9,18),(26,'160x80x6',160,80,6,12,27.4,864.7,108.1,56.2,280.7,72.7,32.6,21.5),(27,'160x120x4',160,120,4,8,21.6,799.2,99.9,60.8,514,85.7,48.8,17),(28,'160x120x5',160,120,5,10,26.9,978.2,122.3,60.3,628.4,104.7,48.3,21.1),(29,'160x120x6',160,120,6,12,32.1,1150.5,143.8,59.9,736.9,122.8,47.9,25.2),(30,'160x120x7',160,120,7,14,37.2,1307.4,163.4,59.3,836.6,139.4,47.4,29.2),(31,'160x120x8',160,120,8,16,42.3,1461,182.6,58.8,932.5,155.4,46.9,33.2),(32,'180x60x5',180,60,5,10,22.9,833.8,92.6,60.3,144.7,48.2,25.1,18),(33,'180x60x6',180,60,6,12,27.4,978.5,108.7,59.7,166.5,55.5,24.6,21.5),(34,'180x100x5',180,100,5,10,26.9,1143,127,65.2,459.6,91.9,41.3,21.1),(35,'180x100x6',180,100,6,12,32.1,1344.4,149.4,64.7,537.8,107.6,40.9,25.2),(36,'180x100x7',180,100,7,14,37.2,1527.9,169.8,64.1,607.9,121.6,40.4,29.2),(37,'180x100x8',180,100,8,16,42.3,1706.1,189.6,63.5,676,135.2,40,33.2),(38,'180x140x4',180,140,4,8,24.6,1165,128.2,69.1,782.4,111.8,57,19.3),(39,'180x140x5',180,140,5,10,30.7,1443,160.3,68.5,981.2,140.2,56.5,24.1),(40,'180x140x6',180,140,6,12,36.8,1706.8,189.6,68.1,1158.9,165.6,56.1,28.9),(41,'180x140x7',180,140,7,14,42.8,1952,216.9,67.5,1322.9,189,55.6,33.6),(42,'180x140x8',180,140,8,16,48.7,2187.3,243,67,1480.6,211.5,55.1,38.2),(43,'200x120x4',200,120,4,8,27.7,1631.8,163.2,76.8,1160,145,64.7,21.8),(44,'200x160x5',200,160,5,10,34.6,2039.7,204,76.7,1450,181.2,64.6,27.2),(45,'200x160x6',200,160,6,12,41.4,2412.4,241.2,76.3,1712.3,214,64.3,32.5),(46,'200x160x7',200,160,7,14,48.2,2767.1,276.7,75.8,1962,245.2,63.8,37.8),(47,'200x160x8',200,160,8,16,54.8,3104.3,310.4,75.3,2199,274.9,63.3,43),(48,'200x160x9',200,160,9,18,61.3,3424,342.3,74.8,2436,303.3,62.8,48.1),(49,'200x160x10',200,160,10,20,67.7,3726.7,372.4,74.3,2211.7,330.4,62.3,53.1),(50,'300x200x8',300,200,8,16,75.8,9512,634,112,5069,510,82,59.5),(51,'300x200x9',300,200,9,18,84.7,10527.001,702,111.5,5630,563,81.5,66.5),(52,'300x200x10',300,200,10,20,93.4,11505.001,767,111,6143,614,81.1,73.3),(53,'300x200x11',300,200,11,22,102,12446.001,830,110.5,6634,663,80.6,80.1),(54,'300x200x12',300,200,12,24,111,13351,890,110,7104,710,80.1,86.8),(55,'300x200x13',300,200,13,26,119,12482.001,945,109.5,7553,755,79.6,93.4),(56,'300x200x14',300,200,14,28,127,15054.001,1004,109,7983,798,79.2,99.8),(57,'320x180x8',320,180,8,16,75.8,10341.001,646,117,4248,472,74.9,59.5),(58,'320x180x10',320,180,10,20,93.4,12506.001,782,116,5111,568,74,73.3),(59,'320x180x12',320,180,12,24,111,14511.001,907,115,5899,655,73.1,86.8),(60,'320x180x14',320,180,14,28,127,16359.001,1022,113,6617,735,72.1,99.8),(61,'340x160x9',340,160,9,18,84.7,12306.001,724,121,3793,474,66.9,66.5),(62,'340x160x10',340,160,10,20,93.4,13446.001,791,120,4130,516,66.5,73.3),(63,'340x160x12',340,160,12,24,111,15596.001,917,119,4755,594,65.6,86.8),(64,'340x160x14',340,160,14,28,127,17576,1034,118,5319,655,64.7,99.8),(65,'340x260x10',340,260,10,20,113,18892,1111,129,12510.001,962,105,89),(66,'340x260x12',340,260,12,24,135,22054.002,1297,128,14577.001,1121,104,106),(67,'340x260x14',340,260,14,28,155,25020.002,1472,127,16508,1269,103,122),(68,'380x220x10',380,220,10,20,113,21925.002,1154,139,9416,856,91.1,89),(69,'380x220x12',380,220,12,24,135,25594,1347,138,10948.001,995,90.2,106),(70,'380x220x14',380,220,14,28,155,29037,1528,137,12370,1125,89.3,122),(71,'400x200x10',400,200,10,20,113,23345.002,1167,143,7949,795,83.7,89),(72,'400x200x12',400,200,12,24,135,27248.002,1362,142,9227,923,82.8,10.6),(73,'400x200x14',400,200,14,28,155,30907,1545,141,10409.001,1041,81.9,122);
/*!40000 ALTER TABLE `hollow_rectangle_gost30245_94` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hollow_square_gost30245_94`
--

DROP TABLE IF EXISTS `hollow_square_gost30245_94`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hollow_square_gost30245_94` (
  `id` int DEFAULT NULL,
  `profileNumber` varchar(255) DEFAULT NULL,
  `height_h_mm` int DEFAULT NULL,
  `webThick_s_mm` double DEFAULT NULL,
  `insideRadius_r1_mm` int DEFAULT NULL,
  `area_A_sm^2` double DEFAULT NULL,
  `secondMomentAboutYAxis_Iy_sm^4` double DEFAULT NULL,
  `sectionModulusAboutYAxis_Wy_sm^3` double DEFAULT NULL,
  `radiusOfGyrationYAxis_iy_mm` double DEFAULT NULL,
  `weightPerLength_P_kg/m` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hollow_square_gost30245_94`
--

LOCK TABLES `hollow_square_gost30245_94` WRITE;
/*!40000 ALTER TABLE `hollow_square_gost30245_94` DISABLE KEYS */;
INSERT INTO `hollow_square_gost30245_94` VALUES (1,'50x2',50,2,4,3.9,14.4,5.7,19.6,3),(2,'50x2.5',50,2.5,5,4.7,17.2,6.8,19.3,3.6),(3,'50x3',50,3,6,5.5,19.9,7.9,19.1,4.3),(4,'50x4',50,4,8,7.1,24.5,9.8,18.6,5.5),(5,'50x5',50,5,10,8.6,28.3,11.3,18.1,6.7),(6,'80x2.5',80,2.5,5,7.7,74.6,18.7,31.2,6),(7,'80x3',80,3,6,9.2,89.5,22.4,31.2,7.2),(8,'80x4',80,4,8,12.2,115.3,28.8,30.7,9.6),(9,'80x5',80,5,10,15,138,34.5,30.3,11.8),(10,'80x6',80,6,12,17.8,158.1,39.5,29.8,14),(11,'100x3',100,3,6,11.6,180.2,36,39.4,9.1),(12,'100x4',100,4,8,15.3,231.3,46.3,38.9,12),(13,'100x5',100,5,10,18.9,278.7,55.7,38.4,14.8),(14,'100x6',100,6,12,22.6,326.3,65.3,38,17.7),(15,'100x7',100,7,14,26.2,373.9,74.8,37.5,20.5),(16,'120x3',120,3,6,14,315.1,52.5,47.6,11),(17,'120x4',120,4,8,18.5,408.5,68.1,47.1,14.5),(18,'120x5',120,5,10,22.9,497.9,83,46.6,18),(19,'120x6',120,6,12,27.4,583.4,97.2,46.1,21.5),(20,'140x4',140,4,8,21.6,657.9,94,55.2,17),(21,'140x5',140,5,10,26.9,808.4,115.5,54.8,21.1),(22,'140x6',140,6,12,32.1,947.1,135.3,54.3,25.2),(23,'140x7',140,7,14,37.2,1077.1,153.9,53.8,29.2),(24,'140x8',140,8,16,42.3,1201.7,171.7,53.3,33.2),(25,'160x4',160,4,8,24.7,989.7,123.7,63.3,19.4),(26,'160x5',160,5,10,30.7,1214.6,151.8,62.9,24.1),(27,'160x6',160,6,12,36.8,1435.1,179.4,62.4,28.9),(28,'160x7',160,7,14,42.8,1640.8,205.1,62,33.6),(29,'160x8',160,8,16,48.7,1836.9,229.6,61.5,38.2),(30,'180x5',180,5,10,34.6,1749.1,194.3,71.1,27.2),(31,'180x6',180,6,12,41.4,2063.5,229.3,70.6,32.5),(32,'180x7',180,7,14,48.2,2372.1,263.6,70.1,37.8),(33,'180x8',180,8,16,54.8,2663.3,295.9,69.7,43),(34,'180x9',180,9,18,61.5,2976.5,326.2,69.1,48.3),(35,'180x10',180,10,20,68.2,3300.7,353.5,68.6,53.5),(36,'200x5',200,5,10,38.4,2410,241,79.3,30.1),(37,'200x6',200,6,12,45.6,2832,283,78.8,35.8),(38,'200x7',200,7,14,52.8,3236,324,78.3,41.4),(39,'200x8',200,8,16,59.8,3621,362,77.8,46.9),(40,'200x9',200,9,18,66.7,3987,399,77.3,52.3),(41,'200x10',200,10,20,73.4,4336,434,76.8,57.6),(42,'200x11',200,11,22,80,4667,467,76.4,62.8),(43,'200x12',200,12,24,86.5,4980,498,75.9,67),(44,'200x13',200,13,26,92.9,4685,527,75.4,72.9),(45,'200x14',200,14,28,99.2,4408,554,74.9,77.9),(46,'250x8',250,8,16,75.8,7315,585,98.2,59.5),(47,'250x9',250,9,18,84.7,8092,647,97.8,66.5),(48,'250x10',250,10,20,93.4,8840,707,97.3,73.3),(49,'250x11',250,11,22,102,9559,765,96.8,80.1),(50,'250x12',250,12,24,111,10251,820,96.3,86.8),(51,'250x13',250,13,26,119,10917.001,872,95.8,93.4),(52,'250x14',250,14,28,127,11550.001,924,95.3,99.8),(53,'300x8',300,8,16,89.9,12812,846,119.4,70.5),(54,'300x9',300,9,18,101,14302.001,949,119,79.3),(55,'300x10',300,10,20,113,15712.001,1047,117.9,89),(56,'300x11',300,11,22,124,17080,1139,117.4,97.3),(57,'300x12',300,12,24,135,18330,1222,116.5,106),(58,'300x13',300,13,26,145,19580,1309,116.2,113.8),(59,'300x14',300,14,28,155,20784.002,1386,115.8,122);
/*!40000 ALTER TABLE `hollow_square_gost30245_94` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `i_profile_gost19425_74`
--

DROP TABLE IF EXISTS `i_profile_gost19425_74`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `i_profile_gost19425_74` (
  `id` int NOT NULL AUTO_INCREMENT,
  `profileNumber` varchar(255) DEFAULT NULL,
  `height_h_mm` int DEFAULT NULL,
  `breadth_b_mm` int DEFAULT NULL,
  `webThick_s_mm` double DEFAULT NULL,
  `flangeThick_t_mm` double DEFAULT NULL,
  `insideRadius_r1_mm` double DEFAULT NULL,
  `outsideRadius_r2_mm` double DEFAULT NULL,
  `area_A_sm^2` double DEFAULT NULL,
  `weightPerLength_P_kg/m` double DEFAULT NULL,
  `secondMomentAboutYAxis_Iy_sm^4` int DEFAULT NULL,
  `sectionModulusAboutYAxis_Wy_sm^3` int DEFAULT NULL,
  `radiusOfGyrationYAxis_iy_mm` double DEFAULT NULL,
  `firstMomentAboutYAxes_Sy_sm^3` double DEFAULT NULL,
  `secondMomentAboutZAxis_Iz_sm^4` double DEFAULT NULL,
  `sectionModulusAboutZAxis_Wz_sm^3` double DEFAULT NULL,
  `radiusOfGyrationZAxis_iz_mm` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `i_profile_gost19425_74`
--

LOCK TABLES `i_profile_gost19425_74` WRITE;
/*!40000 ALTER TABLE `i_profile_gost19425_74` DISABLE KEYS */;
INSERT INTO `i_profile_gost19425_74` VALUES (1,'14C',140,80,5.5,9.1,7.5,3.8,21.5,16.9,712,102,57.5,58.4,64.8,16.2,17.4),(2,'18M',180,90,7,12,9,3.5,32.9,25.8,1760,196,73.2,113,130,28.9,19.9),(3,'20C',200,100,7,11.4,9,4.5,35.6,27.9,2370,237,81.6,136,159,31.8,21.1),(4,'20Ca',200,102,9,11.4,9,4.5,39.6,31.1,2500,250,79.5,146,170,33.3,20.7),(5,'22C',220,110,7.5,12.3,9.5,4.8,42.1,33.1,3400,310,90,178,228,41.5,23.2),(6,'24M',240,110,8.2,14,10.5,4,48.7,38.3,4640,387,97.5,223,276,50.2,23.8),(7,'27C',270,122,8.5,13.7,10.5,5.3,51.5,42.8,6550,485,110,279,346,56.7,25.2),(8,'27Ca',270,124,10.5,13.7,10.5,5.3,59.9,47,6870,507,107,297,366,59,24.7),(9,'30M',300,130,9,15,12,6,64,50.2,9500,633,122,364,480,73.9,27.4),(10,'36M',360,130,9.5,16,14,6,73.8,57.9,15340,852,144,493,518,79.7,26.5),(11,'36C',350,140,11,15.8,12,6,90.9,71.3,17360,964,138,574,618,88.3,26.1),(12,'45M',450,150,10.5,18,16,7,98.8,77.6,31900,1420,180,821,892,119,30);
/*!40000 ALTER TABLE `i_profile_gost19425_74` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `i_profile_gost8239_89`
--

DROP TABLE IF EXISTS `i_profile_gost8239_89`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `i_profile_gost8239_89` (
  `id` int NOT NULL AUTO_INCREMENT,
  `profile_number` varchar(255) DEFAULT NULL,
  `height` int DEFAULT NULL,
  `breadth` int DEFAULT NULL,
  `web_thick` float DEFAULT NULL,
  `flange_thick` float DEFAULT NULL,
  `inside_radius` float DEFAULT NULL,
  `outside_radius` float DEFAULT NULL,
  `area` float DEFAULT NULL,
  `weight_per_length` float DEFAULT NULL,
  `second_moment_aboutyaxis` float DEFAULT NULL,
  `section_modulus_aboutyaxis` float DEFAULT NULL,
  `radius_of_gyrationyaxis` float DEFAULT NULL,
  `first_moment_aboutyaxis` float DEFAULT NULL,
  `second_moment_aboutzaxis` float DEFAULT NULL,
  `section_modulus_aboutzaxis` float DEFAULT NULL,
  `radius_of_gyrationzaxis` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `i_profile_gost8239_89`
--

LOCK TABLES `i_profile_gost8239_89` WRITE;
/*!40000 ALTER TABLE `i_profile_gost8239_89` DISABLE KEYS */;
INSERT INTO `i_profile_gost8239_89` VALUES (1,'10',100,55,4.5,7.2,7,2.5,12,9.46,198,39.7,40.6,23,17.9,6.49,12.2),(2,'12',120,64,4.8,7.3,7.5,3,14.7,11.5,350,58.4,48.8,33.7,27.9,8.72,13.8),(3,'14',140,73,4.9,7.5,8,3,17.4,13.7,572,81.7,57.3,46.8,41.9,11.5,15.5),(4,'16',160,81,5,7.8,8.5,3.5,20.2,15.9,873,109,65.7,62.3,58.6,14.5,17),(5,'18',180,90,5.1,8.1,9,3.5,23.4,18.4,1290,143,74.2,81.4,82.6,18.4,18.8),(6,'20',200,100,5.2,8.4,9.5,4,26.8,21,1840,184,82.8,104,115,23.1,20.7),(7,'22',220,110,5.4,8.7,10,4,30.6,24,2550,232,91.3,131,157,28.6,22.7),(8,'24',240,115,5.6,9.5,10.5,4,34.8,27.3,3460,289,99.7,163,198,34.5,23.7),(9,'27',270,125,6,9.8,11,4.5,40.2,31.5,5010,371,112,210,260,41.5,25.4),(10,'30',300,135,6.5,10.2,12,5,46.5,36.5,7080,472,123,268,337,49.9,26.9),(11,'33',330,140,7,11.2,13,5,53.8,42.2,9840,597,135,339,419,59.9,27.9),(12,'36',360,145,7.5,12.3,14,6,61.9,48.6,13380,743,147,423,516,71.1,28.9),(13,'40',400,155,8.3,13,15,6,72.6,57,19062,953,162,545,667,86.1,30.3),(14,'45',450,160,9,14.2,16,7,84.7,66.5,27696,1231,181,708,808,101,30.9),(15,'50',500,170,10,15.2,17,7,100,78.5,39727,1589,199,919,1043,123,32.3),(16,'55',550,180,11,16.5,18,7,118,92.6,55962,2035,218,1181,1356,151,33.9),(17,'60',600,190,12,17.8,20,8,138,108,76806,2560,236,1491,1725,182,35.4);
/*!40000 ALTER TABLE `i_profile_gost8239_89` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `steel_name`
--

DROP TABLE IF EXISTS `steel_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `steel_name` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `steel_name`
--

LOCK TABLES `steel_name` WRITE;
/*!40000 ALTER TABLE `steel_name` DISABLE KEYS */;
INSERT INTO `steel_name` VALUES (1,'S235'),(2,'S245'),(3,'S255'),(4,'S275'),(5,'S285'),(6,'S295'),(7,'S325'),(8,'S345'),(9,'S345K'),(10,'S355'),(11,'S375'),(12,'S390'),(13,'S390K'),(14,'S420'),(15,'S440'),(16,'S460'),(17,'S490');
/*!40000 ALTER TABLE `steel_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `steel_resist`
--

DROP TABLE IF EXISTS `steel_resist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `steel_resist` (
  `id` int NOT NULL,
  `steel_id` int NOT NULL,
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
  PRIMARY KEY (`id`),
  KEY `steel_id` (`steel_id`) /*!80000 INVISIBLE */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `steel_resist`
--

LOCK TABLES `steel_resist` WRITE;
/*!40000 ALTER TABLE `steel_resist` DISABLE KEYS */;
INSERT INTO `steel_resist` VALUES (1,1,2,20,235,360,235,360,230,350,230,350),(2,1,20.1,40,225,360,225,360,220,350,220,350),(3,1,40.1,100,215,360,NULL,NULL,210,350,NULL,NULL),(4,1,100.1,200,195,360,NULL,NULL,190,350,NULL,NULL),(5,2,2,20,245,370,245,370,240,360,240,360),(6,2,20.1,30,NULL,NULL,235,370,NULL,NULL,230,360),(7,3,2,3.9,255,380,NULL,NULL,250,370,NULL,NULL),(8,3,4,10,245,370,255,380,240,360,250,370),(9,3,10.1,20,245,370,245,370,240,360,240,360),(10,3,20.1,40,235,370,235,370,230,360,230,360),(11,4,2,10,275,380,275,390,270,370,270,380),(12,4,10.1,20,265,370,275,380,260,360,270,370),(13,5,2,3.9,285,390,NULL,NULL,280,380,NULL,NULL),(14,5,4,10,275,390,285,400,270,380,280,390),(15,5,10.1,20,265,380,275,390,260,370,270,380),(16,6,2,100,295,430,295,430,285,420,285,420),(17,7,10,20,325,470,325,470,315,460,315,460),(18,7,20.1,40,305,460,305,460,300,450,300,450),(19,7,40.1,60,285,450,NULL,NULL,280,440,NULL,NULL),(20,7,60.1,80,275,440,NULL,NULL,270,430,NULL,NULL),(21,7,80.1,100,265,430,NULL,NULL,260,420,NULL,NULL),(22,8,2,10,345,490,345,490,335,480,335,480),(23,8,10.1,20,325,470,325,470,315,460,315,460),(24,8,20.1,40,305,460,305,460,300,450,300,450),(25,9,4,10,345,470,345,470,335,460,335,460),(26,10,8,50,355,450,NULL,NULL,350,440,NULL,NULL),(27,11,2,10,375,510,375,510,365,500,365,500),(28,11,10.1,20,355,490,355,490,345,480,345,480),(29,11,20.1,40,335,480,335,480,325,470,325,470),(30,12,4,50,390,540,NULL,NULL,380,530,NULL,NULL),(31,13,4,30,390,540,NULL,NULL,380,530,NULL,NULL),(32,14,4,16,420,540,NULL,NULL,410,530,NULL,NULL),(33,14,16.1,40,400,530,NULL,NULL,390,515,NULL,NULL),(34,14,40.1,63,390,530,NULL,NULL,380,515,NULL,NULL),(35,14,63.1,80,370,520,NULL,NULL,360,505,NULL,NULL),(36,15,4,30,440,590,NULL,NULL,430,575,NULL,NULL),(37,15,30.1,50,410,570,NULL,NULL,400,555,NULL,NULL),(38,16,4,16,460,570,NULL,NULL,445,555,NULL,NULL),(39,16,16.1,40,440,560,NULL,NULL,430,545,NULL,NULL),(40,16,40.1,63,430,560,NULL,NULL,420,545,NULL,NULL),(41,16,63.1,80,410,540,NULL,NULL,400,530,NULL,NULL),(42,17,8,50,490,590,NULL,NULL,475,575,NULL,NULL);
/*!40000 ALTER TABLE `steel_resist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `u_profile_gost8240_89_parallel_flange`
--

DROP TABLE IF EXISTS `u_profile_gost8240_89_parallel_flange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `u_profile_gost8240_89_parallel_flange` (
  `id` int DEFAULT NULL,
  `profileNumber` varchar(255) DEFAULT NULL,
  `height_h_mm` int DEFAULT NULL,
  `breadth_b_mm` int DEFAULT NULL,
  `webThick_s_mm` double DEFAULT NULL,
  `flangeThick_t_mm` double DEFAULT NULL,
  `insideRadius_r1_mm` double DEFAULT NULL,
  `outsideRadius_r2_mm` double DEFAULT NULL,
  `area_A_sm^2` double DEFAULT NULL,
  `weightPerLength_P_kg/m` double DEFAULT NULL,
  `secondMomentAboutYAxis_Iy_sm^4` double DEFAULT NULL,
  `sectionModulusAboutYAxis_Wy_sm^3` double DEFAULT NULL,
  `radiusOfGyrationYAxis_iy_mm` double DEFAULT NULL,
  `firstMomentAboutYAxes_Sy_sm^3` double DEFAULT NULL,
  `secondMomentAboutZAxis_Iz_sm^4` double DEFAULT NULL,
  `sectionModulusAboutZAxis_Wz_sm^3` double DEFAULT NULL,
  `radiusOfGyrationZAxis_iz_mm` double DEFAULT NULL,
  `lengthToCenterOfWeight_y0_mm` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `u_profile_gost8240_89_parallel_flange`
--

LOCK TABLES `u_profile_gost8240_89_parallel_flange` WRITE;
/*!40000 ALTER TABLE `u_profile_gost8240_89_parallel_flange` DISABLE KEYS */;
INSERT INTO `u_profile_gost8240_89_parallel_flange` VALUES (1,'5П',50,32,4.4,7,6,3.5,6.16,4.84,22.8,9.1,19.2,5.61,5.95,2.99,9.8,12.1),(2,'6.5П',65,36,4.4,7.2,6,3.5,7.51,5.9,48.8,15,25.5,9.02,9.35,4.06,11.2,12.9),(3,'8П',80,40,4.5,7.4,6.5,3.5,8.98,7.05,89.9,22.5,31.6,13.3,13.9,3.31,12.4,13.8),(4,'10П',100,46,4.5,7.6,7,4,10.9,8.59,175,34.9,39.9,20.5,22.6,7.37,14.4,15.3),(5,'12П',120,52,4.8,7.8,7.5,4.5,13.3,10.4,305,50.8,47.9,29.7,34.9,9.84,16.2,16.6),(6,'14П',140,58,4.9,8.1,8,4.5,15.6,12.3,493,70.4,56.1,40.9,51.5,12.9,18.1,18.2),(7,'16П',160,64,5,8.4,8.5,5,18.1,14.2,750,93.8,64.4,54.3,72.8,16.4,20,19.7),(8,'16аП',160,68,5,9,8.5,5,19.5,15.3,827,103,65.1,59.5,90.5,19.6,21.5,21.9),(9,'18П',180,70,5.1,8.7,9,5,20.7,16.3,1090,121,72.6,70,100,20.6,22,21.4),(10,'18аП',180,74,5.1,9.3,9,5,22.2,17.4,1200,133,73.4,76.3,123,24.3,23.5,23.6),(11,'20П',200,76,5.2,9,9.5,5.5,23.4,18.4,1530,153,80.8,88,134,25.2,23.9,23),(12,'22П',220,82,5.4,9.5,10,6,26.7,21,2120,193,89,111,178,31,25.8,24.7),(13,'24П',240,90,5.6,10,10.5,6,30.6,24,2910,243,97.5,139,248,39.5,28.5,27.2),(14,'27П',270,95,6,10.5,11,6.5,35.2,27.7,4180,310,109,178,314,46.7,29.9,27.8),(15,'30П',300,100,6.5,11,12,7,40.5,31.8,5830,389,120,224,393,54.8,31.2,28.3),(16,'33П',330,105,7,11.7,13,7.5,46.5,36.5,8010.8,486,131,281,491,64.6,32.5,29),(17,'36П',360,110,7.5,12.6,14,8.5,53.4,41.9,10850.001,603,143,350,611,76.3,33.8,29.9),(18,'40П',400,115,8,13.5,15,9,61.5,48.3,15260.001,763,158,445,760,89.9,35.1,30.5);
/*!40000 ALTER TABLE `u_profile_gost8240_89_parallel_flange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `u_profile_gost8240_89_slope_flange`
--

DROP TABLE IF EXISTS `u_profile_gost8240_89_slope_flange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `u_profile_gost8240_89_slope_flange` (
  `id` int DEFAULT NULL,
  `profileNumber` varchar(255) DEFAULT NULL,
  `height_h_mm` int DEFAULT NULL,
  `breadth_b_mm` int DEFAULT NULL,
  `webThick_s_mm` double DEFAULT NULL,
  `flangeThick_t_mm` double DEFAULT NULL,
  `insideRadius_r1_mm` double DEFAULT NULL,
  `outsideRadius_r2_mm` double DEFAULT NULL,
  `area_A_sm^2` double DEFAULT NULL,
  `weightPerLength_P_kg/m` double DEFAULT NULL,
  `secondMomentAboutYAxis_Iy_sm^4` double DEFAULT NULL,
  `sectionModulusAboutYAxis_Wy_sm^3` double DEFAULT NULL,
  `radiusOfGyrationYAxis_iy_mm` double DEFAULT NULL,
  `firstMomentAboutYAxes_Sy_sm^3` double DEFAULT NULL,
  `secondMomentAboutZAxis_Iz_sm^4` double DEFAULT NULL,
  `sectionModulusAboutZAxis_Wz_sm^3` double DEFAULT NULL,
  `radiusOfGyrationZAxis_iz_mm` double DEFAULT NULL,
  `lengthToCenterOfWeight_y0_mm` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `u_profile_gost8240_89_slope_flange`
--

LOCK TABLES `u_profile_gost8240_89_slope_flange` WRITE;
/*!40000 ALTER TABLE `u_profile_gost8240_89_slope_flange` DISABLE KEYS */;
INSERT INTO `u_profile_gost8240_89_slope_flange` VALUES (1,'5',50,32,4.4,7,6,2.5,6.16,4.84,22.8,9.1,19.2,5.59,5.61,2.75,9.5,11.6),(2,'6.5',65,36,4.4,7.2,6,2.5,7.51,5.9,48.6,15,25.4,9,8.7,3.68,10.8,12.4),(3,'8',80,40,4.5,7.4,6.5,2.5,8.98,7.05,89.4,22.4,31.6,23.3,12.8,4.75,11.9,13.1),(4,'10',100,46,4.5,7.6,7,3,10.9,8.59,174,34.8,39.9,20.4,20.4,6.46,13.7,14.4),(5,'12',120,52,4.8,7.8,7.5,3,13.3,10.4,304,50.6,47.8,29.6,31.2,8.52,15.3,15.4),(6,'14',140,58,4.9,8.1,8,3,15.6,12.3,491,70.2,56,40.8,45.4,11,17,16.7),(7,'16',160,64,5,8.4,8.5,3.5,18.1,14.2,747,93.4,64.2,54.1,63.3,13.8,18.7,18),(8,'16a',160,68,5,9,8.5,3.5,19.5,15.3,823,103,64.9,59.4,78.8,16.4,20.1,20),(9,'18',180,70,5.1,8.7,9,3.5,20.7,16.3,1090,121,72.4,69.8,86,17,20.4,19.4),(10,'18a',180,74,5.1,9.3,9,3.5,22.2,17.4,1190,132,73.2,76.1,105,20,21.8,21.3),(11,'20',200,76,5.2,9,9.5,4,23.4,18.4,1520,152,80.7,87.8,113,20.5,22,20.7),(12,'22',220,82,5.4,9.5,10,4,26.7,21,2110,192,88.9,110,151,25.1,23.7,22.1),(13,'24',240,90,5.6,10,10.5,4,30.6,24,2900,242,97.3,139,208,31.6,26,24.2),(14,'27',270,95,6,10.5,11,4.5,35.2,27.7,4160,308,109,178,262,37.3,27.3,24.7),(15,'30',300,100,6.5,11,12,5,40.5,31.8,5810,387,120,224,327,43.6,28.4,25.2),(16,'33',330,105,7,11.7,13,5,46.5,36.5,7980,484,131,281,410,51.8,29.7,25.9),(17,'36',360,110,7.5,12.6,14,6,53.4,41.9,10820.001,601,142,350,513,61.7,31,26.8),(18,'40',400,115,8,13.5,15,6,61.5,48.3,15220.001,761,157,444,642,73.4,32.3,27.5);
/*!40000 ALTER TABLE `u_profile_gost8240_89_slope_flange` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-25 17:50:22
