package com.axcelinno.shop;

public class Product {
	
	int ID;
	String name;
	double price = 0.0;
	int quantity = 0;
	boolean isAvailable = true;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

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
	
	public int changeQuantity(int i) {
		return this.quantity -= i;
		
	}
	
	public int returnQuantity(int i) {
		return this.quantity += i;
	}
	
	public String toString() {
		return name;
	}
}
