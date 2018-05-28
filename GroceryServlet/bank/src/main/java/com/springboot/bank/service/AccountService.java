/**
 * 
 */
package com.springboot.bank.service;

import com.springboot.bank.exception.BankException;
import com.springboot.bank.model.Account;
import com.springboot.bank.wrapper.AccountDetails;
import com.springboot.bank.wrapper.WrapperBankCustomerAccount;

/**
 * @author Sumit
 *
 */
public interface AccountService {

	Account createAccount(WrapperBankCustomerAccount wrapperBankCustomerAccount) throws BankException;

	Account depositMoney(AccountDetails accountDetails) throws BankException;

	Account withdrawMoney(AccountDetails accountDetails) throws BankException;

	Account getAccountDetails(Long accountId) throws BankException;
}
