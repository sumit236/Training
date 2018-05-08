package repository;

import model.Customer;

public interface CustomerDAO {

	int addCustomer(Customer customer);

	int removeCustomer(String customerId);

	int updateCustomer(String customerId);

}
