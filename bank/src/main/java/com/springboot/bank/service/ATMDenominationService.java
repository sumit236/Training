/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import com.springboot.bank.exception.BankException;

/**
 * @author Sumit
 *
 */
public interface ATMDenominationService {

	void addDenomination(BigDecimal amount, Long atmId, Long atmDenominationId) throws BankException;
}
