/**
 * 
 */
package com.springboot.bank.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Sumit
 *
 */
@Entity
@Table(name = "atm")
public class ATM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long atmId;
	// @Required
	private BigDecimal money;
	@ManyToOne
	@JoinColumn(name = "bankId")
	private Bank bank;

	/**
	 * 
	 */
	public ATM() {
		super();
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
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * @param bank
	 *            the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ATM [atmId=" + atmId + ", money=" + money + ", bank=" + bank + "]";
	}
}
