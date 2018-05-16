/**
 * 
 */
package com.springboot.bank.model;

import javax.persistence.CascadeType;
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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "bankId")
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

}
