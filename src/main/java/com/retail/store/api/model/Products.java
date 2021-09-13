package com.retail.store.api.model;

import java.util.List;

import com.retail.store.api.util.BillUtils;

/*
 * @author Tlotlo Lebotse
 * @version 1.0
 * @description products object class containing product attributes
 * 
 */
public class Products {
	
	private String productName;
	private double productPrice;
	private String productType;
	private int quantity;
	
	public Products() {
	}

	public Products(String productName, double productPrice, String productType, int quantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Products [productName=" + productName + ", productPrice=" + productPrice + ", productType="
				+ productType + ", quantity=" + quantity + "]";
	}

	public double getTotalPrice() {
		return getProductPrice()*getQuantity();
	}
}
