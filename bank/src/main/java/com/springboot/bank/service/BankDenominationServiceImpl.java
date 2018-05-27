/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.exception.BankException;
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
@Service("bankDenominationService")
public class BankDenominationServiceImpl implements BankDenominationService {

	@Autowired
	private BankDAO bankDao;

	@Autowired
	private RefMoneyDAO refMoneyDAO;

	@Autowired
	private BankDenominationDAO bankDenominationDAO;

	/*
	 * com.springboot.bank.service.BankDenominationService#addToBankFromAccount(java
	 * .lang.Long, java.lang.Long)
	 */
	@Override
	public void addToBankFromAccount(Long bankId, BigDecimal amountToBeAdded) throws BankException {

		Random random = new Random();
		Optional<Bank> bankList = bankDao.findById(bankId);
		RefMoney refMoney;
		Bank bank = null;
		if (bankList.isPresent()) {
			bank = bankList.get();
			BankDenomination bankDenomination = bankDenominationDAO.findBybank(bankId);
			refMoney = bankDenomination.getRefMoney();
			List<RefMoney> refMoneyList = refMoneyDAO.findAll();
			BigDecimal remainderMoney = amountToBeAdded;
			Iterator iteratorOfDenomination = refMoneyList.iterator();
			RefMoney randomGeneratedRefMoney = null;
			BigDecimal randomGeneratedNote = null;
			while (iteratorOfDenomination.hasNext()) {
				int randomIndex = random.nextInt(refMoneyList.size());
				randomGeneratedRefMoney = refMoneyList.get(randomIndex);
				randomGeneratedNote = randomGeneratedRefMoney.getDenomination();

				if (randomGeneratedNote.compareTo(remainderMoney) == 0
						|| randomGeneratedNote.compareTo(remainderMoney) == -1) {
					Integer noOfDenominations = remainderMoney.divide(randomGeneratedNote).intValue();
					bankDenomination.setNoOfDenomination(noOfDenominations);
					// total no of denomination mil gae ab store karni hai isko bankDenom me
					// problem statement: vo bankDenom me ek bigdecimal field hai for
					// totalno fir baaki refmoney ke attributes kaise set honge

					remainderMoney = remainderMoney.remainder(randomGeneratedNote);
					if (remainderMoney.compareTo(BigDecimal.ZERO) == 0) {
						break;
					}
					refMoneyList.remove(randomGeneratedNote);
				}
			}
		}
	}

	public void createBankDenomination(Long bankId, List<RefMoney> refMoneyList) throws BankException {
		Optional<Bank> bankList = bankDao.findById(bankId);
		Bank bank = null;
		if (bankList.isPresent()) {
			bank = bankList.get();
			Iterator iterator = refMoneyList.iterator();
			while (iterator.hasNext()) {
				RefMoney rf1 = (RefMoney) iterator.next();
				BankDenomination bankDenomination = bankDenominationDAO.findBybank(bankId);
				bankDenomination.getRefMoney();
				bankDenomination.setRefMoney(rf1);
				bankDenomination.setNoOfDenomination(0);
				bankDenominationDAO.save(bankDenomination);
			}
			bankDao.save(bank);
		} else {
			throw new BankException("bank not found");
		}
	}
}
