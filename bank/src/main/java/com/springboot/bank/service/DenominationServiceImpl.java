/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.bank.exception.BankException;

/**
 * @author Sumit
 *
 */

@Service("bankDenominationService")
public class DenominationServiceImpl implements DenominationService {

	@Autowired
	DenominationServiceImpl denominationServiceImpl;

	@Override
	public Map<BigDecimal, Integer> getDenominationList() throws BankException {
		Map<BigDecimal, Integer> denominationList = new HashMap<BigDecimal, Integer>();
		denominationList.put(new BigDecimal(2000), 0);
		denominationList.put(new BigDecimal(500), 0);
		denominationList.put(new BigDecimal(100), 0);
		denominationList.put(new BigDecimal(50), 0);
		denominationList.put(new BigDecimal(20), 0);
		denominationList.put(new BigDecimal(10), 0);
		return denominationList;
	}

	@Override
	public Map<BigDecimal, Integer> addDenomination(BigDecimal amount) throws BankException {

		Map<BigDecimal, Integer> denominationList = denominationServiceImpl.getDenominationList();
		BigDecimal remainder = amount;
		Random random = new Random();
		Set setOfKeys = denominationList.keySet();
		Iterator iterator = setOfKeys.iterator();
		while (iterator.hasNext()) {
			BigDecimal randomElement = null;
			BigDecimal randomValue = (BigDecimal) iterator.next();
			if (randomValue.compareTo(remainder) == 0 || randomValue.compareTo(remainder) == -1) {
				randomElement = (BigDecimal) iterator.next();
				Integer noOfDenominations = remainder.divide(randomValue).intValue();
				denominationList.put(randomElement, noOfDenominations);
				remainder = remainder.remainder(randomValue);
				if (remainder.compareTo(BigDecimal.ZERO) == 0) {
					break;
				}
			}
			setOfKeys.remove(randomElement);
		}
		return denominationList;
	}

}