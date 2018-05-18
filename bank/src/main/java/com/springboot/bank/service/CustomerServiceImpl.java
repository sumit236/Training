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
	CustomerDAO customerDao;

	@Autowired
	BankDAO bankDao;

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

	@Override
	public Customer getCustomerDetails(Long customerId) throws BankException {
		Optional<Customer> customerList = customerDao.findById(customerId);
		if (customerList.isPresent()) {
			Customer customer = customerList.get();
			return customer;
		} else
			throw new BankException("Bank details not found");
	}
}
