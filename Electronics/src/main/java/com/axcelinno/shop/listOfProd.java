package com.axcelinno.shop;

import java.util.*;

public class listOfProd {

	List<Product> prodList = new ArrayList<Product>();
	
	public listOfProd() {
		
	}
	
	public listOfProd(List<Product> prodList) {
		this.prodList = prodList;
	}

	public List<Product> getProdList() {
		return prodList;
	}

	public void setProdList(List<Product> prodList) {
		this.prodList = prodList;
	}
	
	public void addTo(Product p) {
		prodList.add(p);
	}
	
	public int prodListSize() {
		return prodList.size();
	}
}
