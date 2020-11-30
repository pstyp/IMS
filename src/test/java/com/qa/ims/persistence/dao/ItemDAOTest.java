package com.qa.ims.persistence.dao;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;


public class ItemDAOTest {
	private final ItemDAO itemDAO = new ItemDAO();

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
		final String itemName = "doggo";
		final double itemPrice = 69.69;
		final long ID = 5l;
		final Item created = new Item(ID, itemName, itemPrice);
		
		assertEquals(created, itemDAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1l, "Piers", 12.00));
		expected.add(new Item(2l, "Jordan", 2.69));
		expected.add(new Item(3l, "Vinesh", 1.99));
		expected.add(new Item(4l, "Alan", 3999.99));
		assertEquals(expected, itemDAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(4l, "Alan", 3999.99), itemDAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(1l, "Piers", 12.00), itemDAO.readItem(ID));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(1l, "Updated Piers", 0.5);
		assertEquals(updated, itemDAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, itemDAO.delete(3));
	}
}
