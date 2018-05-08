package com.training.springbootjpa.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springbootjpa.model.Customer;
import com.training.springbootjpa.repository.CustomerDAO;

/**
 * @author Sumit
 *
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer customerData = customerDAO.save(customer);
		return customerData;
	}

	@Override
public void deleteUserById(long id) {
		
		List customerList = new ArrayList<Customer>;
		
		    if (user.getCustomerId() == id) 
		    {
		        iterator.remove();
		    }
		}

	@Override
	public Customer updateCustomer(Long customerId) {
		Customer customerData = customerDAO.updateCustomer(customerId);
		return customerData;
	}
}
