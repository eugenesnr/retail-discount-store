package com.retail.store.api.test.data;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.retail.store.api.model.Products;
import com.retail.store.api.model.User;

public class BillTestData {
	
	public static User employeeObject() { 
		return new User("Tlotlo","Lebotse","employee",new GregorianCalendar(2014, 2, 11).getTime());
	}
	
	public static User affiliateObject() { 
		return new User("Tlotlo","Lebotse","affiliate",new GregorianCalendar(2018, 2, 11).getTime());
	}
	
	public static User customerObject() { 
		return new User("Tlotlo","Lebotse","customer",new GregorianCalendar(2010, 2, 11).getTime());
	}
	
	public static User customerLess2YearsObject() { 
		return new User("Tlotlo","Lebotse","customer",new GregorianCalendar(2020, 2, 11).getTime());
	}

	public static User customerMore2YearsObject() { 
		return new User("Tlotlo","Lebotse","customer",new GregorianCalendar(2010, 2, 11).getTime());
	}
	
	public static Products productObject() {
		return new Products("Soda", 100.0, "grocery", 1);
	}

	public static Products nullProductObject() {
		Products product = null;
		return product;
	}
	
	public static List<Products> listOfProductsObject(){
		List<Products> products = new ArrayList<Products>();
		products.add(new Products("Soda", 100.0, "grocery", 2));
		products.add(new Products("Hammer", 100.0, "hardware", 1));
		return products;
	}
}
