/**
 * 
 */
package com.springboot.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

/**
 * @author Sumit
 *
 */
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column(nullable = false, length = 100)
	private String customerName;
	@NonNull
	private Integer customerPin;
	@ManyToOne
	// @JoinTable(name = "bank_customer", joinColumns = @JoinColumn(name = "customerId"), inverseJoinColumns = @JoinColumn(name = "bankId"))
	@JoinColumn(name = "bankId")
	private Bank bank;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerPin
	 */
	public Integer getCustomerPin() {
		return customerPin;
	}

	/**
	 * @param customerPin
	 *            the customerPin to set
	 */
	public void setCustomerPin(Integer customerPin) {
		this.customerPin = customerPin;
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
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPin=" + customerPin
				+ ", bank=" + bank + "]";
	}

}
