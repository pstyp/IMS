package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {

	Item testItem1 = new Item("car", 301.69);
	Item testItem2 = new Item(1l, "phone", 500.00);
	Customer testCustomer = new Customer("John", "Smith");

	@Test
	public void testSetters() {
		testItem1.setProductId(5l);
		testItem1.setProductName("dog");
		testItem1.setPrice(20.43);

		assertFalse(testItem1.equals(testItem2));
	}

	@Test
	public void testGetters() {
		long prodID = 1l;
		String prodName = "car";
		double prodPrice = 301.69;
		assertTrue(testItem2.getProductId().equals(prodID));
		assertTrue(testItem1.getProductName().equals(prodName));
		assertEquals(prodPrice, testItem1.getPrice(), 0.1);
	}

	@Test
	public void testEquals() {
		assertFalse(testItem1.equals(null));
		assertFalse(testItem1.equals(testCustomer));
		assertTrue(testItem2.equals(new Item(1l, "phone", 500.00)));
	}

}
