package com.training.springbootjpa.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
	public List deleteCustomerById(long deleteById) {
		List<Customer> customerList = customerDAO.findAll();
		Iterator iterator = customerList.iterator();
		while (iterator.hasNext()) {
			Customer customer = (Customer) iterator.next();
			if (customer.getCustomerId() == deleteById) {
				customerDAO.deleteById(deleteById);
			}
		}
		return customerList;
	}

	@Override
	public Customer updateCustomerById(long updateById) {
		Optional<Customer> customer = customerDAO.findById(updateById);
		Customer customerDummy = customer.get();
		customerDummy.setCustomerAddress("California");
		return customerDummy;
	}
}
