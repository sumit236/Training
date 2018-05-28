/**
 * 
 */
package com.springboot.bank.wrapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sumit
 *
 */
public class DenominationDetails {

	Long bankId;
	Long atmId;
	List<BigDecimal> denominationList;

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
	 * @return the denominationList
	 */
	public List<BigDecimal> getDenominationList() {
		return denominationList;
	}

	/**
	 * @param denominationList
	 *            the denominationList to set
	 */
	public void setDenominationList(List<BigDecimal> denominationList) {
		this.denominationList = denominationList;
	}

	/*
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DenominationDetails [bankId=" + bankId + ", atmId=" + atmId + ", denominationList=" + denominationList
				+ "]";
	}

	/**
	 * @param bankId
	 * @param atmId
	 * @param denominationList
	 */
	public DenominationDetails(Long bankId, Long atmId, List<BigDecimal> denominationList) {
		super();
		this.bankId = bankId;
		this.atmId = atmId;
		this.denominationList = denominationList;
	}

	/**
	 * 
	 */
	public DenominationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
