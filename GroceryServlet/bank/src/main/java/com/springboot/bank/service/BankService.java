
/**
 * 
 */
package com.springboot.bank.service;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Bank;

/**
 * @author Sumit
 *
 */
public interface BankService {

	Bank createBank(Bank bank) throws BankException;

	Bank getBankDetails(Long bankId) throws BankException;
}