

import java.util.List;

public class Customer {

	private static String firstName = null;
	private String lastName = null;

	private List<Account> AccountList;
	private Contact contactObj;

	Customer(String firstName, String lastName, Contact contactObj,
			List<Account> AccountList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactObj = contactObj;
		this.AccountList = AccountList;

	}

	public static String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Account> getAccountList() {
		return AccountList;
	}

	public Contact getContactObj() {
		return contactObj;
	}

}