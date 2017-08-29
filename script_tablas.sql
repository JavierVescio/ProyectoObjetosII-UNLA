-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gestion-restaurant
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gestion-restaurant
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gestion-restaurant` DEFAULT CHARACTER SET utf8 ;
USE `gestion-restaurant` ;

-- -----------------------------------------------------
-- Table `gestion-restaurant`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `imagen` VARCHAR(45) NULL,
  `habilitado` TINYINT(1) NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`bebida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`bebida` (
  `idBebida` INT NOT NULL,
  `notas` VARCHAR(45) NULL,
  INDEX `fk_id_producto_idx` (`idBebida` ASC),
  PRIMARY KEY (`idBebida`),
  CONSTRAINT `fk_id_producto`
    FOREIGN KEY (`idBebida`)
    REFERENCES `gestion-restaurant`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`plato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`plato` (
  `idPlato` INT NOT NULL,
  `notas` VARCHAR(45) NULL,
  INDEX `fk_plato_producto1_idx` (`idPlato` ASC),
  PRIMARY KEY (`idPlato`),
  CONSTRAINT `fk_plato_producto1`
    FOREIGN KEY (`idPlato`)
    REFERENCES `gestion-restaurant`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`tipoCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`tipoCliente` (
  `idTipoCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`precioProducto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`precioProducto` (
  `idPrecioProducto` INT NOT NULL AUTO_INCREMENT,
  `idProducto` INT NOT NULL,
  `idTipoCliente` INT NOT NULL,
  `precio` FLOAT NOT NULL,
  `fechaCreacion` DATETIME NULL,
  INDEX `fk_PrecioProducto_producto1_idx` (`idProducto` ASC),
  PRIMARY KEY (`idPrecioProducto`),
  INDEX `fk_precioProducto_tipoCliente1_idx` (`idTipoCliente` ASC),
  CONSTRAINT `fk_PrecioProducto_producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `gestion-restaurant`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_precioProducto_tipoCliente1`
    FOREIGN KEY (`idTipoCliente`)
    REFERENCES `gestion-restaurant`.`tipoCliente` (`idTipoCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`tipoPersonal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`tipoPersonal` (
  `idTipoPersonal` INT NOT NULL AUTO_INCREMENT,
  `tipoPersonal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoPersonal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`logIn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`logIn` (
  `idLogIn` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(45) NOT NULL,
  `enLinea` BIT(1) NOT NULL,
  PRIMARY KEY (`idLogIn`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`personal` (
  `idPersonal` INT NOT NULL,
  `idLogIn` INT NOT NULL,
  `idTipoPersonal` INT NOT NULL,
  `cuil` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`idPersonal`),
  INDEX `fk_personal_tipoDePersonal1_idx` (`idTipoPersonal` ASC),
  INDEX `fk_personal_logIn1_idx` (`idLogIn` ASC),
  CONSTRAINT `fk_personal_persona1`
    FOREIGN KEY (`idPersonal`)
    REFERENCES `gestion-restaurant`.`persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_personal_tipoDePersonal1`
    FOREIGN KEY (`idTipoPersonal`)
    REFERENCES `gestion-restaurant`.`tipoPersonal` (`idTipoPersonal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_personal_logIn1`
    FOREIGN KEY (`idLogIn`)
    REFERENCES `gestion-restaurant`.`logIn` (`idLogIn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`cliente` (
  `idCliente` INT NOT NULL,
  `idTipoCliente` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_cliente_tipoCliente1_idx` (`idTipoCliente` ASC),
  CONSTRAINT `fk_cliente_persona1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `gestion-restaurant`.`persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_tipoCliente1`
    FOREIGN KEY (`idTipoCliente`)
    REFERENCES `gestion-restaurant`.`tipoCliente` (`idTipoCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`mesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`mesa` (
  `idMesa` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idPersonal` INT NOT NULL,
  `fechaHoraInicio` DATETIME NOT NULL,
  `fechaHoraFin` DATETIME NOT NULL,
  `habitacion` VARCHAR(45) NOT NULL,
  `estado` ENUM('libre', 'ocupada', 'terminada') NOT NULL,
  PRIMARY KEY (`idMesa`),
  INDEX `fk_mesa_personal1_idx` (`idPersonal` ASC),
  INDEX `fk_mesa_cliente1_idx` (`idCliente` ASC),
  CONSTRAINT `fk_mesa_personal1`
    FOREIGN KEY (`idPersonal`)
    REFERENCES `gestion-restaurant`.`personal` (`idPersonal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mesa_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `gestion-restaurant`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`comanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`comanda` (
  `idComanda` INT NOT NULL AUTO_INCREMENT,
  `idMesa` INT NOT NULL,
  `fechaHora` DATETIME NOT NULL,
  `anulada` BIT(1) NOT NULL,
  PRIMARY KEY (`idComanda`),
  INDEX `fk_comanda_mesa1_idx` (`idMesa` ASC),
  CONSTRAINT `fk_comanda_mesa1`
    FOREIGN KEY (`idMesa`)
    REFERENCES `gestion-restaurant`.`mesa` (`idMesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`detalleComanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`detalleComanda` (
  `idDetalleComanda` INT NOT NULL AUTO_INCREMENT,
  `idComanda` INT NOT NULL,
  `idProducto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` FLOAT NOT NULL,
  `anulada` BIT(1) NOT NULL,
  PRIMARY KEY (`idDetalleComanda`),
  INDEX `fk_detalleComanda_producto1_idx` (`idProducto` ASC),
  INDEX `fk_detalleComanda_comanda1_idx` (`idComanda` ASC),
  CONSTRAINT `fk_detalleComanda_producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `gestion-restaurant`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleComanda_comanda1`
    FOREIGN KEY (`idComanda`)
    REFERENCES `gestion-restaurant`.`comanda` (`idComanda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`unidadMesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`unidadMesa` (
  `idUnidadMesa` INT NOT NULL AUTO_INCREMENT,
  `idMesa` INT NOT NULL,
  `nroMesa` INT NOT NULL COMMENT 'Si es -1, quiere decir que la unidadMesa no está siendo utilizada en ninguna mesa.',
  `cantidadMaximaComensales` INT NOT NULL DEFAULT 2,
  PRIMARY KEY (`idUnidadMesa`),
  INDEX `fk_unidadMesa_mesa1_idx` (`idMesa` ASC),
  CONSTRAINT `fk_unidadMesa_mesa1`
    FOREIGN KEY (`idMesa`)
    REFERENCES `gestion-restaurant`.`mesa` (`idMesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gestion-restaurant`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gestion-restaurant`.`ticket` (
  `idTicket` INT NOT NULL AUTO_INCREMENT,
  `idComanda` INT NOT NULL,
  `idPersonal` INT NOT NULL,
  `importeTotal` FLOAT NOT NULL,
  `fechaEmision` DATETIME NOT NULL,
  PRIMARY KEY (`idTicket`),
  INDEX `fk_ticket_comanda1_idx` (`idComanda` ASC),
  INDEX `fk_ticket_personal1_idx` (`idPersonal` ASC),
  CONSTRAINT `fk_ticket_comanda1`
    FOREIGN KEY (`idComanda`)
    REFERENCES `gestion-restaurant`.`comanda` (`idComanda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_personal1`
    FOREIGN KEY (`idPersonal`)
    REFERENCES `gestion-restaurant`.`personal` (`idPersonal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
