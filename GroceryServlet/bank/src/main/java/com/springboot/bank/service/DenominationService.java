/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.RefMoney;
import com.springboot.bank.wrapper.DenominationDetails;

/**
 * @author Sumit
 *
 */
public interface DenominationService {

	List<RefMoney> createDenomination(DenominationDetails denominationDetails) throws BankException;

	Map<BigDecimal, Integer> addDenomination(BigDecimal amountToBeAdded) throws BankException;
}
