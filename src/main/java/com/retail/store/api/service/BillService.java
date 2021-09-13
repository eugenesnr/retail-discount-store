package com.retail.store.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.store.api.model.Bill;
import com.retail.store.api.model.Products;

/*
 * 
 * @author Tlotlo Lebotse
 * @version 1.0
 * @description Bill interface class 
 * 
 */
@Service
public interface BillService {
	
	public Bill calcuteNetTotal(Bill bill);
	public double getNetTotal(List<Products> products, double discountPercentage);
	
}
