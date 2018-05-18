/**
 * 
 */
package com.springboot.bank.wrapper;

/**
 * @author Sumit
 *
 */
public class TransactionDetails {

	private Long customerId;
	private Long accountId;
	private Long transactionId;

	/**
	 * 
	 */
	public TransactionDetails() {
		super();
	}

	/**
	 * @param customerId
	 * @param accountId
	 * @param transactionId
	 */
	public TransactionDetails(Long customerId, Long accountId, Long transactionId) {
		this.customerId = customerId;
		this.accountId = accountId;
		this.transactionId = transactionId;
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
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the transactionId
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionDetails [customerId=" + customerId + ", accountId=" + accountId + ", transactionId="
				+ transactionId + "]";
	}

}
