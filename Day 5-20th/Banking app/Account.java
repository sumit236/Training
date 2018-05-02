

import java.util.Iterator;
import java.util.List;

/**
 * Program 		:	Banking Application
 * Description 	:	The application shows different relationships like one to one (Contact to Address), 
 * 					one to many (Customer to Account).
 * 					 
 */
class Account extends Bank {
	private double money;
	private final double interestRate = 0.07;
	private int period;
	protected List<Statement> statementList;

	public Account(double money, int period, List<Statement> statementList) {
		this.money = money;
		this.period = period;
		this.statementList = statementList;
	}

	
	/**
	 * Method Name	:	getStatementList()	
	 * Description	:	It returns the list of statements.
	 */
	public List<Statement> getStatementList() {
		return statementList;
	}

	/**
	 * Method Name	:	getMoney()	
	 * Description	:	It returns the money.
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * Method Name	:	getPeriod()	
	 * Description	:	It returns the period. 
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * Method Name	:	getMoney()	
	 * Description	:	It sets the money.
	 */
	private void setMoney(double money) {
		this.money = money;
	}


	/**
	 * Method Name	:	getPeriod()	
	 * Description	:	It sets the period. 
	 */
	private void setPeriod(int period) {
		this.period = period;
	}


	private void setStatementList(List<Statement> statementList) {
		this.statementList = statementList;
	}


	/**
	 * Method Name	:	getStatements()	
	 * Description	:	It prints all the statement one by one. 
	 */
	public void getStatements(List<Statement> statement) {
		Iterator iterator = statement.iterator();
		while (iterator.hasNext()) {
			log.info(iterator.next());
		}
	}

}