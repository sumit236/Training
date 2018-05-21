/**
 * 
 */
package com.springboot.bank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;
import com.springboot.bank.repository.BankDAO;
import com.springboot.bank.repository.CustomerDAO;
import com.springboot.bank.service.CustomerServiceImpl;
import com.springboot.bank.wrapper.WrapperBankCustomer;

/**
 * @author Sumit
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Mock
	CustomerDAO customerDao;

	@Mock
	BankDAO bankDao;

	@InjectMocks
	CustomerServiceImpl customerService;

	@Test
	public void checkCreateCustomer() {
		Bank bank = new Bank(1L, new BigDecimal(1000));
		Optional<Bank> ob = Optional.of(bank);
		final Customer customer = new Customer(1L, "sumit", 12345, bank);
		final WrapperBankCustomer cust = new WrapperBankCustomer(customer, 1L);
		when(bankDao.findById(Mockito.any(Long.class))).thenReturn(ob);
		when(customerDao.save(customer)).thenReturn(customer);
		assertThat(customerService.createCustomer(cust), is(notNullValue()));
	}

	@Test(expected = BankException.class)
	public void checkCreateCustomers() {
		final Bank bank = new Bank(1L, new BigDecimal(1000));
		final Optional<Bank> ob = Optional.empty();
		final Customer customer = new Customer(1L, "sumit", 12345, bank);
		when(bankDao.findById(Mockito.any(Long.class))).thenReturn(ob);
		when(customerDao.save(customer)).thenReturn(customer);
	}
}