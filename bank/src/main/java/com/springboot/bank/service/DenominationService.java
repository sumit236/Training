/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.Map;

import com.springboot.bank.exception.BankException;

/**
 * @author Sumit
 *
 */
public interface DenominationService {

	public Map<BigDecimal, Integer> getDenominationList() throws BankException;

	Map<BigDecimal, Integer> addDenomination(BigDecimal amount) throws BankException;
}
