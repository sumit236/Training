/**
 * 
 */
package com.springboot.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.bank.model.Bank;
import com.springboot.bank.service.BankService;

/**
 * @author Sumit
 *
 */
@RestController
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping(value = "/addBank")
	public ResponseEntity<Bank> addBank(@RequestBody Bank bank) throws BankException {
		Bank bankData = null;
		try {
			/* bankData = */bankService.createBank(bank);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (bankData == null)
			throw new BankException("Bank details not added");
		else
			return new ResponseEntity<Bank>(bank, HttpStatus.OK);
	}

	@GetMapping(value = "/getBankDetails/{bankId}")
	public ResponseEntity<Bank> getBankDetails(@PathVariable Long bankId) throws BankException {
		Bank bank = null;
		try {
			bank = bankService.getBankDetails(bankId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (bank == null)
			throw new BankException("No such Id of Bank exixts");
		else
			return new ResponseEntity<Bank>(bank, HttpStatus.OK);
	}
}
