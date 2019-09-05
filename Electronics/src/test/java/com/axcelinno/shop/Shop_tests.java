package com.axcelinno.shop;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

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
		laptop.changQuantity(1);
		assertEquals(149, laptop.quantity);
	}
	
	@Test
	public void customer_test() {
		Customer customer = new Customer(1);
		Product laptop = new Product(1, "laptop", 999.99, 150);
		assertEquals(1,  customer.ID);
		assertEquals(0.0, customer.balance, 1e-8);
		assertFalse(customer.jobStatus);
		assertTrue(customer.cart.isEmpty());
		customer.cart.add(laptop);
		customer.balance +=customer.cart.get(customer.cart.size() - 1).price;
		assertEquals(999.99, customer.balance, 1e-8);
		customer.cart.add(laptop);
		customer.balance +=customer.cart.get(customer.cart.size() - 1).price;
		assertEquals(999.99*2, customer.balance, 1e-8);
		customer.printCart();
	}
	
	@Test
	public void shop_test() {
		Scanner s = new Scanner(System.in);
		System.out.println("Are you an employee?(yes or no)");
		String employeed = s.nextLine();
		System.out.println(employeed);
	}

}
