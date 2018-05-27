/**
 * 
 */
package com.springboot.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bank.model.Bank;

/**
 * @author Sumit
 *
 */
public interface BankDAO extends JpaRepository<Bank, Long> {

	@Query("select * from bank where bankId = ?")
	Optional<Bank> findById(Long bankId);
}
