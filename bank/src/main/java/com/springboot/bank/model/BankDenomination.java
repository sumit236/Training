/**
 * 
 */
package com.springboot.bank.model;

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
public class BankDenomination extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankDenominationId;
	private Integer noOfDenomination;
	@OneToOne(targetEntity = RefMoney.class)
	private RefMoney refMoney;
	@OneToOne(targetEntity = Bank.class)
	private Bank bank;

	/**
	 * 
	 */
	public BankDenomination() {
		super();
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

	/*
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankDenomination [bankDenominationId=" + bankDenominationId + ", noOfDenomination=" + noOfDenomination
				+ ", refMoney=" + refMoney + ", bank=" + bank + "]";
	}

	/**
	 * @return the bankDenominationId
	 */
	public Integer getBankDenominationId() {
		return bankDenominationId;
	}

	/**
	 * @param bankDenominationId
	 *            the bankDenominationId to set
	 */
	public void setBankDenominationId(Integer bankDenominationId) {
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

}
