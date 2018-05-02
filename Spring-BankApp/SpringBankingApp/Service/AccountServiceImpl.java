package service;

import java.util.Iterator;
import java.util.List;

import model.Account;
import model.Address;
import model.Customer;
import model.Statement;

/**
 * @author trainee
 *
 */
public class AccountServiceImpl implements AccountService {

	Account account;
	Address address;
	double newBalance = 0;
	Statement statement;
	List<Statement> statementList;

	public void withdraw(Customer customer, String checkAccountNumber, double amount) {

		List<Account> accountlist = customer.getAccountlist();

		Iterator iterator = accountlist.iterator();
		while (iterator.hasNext()) {
			account = (Account) iterator.next();

			if (account.getAccountNumber().equals(checkAccountNumber)) {
				newBalance = account.getMoney() - amount;
				if(newBalance < 0 )
					{
					account.setMoney(newBalance);
					List<Statement> statementList1 = account.getStatementList();
					statement = new Statement("money withdrawn");
					statementList1.add(statement);
					}
				else
					System.out.println("Insufficient balance");
			}
		}
	}

	public void deposit(Customer customer, String checkAccountNumber, double amount) {

		List<Account> accountList = customer.getAccountlist();
		Iterator iterator = accountList.iterator();
		while (iterator.hasNext()) {
			account = (Account) iterator.next();

			if (account.getAccountNumber().equals(checkAccountNumber)) {
				newBalance = account.getMoney() + amount;
				account.setMoney(newBalance);
				statement = new Statement("money deposited");
				statementList.add(statement);
			}
		}
	}

	public void deleteAccount(Customer customer, String checkAccountNumber) {

		List<Account> accountList = customer.getAccountlist();
		int index = 0;
		Iterator iterator = accountList.iterator();
		while (iterator.hasNext()) {
			account = (Account) iterator.next();

			if (account.getAccountNumber().equals(checkAccountNumber)) {
				accountList.remove(index);
			}
			index++;
		}
	}

	public void updateDetailsOfAccount(Customer customer, String checkAccountNumber, int newChange) {

		List<Account> accountList = customer.getAccountlist();
		Iterator iterator = accountList.iterator();
		while (iterator.hasNext()) {

			if (account.getAccountNumber().equals(checkAccountNumber)) {
				address.setZipCode(newChange);

			}
		}
	}

	public void getStatement(Customer customer, String checkAccountNumber) {

		List<Account> accountList = customer.getAccountlist();
		Iterator iterator = accountList.iterator();
		while (iterator.hasNext()) {

			if (account.getAccountNumber().equals(checkAccountNumber)) {
				statementList = account.getStatementList();
				Iterator iterator1 = statementList.iterator();
				while (iterator1.hasNext()) {
					statement = (Statement) iterator1.next();
					System.out.println(statement);
				}
			}
		}
	}
}
