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
import com.springboot.bank.model.Bank;
import com.springboot.bank.model.Customer;
import com.springboot.bank.model.Transaction;
import com.springboot.bank.service.CustomerServiceImpl;
import com.springboot.bank.service.TransactionServiceImpl;
import com.springboot.bank.wrapper.WrapperBankCustomer;

/**
 * @author Lohit
 *
 */
public class TransactionTest {

	@Mock
	TransactionServiceImpl transactionService;

	@InjectMocks
	TransactionController transactionController;

	@Test
	public void truecheckCreateTransaction() throws BankException {
		final Transaction transaction = new Transaction();

		when(transactionService.createTransaction(transaction)).thenReturn(transaction);
		assertThat(transactionController.createTransaction(transaction), is(notNullValue()));
	}

	@Test
	public void falseCheckCreateTransaction() {
		final Transaction transaction = new Transaction();
		try {
			when(transactionService.createTransaction(transaction)).thenReturn(transaction);
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
		final Transaction transaction = new Transaction();
		try {
			when(transactionService.getTransactionDetails((1L)).thenReturn(transaction);
		} catch (BankException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResponseEntity<Optional<Transaction>> transactionList = null;
		Transaction transaction2 = null;
			transactionList = transactionController.getTransactionDetails(1L);
			if(transactionList == null) {
				throw new BankException("transctn null");
			}
			else {
				Optional<Transaction> transactionDummyList = transactionList.getBody();
				transaction2 = transactionDummyList.get();
			}
	assertEquals("Transaction not found", transaction2.getCustomer() , transaction.getCustomer());
	}
}
