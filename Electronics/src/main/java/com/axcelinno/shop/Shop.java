package com.axcelinno.shop;

import java.util.*;

public class Shop {
	
	//Customer customer;
	float day;
	double discountAmt = 0.0;
	double finalAmt = 0.0;
	HashMap<Integer, Product> products = new HashMap<Integer, Product>() {
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
			put(8,  headphones);
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
			c.cart.add(p);
			p.changQuantity(1);
		}
		else {
			if (p.isAvailable()) {
				for (int it = 0; it < i; it++) {
					c.cart.add(p);
					p.changQuantity(1);
				}
			}
		}
	}
	
	public void removeItem(Product p, Customer c, int i) {
		if (i <= 0) {
			System.out.println("Please enter a valid number(1 and up)");
		}
		else if (i <= 1) {
			c.cart.remove(c.cartLocation(p));
			p.returnQuantity(1);
		}
		else {
			for (int it = 0; it < i; it++) {
				c.cart.remove(c.cartLocation(p));
				p.returnQuantity(1);
			}
		}
	}
	
	public boolean isEmployeed(int i, Customer  c) {
		if (empID.contains(i)) {
			c.jobStatus = true;
			return true;
		}
		else {
			c.jobStatus = false;
			return false;
		}
	}
	
	
	public void shopLoop() {
		Scanner s = new Scanner(System.in);
		System.out.println("Are you an employee?(yes or no)");
		String output = s.nextLine();
		System.out.println("Please Enter the product and quantity of that product you want? (format of product quantity)");
		while (!output.equals("e") && s.hasNext()) {
			System.out.println("Please Enter the product and quantity of that product you want? (format of product quantity)");
			output = s.next();
			String quant = s.next();
			System.out.println(output); 
			System.out.println(quant);
		}
	}

}
