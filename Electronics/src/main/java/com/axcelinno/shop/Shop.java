package com.axcelinno.shop;

import java.util.*;

public class Shop {
	
	//Customer customer;
	float day;
	double discountAmt = 0.0;
	double finalAmt = 0.0;
	HashMap<Integer, Product> productList = new HashMap<Integer, Product>() {
		{
			Product laptop = new Product(1,  "laptop", 999.99, 150);
			put(1,  laptop);
			Product tablet = new Product(2,  "tablet", 300.00, 150);
			put(2,  tablet);
			Product tv = new Product(3,  "tv", 4100.00, 100);
			put(3,  tv);
			Product refriderator = new Product(4,  "refriderator", 1199.99, 15);
			put(4, refriderator);
			Product console = new Product(5,  "game console", 399.99, 250);
			put(5, console);
			Product camera = new Product(6,  "camera", 349.99, 150);
			put(6, camera);
			Product headphones = new Product(7,  "headphones", 299.99, 250);
			put(7, headphones);
			Product printer = new Product(8,  "printer", 150.00, 150);
			put(8,  printer);
			Product phone = new Product(9,  "phone", 899.00, 300);
			put(9,  phone);
			Product speakers = new Product(10,  "speakers", 189.00, 100);
			put(10,  speakers);
		}
	};
	ArrayList<Integer> empID = new ArrayList<Integer>(Arrays.asList(12189554, 54993663, 48723891, 62284457, 32600943, 89237002, 50196955));
	
	public Shop() {
		
	}
	
	
	public void showEmp() {
		for (Integer i : empID) {
			System.out.println(i);
		}
	}
	
	public void addItem(Product p, Customer c, int i) {
		if (i <= 0) {
			System.out.println("Please enter a valid number(1 and up)");
		}
		else if (i <= 1 && p.isAvailable()) {
			c.addToCart(p);
		}
		else {
			if (p.isAvailable()) {
				for (int it = 0; it < i; it++) {
					c.addToCart(p);
				}
			}
		}
	}
	
	public void removeItem(Product p, Customer c, int i) {
		if (i <= 0) {
			System.out.println("Please enter a valid number(1 and up)");
		}
		else if (i <= 1) {
			c.removeFromCart(p);
		}
		else {
			for (int it = 0; it < i; it++) {
				c.removeFromCart(p);
			}
		}
	}
	
	public void printAvailability() {
		for (Integer i : productList.keySet()) {
			System.out.println(productList.get(i).toString() + " has " + productList.get(i).quantity + " available" + "\n");
		}
	}
	
	public boolean isEmployeed(int i, Customer  c) {
		if (empID.contains(i)) {
			c.jobStatus = true;
			System.out.println("You are an employee, you get a discount!");
			return true;
		}
		else {
			c.jobStatus = false;
			System.out.println("You are not an employee, continue shopping.");
			return false;
		}
	}
	
	
	public void shopLoop(Customer c) {
		Scanner s = new Scanner(System.in);
		System.out.println("Are you an employee?(yes or no)");
		String output = s.nextLine();
		if (output.equals("yes")) {
			System.out.println("What is your employee ID?");
			String id = s.nextLine();
			Integer i = Integer.parseInt(id);
			isEmployeed(i,  c);
		}
		System.out.println("Please Enter the product and quantity of that product you want? (format of product quantity)");
		while (!output.equals("e") && s.hasNext()) {
			output = s.next();
			if (output.equals("e")) {
				break;
			}
			String quant = s.next();
			System.out.println(output); 
			System.out.println(quant);
			System.out.println("Please Enter the product and quantity of that product you want? (format of product quantity)");
		}
	}

}
