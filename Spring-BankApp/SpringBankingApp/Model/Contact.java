package model;

public class Contact {
	
	private String mobileNumber;
	private String emailId;
	Address address;

	
	/**
	 * @param mobileNumber
	 * @param emailId
	 * @param addressObj
	 */
	public Contact(String mobileNumber, String emailId, Address address) {
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
	}

	/**
	 * @param mobileNumber
	 */
	private void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the mobile number.
	 */
	private String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param emailId
	 */
	private void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * @return the emailId.
	 */
	private String getEmailId() {
		return emailId;
	}

	/**
	 * @param address
	 */
	private void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * @return the address.
	 */
	private Address getAddress() {
		return address;
	}

}
