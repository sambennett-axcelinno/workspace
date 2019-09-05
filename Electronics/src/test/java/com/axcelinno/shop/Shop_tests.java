package com.axcelinno.shop;

import static org.junit.Assert.*;

import org.junit.Test;

public class Shop_tests {

	@Test
	public void product_test() {
		Product laptop = new Product(1, "laptop", 999.99, 150);
		assertEquals(1, laptop.ID);
		assertEquals("laptop", laptop.name);
		assertEquals(999.99, laptop.price, 1e-8);
		assertEquals(150, laptop.quantity);
		assertEquals(999.99, laptop.getPrice(), 1e-8);
		assertTrue(laptop.isAvailable());
		//System.out.println("test");
	}

}
