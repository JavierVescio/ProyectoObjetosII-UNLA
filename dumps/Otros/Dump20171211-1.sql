-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: gestion-restaurant
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `bebida`
--

DROP TABLE IF EXISTS `bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bebida` (
  `idBebida` int(11) NOT NULL,
  `notas` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idBebida`),
  KEY `fk_id_producto_idx` (`idBebida`),
  CONSTRAINT `fk_id_producto` FOREIGN KEY (`idBebida`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
INSERT INTO `bebida` VALUES (7,'Botella plástica 600ml'),(12,'');
/*!40000 ALTER TABLE `bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `idTipoCliente` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_cliente_tipocliente1_idx` (`idTipoCliente`),
  CONSTRAINT `fk_cliente_persona1` FOREIGN KEY (`idCliente`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_tipocliente1` FOREIGN KEY (`idTipoCliente`) REFERENCES `tipocliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,2);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comanda` (
  `idComanda` int(11) NOT NULL AUTO_INCREMENT,
  `idOcupacionMesa` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `anulada` bit(1) NOT NULL,
  PRIMARY KEY (`idComanda`),
  KEY `fk_comanda_ocupacionmesa1_idx` (`idOcupacionMesa`),
  CONSTRAINT `fk_comanda_ocupacionmesa1` FOREIGN KEY (`idOcupacionMesa`) REFERENCES `ocupacionmesa` (`idOcupacionMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
INSERT INTO `comanda` VALUES (1,1,'2017-10-02 16:25:59','\0'),(2,3,'2017-12-11 00:09:17','\0'),(3,3,'2017-12-11 00:41:30','\0'),(4,3,'2017-12-11 00:42:12','\0'),(5,3,'2017-12-11 00:54:22','\0');
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecomanda`
--

DROP TABLE IF EXISTS `detallecomanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecomanda` (
  `idDetalleComanda` int(11) NOT NULL AUTO_INCREMENT,
  `idComanda` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL,
  `anulada` bit(1) NOT NULL,
  PRIMARY KEY (`idDetalleComanda`),
  KEY `fk_detallecomanda_producto1_idx` (`idProducto`),
  KEY `fk_detallecomanda_comanda1_idx` (`idComanda`),
  CONSTRAINT `fk_detallecomanda_comanda1` FOREIGN KEY (`idComanda`) REFERENCES `comanda` (`idComanda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detallecomanda_producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecomanda`
--

LOCK TABLES `detallecomanda` WRITE;
/*!40000 ALTER TABLE `detallecomanda` DISABLE KEYS */;
INSERT INTO `detallecomanda` VALUES (1,1,6,2,200,'\0'),(2,1,7,1,60,'\0'),(3,4,6,3,200,'\0'),(4,4,7,2,60,'\0');
/*!40000 ALTER TABLE `detallecomanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `idLogIn` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `enLinea` tinyint(1) NOT NULL,
  PRIMARY KEY (`idLogIn`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'Javier','javier92',0),(2,'a','a',1),(3,'Feijoo','flaura',1);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL AUTO_INCREMENT,
  `nroMesa` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`idMesa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` VALUES (1,15,0),(2,5,0),(3,10,0),(4,20,0);
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocupacionmesa`
--

DROP TABLE IF EXISTS `ocupacionmesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocupacionmesa` (
  `idOcupacionMesa` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `idCamarero` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `cantidadComensales` int(11) NOT NULL,
  `fechaHoraInicio` datetime NOT NULL,
  `fechaHoraFin` datetime DEFAULT NULL,
  `habitacion` varchar(45) NOT NULL,
  PRIMARY KEY (`idOcupacionMesa`),
  KEY `fk_ocupacionmesa_cliente1_idx` (`idCliente`),
  KEY `fk_ocupacionmesa_camarero1_idx` (`idCamarero`),
  KEY `fk_ocupacionmesa_mesa1_idx` (`idMesa`),
  CONSTRAINT `fk_ocupacionmesa_camarero1` FOREIGN KEY (`idCamarero`) REFERENCES `personal` (`idPersonal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ocupacionmesa_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ocupacionmesa_mesa1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocupacionmesa`
--

LOCK TABLES `ocupacionmesa` WRITE;
/*!40000 ALTER TABLE `ocupacionmesa` DISABLE KEYS */;
INSERT INTO `ocupacionmesa` VALUES (1,1,2,4,3,'2017-10-02 15:18:22','2017-10-02 17:14:39',''),(2,1,2,4,3,'2017-10-02 17:08:51','2017-10-02 17:48:51',''),(3,1,2,4,2,'2017-12-10 23:01:45','2017-12-11 01:21:31','');
/*!40000 ALTER TABLE `ocupacionmesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'36086446','Javier','Vescio'),(2,'32057885','Pablo','Mouche'),(3,'16321415','Feijoo','Laura');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal` (
  `idPersonal` int(11) NOT NULL,
  `idTipoPersonal` int(11) NOT NULL,
  `idLogIn` int(11) NOT NULL,
  `cuil` varchar(11) NOT NULL,
  PRIMARY KEY (`idPersonal`),
  KEY `fk_personal_tipopersonal1_idx` (`idTipoPersonal`),
  KEY `fk_personal_login1_idx` (`idLogIn`),
  CONSTRAINT `fk_personal_login1` FOREIGN KEY (`idLogIn`) REFERENCES `login` (`idLogIn`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personal_persona1` FOREIGN KEY (`idPersonal`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personal_tipopersonal1` FOREIGN KEY (`idTipoPersonal`) REFERENCES `tipopersonal` (`idTipoPersonal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (2,1,2,'20320578855'),(3,1,3,'26163214155');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plato` (
  `idPlato` int(11) NOT NULL,
  `notas` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPlato`),
  KEY `fk_plato_producto1_idx` (`idPlato`),
  CONSTRAINT `fk_plato_producto1` FOREIGN KEY (`idPlato`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (6,'Incluye dos sobresitos de queso de rallar'),(9,'Incluye aceitunas.'),(10,'Riquisimos'),(11,'Con mucha carne'),(13,'Mmmmh');
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precioproducto`
--

DROP TABLE IF EXISTS `precioproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `precioproducto` (
  `idPrecioProducto` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) NOT NULL,
  `idTipoCliente` int(11) NOT NULL,
  `precio` float NOT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idPrecioProducto`),
  KEY `fk_PrecioProducto_producto1_idx` (`idProducto`),
  KEY `fk_precioProducto_tipoCliente1_idx` (`idTipoCliente`),
  CONSTRAINT `fk_PrecioProducto_producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_precioProducto_tipoCliente1` FOREIGN KEY (`idTipoCliente`) REFERENCES `tipocliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precioproducto`
--

LOCK TABLES `precioproducto` WRITE;
/*!40000 ALTER TABLE `precioproducto` DISABLE KEYS */;
INSERT INTO `precioproducto` VALUES (1,6,1,150,'2017-09-06 00:00:00'),(2,6,2,200,'2017-09-06 00:00:00'),(3,7,2,60,'2017-03-24 00:00:00'),(4,6,1,200,'2017-10-07 00:00:00');
/*!40000 ALTER TABLE `precioproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `imagen` varchar(45) DEFAULT NULL,
  `habilitado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (6,'Fideos a la bolognesa','Plato de fideos con salsa','-',1),(7,'Manaos','Bebida de cola','-',1),(9,'Pizza','Napolitana','',1),(10,'Ravioles','Con salsa','',1),(11,'Pastel de Papas','Riquisimo','',1),(12,'Paso de los Toros','Bebifa refrescatna','',1),(13,'Churrasco','Con ensalada','',1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `idPersonal` int(11) NOT NULL,
  `idComanda` int(11) NOT NULL,
  `importeTotal` float NOT NULL,
  `fechaEmision` datetime NOT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `fk_ticket_personal1_idx` (`idPersonal`),
  KEY `fk_ticket_comanda1_idx` (`idComanda`),
  CONSTRAINT `fk_ticket_comanda1` FOREIGN KEY (`idComanda`) REFERENCES `comanda` (`idComanda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_personal1` FOREIGN KEY (`idPersonal`) REFERENCES `personal` (`idPersonal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,2,1,460,'2017-10-02 16:44:20'),(2,2,1,460,'2017-10-02 17:14:39'),(3,2,4,720,'2017-12-11 01:21:31');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocliente`
--

DROP TABLE IF EXISTS `tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocliente` (
  `idTipoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocliente`
--

LOCK TABLES `tipocliente` WRITE;
/*!40000 ALTER TABLE `tipocliente` DISABLE KEYS */;
INSERT INTO `tipocliente` VALUES (1,'Ejecutivo'),(2,'VIP'),(4,'Popular');
/*!40000 ALTER TABLE `tipocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopersonal`
--

DROP TABLE IF EXISTS `tipopersonal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopersonal` (
  `idTipoPersonal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoPersonal`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopersonal`
--

LOCK TABLES `tipopersonal` WRITE;
/*!40000 ALTER TABLE `tipopersonal` DISABLE KEYS */;
INSERT INTO `tipopersonal` VALUES (1,'Camarero'),(2,'Seguridad'),(4,'Valet Parking');
/*!40000 ALTER TABLE `tipopersonal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadmesa`
--

DROP TABLE IF EXISTS `unidadmesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidadmesa` (
  `idUnidadMesa` int(11) NOT NULL AUTO_INCREMENT,
  `idMesa` int(11) NOT NULL,
  PRIMARY KEY (`idUnidadMesa`),
  KEY `fk_unidadmesa_mesa1_idx` (`idMesa`),
  CONSTRAINT `fk_unidadmesa_mesa1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='				';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadmesa`
--

LOCK TABLES `unidadmesa` WRITE;
/*!40000 ALTER TABLE `unidadmesa` DISABLE KEYS */;
INSERT INTO `unidadmesa` VALUES (2,3),(3,3),(4,3),(5,3);
/*!40000 ALTER TABLE `unidadmesa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-11 14:30:22
