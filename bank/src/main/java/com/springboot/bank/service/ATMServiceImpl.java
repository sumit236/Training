/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.ATM;
import com.springboot.bank.model.Account;
import com.springboot.bank.model.Bank;
import com.springboot.bank.repository.ATMDAO;
import com.springboot.bank.repository.AccountDAO;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.repository.BankDenominationDAO;
import com.springboot.bank.wrapper.ATMDetails;
import com.springboot.bank.wrapper.WrapperBankATM;

/**
 * @author Sumit
 *
 */
@Service("ATMService")
public class ATMServiceImpl implements ATMService {

	@Autowired
	private ATMDAO atmDao;

	@Autowired
	private BankDAO bankDao;

	@Autowired
	private AccountDAO accountDao;

	@Autowired
	private BankDenominationDAO bankDenominationDao;
	
	@Autowired
	private ATMDenominationService atmDenominationService;
	/*
	 * @MethodName : createATM 
	 * Description : The method accepts the wrapper object consisting bankId, ATM object
	 * 				 and creates an ATM for a particular bank.
	 */
	@Override
	public ATM createATM(WrapperBankATM wrapperBankATM) throws BankException {
		ATM ATMData = wrapperBankATM.getAtm();
		Long bankId = wrapperBankATM.getBankId();
		Optional<Bank> bankList = /*bankDao.findByBankId(bankId);*/ null;
		Bank bank = bankList.get();
		if (bank == null)
			throw new BankException("Id not found");
		else {
			ATMData.setBank(bank);
			ATMData = atmDao.save(ATMData);
		}
		return ATMData;
	}

	/*
	 * @MethodName : addMoneyFromBank 
	 * Description : The method accepts the atmId as for the money to be added ATM, the bankId as 
	 * 				 for the money is to be added from a particular Bank and accepts money to be 
	 * 				 added to a particular ATM.
	 */
	@Override
	public ATM addMoneyFromBank(Long atmId, Long bankId, BigDecimal moneyToBeAddedToATM, Long atmDenominationId) throws BankException {

		Optional<ATM> atmList = atmDao.findByAtmId(atmId);
		ATM atmdata = null;
		ATM atm = atmList.get();
		if (atm == null)
			throw new BankException("Atm with such Id doesnt exist");
		else {
			Optional<Bank> bankList = /*bankDao.findByBankId(bankId);*/ null;
			Bank bank = bankList.get();
			if (bank == null)
				throw new BankException("Bank with such Id doesnt exist");
			else {
				BigDecimal bankMoney = bank.getAmount();
				BigDecimal finalAmount = bankMoney.subtract(moneyToBeAddedToATM);
				if (finalAmount.compareTo(BigDecimal.ZERO) == 1) {
					BigDecimal atmMoney = atm.getMoney().add(moneyToBeAddedToATM);
					//atmDenominationService.addDenomination(moneyToBeAddedToATM,atmId,atmDenominationId);
					atm.setMoney(atmMoney);
					bank.setAmount(finalAmount);
					atmdata = atmDao.save(atm);
					bankDao.save(bank);
				} else
					throw new BankException("Bank doesnt have enough money");
			}
			return atmdata;
		}
	}

	/*
	 * @MethodName : withdrawMoney 
	 * Description : The method accepts the wrapper object consisting bankId, atmId, accountId
	 * 				 from where the money is to be withdrawn. It also consist the amount to be 
	 * 				 withdrawn from the particular account.
	 * 
	 */
	@Override
	public ATM withdrawMoney(ATMDetails atmDetails) throws BankException {
		Long atmId = atmDetails.getAccountId();
		Long bankId = atmDetails.getBankId();
		Long accountId = atmDetails.getAccountId();
		BigDecimal amountToBeWithdrawn = atmDetails.getAmount();
		Account account = null;
		Bank bank = null;
		ATM atm = null;
		if (accountId == 0 || bankId == 0 || atmId == 0) {
			throw new BankException("Id cannot be zero");
		}
		else {
			Optional<Account> accountList = accountDao.findByAccountId(accountId);
			account = accountList.get();
			BigDecimal newAccountBalance;
			if (account == null) {
				throw new BankException("No such account exists");
			} else {
				newAccountBalance = account.getAmount().subtract(amountToBeWithdrawn);
				if (newAccountBalance.compareTo(BigDecimal.ZERO) == 1) {
					account.setAmount(newAccountBalance);
					accountDao.save(account);
				} else {
					throw new BankException("Account Balance cannot be negative");
				}
			}
			Optional<Bank> bankList = /*bankDao.findByBankId(bankId);*/ null;
			bank = bankList.get();
			if (bank == null) {
				throw new BankException("No such id of Bank exists");
			} else {
				BigDecimal newBankBalance = bank.getAmount().subtract(amountToBeWithdrawn);
				if (newBankBalance.compareTo(BigDecimal.ZERO) == 1) {
					bank.setAmount(newBankBalance);
					bankDao.save(bank);
				} else {
					throw new BankException("Bank Balance cannot be negative");
				}
			}
			Optional<ATM> atmList = atmDao.findByAtmId(atmId);
			atm = atmList.get();
			if (atm == null) {
				throw new BankException("No such id of ATM exists");
			} else {
				BigDecimal newBankBalance = atm.getMoney().subtract(amountToBeWithdrawn);
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
