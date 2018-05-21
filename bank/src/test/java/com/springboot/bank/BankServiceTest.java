/**
 * 
 */
package com.springboot.bank;

/**
 * @author Sumit
 *
 */

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Bank;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.repository.CustomerDAO;
import com.springboot.bank.service.BankServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankServiceTest{


	@Mock
	BankDAO bankDao;

	@Mock
	CustomerDAO customerDao;

	@InjectMocks
	BankServiceImpl bankServiceImpl;

	@Test
	public void createBank() {
		final Bank bank = new Bank(1L, new BigDecimal(1000));
		when(bankDao.save(bank)).thenReturn(bank);
		assertThat(bankServiceImpl.createBank(bank), is(notNullValue()));
	}

	@Test(expected = BankException.class)
	public void createBanks() {
		Bank bank = new Bank(-1L, new BigDecimal(2000));
		when(bankServiceImpl.createBank(bank)).thenThrow(new BankException(" Zero or Negative Id Not Found"));
	}
}
