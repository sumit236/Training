/**
 * 
 */
package com.springboot.bank.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.bank.model.Bank;

/**
 * @author Sumit
 *
 */
public interface BankDAO extends JpaRepository<Bank, Long>{
	

}
