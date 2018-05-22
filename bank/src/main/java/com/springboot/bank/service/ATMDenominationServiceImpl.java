/**
 * 
 */
package com.springboot.bank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.ATM;
import com.springboot.bank.model.ATMDenomination;
import com.springboot.bank.model.Denomination;
import com.springboot.bank.repository.ATMDAO;
import com.springboot.bank.repository.ATMDenominationDAO;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.repository.BankDenominationDAO;

/**
 * @author Sumit
 *
 */
@Service("atmDenominationService")
public class ATMDenominationServiceImpl implements ATMDenominationService {

	@Autowired
	private BankDAO bankDao;

	@Autowired
	private ATMDAO atmDao;

	@Autowired
	private ATMDenominationDAO atmDenominationDao;

	@Autowired
	private BankDenominationDAO denominationDao;

	/*
	 * @see
	 * com.springboot.bank.service.ATMDenominationService#addDenomination(java.math.
	 * BigDecimal)
	 */
	@Override
	public void addDenomination(BigDecimal amount, Long atmId, Long atmDenominationId) throws BankException {

		List<BigDecimal> denominationList = new ArrayList<BigDecimal>();
		denominationList.add(new BigDecimal(10));
		denominationList.add(new BigDecimal(20));
		denominationList.add(new BigDecimal(50));
		denominationList.add(new BigDecimal(100));
		denominationList.add(new BigDecimal(200));
		denominationList.add(new BigDecimal(500));
		denominationList.add(new BigDecimal(2000));
		BigDecimal remainderValue = amount;
		ATMDenomination atmDenomination = null;
		Denomination denomination = null;
		Random random = new Random();

		for (int i = 0; i <= denominationList.size(); i++) {
			Integer randomIndex = random.nextInt(denominationList.size());
			BigDecimal randomValue = denominationList.get(randomIndex);

			if (randomValue.compareTo(remainderValue) == 0 || randomValue.compareTo(remainderValue) == -1) {
				Optional<ATMDenomination> atmDenominationList = atmDenominationDao.findById(atmDenominationId);
				if (atmDenominationList.isPresent()) {
					atmDenomination = atmDenominationList.get();
					denomination = atmDenomination.getDenomination();
					BigDecimal updatedNoOfDenomination = denomination.getNoOfDenomination()
							.add(remainderValue.divide(randomValue));
					denomination.setNoOfDenomination(updatedNoOfDenomination);

					denomination.setDenomination(randomValue);
					remainderValue = remainderValue.remainder(randomValue);

					if (remainderValue.compareTo(BigDecimal.ZERO) == 0) {
						break;
					} else {
						denominationList.remove(randomIndex);
					}

				} else {
					throw new BankException("ATMDenomination not found");
				}
			}
			Optional<ATM> atmList = atmDao.findById(atmId);
			if (atmList.isPresent()) {
				ATM atm = atmList.get();
				atmDenomination.setAtm(atm);
				denominationDao.save(denomination);
				atmDenominationDao.save(atmDenomination);
			} else {
				throw new BankException("atm not found");
			}
		}
	}
}
