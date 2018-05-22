/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Account;
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.BankDenomination;
import com.springboot.bank.model.RefMoney;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.repository.BankDenominationDAO;
import com.springboot.bank.repository.RefMoneyDAO;

/**
 * @author Sumit
 *
 */
public class BankDenominationServiceImpl implements BankDenominationService {

	@Autowired
	private BankDAO bankDao;

	@Autowired
	private RefMoneyDAO refMoneyDAO;

	@Autowired
	BankDenominationDAO bankDenominationDAO;

	/*
	 * com.springboot.bank.service.BankDenominationService#addToBankFromAccount(java
	 * .lang.Long, java.lang.Long)
	 */
	@Override
	public void addToBankFromAccount(Long bankId, BigDecimal amountToBeAdded, Map<BigDecimal, Integer> denominationList)
			throws BankException {

		Bank bank = null;
		RefMoney refMoney = null;
		Optional<Bank> bankList = bankDao.findById(bankId);
		if (bankList.isPresent()) {
			bank = bankList.get();
			Set denominationSetOfKeys = denominationList.keySet();
			BankDenomination bankDenomination = new BankDenomination();
			Iterator iterator = denominationSetOfKeys.iterator();

			// set money for bank
			BigDecimal newBankBalance = amountToBeAdded.add(bank.getAmount());
			bank.setAmount(newBankBalance);
			bankDao.save(bank);
			
			while (iterator.hasNext()) {
				BigDecimal denomination = (BigDecimal) iterator.next();
				refMoney = bankDenomination.getRefMoney();
				refMoney.setDenomination(denomination);
				refMoneyDAO.save(refMoney);
				// null pointer exception
				Integer updatedDenomination = bankDenomination.getNoOfDenomination()
						+ denominationList.get(denomination);

				// set bankdenomination
				bankDenomination.setBank(bank);
				bankDenomination.setRefMoney(refMoney);
				bankDenomination.setNoOfDenomination(updatedDenomination);
				bankDenominationDAO.save(bankDenomination);
			}
		} else {
			throw new BankException("No such bank account exists");
		}
	}
}
