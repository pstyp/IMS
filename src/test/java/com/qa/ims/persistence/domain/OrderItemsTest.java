package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderItemsTest {
	private OrderItems testOrderItems1 = new OrderItems(1l, 1l, 1l);
	private OrderItems testOrderItems2 = new OrderItems(2l, 2l, 2l);
	private OrderItems testOrderItems3 = new OrderItems(1l, 1l);
	private OrderItems nullOrder1 = new OrderItems(null, null, null);
	private OrderItems nullOrder2 = new OrderItems(null, null);
	
	
	
	@Test
	public void testSetters() {
		testOrderItems1.setOrderItemsId(1l);;
		testOrderItems1.setOrderId(2l);
		testOrderItems1.setProductId(3l);		
		assertFalse(testOrderItems1.equals(testOrderItems2));
	}
	@Test
	public void testGetters() {
		long ordId = 1l;
		long prodId = 2l;
		long ordItems = 1l;
		assertTrue(testOrderItems1.getOrderId().equals(ordId));
		assertTrue(testOrderItems2.getProductId().equals(prodId));
		assertTrue(testOrderItems1.getOrderItemsId().equals(ordItems));
	}
	@Test
	public void testEquals() {
		assertFalse(testOrderItems1.equals(testOrderItems2));
		assertFalse(nullOrder1.equals(testOrderItems3));
		assertFalse(testOrderItems1.equals(null));
		assertTrue(nullOrder1.equals(nullOrder2));
		
	}
}
