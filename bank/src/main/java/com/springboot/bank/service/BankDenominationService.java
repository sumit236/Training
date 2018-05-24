/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.List;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.RefMoney;

/**
 * @author Sumit
 *
 */
public interface BankDenominationService {

	void addToBankFromAccount(BigDecimal amountToBeAdded,Long bankId) ;

	void createBankDenomination(Long bankId, List<RefMoney> refMoneyList) throws BankException;

}
