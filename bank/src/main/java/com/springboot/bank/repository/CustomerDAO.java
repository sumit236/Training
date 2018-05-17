/**
 * 
 */
package com.springboot.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.bank.model.Customer;

/**
 * @author Sumit
 *
 */
public interface CustomerDAO extends JpaRepository<Customer, Long> {

}
