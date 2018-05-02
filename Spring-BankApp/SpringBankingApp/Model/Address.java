package model;

public class Address {

	private String streetName;
	private int houseNumber;
	private int zipCode;
	private String cityName;

	/**
	 * @param streetName
	 * @param houseNumber
	 * @param zipCode
	 * @param cityName
	 */
	public Address(String streetName, int houseNumber, int zipCode, String cityName) {
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.cityName = cityName;
	}

	/**
	 * @return the streetName.
	 */
	public String getStreetName() {
		return streetName;
	}

	
	/**
	 * @param streetName.
	 */
	private void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the houseNumber.
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber
	 */
	private void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * @return the zipCode.
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the cityName.
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 */
	private void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
