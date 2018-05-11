package com.training.springbootjpa.service;

import java.util.List;
import java.util.Map;

import com.training.springbootjpa.exception.GenericException;
import com.training.springbootjpa.model.Customer;

public interface CustomerService {

	String addCustomer(Customer customer) throws GenericException;

	Map<Long, String> updateCustomerById(List<Long> updateById) throws GenericException;

	Map<Long, String> deleteCustomerById(List<Long> customerId) throws GenericException;

}
