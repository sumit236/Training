package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	String nameOfBank = "HDFC";
	List<Customer> customerList;

	Bank() {
	}

	/**
	 * @param nameOfBank
	 * @param customerList
	 */
	public Bank(String nameOfBank, List<Customer> customerList) {
		this.nameOfBank = nameOfBank;
		this.customerList = customerList;
	}

	/**
	 * @return the name of bank.
	 */
	public String getNameOfBank() {
		return nameOfBank;
	}

	/**
	 * @param nameOfBank
	 */
	private void setNameOfBank(String nameOfBank) {
		this.nameOfBank = nameOfBank;
	}

	/**
	 * @return the customer list.
	 */
	public List<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * @param customerList
	 */
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

}
