package com.axcelinno.shop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Customer {
	
	int ID;
	int items = 0;
	double balance = 0.0;
	double discountAmt = 0.0;
	double finalAmt = 0.0;
	double salesTax = 0.0;
	ArrayList<Product> cart = new ArrayList<Product>();
	boolean jobStatus = false;
	
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
		//this.finalAmt += p.price;
	}
	
	public void removeFromCart(Product p) {
		this.cart.remove(p);
		p.returnQuantity(1);
		this.balance -= p.price;
		//this.finalAmt -= p.price;
	}
	
	public String outpString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Customer ID: ");
		sb.append(this.ID);
		sb.append(" Amount in cart: ");
		sb.append(this.cartSize());
		sb.append(" Total cost without discount: " + round(this.balance,  2));
		sb.append(" Total cost with discount: " + round(this.finalAmt,  2));
		sb.append(" Discount amount: " + round(this.discountAmt,  2));
		sb.append(" Total after sales tax is: " + round(this.salesTax,  2) + "\n");
		return sb.toString();
	}
	
	public void writeToFile() throws IOException {
		try  {
			//BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/samuelbennett/Documents/electronics-write.txt", true));
			PrintWriter writer = new PrintWriter(new FileWriter("/Users/samuelbennett/Documents/store.csv", true));
			//writer.newLine();
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append(this.ID + "," + this.cartSize() + "," + round(this.balance,  2) + "," + round(this.finalAmt,  2) + "," + round(this.discountAmt, 2) + "," + round(this.salesTax,  2) + "\n");
			writer.write(sBuilder.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public void returnPricing() {
		this.finalAmt = this.balance - this.discountAmt;
		salesTax = round(finalAmt * 1.075, 2);
		this.items = cartSize();
		System.out.println("You have bought " + this.items + " items.");
		System.out.println("You spent: " + round(this.balance,  2));
		System.out.println("You saved: " + round(this.discountAmt,  2));
		System.out.println("Your spent " + round(this.finalAmt,  2) +  " after discount added.");
		System.out.println("After sales tax you spent: " + salesTax);
	}

}
