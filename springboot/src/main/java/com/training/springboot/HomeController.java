package com.training.springboot;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import model.Customer;
import repository.CustomerDAO;
import repository.RetailerDAO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private RetailerDAO retailerDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/viewCustomers")
	@ResponseBody
	public List<Customer> allCustomer() {
		List customerList = new ArrayList<Customer>();
		customerList = retailerDAO.viewCustomer("");
		return customerList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addCustomer")
	@ResponseBody
	public String addSingleCustomer() {
		final String dummy = customerDAO.addCustomer("5_C", "Data12", "Computer12", "CASH", "1_R");
		// System.out.println(dummy);
		return dummy;
	}
}
