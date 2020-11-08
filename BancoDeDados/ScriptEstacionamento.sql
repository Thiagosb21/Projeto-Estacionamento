-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema estacionamento
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema estacionamento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `estacionamento` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `estacionamento` ;

-- -----------------------------------------------------
-- Table `estacionamento`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`cliente` (
  `cpf` BIGINT NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `telefone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `estacionamento`.`estacionamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`estacionamento` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(255) NULL DEFAULT NULL,
  `nome_estacionamento` VARCHAR(255) NULL DEFAULT NULL,
  `qtdvagas` INT NOT NULL,
  `telefone_estacionamento` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `estacionamento`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`veiculo` (
  `placa` VARCHAR(255) NOT NULL,
  `cor` VARCHAR(255) NULL DEFAULT NULL,
  `modelo` VARCHAR(255) NULL DEFAULT NULL,
  `cliente_cpf` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`placa`),
  INDEX `FKfho6h76pwmaj5p4hcaodp2ye0` (`cliente_cpf` ASC) VISIBLE,
  CONSTRAINT `FKfho6h76pwmaj5p4hcaodp2ye0`
    FOREIGN KEY (`cliente_cpf`)
    REFERENCES `estacionamento`.`cliente` (`cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `estacionamento`.`vaga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`vaga` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `entrada` DATE NULL DEFAULT NULL,
  `saida` DATE NULL DEFAULT NULL,
  `estacionamento_id` BIGINT NULL DEFAULT NULL,
  `veiculo_placa` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKjucm7l4g328poyuguljubkja8` (`estacionamento_id` ASC) VISIBLE,
  INDEX `FKt66kd6g9c091i9r9oqkiaa278` (`veiculo_placa` ASC) VISIBLE,
  CONSTRAINT `FKjucm7l4g328poyuguljubkja8`
    FOREIGN KEY (`estacionamento_id`)
    REFERENCES `estacionamento`.`estacionamento` (`id`),
  CONSTRAINT `FKt66kd6g9c091i9r9oqkiaa278`
    FOREIGN KEY (`veiculo_placa`)
    REFERENCES `estacionamento`.`veiculo` (`placa`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
