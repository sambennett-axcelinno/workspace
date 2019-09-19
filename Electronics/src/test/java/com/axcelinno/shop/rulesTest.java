package com.axcelinno.shop;

import static org.junit.Assert.*;

import org.junit.Test;

public class rulesTest {

	@Test
	public void test() {
		Customers customers = new Customers(1, 1, 400.00, 0.0, true, null, 62284457, 0.0, true);
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Shop shop = new Shop(false);
		fireRules fRules = new fireRules();
		fRules.runWithData(customers,  product,  shop);
		assertEquals(100,  product.getQuantity());
	}

}
