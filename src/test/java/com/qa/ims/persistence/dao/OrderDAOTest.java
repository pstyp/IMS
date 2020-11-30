package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	private Item trainer1 = new Item(1l, "Piers", 12.00);
	private Item trainer2 = new Item(2l, "Jordan", 2.69);
	private Item trainer3 = new Item(3l, "Vinesh", 1.99);
	private Item trainer4 = new Item(4l, "Alan", 3999.99);

	private final OrderDAO orderDAO = new OrderDAO();


	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		List<Item> items = new ArrayList<>();
		final Order created = new Order(3l, 1l, "address", items);
		assertEquals(created, orderDAO.create(created));
	}

	@Test
	public void testReadLatest() {
		List<Item> items = new ArrayList<>();
		items.add(trainer2);
		final Order expected = new Order(2l, 1l, "Manchester", items);
		assertEquals(expected, orderDAO.readLatest());
	}

	@Test
	public void testRead() {
		List<Item> items = new ArrayList<>();
		items.add(trainer2);
		final long ID = 2L;
		final Order order = new Order(2l, 1l, "Manchester", items);
		assertEquals(order, orderDAO.readOrder(ID));
	}

	@Test
	public void testDelete() {
		final Order created = new Order(3l, 3l, "London");
		orderDAO.create(created);
		assertEquals(1, orderDAO.delete(3));
	}

	@Test
	public void testDeleteOrderLines() {
		final long Id = 1L;
		assertEquals(3, orderDAO.deleteOrderLines(Id));
	}

	@Test
	public void testDeleteLine() {
		final long orderId = 1L;
		final long itemId = 4L;
		assertEquals(1, orderDAO.deleteOrderItems(orderId, itemId));

	}
	
	@Test
	public void testUpdate() {
		List<Item> items = new ArrayList<>();
		items.add(trainer2);
		final Order updated = new Order(2l,2l, "address", items);
		
		assertEquals(updated, orderDAO.update(updated));
	}

	
	//@Test 
	//public void testAddItem() {
		//final OrderItems orderItem = new OrderItems(5l, 2l, 3l);
		//assertEquals(orderItem, orderDAO.addItem(orderItem));
	//}
	
	@Test
	public void testReadAll() {
		List<Item> items1 = new ArrayList<>();
		List<Item> items2 = new ArrayList<>();
		List<Order> expected = new ArrayList<>();
		final Order order1 = new Order(1l,3l,"London", items1);
		final Order order2 = new Order(2l,1l, "Manchester", items2);
		items1.add(trainer4);
		items1.add(trainer1);
		items1.add(trainer2);
		items2.add(trainer2);
		expected.add(order1);
		expected.add(order2);
		assertEquals(expected, orderDAO.readAll());
} 
	
}