package com.training.springbootjpa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.springbootjpa.exception.GenericException;
import com.training.springbootjpa.model.Customer;
import com.training.springbootjpa.repository.CustomerDAO;

/**
 * @author Sumit
 *
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private final static Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public String addCustomer(Customer customer) throws GenericException {
		String customerData = null;
		String customerAddress = customer.getCustomerAddress();
		String paymnetMode = customer.getPaymentMode();
		boolean checkEmptyAddress = customerAddress.isEmpty();
		boolean checkEmptyPayment = paymnetMode.isEmpty();
		if (customerAddress == null || customerAddress.equals("null") || checkEmptyAddress) {
			throw new GenericException("Address cannot be null");
		} else if (paymnetMode == null || paymnetMode.equals("null") || checkEmptyPayment) {
			throw new GenericException("Payment mode cannot be null");
		} else {
			Customer dummyCustomer = customerDAO.save(customer);
			customerData = "Customer added successfully";
		}
		return customerData;
	}

	@Override
	public Map<Long, String> deleteCustomerById(List<Long> deleteById) throws GenericException {
		Map<Long, String> mapList = new HashMap<>();
		Optional<Customer> customer = null;
		if (deleteById.isEmpty())
			throw new GenericException("Null entry not allowed");
		else {
			for (Long customerId : deleteById) {
				customer = customerDAO.findById(customerId);
				if (customer.isPresent()) {
					mapList.put(customerId, "Customer deleted");
					customerDAO.deleteById(customerId);
				} else {
					mapList.put(customerId, "Customer to be deleted is not found");
				}
			}
		}
		return mapList;
	}

	@Override
	public Map<Long, String> updateCustomerById(List<Long> updateById) throws GenericException {
		Map<Long, String> mapList = new HashMap<>();
		if (updateById.isEmpty())
			throw new GenericException("List of ID is empty");
		else {
			for (Long customerId : updateById) {
				Optional<Customer> customer = customerDAO.findById(customerId);
				if (customer.isPresent()) {
					Customer customerDummy = customer.get();
					customerDummy.setPaymentMode("CREDIT");
					mapList.put(customerId, "Payment updated");
					Customer customerDump = customerDAO.save(customerDummy);
				} else
					mapList.put(customerId, "Id to be updated is not found");
			}
		}
		return mapList;
	}
}