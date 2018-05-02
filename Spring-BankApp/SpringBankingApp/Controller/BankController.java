package controller;

import java.util.Iterator;
import java.util.List;

import model.Bank;
import model.Customer;
import service.AccountService;


public class BankController {

	Customer customer;
	AccountService accountService;
	String checkCustomerId;
	private double amount ;
	Bank bank;
	
	private void sendParticularCustomer()
	{
		if(bank.getNameOfBank().equals("HDFC"))	
		{	
		List customerList = bank.getCustomerList();
		Iterator iterator=customerList.iterator();
		
		while(iterator.hasNext())
			{
			customer =  (Customer)iterator.next();
			while(customer.getCustomerId().equals(checkCustomerId))
				{
				accountService.withdraw(customer, checkCustomerId , amount);
				}
			}
		}
	}
}
