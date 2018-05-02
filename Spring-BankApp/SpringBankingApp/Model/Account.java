package model;

import java.util.List;

import model.Statement;
import service.AccountService;

public class Account {

	private double money;
	private List<Statement> statementList;
	private String typeOfAccount;
	private String accountNumber;

	/**
	 * @param money
	 * @param statementList
	 * @param typeOfAccount
	 */
	public Account(String accountNumber, double money, List<Statement> statementList, String typeOfAccount) {
		this.accountNumber = accountNumber;
		this.money = money;
		this.statementList = statementList;
		this.typeOfAccount = this.typeOfAccount;
	}

	/**
	 * @return the money.
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @return the list of statements.
	 */
	public List<Statement> getStatementList() {
		return statementList;
	}

	/**
	 * @return the type of account.
	 */
	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	/**
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountNumber.
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param money
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * @param statementList
	 */
	public void setStatementList(List<Statement> statementList) {
		this.statementList = statementList;
	}

	/**
	 * @param typeOfAccount
	 */
	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

}
