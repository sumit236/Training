package service;

import repository.CustomerDAO;

/**
 * @author Sumit
 *
 */
public class CustomerServiceImpl implements CustomerService {

	CustomerDAO customerDAO;

	/**
	 * @param customerDAO
	 */
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	@Override
	public String addCustomer(String customerId, String customerName,
			String customerAddress, String paymentMode, String retailerId) {
		String addData = customerDAO.addCustomer(customerId, customerName,
				customerAddress, paymentMode, retailerId);
		return addData;
	}

	@Override
	public String removeCusotmer(String customerId) {
		String removeData = customerDAO.removeCustomer(customerId);
		return removeData;
	}

	@Override
	public String updateCustomer(String customerId) {
		String updateData = customerDAO.updateCustomer(customerId);
		return updateData;
	}
}
