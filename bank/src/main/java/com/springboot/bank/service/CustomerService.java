/**
 * 
 */
package com.springboot.bank.service;

import com.springboot.bank.model.Customer;

/**
 * @author Sumit
 *
 */
public interface CustomerService {

	void addCustomer(Customer customer);

	Customer getCustomerDetails(Long customerId);
}
