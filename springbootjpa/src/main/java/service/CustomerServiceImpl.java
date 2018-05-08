package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Customer;
import repository.CustomerDAO;

/**
 * @author Sumit
 *
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public int addCustomer(Customer customer) {
		int addData = customerDAO.addCustomer(customer);
		return addData;
	}

	@Override
	public int removeCusotmer(String customerId) {
		int removeData = customerDAO.removeCustomer(customerId);
		return removeData;
	}

	@Override
	public int updateCustomer(String customerId) {
		int updateData = customerDAO.updateCustomer(customerId);
		return updateData;
	}
}
