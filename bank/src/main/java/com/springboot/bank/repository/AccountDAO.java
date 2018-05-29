/**
 * 
 */
package com.springboot.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.springboot.bank.model.Account;

/**
 * @author Sumit
 *
 */
public interface AccountDAO extends JpaRepository<Account, Long>{

	
	//@Query("select * from account where account_id = ?1")
	Optional<Account> findByAccountId(Long accountId);
}
