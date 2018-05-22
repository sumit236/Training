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
public class ATMDenomination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long atmDenominationId;
	@OneToOne(targetEntity = ATM.class)
	private ATM atm;
	@OneToOne(targetEntity = Denomination.class)
	private Denomination denomination;

	/**
	 * 
	 */
	public ATMDenomination() {
		super();
	}

	/**
	 * @param atmDenominationId
	 * @param atm
	 * @param denomination
	 */
	public ATMDenomination(Long atmDenominationId, ATM atm, Denomination denomination) {
		super();
		this.atmDenominationId = atmDenominationId;
		this.atm = atm;
		this.denomination = denomination;
	}

	/**
	 * @return the atmDenominationId
	 */
	public Long getAtmDenominationId() {
		return atmDenominationId;
	}

	/**
	 * @param atmDenominationId
	 *            the atmDenominationId to set
	 */
	public void setAtmDenominationId(Long atmDenominationId) {
		this.atmDenominationId = atmDenominationId;
	}

	/**
	 * @return the atm
	 */
	public ATM getAtm() {
		return atm;
	}

	/**
	 * @param atm
	 *            the atm to set
	 */
	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	/**
	 * @return the denomination
	 */
	public Denomination getDenomination() {
		return denomination;
	}

	/**
	 * @param denomination
	 *            the denomination to set
	 */
	public void setDenomination(Denomination denomination) {
		this.denomination = denomination;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ATMDenomination [atmDenominationId=" + atmDenominationId + ", atm=" + atm + ", denomination="
				+ denomination + "]";
	}

}