CREATE DATABASE  IF NOT EXISTS `uni` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `uni`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: uni
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Nestor'),(2,'Jose'),(3,'Ignasi'),(4,'Pepito');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos_materias`
--

DROP TABLE IF EXISTS `alumnos_materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos_materias` (
  `idAlumno` int NOT NULL,
  `idMateria` int NOT NULL,
  PRIMARY KEY (`idAlumno`,`idMateria`),
  KEY `FK_ALUMNOS_MATERIAS_MATERIAS_idx` (`idMateria`),
  CONSTRAINT `FK_ALUMNOS_MATERIAS_ALUMNOS` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `FK_ALUMNOS_MATERIAS_MATERIAS` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos_materias`
--

LOCK TABLES `alumnos_materias` WRITE;
/*!40000 ALTER TABLE `alumnos_materias` DISABLE KEYS */;
INSERT INTO `alumnos_materias` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `alumnos_materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificaciones`
--

DROP TABLE IF EXISTS `calificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idAlumno` int DEFAULT NULL,
  `idMateria` int DEFAULT NULL,
  `nota1` varchar(45) DEFAULT NULL,
  `nota2` varchar(45) DEFAULT NULL,
  `nota3` varchar(45) DEFAULT NULL,
  `nota_final` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CALIFICACIONES_ALUMNOS_idx` (`idAlumno`),
  KEY `FK_CALIFICACIONES_MATERIAS_idx` (`idMateria`),
  CONSTRAINT `FK_CALIFICACIONES_ALUMNOS` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `FK_CALIFICACIONES_MATERIAS` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificaciones`
--

LOCK TABLES `calificaciones` WRITE;
/*!40000 ALTER TABLE `calificaciones` DISABLE KEYS */;
INSERT INTO `calificaciones` VALUES (1,1,1,'5','4','5','6'),(2,2,2,'7','7','7','7'),(3,3,3,'6','8','7','8'),(4,4,4,'3','9','9','7');
/*!40000 ALTER TABLE `calificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carreras`
--

DROP TABLE IF EXISTS `carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carreras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carreras`
--

LOCK TABLES `carreras` WRITE;
/*!40000 ALTER TABLE `carreras` DISABLE KEYS */;
INSERT INTO `carreras` VALUES (1,'Biologo'),(2,'Abogacia'),(3,'Informatico'),(4,'Ingeniero');
/*!40000 ALTER TABLE `carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catedraticos`
--

DROP TABLE IF EXISTS `catedraticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catedraticos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idCatSuplente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CAT_CAT_idx` (`idCatSuplente`),
  CONSTRAINT `FK_CAT_CAT` FOREIGN KEY (`idCatSuplente`) REFERENCES `catedraticos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catedraticos`
--

LOCK TABLES `catedraticos` WRITE;
/*!40000 ALTER TABLE `catedraticos` DISABLE KEYS */;
INSERT INTO `catedraticos` VALUES (1,'Ana',2),(2,'Jorge',3),(3,'Juancito',1);
/*!40000 ALTER TABLE `catedraticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idCatedratico` int DEFAULT NULL,
  `idSemestre` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_MATERIAS_CATEDRATICOS_idx` (`idCatedratico`),
  KEY `FK_MATERIAS_SEMESTRES_idx` (`idSemestre`),
  CONSTRAINT `FK_MATERIAS_CATEDRATICOS` FOREIGN KEY (`idCatedratico`) REFERENCES `catedraticos` (`id`),
  CONSTRAINT `FK_MATERIAS_SEMESTRES` FOREIGN KEY (`idSemestre`) REFERENCES `semestres` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (1,'Mate',1,1),(2,'Ingles',2,2),(3,'Fisica',3,3),(4,'Quimica',2,4);
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semestres`
--

DROP TABLE IF EXISTS `semestres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semestres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCarrera` int DEFAULT NULL,
  `numSemestre` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_SEMESTRES_CARRERAS_idx` (`idCarrera`),
  CONSTRAINT `FK_SEMESTRES_CARRERAS` FOREIGN KEY (`idCarrera`) REFERENCES `carreras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semestres`
--

LOCK TABLES `semestres` WRITE;
/*!40000 ALTER TABLE `semestres` DISABLE KEYS */;
INSERT INTO `semestres` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4);
/*!40000 ALTER TABLE `semestres` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-22 13:08:39
