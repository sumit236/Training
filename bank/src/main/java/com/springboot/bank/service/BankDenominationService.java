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
public interface BankDenominationService {

	void addToBankFromAccount(Long bankId,BigDecimal amount, Map<BigDecimal, Integer> denominationList) throws BankException;
}
