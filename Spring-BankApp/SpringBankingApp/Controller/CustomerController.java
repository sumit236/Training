package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Bank;
import model.Customer;

public class CustomerController {
	
	
	public void addCustomer(List<Customer> dummyCustomerList,Customer customer)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		Bank bank = (Bank) context.getBean("bank"); 
		 List customerList= new ArrayList<Customer>();
		
		 if(bank.getCustomerList() == null)
		 {
			 customerList.add(dummyCustomerList);
			 bank.setCustomerList(customerList);
		 }
		 else
		 {
			 bank.getCustomerList().add(customer);
		 }
	}
}
