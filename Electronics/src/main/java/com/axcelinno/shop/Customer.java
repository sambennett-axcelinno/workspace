package com.axcelinno.shop;

import java.util.*;

public class Customer {
	
	int ID;
	double balance = 0;
	ArrayList<Product> cart = new ArrayList<Product>();
	boolean jobStatus = false;
	int numItems = 0;
	
	public Customer(int ID) {
		this.ID = ID;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void printCart() {
		for (Product p : cart) {
			System.out.println(p.getName());
		}
	}
	
	public int cartLocation(Product p) {
		return cart.indexOf(p);
	}
	
	public int cartSize() {
		return this.cart.size();
	}

}
