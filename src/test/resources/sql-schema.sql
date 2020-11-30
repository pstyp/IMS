drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `product_id` INT(11) NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(40) NULL DEFAULT NULL,
    `price` DOUBLE NULL DEFAULT NULL,
    PRIMARY KEY (`product_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `order_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT, 
    `customer_id` INT NOT NULL,
    `address` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `ims`.`customers`(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
    `order_items_id` INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
    `order_id` INT NOT NULL,
    `product_id` INT NOT NULL,    
    PRIMARY KEY (`order_items_id`),
    CONSTRAINT `order_id` FOREIGN KEY(`order_id`) REFERENCES `ims`.`orders`(`order_id`),
    CONSTRAINT `product_id` FOREIGN KEY(`product_id`) REFERENCES `ims`.`items`(`product_id`)
);