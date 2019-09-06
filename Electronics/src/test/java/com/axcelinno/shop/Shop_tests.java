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
		laptop.changeQuantity(1);
		assertEquals(149, laptop.quantity);
	}
	
	@Test
	public void customer_test() {
		Customer customer = new Customer(1);
		Product laptop = new Product(1, "laptop", 999.99, 150);
		Product tablet = new Product(2,  "tablet", 300.00,150);
		assertEquals(1,  customer.ID);
		assertEquals(0.0, customer.balance, 1e-8);
		assertFalse(customer.jobStatus);
		assertTrue(customer.cart.isEmpty());
		customer.cart.add(laptop);
		customer.balance +=customer.cart.get(customer.cart.size() - 1).price;
		assertEquals(999.99, customer.balance, 1e-8);
		customer.cart.add(laptop);
		customer.balance +=customer.cart.get(customer.cart.size() - 1).price;
		customer.cart.add(tablet);
		customer.balance +=customer.cart.get(customer.cart.size() - 1).price;
		assertEquals(2299.98, customer.balance, 1e-8);
		customer.printCart();
		System.out.println(customer.cartLocation(laptop));
		customer.cart.remove(customer.cartLocation(tablet));
		customer.printCart();
	}
	
	@Test
	public void add_and_remove_items() {
		Customer sam = new Customer(1);
		Shop shop = new Shop();
		shop.addItem(shop.productList.get(2), sam, 2);
		//sam.printCart();
		shop.printAvailability();
		assertEquals(2, sam.cartSize());
		assertEquals(600.00, sam.balance, 1e-8);
		assertEquals(148, shop.productList.get(2).quantity);
		shop.addItem(shop.productList.get(3), sam, 1);
		shop.addItem(shop.productList.get(2), sam, 2);
		//sam.printCart();
		shop.printAvailability();
		assertEquals(5,  sam.cartSize());
		assertEquals(5300.00,  sam.balance, 1e-8);
		assertEquals(146, shop.productList.get(2).quantity);
		assertEquals(99,  shop.productList.get(3).quantity);
		shop.removeItem(shop.productList.get(2), sam,  3);
		//sam.printCart();
		shop.printAvailability();
		assertEquals(2, sam.cartSize());
		assertEquals(4400.00,  sam.balance, 1e-8);
		assertEquals(149,  shop.productList.get(2).quantity);
	}
	
	@Test
	public void employee_check() {
		int emp = 89237002;
		Customer sam = new Customer(1);
		Customer eric = new Customer(2);
		Shop shop = new Shop();
		shop.isEmployeed(emp, sam);
		assertTrue(sam.jobStatus);
		shop.isEmployeed(123456789,  eric);
		assertFalse(eric.jobStatus);
	}
	
	@Test
	public void discountCheck() {
		Customer sam = new Customer(1);
		Shop shop = new Shop();
		assertEquals(12.6,  shop.day, 1e-8);
		sam.jobStatus = true;
		sam.addToCart(shop.productList.get(1));
		shop.addDiscount(sam, shop.productList.get(1));
		assertEquals(999.99, sam.balance, 1e-8);
		assertEquals(299.997,  sam.discountAmt, 1e-8);
		assertEquals(699.993,  sam.finalAmt, 1e-8);
		assertEquals(999.99,  sam.balance, 1e-8);
		Customer bob = new Customer(2);
		shop.isHoliday = true;
		bob.addToCart(shop.productList.get(4));
		shop.addDiscount(bob,  shop.productList.get(4));
		assertEquals(119.999,  bob.discountAmt, 1e-8);
		assertEquals(1079.991,  bob.finalAmt, 1e-8);
		assertEquals(1199.99, bob.balance, 1e-8);
	}
	
	@Test
	public void shop_test() {
		Customer sam = new Customer(1);
		Shop shop = new Shop();
		shop.shopLoop(sam);
	}

}
