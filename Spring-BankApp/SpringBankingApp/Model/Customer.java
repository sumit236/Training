package model;

import java.util.List;

import service.AccountService;

public class Customer {

	private static String firstName;
	private String lastName;
	private Contact contact;
	private List<Account> accountlist;
	public String customerId;

	/**
	 * @param firstName
	 * @param lastName
	 * @param contactObj
	 * @param accountlist
	 */
	public Customer(String firstName, String lastName, Contact contact, List<Account> accountlist, String customerId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.accountlist = accountlist;
		this.customerId = customerId;
	}

	/**
	 * @param firstName
	 */
	private void setFirstName(String firstName) {
		Customer.firstName = firstName;
	}

	/**
	 * @return the first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param lastName
	 */
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the customer id.
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param contact
	 */
	private void setContact(Contact contact) {
		this.contact = contact;
	}
	
	/**
	 * @return the contact object.
	 */
	private Contact getContact() {
		return contact;
	}

	/**
	 * @param accountlist
	 */
	private void setAccountlist(List<Account> accountlist) {
		this.accountlist = accountlist;
	}

	/**
	 * @return the account list.
	 */
	public List<Account> getAccountlist() {
		return accountlist;
	}

}
