/**
 * 
 */
package com.springboot.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bank.model.ATM;


/**
 * @author trainee
 *
 */
public interface ATMDAO extends JpaRepository<ATM, Long> {

	//@Query("select * from ATM where atmId = ?1")
	Optional<ATM> findByAtmId(Long atmId);
}
