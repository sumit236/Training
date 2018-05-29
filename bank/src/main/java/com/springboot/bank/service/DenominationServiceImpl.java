/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


		final BigDecimal remainderMoney = amountToBeAdded;
		BigDecimal randomGeneratedNote = null;
		Map<BigDecimal,Integer> returningList = new HashMap<>();
		return returningList;
	}
	

	@Override
	public List<RefMoney> createDenomination(DenominationDetails denominationDetails) throws BankException{
		List<RefMoney> refMoneyList = new ArrayList<>();
		final Long bankId = denominationDetails.getBankId();
		final Long atmId = denominationDetails.getAtmId();
		final List<BigDecimal> denominationList = denominationDetails.getDenominationList();
		for (BigDecimal denom : denominationList) {
			RefMoney rf1 = new RefMoney();
			rf1.setDenomination(denom);
			refMoneyDAO.save(rf1);
		}
		bankDenominationService.createBankDenomination(bankId, refMoneyList);
		atmDenominationService.createATMDenomination(atmId, refMoneyList);
		return refMoneyList;
	}
}