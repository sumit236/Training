/**
 * 
 */
package com.springboot.bank.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.springboot.bank.model.Customer;

/**
 * @author Sumit
 *
 */
public interface CustomerDAO extends JpaRepository<Customer, Long> {

	@Query("select * from bank where bankId = ?")
	Optional<Customer> findById(Long customerId);
}
