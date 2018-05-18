/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.ATM;
import com.springboot.bank.model.Account;
import com.springboot.bank.model.Bank;
import com.springboot.bank.repository.ATMDAO;
import com.springboot.bank.repository.AccountDAO;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.wrapper.ATMDetails;
import com.springboot.bank.wrapper.AccountDetails;
import com.springboot.bank.wrapper.WrapperBankATM;

/**
 * @author Sumit
 *
 */
@Service("ATMService")
public class ATMServiceImpl implements ATMService {

	@Autowired
	ATMDAO atmDao;

	@Autowired
	BankDAO bankDao;

	@Autowired
	AccountDAO accountDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.springboot.bank.service.ATMService#createATM(com.springboot.bank.model.
	 * ATM)
	 */
	@Override
	public ATM createATM(WrapperBankATM wrapperBankATM) throws BankException {
		ATM ATMData = wrapperBankATM.getAtm();
		Long bankId = wrapperBankATM.getBankId();
		Optional<Bank> bankList = bankDao.findById(bankId);
		Bank bank = bankList.get();
		if (bank == null)
			throw new BankException("Id not found");
		else {
			ATMData.setBank(bank);
			ATMData = atmDao.save(ATMData);
		}
		return ATMData;
	}

	@Override
	public ATM addMoneyFromBank(Long atmId, Long bankId, BigDecimal moneyToBeAddedToATM) throws BankException {

		Optional<ATM> atmList = atmDao.findById(atmId);
		ATM atmdata = null;
		ATM atm = atmList.get();
		if (atm == null)
			throw new BankException("Atm with such Id doesnt exist");
		else {
			Optional<Bank> bankList = bankDao.findById(bankId);
			Bank bank = bankList.get();
			if (bank == null)
				throw new BankException("Bank with such Id doesnt exist");
			else {
				BigDecimal bankMoney = bank.getAmount();
				BigDecimal finalAmount = bankMoney.subtract(moneyToBeAddedToATM);
				if (finalAmount.compareTo(BigDecimal.ZERO) == 1) {
					atm.setMoney(moneyToBeAddedToATM);
					bank.setAmount(finalAmount);
					atmdata = atmDao.save(atm);
					bankDao.save(bank);
				} else
					throw new BankException("Bank doesnt have enough money");
			}
			return atmdata;
		}
	}

	@Override
	public ATM withdrawMoney(ATMDetails atmDetails) throws BankException {
		Long atmId = atmDetails.getAccountId();
		Long bankId = atmDetails.getBankId();
		Long accountId = atmDetails.getAccountId();
		BigDecimal amountToBeWithdrawn = atmDetails.getAmount();
		Account account = null;
		Bank bank = null;
		ATM atm = null;
		if (accountId == 0 || bankId == 0 || atmId == 0 || amountToBeWithdrawn.compareTo(BigDecimal.ZERO) == 0)
			throw new BankException("Id or amount cannot be zero");
		else {
			Optional<Account> accountList = accountDao.findById(accountId);
			account = accountList.get();
			BigDecimal newAccountBalance;
			if (account == null) {
				throw new BankException("No such account exists");
			} else {
				newAccountBalance = amountToBeWithdrawn.subtract(account.getAmount());
				if (newAccountBalance.compareTo(BigDecimal.ZERO) == 1) {
					account.setAmount(newAccountBalance);
					accountDao.save(account);
				} else {
					throw new BankException("Account Balance cannot be negative");
				}
			}
			Optional<Bank> bankList = bankDao.findById(bankId);
			bank = bankList.get();
			if (bank == null) {
				throw new BankException("No such id of Bank exists");
			} else {
				BigDecimal newBankBalance = amountToBeWithdrawn.subtract(bank.getAmount());
				if (newBankBalance.compareTo(BigDecimal.ZERO) == 1) {
					bank.setAmount(newBankBalance);
					bankDao.save(bank);
				} else {
					throw new BankException("Bank Balance cannot be negative");
				}
			}
			Optional<ATM> atmList = atmDao.findById(atmId);
			atm = atmList.get();
			if (atm == null) {
				throw new BankException("No such id of ATM exists");
			} else {
				BigDecimal newBankBalance = amountToBeWithdrawn.subtract(bank.getAmount());
				if (newBankBalance.compareTo(BigDecimal.ZERO) == 1) {
					atm.setMoney(newAccountBalance);
					atmDao.save(atm);
				} else {
					throw new BankException("ATM Balance cannot be negative");
				}
			}
		}
		return atm;
	}
}
