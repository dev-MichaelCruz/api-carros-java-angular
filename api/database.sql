-- -----------------------------------------------------
-- Schema aulas1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `aulas1` ;

-- -----------------------------------------------------
-- Schema aulas1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aulas1` ;
USE `aulas1` ;

-- -----------------------------------------------------
-- Table `aulas1`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aulas1`.`marca` (
                                                `idmarca` INT NOT NULL AUTO_INCREMENT,
                                                `nomemarca` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idmarca`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aulas1`.`carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aulas1`.`carro` (
                                                `idcarro` INT NOT NULL AUTO_INCREMENT,
                                                `nomecarro` VARCHAR(45) NOT NULL,
    `anofabricacaocarro` INT NOT NULL,
    `anomodelocarro` INT NOT NULL,
    `modelocarro` VARCHAR(45) NULL,
    `marca_idmarca` INT NOT NULL,
    PRIMARY KEY (`idcarro`),
    INDEX `fk_carro_marca_idx` (`marca_idmarca` ASC) VISIBLE,
    CONSTRAINT `fk_carro_marca`
    FOREIGN KEY (`marca_idmarca`)
    REFERENCES `aulas1`.`marca` (`idmarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aulas1`.`cor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aulas1`.`cor` (
                                              `idcor` INT NOT NULL AUTO_INCREMENT,
                                              `nomecor` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idcor`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aulas1`.`carro_cor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aulas1`.`carro_cor` (
                                                    `carro_idcarro` INT NOT NULL,
                                                    `cor_idcor` INT NOT NULL,
                                                    INDEX `fk_carro_cor_carro1_idx` (`carro_idcarro` ASC) VISIBLE,
    INDEX `fk_carro_cor_cor1_idx` (`cor_idcor` ASC) VISIBLE,
    CONSTRAINT `fk_carro_cor_carro1`
    FOREIGN KEY (`carro_idcarro`)
    REFERENCES `aulas1`.`carro` (`idcarro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carro_cor_cor1`
    FOREIGN KEY (`cor_idcor`)
    REFERENCES `aulas1`.`cor` (`idcor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;