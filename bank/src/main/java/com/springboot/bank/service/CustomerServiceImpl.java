/**
 * 
 */
package com.springboot.bank.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.repository.CustomerDAO;
import com.springboot.bank.wrapper.WrapperBankCustomer;

/**
 * @author Sumit
 *
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Autowired
	private BankDAO bankDao;

	/*
	 * @MethodName : createCustomer. Description : It will create a new customer
	 * having bankId associated with it.
	 */
	@Override
	public Customer createCustomer(WrapperBankCustomer wrapperBankCustomer) throws BankException {
		Customer customer = null;
		Customer customerData = null;
		customer = wrapperBankCustomer.getCustomer();
		// System.out.println(customer);
		Long bankId = wrapperBankCustomer.getBankId();
		Optional<Bank> bankList = bankDao.findById(bankId);
		Bank bank = bankList.get();
		customer.setBank(bank);
		customerData = customerDao.save(customer);
		// System.out.println(customerData);
		return customerData;
	}

	/*
	 * @MethodName : getCustomerDetails. Description : It will take customerId as a
	 * parameter and find the details of a particular customer from it.
	 */
	@Override
	public Customer getCustomerDetails(Long customerId) throws BankException {
		Optional<Customer> customerList = customerDao.findById(customerId);
		if (customerList.isPresent()) {
			Customer customer = customerList.get();
			return customer;
		} else {
			throw new BankException("Bank details not found");
		}
	}

	@Override
	public Customer updateCustomerDetails(Long customerId) throws BankException {
		Optional<Customer> customerList = customerDao.findById(customerId);
		if (customerList.isPresent()) {
			Customer customer = customerList.get();
			customer.setCustomerName("Naruto Uzumaki");
			customerDao.save(customer);
			return customer;
		} else {
			throw new BankException("Bank details not found");
		}
	}
}
