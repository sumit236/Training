/**
 * 
 */
package com.springboot.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Customer;
import com.springboot.bank.service.CustomerService;
import com.springboot.bank.wrapper.WrapperBankCustomer;

/**
 * @author Sumit
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody WrapperBankCustomer wrapperBankCustomer)
			throws BankException {
		Customer customerData = null;
		try {
			customerData = customerService.createCustomer(wrapperBankCustomer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (customerData == null)
			throw new BankException("Customer details not added");
		else
			return new ResponseEntity<Customer>(customerData, HttpStatus.OK);
	}

	@GetMapping(value = "/getCustomerDetails/{customerId}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable Long customerId) throws BankException {
		Customer customerData = null;
		try {
			customerData = customerService.getCustomerDetails(customerId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (customerData == null)
			throw new BankException("No such Id of Bank exixts");
		else
			return new ResponseEntity<Customer>(customerData, HttpStatus.OK);
	}

}
