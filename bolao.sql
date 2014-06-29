CREATE DATABASE  IF NOT EXISTS `bolao` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bolao`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: bolao
-- ------------------------------------------------------
-- Server version	5.6.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bolao`
--

DROP TABLE IF EXISTS `bolao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bolao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `admin_id` bigint(20) NOT NULL,
  `campeonato_id` bigint(20) NOT NULL,
  `date_created` datetime NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `imagem` varchar(50) DEFAULT NULL,
  `last_updated` datetime NOT NULL,
  `informacao` longtext,
  PRIMARY KEY (`id`),
  KEY `FK_95ripmjkvupiqviq4d97q2i99` (`admin_id`),
  KEY `FK_m9jbjgddpfmklfa40eidlirh8` (`campeonato_id`),
  CONSTRAINT `FK_95ripmjkvupiqviq4d97q2i99` FOREIGN KEY (`admin_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK_m9jbjgddpfmklfa40eidlirh8` FOREIGN KEY (`campeonato_id`) REFERENCES `campeonato` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bolao`
--

LOCK TABLES `bolao` WRITE;
/*!40000 ALTER TABLE `bolao` DISABLE KEYS */;
INSERT INTO `bolao` VALUES (4,2,1,1,'2014-06-23 11:43:14','Copa 2014','fuleco-logo.jpg','2014-06-26 11:29:17','Será cobrada uma taxa de R$ 50,00 por cabeça. Só terá um ganhador, até porque tem pouca gente...... Qualquer reclamação procurar Gustavo Mendes Marques, o Cabelo. E-mail para reclamações: gustavo.marques77@hotmail.com Cel.: 996091059 - Horario para ligações: das 0:00 as 06:00.');
/*!40000 ALTER TABLE `bolao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campeonato`
--

DROP TABLE IF EXISTS `campeonato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campeonato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `date_created` datetime NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `imagem` varchar(50) DEFAULT NULL,
  `last_updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campeonato`
--

LOCK TABLES `campeonato` WRITE;
/*!40000 ALTER TABLE `campeonato` DISABLE KEYS */;
INSERT INTO `campeonato` VALUES (1,0,'2014-06-22 15:15:05','Copa do Mundo 2014','fuleco-logo.jpg','2014-06-22 15:15:05'),(2,0,'2014-06-22 15:15:19','Brasileirão 2014 Série A','35miepw.jpg','2014-06-22 15:15:19');
/*!40000 ALTER TABLE `campeonato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracao`
--

DROP TABLE IF EXISTS `configuracao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuracao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `alturaimagens` int(11) NOT NULL,
  `date_created` datetime NOT NULL,
  `itensporpagina` int(11) NOT NULL,
  `larguraimagens` int(11) NOT NULL,
  `last_updated` datetime NOT NULL,
  `tamanhoiconetimes` int(11) NOT NULL,
  `alturaimagensthumbs` int(11) DEFAULT NULL,
  `larguraimagensthumbs` int(11) DEFAULT NULL,
  `minutosparapalpite` int(11) NOT NULL DEFAULT '5',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracao`
--

LOCK TABLES `configuracao` WRITE;
/*!40000 ALTER TABLE `configuracao` DISABLE KEYS */;
INSERT INTO `configuracao` VALUES (1,11,120,'2014-06-22 15:14:50',100,125,'2014-06-26 18:45:43',32,45,50,5);
/*!40000 ALTER TABLE `configuracao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadio`
--

DROP TABLE IF EXISTS `estadio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `date_created` datetime NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `last_updated` datetime NOT NULL,
  `pais_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descricao` (`descricao`),
  KEY `FK_4jolth3fbhg1y84i7qalqjcsa` (`pais_id`),
  CONSTRAINT `FK_4jolth3fbhg1y84i7qalqjcsa` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadio`
--

LOCK TABLES `estadio` WRITE;
/*!40000 ALTER TABLE `estadio` DISABLE KEYS */;
INSERT INTO `estadio` VALUES (1,0,'Rio de Janeiro','2014-06-22 15:56:43','Maracanã','Rio de Janeiro','2014-06-22 15:56:43',1),(2,0,'São Paulo','2014-06-22 15:58:15','Itaquerão','São Paulo','2014-06-22 15:58:15',1),(3,0,'Natal','2014-06-22 15:59:01','Arena das Dunas','Rio Grande do Norte','2014-06-22 15:59:01',1),(4,0,'Fortaleza','2014-06-22 15:59:32','Castelão','Ceará','2014-06-22 15:59:32',1),(5,0,'Manaus','2014-06-22 16:00:51','Arena Amazônia','Amazônia','2014-06-22 16:00:51',1),(6,0,'Recife','2014-06-22 16:01:43','Arena Pernambuco','Pernambuco','2014-06-22 16:01:43',1),(7,1,'Brasília','2014-06-22 16:02:37','Mané Garrincha','Brasília','2014-06-22 18:18:23',1),(8,0,'Salvador','2014-06-22 16:02:58','Fonte Nova','Bahia','2014-06-22 16:02:58',1),(9,0,'Cuiabá','2014-06-22 16:03:27','Arena Pantanal','Mato Grosso','2014-06-22 16:03:27',1),(10,0,'Porto Alegre','2014-06-22 16:03:57','Beira Rio','Rio Grande do Sul','2014-06-22 16:03:57',1),(11,0,'Curitiba','2014-06-22 16:06:53','Arena da Baixada','Paraná','2014-06-22 16:06:53',1),(12,0,'Belo Horizonte','2014-06-22 16:07:27','Mineirão','Minas Gerais','2014-06-22 16:07:27',1);
/*!40000 ALTER TABLE `estadio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo`
--

DROP TABLE IF EXISTS `jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `campeonato_id` bigint(20) NOT NULL,
  `datajogo` datetime NOT NULL,
  `date_created` datetime NOT NULL,
  `descricaofase` varchar(255) NOT NULL,
  `encerrado` bit(1) NOT NULL,
  `fase` int(11) NOT NULL,
  `last_updated` datetime NOT NULL,
  `scoretime1` int(11) NOT NULL,
  `scoretime2` int(11) NOT NULL,
  `time1_id` bigint(20) NOT NULL,
  `time2_id` bigint(20) NOT NULL,
  `estadio_id` bigint(20) DEFAULT NULL,
  `peso` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_tgxx9spsyxl9krm3i77h0vw07` (`campeonato_id`),
  KEY `FK_39gjtyqv764r2121vuvs9rg89` (`time1_id`),
  KEY `FK_dfj69df7wwbe413abchfo35yb` (`time2_id`),
  KEY `FK_ek8opt6kkcgecvw2kmk1bmu2n` (`estadio_id`),
  CONSTRAINT `FK_39gjtyqv764r2121vuvs9rg89` FOREIGN KEY (`time1_id`) REFERENCES `time` (`id`),
  CONSTRAINT `FK_dfj69df7wwbe413abchfo35yb` FOREIGN KEY (`time2_id`) REFERENCES `time` (`id`),
  CONSTRAINT `FK_ek8opt6kkcgecvw2kmk1bmu2n` FOREIGN KEY (`estadio_id`) REFERENCES `estadio` (`id`),
  CONSTRAINT `FK_tgxx9spsyxl9krm3i77h0vw07` FOREIGN KEY (`campeonato_id`) REFERENCES `campeonato` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
INSERT INTO `jogo` VALUES (1,2,1,'2014-06-12 17:00:00','2014-06-22 16:17:49','1ª Fase','',1,'2014-06-27 19:11:21',3,1,1,3,2,10),(2,1,1,'2014-06-13 13:00:00','2014-06-22 18:24:31','1ª Fase','',1,'2014-06-27 19:11:34',1,0,4,2,3,11),(3,1,1,'2014-06-13 16:00:00','2014-06-22 18:25:18','1ª Fase','',1,'2014-06-27 19:11:55',1,5,7,8,8,11),(4,1,1,'2014-06-13 19:00:00','2014-06-22 18:25:53','1ª Fase','',1,'2014-06-27 19:12:05',3,1,6,5,9,11),(5,1,1,'2014-06-14 13:00:00','2014-06-22 18:26:32','1ª Fase','',1,'2014-06-27 19:12:18',3,0,9,11,12,12),(6,1,1,'2014-06-14 16:00:00','2014-06-22 18:27:26','1ª Fase','',1,'2014-06-27 19:12:31',1,3,16,13,4,12),(7,1,1,'2014-06-14 19:00:00','2014-06-22 18:28:02','1ª Fase','',1,'2014-06-27 19:12:40',1,2,14,15,5,12),(8,1,1,'2014-06-14 22:00:00','2014-06-22 18:28:33','1ª Fase','',1,'2014-06-27 19:12:56',2,1,10,12,6,12),(9,1,1,'2014-06-15 13:00:00','2014-06-22 18:29:15','1ª Fase','',1,'2014-06-27 19:13:55',2,1,20,17,7,13),(10,1,1,'2014-06-15 16:00:00','2014-06-22 18:29:56','1ª Fase','',1,'2014-06-27 19:14:06',3,0,18,19,10,13),(11,1,1,'2014-06-15 19:00:00','2014-06-22 18:30:31','1ª Fase','',1,'2014-06-27 19:14:18',2,1,21,22,1,13),(12,1,1,'2014-06-16 13:00:00','2014-06-22 18:31:06','1ª Fase','',1,'2014-06-27 19:14:43',4,0,25,26,8,14),(13,1,1,'2014-06-16 16:00:00','2014-06-22 18:31:42','1ª Fase','',1,'2014-06-27 19:14:54',0,0,23,24,11,14),(14,1,1,'2014-06-16 19:00:00','2014-06-22 18:32:14','1ª Fase','',1,'2014-06-27 19:15:03',1,2,27,28,3,14),(15,1,1,'2014-06-17 13:00:00','2014-06-22 18:32:46','1ª Fase','',1,'2014-06-27 19:15:15',2,1,29,30,12,15),(16,1,1,'2014-06-17 16:00:00','2014-06-22 18:33:10','1ª Fase','',1,'2014-06-27 19:15:28',0,0,1,4,4,15),(17,1,1,'2014-06-17 19:00:00','2014-06-22 18:34:28','1ª Fase','',1,'2014-06-27 19:15:46',1,1,31,32,9,15),(18,1,1,'2014-06-18 13:00:00','2014-06-22 18:35:04','1ª Fase','',1,'2014-06-27 19:16:00',2,3,5,8,10,16),(19,1,1,'2014-06-18 16:00:00','2014-06-22 18:35:35','1ª Fase','',1,'2014-06-27 19:16:17',0,2,7,6,1,16),(20,1,1,'2014-06-18 19:00:00','2014-06-22 18:36:09','1ª Fase','',1,'2014-06-27 19:16:31',0,4,2,3,5,16),(21,1,1,'2014-06-19 13:00:00','2014-06-22 18:36:39','1ª Fase','',1,'2014-06-27 19:17:00',2,1,9,10,7,17),(22,2,1,'2014-06-19 16:00:00','2014-06-22 18:37:13','1ª Fase','',1,'2014-06-27 19:17:23',2,1,16,14,2,17),(23,1,1,'2014-06-19 19:00:00','2014-06-22 18:37:45','1ª Fase','',1,'2014-06-27 19:17:50',0,0,12,11,3,17),(24,1,1,'2014-06-20 13:00:00','2014-06-22 18:38:51','1ª Fase','',1,'2014-06-27 19:18:03',0,1,15,13,6,18),(25,2,1,'2014-06-20 16:00:00','2014-06-22 18:39:14','1ª Fase','',1,'2014-06-28 11:08:07',2,5,20,18,8,18),(26,1,1,'2014-06-20 19:00:00','2014-06-22 18:39:45','1ª Fase','',1,'2014-06-27 19:18:25',1,2,19,17,11,18),(27,1,1,'2014-06-21 13:00:00','2014-06-22 18:40:09','1ª Fase','',1,'2014-06-27 19:18:41',1,0,21,23,12,19),(28,1,1,'2014-06-21 16:00:00','2014-06-22 18:40:38','1ª Fase','',1,'2014-06-27 19:18:51',2,2,25,27,4,19),(29,1,1,'2014-06-21 19:00:00','2014-06-22 18:41:11','1ª Fase','',1,'2014-06-27 19:19:01',1,0,24,22,9,19),(30,1,1,'2014-06-22 13:00:00','2014-06-22 18:41:42','1ª Fase','',1,'2014-06-27 19:19:21',1,0,29,31,1,20),(31,1,1,'2014-06-22 16:00:00','2014-06-22 18:42:07','1ª Fase','',1,'2014-06-27 19:19:32',2,4,32,30,10,20),(32,2,1,'2014-06-22 19:00:00','2014-06-22 18:42:35','1ª Fase','',1,'2014-06-27 19:19:41',2,2,28,26,5,20),(33,4,1,'2014-06-23 13:00:00','2014-06-22 18:43:06','1ª Fase','',1,'2014-06-27 19:20:10',0,3,5,7,11,21),(34,3,1,'2014-06-23 13:00:00','2014-06-22 18:43:31','1ª Fase','',1,'2014-06-27 19:19:56',2,0,8,6,2,21),(35,4,1,'2014-06-23 19:00:00','2014-06-22 18:44:00','1ª Fase','',1,'2014-06-27 19:20:20',1,3,3,4,6,21),(36,5,1,'2014-06-23 17:00:00','2014-06-22 18:44:23','1ª Fase','',1,'2014-06-28 11:25:33',1,4,2,1,7,21),(37,2,1,'2014-06-24 13:00:00','2014-06-22 18:44:58','1ª Fase','',1,'2014-06-27 19:20:33',0,1,15,16,3,22),(38,3,1,'2014-06-24 13:00:00','2014-06-22 18:45:28','1ª Fase','',1,'2014-06-27 19:21:18',0,0,13,14,12,22),(39,2,1,'2014-06-24 17:00:00','2014-06-22 18:45:57','1ª Fase','',1,'2014-06-27 19:21:27',1,4,12,9,9,22),(40,2,1,'2014-06-24 17:00:00','2014-06-22 18:46:23','1ª Fase','',1,'2014-06-27 19:21:38',2,1,11,10,4,22),(41,4,1,'2014-06-25 13:00:00','2014-06-22 18:47:02','1ª Fase','',1,'2014-06-28 11:41:56',2,3,24,21,10,23),(42,2,1,'2014-06-25 13:00:00','2014-06-22 18:47:23','1ª Fase','',1,'2014-06-27 19:21:50',3,1,22,23,8,23),(43,2,1,'2014-06-25 17:00:00','2014-06-22 18:47:48','1ª Fase','',1,'2014-06-27 19:22:10',0,3,19,20,5,23),(44,2,1,'2014-06-25 17:00:00','2014-06-22 18:48:39','1ª Fase','',1,'2014-06-27 19:22:20',0,0,17,18,1,23),(45,2,1,'2014-06-26 13:00:00','2014-06-22 18:49:05','1ª Fase','',1,'2014-06-27 19:22:41',0,1,28,25,6,24),(46,2,1,'2014-06-26 13:00:00','2014-06-22 18:49:30','1ª Fase','',1,'2014-06-27 19:22:52',2,1,26,27,7,24),(47,2,1,'2014-06-26 17:00:00','2014-06-22 18:50:02','1ª Fase','',1,'2014-06-27 19:23:04',0,1,32,29,2,24),(48,2,1,'2014-06-26 17:00:00','2014-06-22 18:50:44','1ª Fase','',1,'2014-06-27 19:23:14',1,1,30,31,11,24),(49,4,1,'2014-06-28 13:00:00','2014-06-22 18:53:37','Oitavas de Final','',2,'2014-06-28 18:37:26',1,1,1,6,12,25),(50,3,1,'2014-06-28 17:00:00','2014-06-22 18:54:03','Oitavas de Final','',2,'2014-06-28 18:53:43',2,0,9,16,1,25),(51,3,1,'2014-06-29 13:00:00','2014-06-22 18:54:52','Oitavas de Final','\0',2,'2014-06-27 19:24:22',0,0,8,4,4,26),(52,2,1,'2014-06-29 17:00:00','2014-06-22 18:55:19','Oitavas de Final','\0',2,'2014-06-27 19:24:38',0,0,13,11,6,26),(53,4,1,'2014-06-30 13:00:00','2014-06-22 18:55:42','Oitavas de Final','\0',2,'2014-06-27 19:24:51',0,0,18,24,7,27),(54,2,1,'2014-06-30 17:00:00','2014-06-22 18:56:07','Oitavas de Final','\0',2,'2014-06-27 19:25:01',0,0,25,30,10,27),(55,3,1,'2014-07-01 13:00:00','2014-06-22 18:56:38','Oitavas de Final','\0',2,'2014-06-27 19:25:36',0,0,21,20,2,28),(56,2,1,'2014-07-01 17:00:00','2014-06-22 18:57:01','Oitavas de Final','\0',2,'2014-06-27 19:25:48',0,0,29,28,8,28),(57,1,1,'2014-07-04 13:00:00','2014-06-22 18:57:35','Quartas de Final','\0',3,'2014-06-27 19:26:17',0,0,33,33,1,29),(58,1,1,'2014-07-04 17:00:00','2014-06-22 18:58:02','Quartas de Final','\0',3,'2014-06-27 19:26:28',0,0,33,33,4,29),(59,1,1,'2014-07-05 13:00:00','2014-06-22 18:58:31','Quartas de Final','\0',3,'2014-06-27 19:27:03',0,0,33,33,7,30),(60,1,1,'2014-07-05 17:00:00','2014-06-22 18:58:52','Quartas de Final','\0',3,'2014-06-27 19:27:13',0,0,33,33,8,30),(61,1,1,'2014-07-08 17:00:00','2014-06-22 18:59:34','Semi-Final','\0',4,'2014-06-27 19:27:24',0,0,33,33,12,31),(62,1,1,'2014-07-09 17:00:00','2014-06-22 19:00:03','Semi-Final','\0',4,'2014-06-27 19:27:35',0,0,33,33,2,32),(63,1,1,'2014-07-12 17:00:00','2014-06-22 19:00:44','Terceiro Lugar','\0',5,'2014-06-27 19:27:48',0,0,33,33,7,33),(64,1,1,'2014-07-13 16:00:00','2014-06-22 19:01:17','Final','\0',6,'2014-06-27 19:27:57',0,0,33,33,1,34);
/*!40000 ALTER TABLE `jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `codigo` varchar(2) NOT NULL,
  `date_created` datetime NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `imagem` varchar(50) DEFAULT NULL,
  `last_updated` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ef4wmfj2gfd7yl3bsq1rwstup` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,0,'BR','2014-05-21 17:10:41','Brasil','Brazil.png','2014-05-21 17:10:41');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `palpite`
--

DROP TABLE IF EXISTS `palpite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `palpite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `date_created` datetime NOT NULL,
  `finalizado` bit(1) DEFAULT b'0',
  `jogo_id` bigint(20) NOT NULL,
  `last_updated` datetime NOT NULL,
  `scoretime1` int(11) DEFAULT NULL,
  `scoretime2` int(11) DEFAULT NULL,
  `usuariobolao_id` bigint(20) NOT NULL,
  `pontuacao` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_sj2ds87lshqfmehhb1qf7r116` (`jogo_id`),
  KEY `FK_ausi2i06ekd4amwevwp5dd3br` (`usuariobolao_id`),
  CONSTRAINT `FK_ausi2i06ekd4amwevwp5dd3br` FOREIGN KEY (`usuariobolao_id`) REFERENCES `usuario_bolao` (`id`),
  CONSTRAINT `FK_sj2ds87lshqfmehhb1qf7r116` FOREIGN KEY (`jogo_id`) REFERENCES `jogo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `palpite`
--

LOCK TABLES `palpite` WRITE;
/*!40000 ALTER TABLE `palpite` DISABLE KEYS */;
INSERT INTO `palpite` VALUES (7,6,'2014-06-26 09:58:09','',1,'2014-06-28 00:34:05',3,0,3,180),(11,3,'2014-06-26 16:51:04','',2,'2014-06-28 00:34:14',2,0,3,132),(12,1,'2014-06-26 17:30:24','',3,'2014-06-27 16:58:55',2,0,3,0),(13,2,'2014-06-26 17:30:24','',4,'2014-06-28 00:34:32',2,0,3,165),(14,2,'2014-06-26 17:30:24','',5,'2014-06-28 00:34:44',2,0,3,144),(15,1,'2014-06-26 17:30:24','',6,'2014-06-27 16:58:55',3,1,3,0),(16,1,'2014-06-26 17:30:24','',7,'2014-06-27 16:58:55',1,0,3,0),(17,1,'2014-06-26 17:30:24','',8,'2014-06-27 16:58:55',1,2,3,0),(18,1,'2014-06-26 17:30:24','',9,'2014-06-27 16:58:55',1,3,3,0),(19,2,'2014-06-26 17:30:25','',10,'2014-06-28 00:36:11',2,1,3,130),(20,2,'2014-06-26 17:30:25','',11,'2014-06-28 00:36:22',3,0,3,130),(21,2,'2014-06-26 17:30:25','',12,'2014-06-28 00:36:33',1,0,3,168),(22,1,'2014-06-26 17:30:25','',13,'2014-06-27 16:58:55',0,2,3,0),(23,2,'2014-06-26 17:30:25','',14,'2014-06-28 00:36:58',1,2,3,350),(24,2,'2014-06-26 17:30:25','',15,'2014-06-28 00:37:08',2,0,3,270),(25,1,'2014-06-26 17:30:25','',16,'2014-06-27 16:58:55',2,0,3,0),(26,1,'2014-06-26 17:30:25','',17,'2014-06-27 16:58:55',2,1,3,0),(27,2,'2014-06-26 17:30:25','',18,'2014-06-28 00:37:40',0,3,3,288),(28,1,'2014-06-26 17:30:25','',19,'2014-06-27 16:58:55',2,0,3,0),(29,2,'2014-06-26 17:30:25','',20,'2014-06-28 00:38:01',1,2,3,160),(30,2,'2014-06-26 17:30:25','',21,'2014-06-28 00:38:15',2,0,3,306),(31,2,'2014-06-26 17:30:25','',22,'2014-06-28 00:38:26',1,1,3,68),(32,1,'2014-06-26 17:30:25','',23,'2014-06-27 16:58:55',2,1,3,0),(33,1,'2014-06-26 17:30:25','',24,'2014-06-27 16:58:55',2,0,3,0),(34,2,'2014-06-26 17:30:25','',25,'2014-06-28 00:39:33',0,2,3,180),(35,2,'2014-06-26 17:30:25','',26,'2014-06-28 00:39:57',0,2,3,324),(36,2,'2014-06-26 17:30:25','',27,'2014-06-28 00:40:25',3,0,3,228),(37,1,'2014-06-26 17:30:25','',28,'2014-06-27 16:58:56',3,0,3,0),(38,1,'2014-06-26 17:30:25','',29,'2014-06-27 16:58:56',0,2,3,0),(39,2,'2014-06-26 17:30:25','',30,'2014-06-28 00:40:58',2,1,3,300),(40,1,'2014-06-26 17:30:25','',31,'2014-06-27 16:58:56',1,0,3,0),(41,1,'2014-06-26 17:30:25','',32,'2014-06-27 16:58:56',1,2,3,0),(42,3,'2014-06-26 17:30:25','',34,'2014-06-28 11:01:54',2,2,3,84),(43,2,'2014-06-26 17:30:25','',33,'2014-06-28 00:42:13',1,2,3,210),(44,3,'2014-06-26 17:30:25','',36,'2014-06-28 11:27:41',0,2,3,210),(45,2,'2014-06-26 17:30:25','',35,'2014-06-28 00:42:59',0,1,3,210),(46,3,'2014-06-26 17:30:25','',37,'2014-06-28 11:01:54',2,1,3,0),(47,1,'2014-06-26 17:30:25','',38,'2014-06-27 16:58:56',1,2,3,0),(48,2,'2014-06-26 17:30:25','',39,'2014-06-28 00:43:03',0,2,3,220),(49,1,'2014-06-26 17:30:25','',40,'2014-06-27 16:58:56',0,2,3,0),(50,2,'2014-06-26 17:30:25','',42,'2014-06-28 00:43:05',1,1,3,92),(51,3,'2014-06-26 17:30:25','',41,'2014-06-28 12:05:53',1,2,3,345),(52,2,'2014-06-26 17:30:25','',43,'2014-06-28 00:43:08',0,2,3,276),(53,1,'2014-06-26 17:30:25','',44,'2014-06-27 16:58:56',1,3,3,0),(54,4,'2014-06-26 17:33:23','',45,'2014-06-28 12:54:35',1,1,3,96),(55,2,'2014-06-26 17:33:23','',46,'2014-06-28 00:43:10',2,1,3,600),(56,3,'2014-06-26 17:33:23','',47,'2014-06-28 12:57:48',1,2,3,360),(57,1,'2014-06-26 17:33:23','',48,'2014-06-27 16:58:56',2,1,3,0),(58,2,'2014-06-26 17:33:23','\0',49,'2014-06-27 17:10:22',3,1,3,0),(59,3,'2014-06-26 17:33:23','\0',50,'2014-06-28 18:53:45',2,1,3,450),(60,2,'2014-06-26 17:33:23','\0',51,'2014-06-27 17:10:22',2,1,3,0),(61,2,'2014-06-26 17:33:23','\0',52,'2014-06-27 17:10:22',2,0,3,0),(62,2,'2014-06-26 17:33:23','\0',53,'2014-06-27 17:10:22',0,2,3,0),(63,2,'2014-06-26 17:33:23','\0',55,'2014-06-27 17:10:22',3,1,3,0),(64,1,'2014-06-27 17:01:15','\0',56,'2014-06-27 17:10:22',1,2,3,0),(65,1,'2014-06-28 17:04:20','\0',1,'2014-06-28 18:03:01',2,0,4,150),(66,1,'2014-06-28 17:05:11','\0',2,'2014-06-28 18:03:01',1,0,4,275),(67,0,'2014-06-28 17:08:48','\0',3,'2014-06-28 17:08:48',1,0,4,0),(68,1,'2014-06-28 17:08:49','\0',4,'2014-06-28 18:03:01',2,1,4,132),(69,1,'2014-06-28 17:56:27','\0',5,'2014-06-28 18:03:01',2,1,4,120),(70,0,'2014-06-28 17:56:27','\0',6,'2014-06-28 17:56:27',2,0,4,0),(71,1,'2014-06-28 18:01:49','\0',7,'2014-06-28 18:03:01',0,0,4,48),(72,1,'2014-06-28 18:01:50','\0',8,'2014-06-28 18:03:01',1,1,4,48),(73,1,'2014-06-28 18:01:50','\0',9,'2014-06-28 18:03:01',1,0,4,195),(74,1,'2014-06-28 18:01:50','\0',10,'2014-06-28 18:03:01',2,0,4,156),(75,1,'2014-06-28 18:01:50','\0',11,'2014-06-28 18:03:01',2,1,4,325),(76,1,'2014-06-28 18:01:50','\0',12,'2014-06-28 18:03:01',1,0,4,168),(77,0,'2014-06-28 18:01:50','\0',13,'2014-06-28 18:01:50',0,2,4,0),(78,0,'2014-06-28 18:01:50','\0',14,'2014-06-28 18:01:50',2,1,4,0),(79,1,'2014-06-28 18:01:50','\0',15,'2014-06-28 18:03:01',2,0,4,270),(80,0,'2014-06-28 18:01:50','\0',16,'2014-06-28 18:01:50',3,0,4,0),(81,0,'2014-06-28 18:01:50','\0',17,'2014-06-28 18:01:50',2,0,4,0),(82,1,'2014-06-28 18:01:50','\0',18,'2014-06-28 18:03:01',0,2,4,160),(83,0,'2014-06-28 18:01:50','\0',19,'2014-06-28 18:01:50',1,0,4,0),(84,1,'2014-06-28 18:01:50','\0',20,'2014-06-28 18:03:01',0,2,4,192),(85,1,'2014-06-28 18:01:50','\0',21,'2014-06-28 18:03:01',1,1,4,68),(86,0,'2014-06-28 18:01:50','\0',22,'2014-06-28 18:01:50',1,2,4,0),(87,0,'2014-06-28 18:01:50','\0',23,'2014-06-28 18:01:50',2,1,4,0),(88,0,'2014-06-28 18:01:50','\0',24,'2014-06-28 18:01:50',1,0,4,0),(89,1,'2014-06-28 18:01:50','\0',25,'2014-06-28 18:03:01',1,1,4,72),(90,1,'2014-06-28 18:01:50','\0',26,'2014-06-28 18:03:01',0,1,4,270),(91,1,'2014-06-28 18:01:50','\0',27,'2014-06-28 18:03:01',4,0,4,228),(92,0,'2014-06-28 18:01:50','\0',28,'2014-06-28 18:01:50',2,0,4,0),(93,1,'2014-06-28 18:01:50','\0',29,'2014-06-28 18:03:01',1,1,4,76),(94,1,'2014-06-28 18:01:50','\0',30,'2014-06-28 18:03:01',1,0,4,500),(95,0,'2014-06-28 18:01:50','\0',31,'2014-06-28 18:01:50',1,0,4,0),(96,0,'2014-06-28 18:01:50','\0',32,'2014-06-28 18:01:50',1,2,4,0),(97,1,'2014-06-28 18:01:50','\0',34,'2014-06-28 18:03:02',1,1,4,84),(98,1,'2014-06-28 18:01:50','\0',33,'2014-06-28 18:03:02',1,2,4,210),(99,1,'2014-06-28 18:01:50','\0',36,'2014-06-28 18:03:02',0,3,4,315),(100,1,'2014-06-28 18:01:50','\0',35,'2014-06-28 18:03:02',1,1,4,84),(101,1,'2014-06-28 18:01:50','\0',37,'2014-06-28 18:03:02',1,1,4,88),(102,1,'2014-06-28 18:01:50','\0',38,'2014-06-28 18:03:02',1,1,4,330),(103,1,'2014-06-28 18:01:50','\0',39,'2014-06-28 18:03:02',1,2,4,264),(104,0,'2014-06-28 18:01:50','\0',40,'2014-06-28 18:01:50',0,2,4,0),(105,1,'2014-06-28 18:01:50','\0',42,'2014-06-28 18:03:02',2,1,4,276),(106,1,'2014-06-28 18:01:50','\0',41,'2014-06-28 18:03:02',1,2,4,345),(107,1,'2014-06-28 18:01:50','\0',43,'2014-06-28 18:03:02',0,1,4,276),(108,0,'2014-06-28 18:01:50','\0',44,'2014-06-28 18:01:50',0,2,4,0),(109,1,'2014-06-28 18:01:50','\0',45,'2014-06-28 18:03:02',1,2,4,360),(110,1,'2014-06-28 18:01:50','\0',46,'2014-06-28 18:03:02',2,1,4,600),(111,1,'2014-06-28 18:01:50','\0',47,'2014-06-28 18:03:02',0,2,4,288),(112,0,'2014-06-28 18:01:50','\0',48,'2014-06-28 18:01:50',1,2,4,0),(113,0,'2014-06-28 18:01:50','\0',49,'2014-06-28 18:01:50',3,1,4,0),(114,1,'2014-06-28 18:01:50','\0',50,'2014-06-28 18:53:45',2,1,4,450);
/*!40000 ALTER TABLE `palpite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration_code`
--

DROP TABLE IF EXISTS `registration_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL,
  `token` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration_code`
--

LOCK TABLES `registration_code` WRITE;
/*!40000 ALTER TABLE `registration_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `registration_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regra`
--

DROP TABLE IF EXISTS `regra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `authority` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_22k1x9yv8i48fltn8mg30pknu` (`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regra`
--

LOCK TABLES `regra` WRITE;
/*!40000 ALTER TABLE `regra` DISABLE KEYS */;
INSERT INTO `regra` VALUES (1,0,'admin'),(2,0,'usuario');
/*!40000 ALTER TABLE `regra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `campeonato_id` bigint(20) NOT NULL,
  `date_created` datetime NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `imagem` varchar(50) DEFAULT NULL,
  `last_updated` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_descricao` (`campeonato_id`,`descricao`),
  CONSTRAINT `FK_raop2edng6c1pij7b96fw9m5u` FOREIGN KEY (`campeonato_id`) REFERENCES `campeonato` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,0,1,'2014-06-22 15:15:46','Brasil','Brazil.png','2014-06-22 15:15:46'),(2,0,1,'2014-06-22 15:16:03','Camarões','Cameroon.png','2014-06-22 15:16:03'),(3,0,1,'2014-06-22 15:16:21','Croácia','Croatia.png','2014-06-22 15:16:21'),(4,0,1,'2014-06-22 15:16:44','México','Mexico.png','2014-06-22 15:16:44'),(5,0,1,'2014-06-22 15:16:55','Austrália','Australia.png','2014-06-22 15:16:55'),(6,0,1,'2014-06-22 15:17:03','Chile','Chile.png','2014-06-22 15:17:03'),(7,0,1,'2014-06-22 15:17:13','Espanha','Spain.png','2014-06-22 15:17:13'),(8,0,1,'2014-06-22 15:17:28','Holanda','Netherlands.png','2014-06-22 15:17:28'),(9,0,1,'2014-06-22 15:17:40','Colômbia','Colombia.png','2014-06-22 15:17:40'),(10,0,1,'2014-06-22 15:17:50','Costa do Marfim','Cote d\'Ivoire.png','2014-06-22 15:17:50'),(11,0,1,'2014-06-22 15:18:05','Grécia','Greece.png','2014-06-22 15:18:05'),(12,0,1,'2014-06-22 15:18:17','Japão','Japan.png','2014-06-22 15:18:17'),(13,0,1,'2014-06-22 15:18:31','Costa Rica','Costa-Rica.png','2014-06-22 15:18:31'),(14,0,1,'2014-06-22 15:18:46','Inglaterra','England.png','2014-06-22 15:18:46'),(15,0,1,'2014-06-22 15:18:54','Itália','Italy.png','2014-06-22 15:18:54'),(16,0,1,'2014-06-22 15:19:03','Uruguai','Uruguay.png','2014-06-22 15:19:03'),(17,0,1,'2014-06-22 15:19:24','Equador','Ecuador.png','2014-06-22 15:19:24'),(18,0,1,'2014-06-22 15:19:46','França','France.png','2014-06-22 15:19:46'),(19,0,1,'2014-06-22 15:20:12','Honduras','Honduras.png','2014-06-22 15:20:12'),(20,0,1,'2014-06-22 15:20:30','Suiça','Switzerland.png','2014-06-22 15:20:30'),(21,0,1,'2014-06-22 15:20:53','Argentina','Argentina.png','2014-06-22 15:20:53'),(22,0,1,'2014-06-22 15:21:26','Bósnia e Herzegovina','Bosnia & Herzegovina.png','2014-06-22 15:21:26'),(23,0,1,'2014-06-22 15:21:47','Irã','Iran.png','2014-06-22 15:21:47'),(24,0,1,'2014-06-22 15:22:05','Nigéria','Nigeria.png','2014-06-22 15:22:05'),(25,0,1,'2014-06-22 15:23:03','Alemanha','Germany.png','2014-06-22 15:23:03'),(26,0,1,'2014-06-22 15:23:22','Portugal','Portugal.png','2014-06-22 15:23:22'),(27,0,1,'2014-06-22 15:23:45','Gana','Ghana.png','2014-06-22 15:23:45'),(28,0,1,'2014-06-22 15:24:05','Estados Unidos','United States of America (USA).png','2014-06-22 15:24:05'),(29,0,1,'2014-06-22 15:24:26','Bélgica','Belgium.png','2014-06-22 15:24:26'),(30,0,1,'2014-06-22 15:24:46','Argélia','Algeria.png','2014-06-22 15:24:46'),(31,0,1,'2014-06-22 15:25:07','Rússia','Russian Federation.png','2014-06-22 15:25:07'),(32,0,1,'2014-06-22 15:25:52','Coréia do Sul','South Korea.png','2014-06-22 15:25:52'),(33,0,1,'2014-06-22 18:52:47','Indefinido',NULL,'2014-06-22 18:52:47');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `account_expired` bit(1) NOT NULL,
  `account_locked` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `imagem` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `password_expired` bit(1) NOT NULL,
  `primeironome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_863n1y3x0jalatoir4325ehal` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,2,'\0','\0','liunit@gmail.com','','noronha.jpg','$2a$10$6Cb9mmGB7aoY8iY5VDIPi.WBQ4DmzgJ58ze6BACWJC3VLE5OdDYyC','\0','Luiz','Marques','marques'),(2,0,'\0','\0','liunit@gmail.com','','liu_vo2.jpg','$2a$10$4OKfdHpFLPmIfpYHu.KMA.nBKfzUKZmGhm.4MdEVs3DQZslm63Gty','\0','Administrador',NULL,'admin'),(14,0,'\0','\0','gustavo.marques77@hotmail.com','','792361-2832-in.jpg','$2a$10$C0xIThNUA7u4qLpvl4hI/uYRUYRTLBAEvpBYpnEgEaBJa0UOUYPhe','\0','Gustavo','Mendes Marques','cabelo'),(15,0,'\0','\0','ronaldomelo79@hotmail.com','','ronaldo-gordo.jpg','$2a$10$EzshNKFHc/OMzHtxBskciuFZH5/DBAjH7GYYZgitOiW0V9NkqdN0m','\0','Ronaldo','Melo','ronaldinho'),(16,0,'\0','\0','felipesale@hotmail.com','','tomando todas no Carnaval.jpg','$2a$10$5fBAAPfg2.SHAPqxw2zgreMXC77uBl/ka05g3IuyWZCLtfsmHgVzu','\0','Luiz Felipe','Souza','felipesale'),(17,0,'\0','\0','liunit@gmail.com','','dinho1.jpg','$2a$10$MZSVeH88EPwf7oOZtXYu1.lpMAt4CnzlZTOg3t3gsapFIXsV/IQ92','\0','Vinicius','Goulart Pentagna','vinicius');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_bolao`
--

DROP TABLE IF EXISTS `usuario_bolao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_bolao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bolao_id` bigint(20) NOT NULL,
  `usuario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_usuario_id` (`bolao_id`,`usuario_id`),
  KEY `FK_s1c4niohr4gs3mtm4fa756sd9` (`usuario_id`),
  CONSTRAINT `FK_h6598s85gpsxxfpjtw9da6bpl` FOREIGN KEY (`bolao_id`) REFERENCES `bolao` (`id`),
  CONSTRAINT `FK_s1c4niohr4gs3mtm4fa756sd9` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_bolao`
--

LOCK TABLES `usuario_bolao` WRITE;
/*!40000 ALTER TABLE `usuario_bolao` DISABLE KEYS */;
INSERT INTO `usuario_bolao` VALUES (3,4,1),(4,4,14),(5,4,15),(9,4,17);
/*!40000 ALTER TABLE `usuario_bolao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_regra`
--

DROP TABLE IF EXISTS `usuario_regra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_regra` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `regra_id` bigint(20) NOT NULL,
  `usuario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_usuario_id` (`regra_id`,`usuario_id`),
  KEY `FK_c9e04hk36ue2k50nb2ei9i08b` (`usuario_id`),
  CONSTRAINT `FK_c9e04hk36ue2k50nb2ei9i08b` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK_jqgkp5de6cj7xi1t62jxsydol` FOREIGN KEY (`regra_id`) REFERENCES `regra` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_regra`
--

LOCK TABLES `usuario_regra` WRITE;
/*!40000 ALTER TABLE `usuario_regra` DISABLE KEYS */;
INSERT INTO `usuario_regra` VALUES (1,1,2),(2,2,1);
/*!40000 ALTER TABLE `usuario_regra` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-28 23:56:07
