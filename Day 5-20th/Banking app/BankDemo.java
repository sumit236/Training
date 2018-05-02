

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankDemo {

	public static void main(String[] args) {

		// Object of Bank.
		Bank bank = new Bank();

		// Prints the Name of the Bank.
		bank.getNameOfBank();

		// Creates two Statement Objects to add in statementList.
		Statement statementObj1 = new Statement("1st Statement");
		Statement statementObj2 = new Statement("2nd Statement");

		// Creates a List to add all Statement in single List ie statementList.
		List statementList = new ArrayList<Statement>();
		statementList.add(statementObj1);
		statementList.add(statementObj2);

		// Creates an Address object.
		Address addressObj = new Address("Road", 9, 23453, "Tokyo");

		// Creates an Contact object which takes Address object along with different
		// args(One to One Relationship).
		Contact contactObj = new Contact("123456789", "sssss@asd.asd", addressObj);

		// Creates two Account objects for a particular person.
		Account savingAccount1 = new SavingAccount(10000, 15, statementList, "abc");
		Account savingAccount2 = new SavingAccount(20000, 10, statementList, "cde");

		// Creates a List by name accountList to add all the account for that person.
		List accountList = new ArrayList<Account>();
		accountList.add(savingAccount1);
		accountList.add(savingAccount2);

		// Creates a Customer object having multiple account(One to Many Relationship).
		Customer customer = new Customer("Sasuke", "Uchiha", contactObj, accountList);

		// Prints the Details one by one.
		log.info(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getAccountList());

	}

}