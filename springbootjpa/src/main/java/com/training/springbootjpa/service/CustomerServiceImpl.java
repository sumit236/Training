package com.training.springbootjpa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
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

	private final static Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer customerData = customerDAO.save(customer);
		return customerData;
	}

	/*
	 * @Override public String deleteCustomerById(long deleteById) {
	 * 
	 * List<Customer> customerList = customerDAO.findAll(); Iterator iterator =
	 * customerList.iterator(); while (iterator.hasNext()) {
	 * 
	 * Optional<Customer> customer = null; try { customer =
	 * customerDAO.findById(deleteById); Customer customerDummy = customer.get(); //
	 * LOGGER.info(customerDummy.getCustomerId()+" //
	 * "+customerDummy.getCustomerName()); customerDAO.delete(customerDummy); return
	 * "Data Successfully deleted "; } catch (Exception e) { return
	 * "Record not found"; } }
	 */

	@Override
	public Map<Long, String> updateCustomerById(List<Long> updateById) {
		Map<Long, String> mapList = new HashMap<>();
		for (Long customerId : updateById) {
			Optional<Customer> customer = customerDAO.findById(customerId);
			Customer customerDummy = customer.get();
			if (customer.isPresent()) {
				customerDummy.setPaymentMode("CREDIT");
				mapList.put(customerId, "Payment updated");
			} else
				mapList.put(customerId, "Id to be updated is not found");
		}
		return mapList;
	}

	@Override
	public Map<Long, String> deleteCustomerById(List<Long> deleteById) {

		Map<Long, String> mapList = new HashMap<>();
		Optional<Customer> customer = null;
		// Long customerSize = customerDAO.count();
		for (Long customerId : deleteById) {
			System.out.println("abcd");
			customer = customerDAO.findById(customerId);
			if (customer.isPresent()) {
				mapList.put(customerId, "Data deleted");
				customerDAO.deleteById(customerId);
			} else
				mapList.put(customerId, "Data to be deleted is not found");
		}
		return mapList;
	}
}