package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomerTest {
	
	private Customer testCustomer1 = new Customer(1l,"name","surname");
	private Customer testCustomer2 = new Customer(1l,"name","surname");
	private Customer testCustomer3 = new Customer(2l,"name","surname");
	private Customer nullCustomer1 = new Customer(null,null,null);
	private Customer nullCustomer2 = new Customer(1l,null,null);
	private Customer nullCustomer3 = new Customer(1l,"piers",null);
	
	@Test
	public void testSetters() {
		testCustomer1.setId(2l);
		testCustomer1.setFirstName("TestName");
		testCustomer1.setSurname("TestSurname");
		assertFalse(testCustomer1.equals(testCustomer2));
	}
	
	@Test
	public void testGetters() {
		long id = 1l;
		String fName = "name";
		String lName = "surname";
		assertTrue(testCustomer1.getId().equals(id));
		assertTrue(testCustomer1.getFirstName().equals(fName));
		assertTrue(testCustomer1.getSurname().equals(lName));
	}
	
	@Test
	public void testEquals() {
		assertFalse(nullCustomer1.equals(testCustomer1));
		assertFalse(nullCustomer2.equals(testCustomer1));
		assertFalse(nullCustomer3.equals(testCustomer1));
		
		assertFalse(testCustomer1.equals(nullCustomer1));
		assertFalse(testCustomer1.equals(nullCustomer2));
		assertFalse(testCustomer1.equals(nullCustomer3));
		
		assertTrue(testCustomer1.equals(testCustomer1));
		
		assertFalse(testCustomer1.equals(null));
		assertFalse(testCustomer1.equals(testCustomer3));
	}
}

