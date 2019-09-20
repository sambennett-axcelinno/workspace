package com.axcelinno.shop;

import static org.junit.Assert.*;

import org.junit.Test;

public class rulesTest {

	@Test
	public void test() {
		Customers customers = new Customers(1, 1, 400.00, 0.0, true, null, 62284457, 0.0, true);
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Shop shop = new Shop(false, null, null);
		fireRules fRules = new fireRules();
		fRules.runWithData(customers,  product,  shop);
		assertEquals(99,  product.getQuantity());
		assertEquals(430.00,  customers.getBalance(), 1e-8);
		assertTrue(customers.isJobStatus());
		assertEquals(105.0,  product.getPrice(), 1e-8);
	}
	
	@Test
	public void holiday() {
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Customers customers = new Customers(1, 1, 400.00, 0.0, false, null, 16, 0.0, true);
		Shop shop = new Shop(true,  null,   null);
		fireRules fRules = new fireRules();
		fRules.runWithData(customers,  product,  shop);
		assertTrue(shop.isHoliday());
		assertEquals(135.0,  product.getPrice(), 1e-8);
	}
	
	@Test
	public void TV() {
		Product product = new Product(3,  "tv", 4100.00, 100, true);
		Customers customers = new Customers(1, 1, 400.00, 0.0, true, null, 16, 0.0, true);
		Shop shop = new Shop(true,  null,   null);
		fireRules fRules = new fireRules();
		fRules.runWithData(customers,  product,  shop);
		assertEquals(4100.00,  product.getPrice(), 1e-8);
		assertTrue(customers.isJobStatus());
	}
	
	@Test
	public void noCheckout() {
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Customers customers = new Customers(1, 1, 400.00, 0.0, true, null, 62284457, 0.0, false);
		Shop shop = new Shop(false,  null,   null);
		fireRules fRules = new fireRules();
		fRules.runWithData(customers,  product,  shop);
		assertEquals(400,  customers.getBalance(), 1e-8);
	}


}
