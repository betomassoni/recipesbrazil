-- MySQL Script generated by MySQL Workbench
-- Sat May 13 19:11:26 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema recipesbrazil_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema recipesbrazil_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `recipesbrazil_db` DEFAULT CHARACTER SET utf8 ;
USE `recipesbrazil_db` ;

-- -----------------------------------------------------
-- Table `recipesbrazil_db`.`recipe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipesbrazil_db`.`recipe` ;

CREATE TABLE IF NOT EXISTS `recipesbrazil_db`.`recipe` (
  `id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL,
  `instructions` BLOB NOT NULL,
  `preparation_time_in_minutes` INT NOT NULL,
  `number_of_servings` INT NOT NULL,
  `diet_type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `recipesbrazil_db`.`ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `recipesbrazil_db`.`ingredient` ;

CREATE TABLE IF NOT EXISTS `recipesbrazil_db`.`ingredient` (
  `id` INT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `recipe_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ingredient_recipe_idx` (`recipe_id` ASC) VISIBLE,
  CONSTRAINT `fk_ingredient_recipe`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `recipesbrazil_db`.`recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
