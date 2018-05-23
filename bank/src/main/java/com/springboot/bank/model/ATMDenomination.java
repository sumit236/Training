/**
 * 
 */
package com.springboot.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Sumit
 *
 */

@Entity
public class ATMDenomination {

	@Id
	private Integer noOfDenomination;
	@OneToOne(targetEntity = RefMoney.class)
	private RefMoney refMoney;

	/**
	 * 
	 */
	public ATMDenomination() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param noOfDenomination
	 * @param refMoney
	 */
	public ATMDenomination(Integer noOfDenomination, RefMoney refMoney) {
		super();
		this.noOfDenomination = noOfDenomination;
		this.refMoney = refMoney;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ATMDenomination [noOfDenomination=" + noOfDenomination + ", refMoney=" + refMoney + "]";
	}

}