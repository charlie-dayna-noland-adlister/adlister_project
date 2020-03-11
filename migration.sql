-- MySQL Script generated by MySQL Workbench
-- Mon Mar  9 16:03:03 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE USER IF NOT EXISTS 'adlister_user'@'localhost' IDENTIFIED BY 'fresh_Headshot-2020';
GRANT ALL ON adlister_database.* TO 'adlister_user'@'localhost';
-- -----------------------------------------------------
-- Schema adlister_database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema adlister_database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `adlister_database` DEFAULT CHARACTER SET utf8 ;
USE `adlister_database` ;


-- -----------------------------------------------------
-- Table `adlister_database`.`users`
-- -----------------------------------------------------
--DROP TABLE IF EXISTS `adlister_database`.`users` ;
--
--CREATE TABLE IF NOT EXISTS `adlister_database`.`users` (
--  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
--  `username` VARCHAR(45) NOT NULL,
--  `email` VARCHAR(100) NOT NULL,
--  `password` VARCHAR(255) NOT NULL,
--  `image_text` LONGTEXT NULL,
--  `user_avr` TINYINT(6) UNSIGNED NOT NULL,
--  `times_reported` INT UNSIGNED NOT NULL,
--  `num_ads_reported` INT UNSIGNED NOT NULL,
--  `num_reviews` INT UNSIGNED NOT NULL,
--  `zipcode` INT UNSIGNED NOT NULL,
--  `is_admin` TINYINT(1) NOT NULL,
--  PRIMARY KEY (`id`),
--  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
--  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
--  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
--
--ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `adlister_database`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `adlister_database`.`ads` ;

CREATE TABLE IF NOT EXISTS `adlister_database`.`ads` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `description` VARCHAR(240) NOT NULL,
  `price` DOUBLE UNSIGNED NOT NULL,
  `date_posted` DATE NOT NULL,
  `image_text` LONGTEXT NULL,
  `review_avr` TINYINT(6) UNSIGNED NULL,
  `quantity_reported` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (user_id) REFERENCES users (id),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `adlister_database`.`reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `adlister_database`.`reviews` ;

CREATE TABLE IF NOT EXISTS `adlister_database`.`reviews` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `review_text` VARCHAR(250) NOT NULL,
  `rating` TINYINT(6) UNSIGNED NOT NULL,
  `image_text` LONGTEXT NULL,
  `ad_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_reviews_ads1_idx` (`ad_id` ASC),
  CONSTRAINT `fk_reviews_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `adlister_database`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reviews_ads1`
    FOREIGN KEY (`ad_id`)
    REFERENCES `adlister_database`.`ads` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
   )
ENGINE = InnoDB;

DROP TABLE IF EXISTS `adlister_database`.`categories` ;

CREATE TABLE IF NOT EXISTS `adlister_database`.`categories` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `type_UNIQUE` (`type` ASC)
  )
ENGINE = InnoDB;

DROP TABLE IF EXISTS `adlister_database`.`ads_categories` ;

CREATE TABLE IF NOT EXISTS `adlister_database`.`ads_categories` (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ads_id INT UNSIGNED,
    categories_id INT UNSIGNED,
  PRIMARY KEY (`id`),
  FOREIGN KEY (ads_id) REFERENCES ads (id),
  FOREIGN KEY (categories_id) REFERENCES categories (id),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC)
  )
ENGINE = InnoDB;

DROP TABLE IF EXISTS `adlister_database`.`users_followed` ;

 CREATE TABLE IF NOT EXISTS `adlister_database`.`users_followed`
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id   INT UNSIGNED,
    followed_id INT UNSIGNED,
    PRIMARY KEY (id),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (followed_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS `adlister_database`.`ads_reported_users` ;
 CREATE TABLE IF NOT EXISTS `adlister_database`.`ads_reported_users`
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ads_id  INT UNSIGNED,
    reported_user_id INT UNSIGNED,
    PRIMARY KEY (id),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    FOREIGN KEY (ads_id) REFERENCES ads (id),
    FOREIGN KEY (reported_user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS `adlister_database`.`users_ads` ;
 CREATE TABLE IF NOT EXISTS `adlister_database`.`users_ads`
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ads_id  INT UNSIGNED,
    user_id INT UNSIGNED,
    PRIMARY KEY (id),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    FOREIGN KEY (ads_id) REFERENCES ads (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
