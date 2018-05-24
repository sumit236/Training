/**
 * 
 */
package com.springboot.bank.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Sumit
 *
 */
@Entity
public class RefMoney  extends BaseEntity{

	@Id
	private BigDecimal denomination;

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
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RefMoney [denomination=" + denomination + "]";
	}

	/**
	 * @param denomination
	 */
	public RefMoney(BigDecimal denomination) {
		super();
		this.denomination = denomination;
	}

	/**
	 * 
	 */
	public RefMoney() {
		super();
	}

}
