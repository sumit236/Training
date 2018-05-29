/**
 * 
 */
package com.springboot.bank.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.springboot.bank.model.RefMoney;

/**
 * @author Sumit
 *
 */
public interface RefMoneyDAO extends JpaRepository<RefMoney, Long> {

	//@Query("select * from  RefMoney where refMoneyId = ?1")
	Optional<RefMoney> findByDenomination(Long refMoneyId);
	
	
	/*@Modifying
	@Query("update * from  RefMoney where refMoneyId = ?1")
	RefMoney save(RefMoney refMoney);*/
}


