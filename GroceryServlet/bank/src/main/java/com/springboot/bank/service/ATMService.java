/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.ATM;
import com.springboot.bank.wrapper.ATMDetails;
import com.springboot.bank.wrapper.WrapperBankATM;

/**
 * @author Sumit
 *
 */
public interface ATMService {

	ATM createATM(WrapperBankATM wrapperBankATM) throws BankException;

	ATM addMoneyFromBank(Long atmId, Long bankId, BigDecimal moneyToBeAddedToATM, Long atmDenominationId) throws BankException;

	ATM withdrawMoney(ATMDetails atmDetails) throws BankException;

}
