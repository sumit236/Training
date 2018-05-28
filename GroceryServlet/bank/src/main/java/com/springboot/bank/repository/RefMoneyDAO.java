/**
 * 
 */
package com.springboot.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.bank.model.RefMoney;

/**
 * @author Sumit
 *
 */
public interface RefMoneyDAO extends JpaRepository<RefMoney, Long> {

}
