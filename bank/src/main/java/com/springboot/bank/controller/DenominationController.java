/**
 * 
 */
package com.springboot.bank.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.RefMoney;
import com.springboot.bank.service.DenominationService;
import com.springboot.bank.wrapper.DenominationDetails;

/**
 * @author Sumit
 *
 */

@RestController
public class DenominationController {

	private final Logger LOGGER = Logger.getLogger(DenominationController.class);

	@Autowired
	private DenominationService denominationService;

	@PostMapping(value = "/createDenomination")
	public ResponseEntity<List<RefMoney>> createDenomination(@RequestBody DenominationDetails denominationDetails)
			throws BankException {
		List<RefMoney> refMoneyData = null;
		try {
			refMoneyData = denominationService.createDenomination(denominationDetails);
		} catch (BankException e) {
			LOGGER.error(e.getMessage());
		}
		if (refMoneyData == null)
			throw new BankException("DenominationDetails not added");
		else
			return new ResponseEntity<List<RefMoney>>(refMoneyData, HttpStatus.OK);
	}
}
