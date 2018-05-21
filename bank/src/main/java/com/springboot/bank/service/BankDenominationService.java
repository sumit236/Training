/**
 * 
 */
package com.springboot.bank.service;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.BankDenomination;
import com.springboot.bank.wrapper.WrapperBankDenomination;

/**
 * @author Sumit
 *
 */
public interface BankDenominationService {

	//BankDenomination addDenomination(WrapperBankDenomination wrapperBankDenomination) throws BankException;

	void  addDenominationNew(Integer amount) throws BankException;

}
