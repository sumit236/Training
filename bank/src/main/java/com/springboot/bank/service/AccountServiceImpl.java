/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Account;
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;
import com.springboot.bank.model.Transaction;
import com.springboot.bank.repository.AccountDAO;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.repository.CustomerDAO;
import com.springboot.bank.wrapper.AccountDetails;
import com.springboot.bank.wrapper.WrapperBankCustomerAccount;

/**
 * @author Sumit
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	BankDAO bankDao;

	@Autowired
	CustomerDAO customerDao;

	@Autowired
	AccountDAO accountDao;

	@Autowired
	TransactionService transactionService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.springboot.bank.service.AccountService#createAccount(com.springboot.bank.
	 * wrapper.WrapperBankCustomerAccount)
	 */
	@Override
	public Account createAccount(WrapperBankCustomerAccount wrapperBankCustomerAccount) throws BankException {

		Account account = null;
		Long bankId = wrapperBankCustomerAccount.getBankId();
		Optional<Bank> bankList = bankDao.findById(bankId);
		Bank bank = bankList.get();
		if (bank == null) {
			throw new BankException("Bank with such Id doesnt exist");
		} else {
			account.setBank(bank);
		}
		Long customerId = wrapperBankCustomerAccount.getCustomerId();
		Optional<Customer> customerList = customerDao.findById(customerId);
		Customer customer = customerList.get();
		if (customer == null) {
			throw new BankException("Customer with such Id doesnt exist");
		} else {
			account.setCustomer(customer);
			account = accountDao.save(account);
		}
		return account;
	}

	@Override
	public Account depositMoney(AccountDetails accountDetails) throws BankException {

		Long accountId = accountDetails.getAccountId();
		Long bankId = accountDetails.getBankId();
		Long customerId = accountDetails.getCustomerId();
		BigDecimal amountToBeAdded = accountDetails.getAmount();
		Account account = null;
		Bank bank = null;
		Customer customer = null;
		if (accountId == 0 || bankId == 0 || customerId == 0 || amountToBeAdded.compareTo(BigDecimal.ZERO) == 0)
			throw new BankException("Id or amount cannot be zero");
		else {
			Optional<Account> accountList = accountDao.findById(accountId);
			account = accountList.get();
			BigDecimal newAccountBalance;
			if (account == null) {
				throw new BankException("No such account id exists");
			} else {
				newAccountBalance = amountToBeAdded.add(account.getAmount());
				Optional<Customer> customerList = customerDao.findById(customerId);
				customer = customerList.get();
				if (customer == null) {
					throw new BankException("No such customer account exists");
				} else {
					Optional<Bank> bankList = bankDao.findById(bankId);
					bank = bankList.get();
					if (bank == null) {
						throw new BankException("No such bank account exists");
					} else {
						account.setAmount(newAccountBalance);
						accountDao.save(account);
						Transaction transaction = new Transaction(customer, account, amountToBeAdded,
								"Money Deposited");
						transactionService.createTransaction(transaction);
						BigDecimal newBankBalance = amountToBeAdded.add(bank.getAmount());
						bank.setAmount(newBankBalance);
						bankDao.save(bank);
					}
				}
			}
		}
		return account;
	}

	@Override
	public Account withdrawMoney(AccountDetails accountDetails) throws BankException {
		Long accountId = accountDetails.getAccountId();
		Long bankId = accountDetails.getBankId();
		Long customerId = accountDetails.getCustomerId();
		BigDecimal amountToBeWithdrawn = accountDetails.getAmount();
		Account account = null;
		Bank bank = null;
		Customer customer = null;
		if (accountId == 0 || bankId == 0 || customerId == 0 || amountToBeWithdrawn.compareTo(BigDecimal.ZERO) == 0)
			throw new BankException("Id or amount cannot be zero");
		else {
			Optional<Account> accountList = accountDao.findById(accountId);
			account = accountList.get();
			BigDecimal newAccountBalance;
			if (account == null) {
				throw new BankException("No such id exists");
			} else {
				newAccountBalance = amountToBeWithdrawn.subtract(account.getAmount());
				if (newAccountBalance.compareTo(BigDecimal.ZERO) == 0
						|| newAccountBalance.compareTo(BigDecimal.ZERO) == -1) {
					throw new BankException("Account Balance cannot be 0 or negative");
				} else {
					Optional<Bank> bankList = bankDao.findById(bankId);
					bank = bankList.get();
					if (bank == null) {
						throw new BankException("No such customer id exists");
					} else {
						BigDecimal newBankBalance = amountToBeWithdrawn.subtract(bank.getAmount());
						if (newBankBalance.compareTo(BigDecimal.ZERO) == 0
								|| newBankBalance.compareTo(BigDecimal.ZERO) == -1) {
							throw new BankException("Bank Balance cannot be 0 or negative");
						} else {
							Optional<Customer> customerList = customerDao.findById(customerId);
							customer = customerList.get();
							if (customer == null) {
								throw new BankException("No such customer id exists");
							} else {
								account.setAmount(newAccountBalance);
								accountDao.save(account);
								bank.setAmount(newBankBalance);
								Transaction transaction = new Transaction(customer, account, amountToBeWithdrawn,
										"Money Withdrawn");
								transactionService.createTransaction(transaction);
								bank.setAmount(newBankBalance);
								bankDao.save(bank);
							}
						}
					}
				}
				return account;
			}
		}
	}

	@Override
	public Account getAccountDetails(Long accountId) throws BankException {
		Optional<Account> accountList = accountDao.findById(accountId);
		Account account = null;
		account = accountList.get();
		if (account == null)
			throw new BankException("Account id doesnt exist");
		else {
			account = accountDao.save(account);
		}
		return account;
	}
}
