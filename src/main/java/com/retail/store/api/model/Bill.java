package com.retail.store.api.model;

import java.util.List;


/*
 * @author Tlotlo Lebotse
 * @version 1.0
 * @description Bill object class containing bill attributes
 * 
 */
public class Bill {
	
	private User user;
	private List<Products> products;
	private double netTotal;
	
	public Bill() {
		
	}
	
	public Bill(User user, List<Products> products, double netTotal) {
		super();
		this.user = user;
		this.products = products;
		this.netTotal = netTotal;
	}

	public Bill(User user, List<Products> products) {
		super();
		this.user = user;
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public double getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(double netTotal) {
		this.netTotal = netTotal;
	}

	@Override
	public String toString() {
		return "Bill [user=" + user + ", products=" + products + ", netTotal=" + netTotal + "]";
	}
}
