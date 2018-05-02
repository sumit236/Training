

public class Contact {
	private String mobileNumber;
	private String emailId;

	Address addressObj;

	public Contact(String mobileNumber, String emailId, Address addressObj) {
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.addressObj = addressObj;
	}

	/**
	 * Method	:	getMobileNumber()
	 * @returns mobile no.
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Method	:	getEmailId()
	 * @returns email Id.
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Method	:	getAddressObj()
	 * @returns address object.
	 */
	public Address getAddressObj() {
		return addressObj;
	}

}