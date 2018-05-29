/**
 * 
 */
package com.springboot.bank.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Sumit
 *
 */

@MappedSuperclass
public class BaseEntity {

	@Column(name="userId")
	String userID;
}
