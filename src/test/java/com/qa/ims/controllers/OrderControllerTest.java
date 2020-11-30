package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private CustomerDAO customerDAO;

	@Mock
	private OrderDAO orderDAO;

	@Mock
	private ItemDAO itemDAO;

	@InjectMocks
	private OrderController orderController;

	@Test
	public void testCreate() {

		final Long custId = 1L;
		final String address = "address";
		final Order created = new Order(custId, address);

		when(utils.getLong()).thenReturn(custId);
		when(utils.getString()).thenReturn(address);
		when(orderDAO.create(created)).thenReturn(created);

		assertEquals(created, orderController.create());

		verify(utils, times(1)).getLong();
		verify(orderDAO, times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		List<Item> items = new ArrayList<>();
		orders.add(new Order(1l, 1L, "address", items));

		when(orderDAO.readAll()).thenReturn(orders);

		assertEquals(orders, orderController.readAll());

		verify(orderDAO, times(1)).readAll();
	}

	@Test
	public void testDelete() {
		final long ID = 1L;
		when(utils.getLong()).thenReturn(ID);
		when(orderDAO.delete(ID)).thenReturn(1);

		assertEquals(1L, this.orderController.delete());

		verify(utils, times(1)).getLong();
		verify(orderDAO, times(1)).delete(ID);
	}

	@Test
	public void testUpdate() {
		

	}
}
