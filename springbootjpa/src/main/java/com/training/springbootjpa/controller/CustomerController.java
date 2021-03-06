package com.training.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootjpa.model.Customer;
import com.training.springbootjpa.repository.CustomerDAO;

@RestController
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	 @RequestMapping(method = RequestMethod.POST, value = "/addCustomer",produces = MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping(path = "/addCustomer")
	public ResponseEntity<Customer> createCustomer(Customer customer) {
		final Customer customerData;
		System.out.println("hIIIIIIIIIIIIIIIIII");
		
		customerData = customerDAO.addCustomer(customer);
		return new ResponseEntity(customerData, HttpStatus.OK);
	}
}
