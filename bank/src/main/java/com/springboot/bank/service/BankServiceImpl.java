/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.model.Bank;

/**
 * @author Sumit
 *
 */
@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	BankDAO bankDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.springboot.bank.service.BankService#createBank(com.springboot.bank.model.
	 * Bank)
	 */
	@Override
	public void createBank(Bank bank) throws BankException {
		final BigDecimal amount = bank.getAmount();
		if (amount.compareTo(BigDecimal.ZERO) <= 0)
			throw new BankException("amount cannot be zero or less than zero");
		else {
			bankDao.save(bank);
			final String bankInfo = "Bank details added";
		}
	}

	/*
	 * (non-Javadoc)
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
