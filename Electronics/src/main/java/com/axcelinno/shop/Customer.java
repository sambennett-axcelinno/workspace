package com.axcelinno.shop;

import java.util.*;

public class Customer {
	
	int ID;
	double balance = 0.0;
	double discountAmt = 0.0;
	double finalAmt = 0.0;
	ArrayList<Product> cart = new ArrayList<Product>();
	boolean jobStatus = false;
	//int numItems = 0;
	
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
	
	public void addToCart(Product p) {
		this.cart.add(p);
		p.changeQuantity(1);
		this.balance += p.price;
	}
	
	public void removeFromCart(Product p) {
		this.cart.remove(p);
		p.returnQuantity(1);
		this.balance -= p.price;
	}
	public void returnPricing() {
		if (this.finalAmt == 0.0) {
			this.finalAmt = this.balance;
		}
		double salesTax = finalAmt * 1.075;
		System.out.println("You have " + cartSize() + " items in  your cart.");
		System.out.println("You spent: " + this.balance);
		System.out.println("You saved: " + this.discountAmt);
		System.out.println("Your spent " + this.finalAmt +  " after discount added.");
		System.out.println("Aftter sales tax you spent: " + salesTax);
	}

}
