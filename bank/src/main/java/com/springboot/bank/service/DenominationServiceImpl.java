/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.RefMoney;
import com.springboot.bank.repository.RefMoneyDAO;
import com.springboot.bank.wrapper.DenominationDetails;

/**
 * @author Sumit
 *
 */

@Service("denominationService")
public class DenominationServiceImpl implements DenominationService {

	@Autowired
	private BankDenominationService bankDenominationService;
	
	@Autowired
	private RefMoneyDAO refMoneyDAO;
	
	@Autowired
	private ATMDenominationService atmDenominationService;
	
	@Override
	public Map<BigDecimal, Integer> addDenomination(BigDecimal amountToBeAdded) throws BankException {

		RefMoney refMoney = null;
		BigDecimal remainderMoney = amountToBeAdded;
		BigDecimal randomGeneratedNote = null;
		Map<BigDecimal,Integer> returningList = new HashMap<>();

		Random random = new Random();
	
		Iterator iteratorOfDenomination = denominationList.iterator();
			while(iteratorOfDenomination.hasNext()) {
				
			int randomIndex = random.nextInt(denominationList.size());
			randomGeneratedNote =  denominationList.get(randomIndex);
			
			if (randomGeneratedNote.compareTo(remainderMoney) == 0 || randomGeneratedNote.compareTo(remainderMoney) == -1) {
				Integer noOfDenominations = remainderMoney.divide(randomGeneratedNote).intValue();
	
				returningList.put(randomGeneratedNote, noOfDenominations);
				remainderMoney = remainderMoney.remainder(randomGeneratedNote);
				if (remainderMoney.compareTo(BigDecimal.ZERO) == 0) {
					break;
				}
			}
			denominationList.remove(randomGeneratedNote);
		}
		return returningList;
	}

}



	@Override
	public List<RefMoney> createDenomination(DenominationDetails denominationDetails) throws BankException {
		List<RefMoney> response = new ArrayList<>();
		final Long bankId = denominationDetails.getBankId();
		final Long atmId = denominationDetails.getAtmId();
		final List<BigDecimal> denominationList = denominationDetails.getDenominationList();
		for (BigDecimal denom : denominationList) {
			RefMoney rf1 = new RefMoney();
			rf1.setDenomination(denom);
			response.add(rf1);
		}
		refMoneyDAO.saveAll(response);
		bankDenominationService.createBankDenomination(bankId, response);
		atmDenominationService.createATMDenomination(atmId, response);
		return response;
	}
}