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
public class BankDenomination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankDenominationId;
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
	public BankDenomination(Integer noOfDenomination, RefMoney refMoney) {
		super();
		this.noOfDenomination = noOfDenomination;
		this.refMoney = refMoney;
	}

	/*
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " noOfDenomination=" + noOfDenomination + ", refMoney=" + refMoney + "]";
	}

}
