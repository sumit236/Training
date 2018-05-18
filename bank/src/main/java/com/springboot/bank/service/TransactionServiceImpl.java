/**
 * 
 */
package com.springboot.bank.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Account;
import com.springboot.bank.model.Customer;
import com.springboot.bank.model.Transaction;
import com.springboot.bank.repository.CustomerDAO;
import com.springboot.bank.repository.TransactionDAO;

/**
 * @author Sumit
 *
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDAO transactionDao;

	@Autowired
	CustomerDAO customerdao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.springboot.bank.service.TransactionService#createTransaction(com.
	 * springboot.bank.wrapper.TransactionDetails)
	 */
	@Override
	public String createTransaction(Transaction transaction) throws BankException {

		Customer customer = transaction.getCustomer();
		Long customerId = customer.getCustomerId();
		Account account = transaction.getAccount();
		Long accountId = account.getAccountId();

		if (accountId == 0) {
			throw new BankException("accountId cannot be 0");
		} else if (customerId == 0) {
			throw new BankException("customerId cannot be 0");
		} else {
			transactionDao.save(transaction);
			return "Transaction details added successfully";
		}
	}

	@Override
	public Optional<Transaction> getTransactionDetails(Long customerId) throws BankException {

		if (customerId == 0) {
			throw new BankException("customerId cannot be 0");
		} else {
			Optional<Transaction> transactionList = transactionDao.findById(customerId);
			return transactionList;
		}
	}
}
