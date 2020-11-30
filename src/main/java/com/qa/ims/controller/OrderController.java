package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}
 
	@Override
	public Order create() {
		LOGGER.info("Please enter your customer id");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter an address");
		String address = utils.getString();
		Order order = orderDAO.create(new Order(customerId, address));
		LOGGER.info("Would you like to add an item to your order?");

		LOGGER.info("Enter yes or no");

		String newItem = utils.getString();

		addItem(newItem);

		return order;
	}

	public Order addItem(String newItem) {

		if (newItem.toLowerCase().equals("yes")) {

			boolean flag = true;

			while (flag) {
				LOGGER.info("Please enter a product id");
				Long productId = utils.getLong();
				LOGGER.info("Please enter an order id");
				Long orderId = utils.getLong();
				orderDAO.addItem(new OrderItems(productId, orderId));
				LOGGER.info("Item successfully added to order");
				LOGGER.info("Would you like to add another item?");
				LOGGER.info("Enter yes or no");
				String addExtra = utils.getString();

				if (addExtra.toLowerCase().equals("no")) {
					flag = false;
				}
			}
			return null;

		} else {
			LOGGER.info("Bye");
			return null;
		}
	}

	@Override
	public Order update() {
		Long id = null;
		Order current = null;
		Long cusId = null;
		do {
			LOGGER.info("Enter the id of the order you would like to update.");
			id = utils.getLong();
			LOGGER.info("Please enter a new customer id");
			cusId = utils.getLong();
			LOGGER.info("Please enter a new address");
			String address = utils.getString();
			orderDAO.update(new Order(id, cusId, address));
			LOGGER.info("Order Updated");
			current = orderDAO.readOrder(id);
		} while (current == null);
		boolean exit = false;
		do {
			current = orderDAO.readOrder(id);
			LOGGER.info(current.toString());
			LOGGER.info("Would you like to add or delete an item? Enter 'add', 'delete' or 'exit'.");
			String selection = utils.getString().toLowerCase();
			Long itemID;
			switch (selection) {
			case "delete":
				LOGGER.info("Enter item id to delete");
				itemID = utils.getLong();
				orderDAO.deleteOrderItems(current.getOrderId(), itemID);
				break;
			case "add":

				LOGGER.info("Please enter a product id");
				Long productId = utils.getLong();
				LOGGER.info("Please enter a customer id");
				Long customerId = utils.getLong();
				orderDAO.addItem(new OrderItems(productId, customerId));
				LOGGER.info("Item successfully added to order");
				break;
			case "exit":
				exit = true;
				break;
			default:
				LOGGER.info("Error");
				break;
			}
		} while (!exit);

		return orderDAO.readOrder(id);
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order to delete");
		Long orderId = utils.getLong();
		LOGGER.info("Order Deleted");
		orderDAO.deleteOrderLines(orderId);
		return orderDAO.delete(orderId);

	}
}
