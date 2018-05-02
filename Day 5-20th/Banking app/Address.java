

public class Address {
	private String streetName;
	private int houseNumber;
	private int zipCode;
	private String cityName;

	public Address(String streetName, int houseNumber, int zipCode, String cityName) {
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.cityName = cityName;
	}

	public String getStreetName() {
		return streetName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getCityName() {
		return cityName;
	}

}