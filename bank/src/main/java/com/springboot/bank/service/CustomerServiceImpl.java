/**
 * 
 */
package com.springboot.bank.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Audit;
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;
import com.springboot.bank.model.eventName;
import com.springboot.bank.model.eventType;
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

	@Autowired
	private AuditService auditService;

	/*
	 * @MethodName : createCustomer. 
	 * Description : It will create a new customer having bankId 
	 * 				 associated with it.
	 */
	@Override 
	public Customer createCustomer(WrapperBankCustomer wrapperBankCustomer) throws BankException {
		Customer customer = null;
		Customer customerData = null;
		customer = wrapperBankCustomer.getCustomer();
		Long bankId = wrapperBankCustomer.getBankId();
		Optional<Bank> bankList = bankDao.findById(bankId);
		Bank bank = bankList.get();
		customer.setBank(bank);
		customerData = customerDao.save(customer);
		return customerData;
	}

	/*
	 * @MethodName : getCustomerDetails. 
	 * Description : It will take customerId as a parameter and find the 
	 * 				 details of a particular customer from it.
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

	/*
	 * @MethodName : updateCustomerDetails. 
	 * Description : It will take customerId as a parameter and find the details of a 
	 * 				 particular customer and update its details.
	 */
	@Override
	public Customer updateCustomerDetails(Long customerId) throws BankException, CloneNotSupportedException {
		Optional<Customer> customerList = customerDao.findById(customerId);
		if (customerList.isPresent()) {
			Customer customer = customerList.get();
			Customer customerDummy = customer.clone();
			Audit audit = new Audit<>();
			audit.setTimestamp("");
			audit.setUuid("");
			audit.setEventName((eventName.CUSTOMER).toString());
			audit.setEventType((eventType.CREATE).toString());
			audit.setOldValue(customerDummy);
			customer.setCustomerName("Kira");
			audit.setNewValue(customer);
			auditService.getAudit(audit);
			return customer;
		} else {
			throw new BankException("Bank details not found");
		}
	}
}
