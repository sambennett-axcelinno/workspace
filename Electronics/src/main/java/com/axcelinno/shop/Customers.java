package com.axcelinno.shop;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Customers {
	
	int ID;
	int items = 0;
	double balance = 0.0;
	double discountAmt = 0.0;
	double finalAmt = 0.0;
	double salesTax = 0.0;
	ArrayList<Product> cart = new ArrayList<Product>();
	boolean jobStatus = false;
	boolean checkout = false;
	double discountAmount = 0.0;
	int test;
	int employeeID;
	
	public Customers() {
		
	}
	
	public Customers(int ID, int items, double balance,
			double discountAmt, boolean jobStatus,
			ArrayList<Product> cart, int employeeID,
			double discountAmount, boolean checkout) {
		this.ID = ID;
		this.items = items;
		this.balance = balance;
		this.discountAmt = discountAmt;
		this.jobStatus = jobStatus;
		this.cart = cart;
		this.employeeID = employeeID;
		this.discountAmount = discountAmount;
		this.checkout = checkout;
	}
	
	public Customers (int id) {
		this.ID = id;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public double getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(double discountAmt) {
		this.discountAmt = discountAmt;
	}

	public double getFinalAmt() {
		return finalAmt;
	}

	public void setFinalAmt(double finalAmt) {
		this.finalAmt = finalAmt;
	}

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public ArrayList<Product> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}

	public boolean isJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(boolean jobStatus) {
		this.jobStatus = jobStatus;
	}

	public boolean isCheckout() {
		return checkout;
	}

	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void cartAdd(Product p) {
		if (cart != null) {
			cart.add(p);
		}
		else {
			cart = new ArrayList<Product>();
			cart.add(p);
		}
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
		if (cart != null) {
			return this.cart.size();
		}
		return -1;
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
		System.out.println("After discount you spent: " + round(this.finalAmt,  2));
		System.out.println("After sales tax you spent: " + salesTax);
	}

}
