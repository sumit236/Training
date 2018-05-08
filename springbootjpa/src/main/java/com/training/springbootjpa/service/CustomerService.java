package com.training.springbootjpa.service;

import com.training.springbootjpa.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	public void deleteUserById(long id);

	Customer updateCustomer(Long customerId);
}
