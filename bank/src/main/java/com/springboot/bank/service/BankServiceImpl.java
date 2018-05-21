/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Bank;
import com.springboot.bank.repository.BankDAO;

/**
 * @author Sumit
 *
 */
@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	BankDAO bankDao;

	/*
	 * 
	 * @see
	 * com.springboot.bank.service.BankService#createBank(com.springboot.bank.model.
	 * Bank)
	 */
	@Override
	public Bank createBank(Bank bank) throws BankException {
		Bank bankData = null;
		final BigDecimal amount = bank.getAmount();
		/*if (amount.compareTo(BigDecimal.ZERO) == -1)
			throw new BankException("amount cannot be zero or less than zero");
		else {*/
			bankData = bankDao.save(bank);
			return bankData;
	}

	/*
	 * 
	 * @see com.springboot.bank.service.BankService#getBankDetails(java.lang.Long)
	 */
	@Override
	public Bank getBankDetails(Long bankId) throws BankException {
		Optional<Bank> bankList = bankDao.findById(bankId);
		if (bankList.isPresent()) {
			Bank bank = bankList.get();
			return bank;
		} else
			throw new BankException("Bank details not found");
	}
}
