package com.retail.store.api.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.store.api.enums.UserEnums;
import com.retail.store.api.model.Bill;
import com.retail.store.api.model.Products;
import com.retail.store.api.service.BillService;
import com.retail.store.api.util.BillUtils;

/*
 * @author Tlotlo Lebotse
 * @version 1.0
 * @description Class implements service methods
 * 
 */
@Service
public class BillServiceImplementation implements BillService{

	/*
	 * Method returns the total net amount based on the type of user
	 * 
	 * @param Bill
	 * @return Bill With updated net total
	 */
	@Override
	public Bill calcuteNetTotal(Bill bill) {
	    switch (bill.getUser().getType()) {
			case BillUtils.EMPLOYEE:
				bill.setNetTotal(getNetTotal(bill.getProducts(),UserEnums.EMPLOYEE.getValue()));
				break;
			case BillUtils.AFFILIATE:
				bill.setNetTotal(getNetTotal(bill.getProducts(),UserEnums.AFFILIATE.getValue()));
				break;
			case BillUtils.CUSTOMER:
				if(bill.getUser().isCustomerMoreThan2Years()) {
					bill.setNetTotal(getNetTotal(bill.getProducts(),UserEnums.CUSTOMER.getValue()));
				} else {
					bill.setNetTotal(getNetTotal(bill.getProducts(),0));
				}
				break;
		default:
			break;
		}
		return bill;
	}
	
	/*
	 * Method calculate the total net amount for the incoming Bill
	 * 
	 * @param List Product list
	 * @param double Discount percentage
	 * return double Total net amount
	 */
	public double getNetTotal(List<Products> products, double discountPercentage) {
		
		double nonGroceryTotal = 0.0;
		double groceryTotal = 0.0;
		double total = 0.0;
		
		for(Products product: products) {
			if(product.getProductType().compareTo(BillUtils.GROCERY) != 0) {
				nonGroceryTotal = nonGroceryTotal + product.getTotalPrice();
				
			} else {
				groceryTotal = groceryTotal + product.getTotalPrice();
			}
		}
		
		if(discountPercentage != 0) {
			total = groceryTotal + (nonGroceryTotal - (nonGroceryTotal*discountPercentage));
			return total - (total / BillUtils.HUNDRED_PERCENT) * BillUtils.DISCOUNT_PER_ONE_HUNDRED;
		} else {
			total = groceryTotal+nonGroceryTotal;
			return total - (total / BillUtils.HUNDRED_PERCENT) * BillUtils.DISCOUNT_PER_ONE_HUNDRED;
		}
	}
	
}
