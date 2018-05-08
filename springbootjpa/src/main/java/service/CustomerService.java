package service;

import model.Customer;

public interface CustomerService {

	int addCustomer(Customer customer);

	int removeCusotmer(String customerId);

	int updateCustomer(String customerId);
}
