/**
 * 
 */
package com.springboot.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.springboot.bank.model.Transaction;

/**
 * @author Sumit
 *
 */
public interface TransactionDAO extends JpaRepository<Transaction, Long> {

	@Query("select * from  Transaction where transactionId = ?")
	Optional< Transaction> findById(Long bankId);
}
