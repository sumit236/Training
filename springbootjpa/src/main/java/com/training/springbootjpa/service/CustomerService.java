package com.training.springbootjpa.service;

import java.util.List;
import java.util.Map;
import com.training.springbootjpa.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	Map<Long, String> updateCustomerById(List<Long> updateById);

	Map<Long, String> deleteCustomerById(List<Long> customerId);

}
