CREATE SCHEMA IF NOT EXISTS `recipesbrazil_db` ;
USE `recipesbrazil_db` ;

CREATE SCHEMA IF NOT EXISTS `recipesbrazil_db` ;
USE `recipesbrazil_db` ;

DROP TABLE IF EXISTS `recipesbrazil_db`.`recipe`;

CREATE TABLE IF NOT EXISTS `recipesbrazil_db`.`recipe` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL,
	`description` VARCHAR(255) NULL,
	`instructions` BLOB NOT NULL,
	`preparation_time_in_minutes` INT NOT NULL,
	`number_of_servings` INT NOT NULL,
	`diet_type` VARCHAR(20) NOT NULL
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `recipesbrazil_db`.`ingredient`;

CREATE TABLE IF NOT EXISTS `recipesbrazil_db`.`ingredient` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`description` VARCHAR(255) NOT NULL,
	`recipe_id` INT NOT NULL,
	INDEX fk_ingredient_recipe_idx4(`recipe_id` ASC)
) ENGINE = InnoDB;

