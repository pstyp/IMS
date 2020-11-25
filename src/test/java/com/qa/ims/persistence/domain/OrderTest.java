package com.qa.ims.persistence.domain;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;


public class OrderTest {
	
	private Order testOrder1 = new Order(1l, 1l, "address");
	private Order testOrder2 = new Order(1l, 2l, "London");
	private Order testOrder3 = new Order(1l, 3l, "Manchester");
	private Order nullOrder1 = new Order(null, null, null);
	private Order nullOrder2 = new Order(1l, null, null);
	private Order nullOrder3 = new Order(1l, 1l, null);
	
	
	@Test
	public void testSetters() {
		testOrder1.setCustomerId(2l);
		testOrder1.setOrderId(2l);
		testOrder1.setAddress("China");
		
		assertFalse(testOrder1.equals(testOrder2));
	}
	@Test
	public void testGetters() {
		long ordId = 1l;
		long cusId = 1l;
		String adds = "address";
		assertTrue(testOrder1.getOrderId().equals(ordId));
		assertTrue(testOrder1.getCustomerId().equals(cusId));
		assertTrue(testOrder1.getAddress().equals(adds));
	}
	@Test
	public void testEquals() {
		assertFalse(testOrder1.equals(testOrder2));
		assertFalse(nullOrder1.equals(testOrder3));
		assertFalse(testOrder1.equals(null));
		assertFalse(nullOrder1.equals(nullOrder2));
		assertFalse(nullOrder1.equals(nullOrder3));
		assertFalse(nullOrder2.equals(testOrder1));
		assertFalse(nullOrder2.equals(nullOrder3));
		assertFalse(nullOrder3.equals(testOrder1));
		assertFalse(nullOrder3.equals(nullOrder2));
	}
}
