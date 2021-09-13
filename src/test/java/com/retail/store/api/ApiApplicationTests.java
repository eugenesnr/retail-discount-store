package com.retail.store.api;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.retail.store.api.controller.BillController;
import com.retail.store.api.model.Bill;
import com.retail.store.api.model.Products;
import com.retail.store.api.model.User;
import com.retail.store.api.service.BillService;
import com.retail.store.api.test.data.BillTestData;
import com.retail.store.api.util.BillUtils;

import junit.framework.Assert;

@SpringBootTest
class ApiApplicationTests {
	
	@Autowired
	BillService billService;
	
	@Autowired
	BillController billController;

	@Test
    @DisplayName("Should return true for a user who is an Affiliate")
	public void isUserTypeAffiliate() {
		User user = BillTestData.affiliateObject();
		Assert.assertTrue(user.getType().compareTo(BillUtils.AFFILIATE) == 0);
	}
	
	@Test
    @DisplayName("Should return true for a user who is an Employee")
	public void isUserTypeEmployee() {
		User user = BillTestData.employeeObject();
		Assert.assertTrue(user.getType().compareTo(BillUtils.EMPLOYEE) == 0);
	}
	
	@Test
    @DisplayName("Should return true for a user who is a Customer")
	public void isUserTypeCustomer() {
		User user = BillTestData.customerObject();
		Assert.assertTrue(user.getType().compareTo(BillUtils.CUSTOMER) == 0);
	}
	
	@Test
    @DisplayName("Should return true for user who's join date is greater 2 years")
	public void isUserJoinDateMoreThan2Years() {
		User user = BillTestData.customerMore2YearsObject();
		Assert.assertTrue(user.isCustomerMoreThan2Years());
	}
	
	@Test
    @DisplayName("Should return false for user who's join date is less than 2 years")
	public void isUserJoinDateLessThan2Years() {
		User user = BillTestData.customerLess2YearsObject();
		Assert.assertFalse(user.isCustomerMoreThan2Years());
	}
	
	@Test
    @DisplayName("Should return true if product is not null")
	public void isProductNotNull() {
		Products product = BillTestData.productObject();
		Assert.assertNotNull(product);
	}
	
	@Test
    @DisplayName("Should return true if product is null")
	public void isProductNull() {
		Products product = BillTestData.nullProductObject();
		Assert.assertNull(product);
	}
	
	@Test
    @DisplayName("Should return true if total is equal to (quantity * price)")
	public void isProductTotal() {
		Products product = BillTestData.productObject();
		Assert.assertEquals(100.0, product.getTotalPrice());
	}
	
	@Test
    @DisplayName("Should return true if Employee discount is calculated correctly")
	public void isEmployeeDiscountCorrect() {
		Bill bill = new Bill(BillTestData.employeeObject(),BillTestData.listOfProductsObject());
		Assert.assertEquals(256.5, billService.calcuteNetTotal(bill).getNetTotal());
	}
	
	@Test
    @DisplayName("Should return true if Affiliate discount is calculated correctly")
	public void isAffiliateDiscountCorrect() {
		Bill bill = new Bill(BillTestData.affiliateObject(),BillTestData.listOfProductsObject());
		Assert.assertEquals(275.5, billService.calcuteNetTotal(bill).getNetTotal());
	}
	
	@Test
    @DisplayName("Should return true if Customer with join date less than 2 years discount is calculated correctly")
	public void isCustomerLess2YearsDiscountCorrect() {
		Bill bill = new Bill(BillTestData.customerLess2YearsObject(),BillTestData.listOfProductsObject());
		Assert.assertEquals(285.0, billService.calcuteNetTotal(bill).getNetTotal());
	}
	
	@Test
    @DisplayName("Should return true if Customer with join date more than 2 years discount is calculated correctly")
	public void isCustomerMore2YearsDiscountCorrect() {
		Bill bill = new Bill(BillTestData.customerMore2YearsObject(),BillTestData.listOfProductsObject());
		Assert.assertEquals(280.25, billService.calcuteNetTotal(bill).getNetTotal());
	}
	
	@Test
    @DisplayName("Should controller.")
	public void controllerTest() {
		Bill bill = new Bill(BillTestData.customerMore2YearsObject(),BillTestData.listOfProductsObject());
		billController.calculateNetTotal(bill);
		Assert.assertEquals(200, billController.calculateNetTotal(bill).getStatusCodeValue());
	}
	
	@Test
    @DisplayName("Should retrun true if user getFirstname is not null")
	public void setFistname() {
		User user  = BillTestData.customerObject();
		user.setFirstName("John");
		Assert.assertNotNull(user.getFirstName());
	}
	
	@Test
    @DisplayName("Should retrun true if user getLastName is not null")
	public void setLastname() {
		User user  = BillTestData.customerObject();
		user.setLastName("John");
		Assert.assertNotNull(user.getLastName() );
	}
	
	@Test
    @DisplayName("Should retrun true if user getType is not null")
	public void setType() {
		User user  = BillTestData.customerObject();
		user.setType("customer");
		Assert.assertNotNull(user.getType());
	}
	
	@Test
    @DisplayName("Should retrun true if user getJoinDate is not null")
	public void setJoinDate() {
		User user  = BillTestData.customerObject();
		user.setJoinDate(new Date());
		Assert.assertNotNull(user.getJoinDate());
	}
	
	@Test
    @DisplayName("Should retrun true if Bill getUser is not null")
	public void setBillUser() {
		Bill bill  = new Bill();
		bill.setUser(BillTestData.customerObject());
		Assert.assertNotNull(bill.getUser());
	}
	
	@Test
    @DisplayName("Should retrun true if Bill getProducts is not null")
	public void setBillProducts() {
		Bill bill  = new Bill();
		bill.setProducts(BillTestData.listOfProductsObject());
		Assert.assertNotNull(bill.getProducts());
	}
	
	@Test
    @DisplayName("Should retrun true if Bill is not null")
	public void createBill() {
		Bill bill  = new Bill(BillTestData.customerObject(),BillTestData.listOfProductsObject(),0);
		Assert.assertNotNull(bill.getProducts());
	}
	
	@Test
	@DisplayName("Should return true if product object has a hash value")
	public void createProducts() {
		Products product = new Products();
		Assert.assertNotNull(product.hashCode());
	}
	
	@Test
	@DisplayName("Should return true if product name is set")
	public void isNameSet() {
		Products product = new Products();
		product.setProductName("Juice");
		Assert.assertEquals("Juice",product.getProductName());
	}
	
	@Test
	@DisplayName("Should return true if product quantity is set")
	public void isQuantitySet() {
		Products product = new Products();
		product.setQuantity(4);
		Assert.assertEquals(4,product.getQuantity());
	}
	
	
	@Test
	@DisplayName("Should return true if product price is set")
	public void isPriceSet() {
		Products product = new Products();
		product.setProductPrice(400.0);
		Assert.assertEquals(400.0,product.getProductPrice());
	}
	
	@Test
	@DisplayName("Should return true if product type is set")
	public void isProductTypeSet() {
		Products product = new Products();
		product.setProductType("grocery");
		Assert.assertEquals("grocery",product.getProductType());
	}
	
}
