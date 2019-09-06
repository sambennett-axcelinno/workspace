package com.axcelinno.shop;

import java.math.RoundingMode;
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
	
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public void returnPricing() {
		if (this.finalAmt == 0.0) {
			this.finalAmt = this.balance;
		}
		double salesTax = round(finalAmt * 1.075, 2);
		System.out.println("You have  bought " + cartSize() + " items.");
		System.out.println("You spent: " + round(this.balance,  2));
		System.out.println("You saved: " + round(this.discountAmt,  2));
		System.out.println("Your spent " + round(this.finalAmt,  2) +  " after discount added.");
		System.out.println("Aftter sales tax you spent: " + salesTax);
	}

}
