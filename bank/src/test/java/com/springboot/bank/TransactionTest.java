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
import java.util.Optional;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import com.springboot.bank.controller.CustomerController;
import com.springboot.bank.controller.TransactionController;
import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Account;
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;
import com.springboot.bank.model.Transaction;
import com.springboot.bank.service.CustomerServiceImpl;
import com.springboot.bank.service.TransactionServiceImpl;
import com.springboot.bank.wrapper.WrapperBankCustomer;

/**
 * @author Sumit
 *
 */
public class TransactionTest {

	@Mock
	private TransactionServiceImpl transactionService;

	@InjectMocks
	private TransactionController transactionController;

	@Test
	public void truecheckCreateTransaction() throws BankException {
		final Bank bank = new Bank(1L, new BigDecimal(5000));
		final Customer customer = new Customer(1L, "Sasuke", 12345, bank);
		final Account account = new Account(bank, customer, new BigDecimal(35000));
		final Transaction transaction = new Transaction(1L,customer,account, new BigDecimal(20000), "Money Deposited");

	//	when(transactionService.createTransaction(transaction)).thenReturn(transaction);
		assertThat(transactionController.createTransaction(transaction), is(notNullValue()));
	}

	@Test
	public void falseCheckCreateTransaction() {
		final Bank bank = new Bank(1L, new BigDecimal(5000));
		final Customer customer = new Customer(1L, "Sasuke", 12345, bank);
		final Account account = new Account(bank, customer, new BigDecimal(35000));
		String transactionList = null;
		final Transaction transaction = new Transaction(1L,customer,account, new BigDecimal(20000), "Money Deposited");
		try {
			
			when(transactionService.createTransaction(transaction)).thenReturn( transactionList);
		} catch (BankException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResponseEntity<String> transactionDummy = null;
		try {
			transactionDummy = transactionController.createTransaction(transaction);
		} catch (BankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Transaction not found", transactionDummy.getBody(), transaction);
	}

	@Test
	public void checkTransactionDetails() {
		final Bank bank = new Bank(1L, new BigDecimal(5000));
		final Customer customer = new Customer(1L, "Sasuke", 12345, bank);
		final Account account = new Account(bank, customer, new BigDecimal(35000));
		final Transaction transaction = new Transaction(1L,customer,account, new BigDecimal(20000), "Money Deposited");
		Optional<Transaction> transactionList = null;
		/*try {
			//when(transactionService.getTransactionDetails((1L)).thenReturn(transactionList);
		} catch (BankException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		ResponseEntity<Optional<Transaction>> transactionList1 = null;
		Transaction transaction2 = null;
			//transactionList = transactionController.getTransactionDetails(1L);
			if(transactionList == null) {
				//throw new BankException("transctn null");
			}
			else {
				/*Optional<Transaction> transactionDummyList = transactionList.getBody();
				transaction2 = transactionDummyList.get();*/
			}
	assertEquals("Transaction not found", transaction2.getCustomer() , transaction.getCustomer());
	}
}
