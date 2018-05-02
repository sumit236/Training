package service;

import java.util.List;

import model.Customer;

public interface AccountService {

	void withdraw(Customer customer, String checkAccountNumber, double amount);

	void deposit(Customer customer, String checkAccountNumber, double amount);

	void deleteAccount(Customer customer, String checkAccountNumber);

	void updateDetailsOfAccount(Customer customer, String checkAccountNumber, int newChange);

	public void getStatement(Customer customer, String checkAccountNumber);
}
