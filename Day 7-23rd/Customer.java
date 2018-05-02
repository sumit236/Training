package SpringDemo.Day1;

public class Customer {

	private String firstName;
	private String lastName;
	
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	private String getFirstName() {
		return firstName;
	}
	private String getLastName() {
		return lastName;
	}
	
	
}
