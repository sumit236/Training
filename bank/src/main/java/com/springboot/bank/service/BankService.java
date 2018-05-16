/**
 * 
 */
package com.springboot.bank.service;

import com.springboot.bank.model.Bank;

/**
 * @author Sumit
 *
 */
public interface BankService {

	void createBank(Bank bank);

	Bank getBankDetails(Long bankId);
}
