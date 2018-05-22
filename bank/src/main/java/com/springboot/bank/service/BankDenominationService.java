/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;

/**
 * @author Sumit
 *
 */
public interface BankDenominationService {

	void addToBankFromAccount(Long bankId,BigDecimal amount);
}
