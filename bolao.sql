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
  PRIMARY KEY (`id`),
  KEY `FK_95ripmjkvupiqviq4d97q2i99` (`admin_id`),
  KEY `FK_m9jbjgddpfmklfa40eidlirh8` (`campeonato_id`),
  CONSTRAINT `FK_m9jbjgddpfmklfa40eidlirh8` FOREIGN KEY (`campeonato_id`) REFERENCES `campeonato` (`id`),
  CONSTRAINT `FK_95ripmjkvupiqviq4d97q2i99` FOREIGN KEY (`admin_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bolao`
--

LOCK TABLES `bolao` WRITE;
/*!40000 ALTER TABLE `bolao` DISABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracao`
--

LOCK TABLES `configuracao` WRITE;
/*!40000 ALTER TABLE `configuracao` DISABLE KEYS */;
INSERT INTO `configuracao` VALUES (1,0,120,'2014-06-22 15:14:50',50,120,'2014-06-22 15:14:50',32);
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
INSERT INTO `estadio` VALUES (1,0,'Rio de Janeiro','2014-06-22 15:56:43','Maracanã','Rio de Janeiro','2014-06-22 15:56:43',1),(2,0,'São Paulo','2014-06-22 15:58:15','Itaquerão','São Paulo','2014-06-22 15:58:15',1),(3,0,'Natal','2014-06-22 15:59:01','Arena das Dunas','Rio Grande do Norte','2014-06-22 15:59:01',1),(4,0,'Fortaleza','2014-06-22 15:59:32','Castelão','Ceará','2014-06-22 15:59:32',1),(5,0,'Manaus','2014-06-22 16:00:51','Arena Amazônia','Amazônia','2014-06-22 16:00:51',1),(6,0,'Recife','2014-06-22 16:01:43','Arena Pernambuco','Pernambuco','2014-06-22 16:01:43',1),(7,0,'Brasília','2014-06-22 16:02:37','Mané Garrincha (Brasília)','Brasília','2014-06-22 16:02:37',1),(8,0,'Salvador','2014-06-22 16:02:58','Fonte Nova','Bahia','2014-06-22 16:02:58',1),(9,0,'Cuiabá','2014-06-22 16:03:27','Arena Pantanal','Mato Grosso','2014-06-22 16:03:27',1),(10,0,'Porto Alegre','2014-06-22 16:03:57','Beira Rio','Rio Grande do Sul','2014-06-22 16:03:57',1),(11,0,'Curitiba','2014-06-22 16:06:53','Arena da Baixada','Paraná','2014-06-22 16:06:53',1),(12,0,'Belo Horizonte','2014-06-22 16:07:27','Mineirão','Minas Gerais','2014-06-22 16:07:27',1);
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
  PRIMARY KEY (`id`),
  KEY `FK_tgxx9spsyxl9krm3i77h0vw07` (`campeonato_id`),
  KEY `FK_39gjtyqv764r2121vuvs9rg89` (`time1_id`),
  KEY `FK_dfj69df7wwbe413abchfo35yb` (`time2_id`),
  KEY `FK_ek8opt6kkcgecvw2kmk1bmu2n` (`estadio_id`),
  CONSTRAINT `FK_39gjtyqv764r2121vuvs9rg89` FOREIGN KEY (`time1_id`) REFERENCES `time` (`id`),
  CONSTRAINT `FK_dfj69df7wwbe413abchfo35yb` FOREIGN KEY (`time2_id`) REFERENCES `time` (`id`),
  CONSTRAINT `FK_ek8opt6kkcgecvw2kmk1bmu2n` FOREIGN KEY (`estadio_id`) REFERENCES `estadio` (`id`),
  CONSTRAINT `FK_tgxx9spsyxl9krm3i77h0vw07` FOREIGN KEY (`campeonato_id`) REFERENCES `campeonato` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
INSERT INTO `jogo` VALUES (1,1,1,'2014-06-12 17:00:00','2014-06-22 16:17:49','1ª Fase','',1,'2014-06-22 16:19:09',3,1,1,3,2);
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
INSERT INTO `pais` VALUES (1,0,'BR','2014-05-21 17:10:41','Brasil','Brazil.png','2014-05-21 17:10:41'),(2,0,'AR','2014-05-21 17:10:59','Argentina','Argentina.png','2014-05-21 17:10:59'),(3,0,'AU','2014-05-21 17:11:13','Austrália','Australia.png','2014-05-21 17:11:13'),(4,0,'CL','2014-05-21 17:11:29','Chile','Chile.png','2014-05-21 17:11:29'),(5,0,'CN','2014-05-21 17:11:42','China','China.png','2014-05-21 17:11:42'),(6,0,'DE','2014-05-21 17:12:01','Alemanha','Germany.png','2014-05-21 17:12:01'),(7,0,'FR','2014-05-21 17:12:19','França','France.png','2014-05-21 17:12:19'),(8,0,'GB','2014-05-21 17:12:39','Grã Betanhã','United Kingdom(Great Britain).png','2014-05-21 17:12:39'),(9,0,'HK','2014-05-21 17:12:52','Hong Kong','Hong Kong.png','2014-05-21 17:12:52'),(10,0,'JP','2014-05-21 17:13:06','Japão','japan.png','2014-05-21 17:13:06'),(11,0,'KR','2014-05-21 17:13:27','Coréia do Sul','South Korea.png','2014-05-21 17:13:27'),(12,0,'PY','2014-05-21 17:13:45','Paraguai','Paraguay.png','2014-05-21 17:13:45'),(13,0,'US','2014-05-21 17:13:57','Estados Unidos','United States Minor Outlying.png','2014-05-21 17:13:57');
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
  `finalizado` bit(1) NOT NULL,
  `jogo_id` bigint(20) NOT NULL,
  `last_updated` datetime NOT NULL,
  `scoretime1` int(11) NOT NULL,
  `scoretime2` int(11) NOT NULL,
  `usuario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sj2ds87lshqfmehhb1qf7r116` (`jogo_id`),
  KEY `FK_bie7niiowiyxxgu5jy6hvievn` (`usuario_id`),
  CONSTRAINT `FK_bie7niiowiyxxgu5jy6hvievn` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK_sj2ds87lshqfmehhb1qf7r116` FOREIGN KEY (`jogo_id`) REFERENCES `jogo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `palpite`
--

LOCK TABLES `palpite` WRITE;
/*!40000 ALTER TABLE `palpite` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regra`
--

LOCK TABLES `regra` WRITE;
/*!40000 ALTER TABLE `regra` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,0,1,'2014-06-22 15:15:46','Brasil','Brazil.png','2014-06-22 15:15:46'),(2,0,1,'2014-06-22 15:16:03','Camarões','Cameroon.png','2014-06-22 15:16:03'),(3,0,1,'2014-06-22 15:16:21','Croácia','Croatia.png','2014-06-22 15:16:21'),(4,0,1,'2014-06-22 15:16:44','México','Mexico.png','2014-06-22 15:16:44'),(5,0,1,'2014-06-22 15:16:55','Austrália','Australia.png','2014-06-22 15:16:55'),(6,0,1,'2014-06-22 15:17:03','Chile','Chile.png','2014-06-22 15:17:03'),(7,0,1,'2014-06-22 15:17:13','Espanha','Spain.png','2014-06-22 15:17:13'),(8,0,1,'2014-06-22 15:17:28','Holanda','Netherlands.png','2014-06-22 15:17:28'),(9,0,1,'2014-06-22 15:17:40','Colômbia','Colombia.png','2014-06-22 15:17:40'),(10,0,1,'2014-06-22 15:17:50','Costa do Marfim','Cote d\'Ivoire.png','2014-06-22 15:17:50'),(11,0,1,'2014-06-22 15:18:05','Grécia','Greece.png','2014-06-22 15:18:05'),(12,0,1,'2014-06-22 15:18:17','Japão','Japan.png','2014-06-22 15:18:17'),(13,0,1,'2014-06-22 15:18:31','Costa Rica','Costa-Rica.png','2014-06-22 15:18:31'),(14,0,1,'2014-06-22 15:18:46','Inglaterra','England.png','2014-06-22 15:18:46'),(15,0,1,'2014-06-22 15:18:54','Itália','Italy.png','2014-06-22 15:18:54'),(16,0,1,'2014-06-22 15:19:03','Uruguai','Uruguay.png','2014-06-22 15:19:03'),(17,0,1,'2014-06-22 15:19:24','Equador','Ecuador.png','2014-06-22 15:19:24'),(18,0,1,'2014-06-22 15:19:46','França','France.png','2014-06-22 15:19:46'),(19,0,1,'2014-06-22 15:20:12','Honduras','Honduras.png','2014-06-22 15:20:12'),(20,0,1,'2014-06-22 15:20:30','Suiça','Switzerland.png','2014-06-22 15:20:30'),(21,0,1,'2014-06-22 15:20:53','Argentina','Argentina.png','2014-06-22 15:20:53'),(22,0,1,'2014-06-22 15:21:26','Bósnia e Herzegovina','Bosnia & Herzegovina.png','2014-06-22 15:21:26'),(23,0,1,'2014-06-22 15:21:47','Irã','Iran.png','2014-06-22 15:21:47'),(24,0,1,'2014-06-22 15:22:05','Nigéria','Nigeria.png','2014-06-22 15:22:05'),(25,0,1,'2014-06-22 15:23:03','Alemanha','Germany.png','2014-06-22 15:23:03'),(26,0,1,'2014-06-22 15:23:22','Portugal','Portugal.png','2014-06-22 15:23:22'),(27,0,1,'2014-06-22 15:23:45','Gana','Ghana.png','2014-06-22 15:23:45'),(28,0,1,'2014-06-22 15:24:05','Estados Unidos','United States of America (USA).png','2014-06-22 15:24:05'),(29,0,1,'2014-06-22 15:24:26','Bélgica','Belgium.png','2014-06-22 15:24:26'),(30,0,1,'2014-06-22 15:24:46','Argélia','Algeria.png','2014-06-22 15:24:46'),(31,0,1,'2014-06-22 15:25:07','Rússia','Russian Federation.png','2014-06-22 15:25:07'),(32,0,1,'2014-06-22 15:25:52','Coréia do Sul','South Korea.png','2014-06-22 15:25:52');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,0,'\0','\0','liunit@gmail.com','','noronha.jpg','$2a$10$6Cb9mmGB7aoY8iY5VDIPi.WBQ4DmzgJ58ze6BACWJC3VLE5OdDYyC','\0','Luiz','Marques','marques'),(2,0,'\0','\0','liunit@gmail.com','','liu_vo2.jpg','$2a$10$4OKfdHpFLPmIfpYHu.KMA.nBKfzUKZmGhm.4MdEVs3DQZslm63Gty','\0','Administrador',NULL,'admin');
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
  CONSTRAINT `FK_s1c4niohr4gs3mtm4fa756sd9` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK_h6598s85gpsxxfpjtw9da6bpl` FOREIGN KEY (`bolao_id`) REFERENCES `bolao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_bolao`
--

LOCK TABLES `usuario_bolao` WRITE;
/*!40000 ALTER TABLE `usuario_bolao` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_regra`
--

LOCK TABLES `usuario_regra` WRITE;
/*!40000 ALTER TABLE `usuario_regra` DISABLE KEYS */;
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

-- Dump completed on 2014-06-22 16:29:41
