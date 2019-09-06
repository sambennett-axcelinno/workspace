package com.axcelinno.shop;

import java.util.*;

public class Shop {
	
	//Customer customer;
	double day = 12.6;
	boolean isHoliday = true;
	int cusID = 0;
	HashMap<Integer, Product> productList = new HashMap<Integer, Product>() {
		{
			Product laptop = new Product(1,  "laptop", 999.99, 150);
			put(1,  laptop);
			Product tablet = new Product(2,  "tablet", 300.00, 150);
			put(2,  tablet);
			Product tv = new Product(3,  "tv", 4100.00, 100);
			put(3,  tv);
			Product refrigerator = new Product(4,  "refrigerator", 1199.99, 15);
			put(4, refrigerator);
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

	public void addDiscount(Customer c, Product p) {
		if (c.jobStatus && p.ID != 3) {
			double dis = p.price * 0.3;
			double newPrice = p.price * 0.7;
			c.discountAmt += dis;
			c.finalAmt += newPrice;
		}
		else if (!c.jobStatus && isHoliday) {
			double dis = p.price * 0.1;
			double newPrice = p.price * 0.9;
			c.discountAmt += dis;
			c.finalAmt += newPrice;
		}
	}
	
	public void removeDiscount(Customer c, Product p) {
		if (c.jobStatus && p.ID != 3) {
			double dis = p.price * 0.3;
			double newPrice = p.price * 0.7;
			c.discountAmt -= dis;
			c.finalAmt -= newPrice;
		}
		else if (!c.jobStatus && isHoliday) {
			double dis = p.price * 0.1;
			double newPrice = p.price * 0.9;
			c.discountAmt -= dis;
			c.finalAmt -= newPrice;
		}
	}
	
	public void addItem(Product p, Customer c, int i) {
		if (i <= 0) {
			System.out.println("Please enter a valid number(1 and up)");
		}
		else if (!p.isAvailable()) {
			System.out.println(p.toString() + " is sold out.  Please check back later once a restock has happened.");
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
	
	public Product convertToProd(String s) {
		Product retProd = new Product(0,  "dummy", 0, 0);
		if (s.equals("laptop") || s.equals("Laptop")) {
			retProd = productList.get(1);
		}
		else if (s.equals("tablet") || s.equals("Tablet")) {
			retProd = productList.get(2);
		}
		else if (s.equals("tv") || s.equals("TV")) {
			retProd = productList.get(3);
		}
		else if (s.equals("refrigerator") || s.equals("Refrigerator")) {
			retProd = productList.get(4);
		}
		else if (s.equals("console") || s.equals("Console")) {
			retProd = productList.get(5);
		}
		else if (s.equals("camera") || s.equals("Camera")) {
			retProd = productList.get(6);
		}
		else if (s.equals("headphones") || s.equals("Headphones")) {
			retProd = productList.get(7);
		}
		else if (s.equals("printer") || s.equals("Printer")) {
			retProd = productList.get(8);
		}
		else if (s.equals("phone") || s.equals("Phone")) {
			retProd = productList.get(9);
		}
		else if (s.equals("speakers") || s.equals("Speakers")) {
			retProd = productList.get(10);
		}
		return retProd;
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
			Integer t = Integer.parseInt(quant);
			Product p = convertToProd(output);
			addItem(p,  c,  t);
			for (int q = 0; q < t; q++) {
				addDiscount(c,  p);
			}
			System.out.println("Current Cart:");
			c.printCart();
			System.out.println("Please Enter the product and quantity of that product you want? (format of product quantity.  e when done)");
		}
		System.out.println("Is there anything that you would like to remove from you cart before you checkout? (yes or no)");
		output = s.next();
		if (output.equals("no")) {
			System.out.println("Here is your final cart and pricing:");
			c.printCart();
			c.returnPricing();
		}
		else {
			System.out.println("What would you like to remove? (e when done) (format of product quantity)");
			while (s.hasNext()) {
				output = s.next();
				if (output.equals("e")) {
					break;
				}
				String quant = s.next();
				Integer t = Integer.parseInt(quant);
				Product p = convertToProd(output);
				removeItem(p,  c,  t);
				for (int q = 0; q < t; q++) {
					removeDiscount(c,  p);
				}
				System.out.println("Here is your updated cart.");
				c.printCart();
				System.out.println("What would you like to remove? (e when done) (format of product quantity)");
			}
			System.out.println("Here is your final cart and pricing:");
			c.printCart();
			c.returnPricing();
		}
	}
	
	public void store() {
		cusID++;
		System.out.println("Welcome to Axcelinno Electronics!");
		Customer c = new Customer(cusID);
		shopLoop(c);
	}

}
