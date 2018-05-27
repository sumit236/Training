/**
 * 
 */
package com.springboot.bank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import com.springboot.bank.controller.ATMController;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.ATM;
import com.springboot.bank.model.Bank;
import com.springboot.bank.service.ATMServiceImpl;
import com.springboot.bank.wrapper.WrapperBankATM;

/**
 * @author Sumit
 *
 */
public class ATMTest {


	@Mock
	ATMServiceImpl atmServiceImpl;

	@InjectMocks
	ATMController atmController;

	@Test
	public void truecheckCreateATM() throws BankException {
		Bank bank = new Bank();
		final ATM atm = new ATM(new BigDecimal(1234), bank);
		final Long bankId = 1L;
		WrapperBankATM wrapperBankATM = new WrapperBankATM(atm, bankId);
		when(atmServiceImpl.createATM(wrapperBankATM)).thenReturn(atm);
		assertThat(atmController.createATM(wrapperBankATM), is(notNullValue()));
	}

	@Test
	public void falseCheckCreateATM() {
		Bank bank = new Bank();
		final ATM atm = new ATM(new BigDecimal(1234), bank);
		final Long bankId = -1L;
		final WrapperBankATM wrapperBankATM = new WrapperBankATM(atm, bankId);
		try {
			when(atmServiceImpl.createATM(wrapperBankATM)).thenReturn(atm);
		} catch (BankException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResponseEntity<ATM> atmDummyList = null;
		ATM atmDummy = null;
		try {
			atmDummyList = atmController.createATM(wrapperBankATM);
			atmDummy = atmDummyList.getBody();
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Customer not found", atmDummy, atm);
	}
}
