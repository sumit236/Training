/**
 * 
 */
package com.springboot.bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Sumit
 *
 */
@Entity
@Table(name = "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bankId")
	private Long bankId;
	private BigDecimal amount;
	@OneToMany(mappedBy = "bank")
	private List<Customer> customer = new ArrayList<Customer>();
	@OneToMany(mappedBy = "bank")
	private List<ATM> atm = new ArrayList<ATM>();

	/**
	 * 
	 */
	public Bank() {
		super();
	}

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
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the customer
	 */
	public List<Customer> getCustomer() {
		return customer;
	}

	/*
	 * @param customer the customer to set
	 */
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", amount=" + amount + "]";
	}
}