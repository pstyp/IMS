INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('john', 'smith');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('pawel', 'stypulkowski');
INSERT INTO `ims`.`items` (`product_name`, `price`) VALUES ('Piers', 12.00);
INSERT INTO `ims`.`items` (`product_name`, `price`) VALUES ('Jordan', 2.69);
INSERT INTO `ims`.`items` (`product_name`, `price`) VALUES ('Vinesh', 1.99);
INSERT INTO `ims`.`items` (`product_name`, `price`) VALUES ('Alan', 3999.99);
INSERT INTO `ims`.`orders` (`customer_id`, `address`) VALUES (3, 'London');
INSERT INTO `ims`.`orders` (`customer_id`, `address`) VALUES (1, 'Manchester');
INSERT INTO `ims`.`order_items` (`order_id`,`product_id`) VALUES (1,4);
INSERT INTO `ims`.`order_items` (`order_id`,`product_id`) VALUES (1,1);
INSERT INTO `ims`.`order_items` (`order_id`,`product_id`) VALUES (1,2);
INSERT INTO `ims`.`order_items` (`order_id`,`product_id`) VALUES (2,2);



