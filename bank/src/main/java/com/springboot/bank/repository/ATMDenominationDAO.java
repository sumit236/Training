/**
 * 
 */
package com.springboot.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.bank.model.ATMDenomination;

/**
 * @author Sumit
 *
 */
public interface ATMDenominationDAO extends JpaRepository<ATMDenomination, Long> {

}
