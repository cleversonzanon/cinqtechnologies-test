CREATE SCHEMA IF NOT EXISTS `SAMPLE`;

USE `SAMPLE`;

CREATE TABLE IF NOT EXISTS `Country` (
    `countryId` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40),
    PRIMARY KEY (`countryId`))
ENGINE = InnoDB;

TRUNCATE TABLE `Country`;

INSERT INTO `Country` (countryId, name) VALUES(1,'Brazil');
INSERT INTO `Country` (countryId, name) VALUES(2,'United States');
INSERT INTO `Country` (countryId, name) VALUES(3,'France');
INSERT INTO `Country` (countryId, name) VALUES(4,'Canada');

CREATE TABLE IF NOT EXISTS `City` (
    `cityId` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40),
    `countryId` INT,
    PRIMARY KEY (`cityId`))
ENGINE = InnoDB;

TRUNCATE TABLE `City`;

CREATE USER IF NOT EXISTS dbuser PASSWORD `dbuser`;

GRANT ALL ON Country TO dbuser;
GRANT ALL ON City TO dbuser;

