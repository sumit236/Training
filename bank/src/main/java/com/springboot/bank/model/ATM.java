/**
 * 
 */
package com.springboot.bank.model;

import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Sumit
 *
 */
public class ATM {

	@Id
	@GeneratedValue
	private Long atmId;
	// @Required
	private BigDecimal money;
	
	@OneToMany
	private Long bankId;

	/**
	 * 
	 */
	public ATM() {
		super();
	}

	/**
	 * @param atmId
	 * @param amount
	 * @param money
	 * @param bankId
	 */
	public ATM(Long atmId, BigDecimal money, Long bankId) {
		this.atmId = atmId;
		this.money = money;
		this.bankId = bankId;
	}

	/**
	 * @return the atmId
	 */
	public Long getAtmId() {
		return atmId;
	}

	/**
	 * @param atmId
	 *            the atmId to set
	 */
	public void setAtmId(Long atmId) {
		this.atmId = atmId;
	}

	/**
	 * @return the money
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            the money to set
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId
	 *            the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ATM [atmId=" + atmId + ", money=" + money + ", bankId=" + bankId + "]";
	}

}
