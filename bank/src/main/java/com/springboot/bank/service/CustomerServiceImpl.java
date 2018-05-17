/**
 * 
 */
package com.springboot.bank.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;
import com.springboot.bank.repository.CustomerDAO;

/**
 * @author Sumit
 *
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDao;

	@Override
	public void addCustomer(Customer customer) throws CustomerException {
		String customerName = customer.getCustomerName();
		Integer customerPin = customer.getCustomerPin();
		if (customerName == null || customerName.equals(null) || customerName.isEmpty())
			throw new CustomerException("Name of customer cannot be null/empty ");
		else if (customerPin == 0)
			throw new CustomerException("pincode of customer cannot be empty/0 ");
		else {
			customerDao.save(customer);
			String customerData = "Customer details added";
		}
	}

	@Override
	public Customer getCustomerDetails(Long customerId) throws CustomerException{
		Optional<Customer> customerList = customerDao.findById(customerId);
		if (customerList.isPresent()) {
			Customer customer = customerList.get();
			return customer;
		} else
			throw new CustomerException("Bank details not found");
	}
}
