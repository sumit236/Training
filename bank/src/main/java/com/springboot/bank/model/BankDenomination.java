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
	@OneToOne(targetEntity = RefMoney.class)
	private RefMoney refMoney;

	/**
	 * 
	 */
	public BankDenomination() {
		super();
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
	 * @return the refMoney
	 */
	public RefMoney getRefMoney() {
		return refMoney;
	}

	/**
	 * @param refMoney
	 *            the refMoney to set
	 */
	public void setRefMoney(RefMoney refMoney) {
		this.refMoney = refMoney;
	}

	/**
	 * @param bankDenominationId
	 * @param bank
	 * @param noOfDenomination
	 * @param refMoney
	 */
	public BankDenomination(Long bankDenominationId, Bank bank, Integer noOfDenomination, RefMoney refMoney) {
		super();
		this.bankDenominationId = bankDenominationId;
		this.bank = bank;
		this.noOfDenomination = noOfDenomination;
		this.refMoney = refMoney;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankDenomination [bankDenominationId=" + bankDenominationId + ", bank=" + bank + ", noOfDenomination="
				+ noOfDenomination + ", refMoney=" + refMoney + "]";
	}

}
