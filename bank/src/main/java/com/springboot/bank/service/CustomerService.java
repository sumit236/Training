/**
 * 
 */
package com.springboot.bank.service;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Customer;
import com.springboot.bank.wrapper.WrapperBankCustomer;

/**
 * @author Sumit
 *
 */
public interface CustomerService {

	Customer createCustomer(WrapperBankCustomer wrapperBankCustomer) throws BankException;

	Customer getCustomerDetails(Long customerId) throws BankException;
	
	Customer updateCustomerDetails(Long customerId) throws BankException, CloneNotSupportedException;
}
