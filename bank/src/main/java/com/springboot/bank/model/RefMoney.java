/**
 * 
 */
package com.springboot.bank.model;

import java.math.BigDecimal;
import javax.persistence.Entity;

/**
 * @author Sumit
 *
 */
@Entity
public class RefMoney {

	private BigDecimal denomination;

	/**
	 * @param denomination
	 */
	public RefMoney(BigDecimal denomination) {
		super();
		this.denomination = denomination;
	}

	/**
	 * @return the denomination
	 */
	public BigDecimal getDenomination() {
		return denomination;
	}

	/**
	 * @param denomination
	 *            the denomination to set
	 */
	public void setDenomination(BigDecimal denomination) {
		this.denomination = denomination;
	}

	/*
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RefMoney [denomination=" + denomination + "]";
	}

}