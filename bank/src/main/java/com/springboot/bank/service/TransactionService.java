/**
 * 
 */
package com.springboot.bank.service;

import java.util.Optional;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Transaction;

/**
 * @author Sumit
 *
 */
public interface TransactionService {

	String createTransaction(Transaction transaction) throws BankException;

	Optional<Transaction> getTransactionDetails( Long customerId) throws BankException;
}
