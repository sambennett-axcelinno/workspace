package com.axcelinno.shop;

public class Product {
	
	int ID;
	String name;
	double price = 0.0;
	int  quantity;
	
	public Product(int ID, String name, double price, int quantity) {
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public boolean isAvailable() {
		return this.quantity > 0 ? true : false;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int changQuantity(int i) {
		return this.quantity -= i;
		
	}
	
	public int returnQuantity(int i) {
		return this.quantity += i;
	}
}
