/**
 * 
 */
package com.springboot.bank.service;

import java.util.List;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.RefMoney;

/**
 * @author Sumit
 *
 */
public interface BankDenominationService {

	void createBankDenomination(Long bankId, List<RefMoney> response) throws BankException;

}
