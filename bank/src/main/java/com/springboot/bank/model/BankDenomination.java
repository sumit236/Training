/**
 * 
 */
package com.springboot.bank.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Sumit
 *
 */

@Entity
public class BankDenomination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankDenominationId;
	@OneToOne(targetEntity = Bank.class)
	private Bank bank;
	private Integer noOfDenomination;
	private BigDecimal denomination;

	/**
	 * 
	 */
	public BankDenomination() {
		super();
	}

	/**
	 * @param bankDenominationId
	 * @param bank
	 * @param noOfDenomination
	 * @param denomination
	 */
	public BankDenomination(Long bankDenominationId, Bank bank, Integer noOfDenomination, BigDecimal denomination) {
		super();
		this.bankDenominationId = bankDenominationId;
		this.bank = bank;
		this.noOfDenomination = noOfDenomination;
		this.denomination = denomination;
	}

	/**
	 * @return the bankDenominationId
	 */
	public Long getBankDenominationId() {
		return bankDenominationId;
	}

	/**
	 * @param bankDenominationId
	 *            the bankDenominationId to set
	 */
	public void setBankDenominationId(Long bankDenominationId) {
		this.bankDenominationId = bankDenominationId;
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

	/**
	 * @return the noOfDenomination
	 */
	public Integer getNoOfDenomination() {
		return noOfDenomination;
	}

	/**
	 * @param noOfDenomination
	 *            the noOfDenomination to set
	 */
	public void setNoOfDenomination(Integer noOfDenomination) {
		this.noOfDenomination = noOfDenomination;
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
		return "BankDenomination [bankDenominationId=" + bankDenominationId + ", bank=" + bank + ", noOfDenomination="
				+ noOfDenomination + ", denomination=" + denomination + "]";
	}

}