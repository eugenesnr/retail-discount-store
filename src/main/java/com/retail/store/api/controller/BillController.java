package com.retail.store.api.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.store.api.model.Bill;
import com.retail.store.api.service.BillService;

@RestController
@RequestMapping("/api")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(
		    value = "/calculateBill", 
		    method = RequestMethod.POST,
		    consumes = {"text/plain", "application/*"})
	public ResponseEntity<Object> calculateNetTotal(@RequestBody Bill bill) {
		HashMap<String, Object> response = new HashMap<>();
		response.put("response", ""+billService.calcuteNetTotal(bill));
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
