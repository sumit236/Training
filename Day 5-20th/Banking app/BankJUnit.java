import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BankJUnit {

	// Creates two Statement Objects to add in statementList.
	Statement statementObj1 = new Statement("1st Statement");

	/**
	 * Method		:	checkStatement
	 * Description	:	Check the complete address like street name,zipcode,city.
	 */
	@Test
	public void checkStatement(){
		String dummy=null;
	assertEquals("Enter valid Statemnt ",dummy,statementObj1.getContent());
	}
	
	// Creates a List to add all Statement in single List ie statementList.
	List statementList = new ArrayList<Statement>();
	statementList.add(statementObj1);

	
	// Creates an Address object.
	Address addressObj = new Address("Road", 9, 23453, "Tokyo");

	/**
	 * Method		:	checkAddress
	 * Description	:	Check the complete address like street name,zipcode,city.
	 */
	@Test
	public void checkAddress(){
		String dummy=null;
		int number=0;
	assertEquals("Enter valid street name",dummy,addressObj.getStreetName());
	assertEquals("Enter  valid city name",dummy,addressObj.getCityName());
	assertEquals("enter vaild house no ",number,addressObj.getHouseNumber());
	assertEquals("enter vaild zip code ",number,addressObj.getZipCode());
	}
	
	
	// Creates an Contact object which takes Address object along with different
	// args(One to One Relationship).
	Contact contactObj = new Contact("123456789", "sssss@asd.asd", addressObj);

	/**
	 * Method		:	contactEmail
	 * Description	:	Check the email entered is correct/not.
	 */
	@Test
	public void contactEmail(){
		String dummy=null;
		String number=null;
	assertEquals("Error null email id is not allowed",dummy,contactObj.getEmailId());
	assertEquals("Error enter vaild mobile no",number,contactObj.getMobileNumber());
	}
	
	
	// Creates two Account objects for a particular person.
	Account savingAccount1 = new SavingAccount(10000, 15, statementList, "abc");

	/**
	 * Method		:	checkMoneyandPeriodNull
	 * Description	:	Check the first and last name entered is null/not
	 */
		@Test
		public void checkMoneyandPeriodNull(){
			double dummy=0;
			assertEquals("0 is not allowed",dummy,savingAccount1.getMoney());
			assertEquals("period must be more than 0",dummy,savingAccount1.getPeriod());
		}

	// Creates a List by name accountList to add all the account for that person.
	List accountList = new ArrayList<Account>();
	accountList.add(savingAccount1);
	
	
	// Creates a Customer object having multiple account(One to Many Relationship).
	Customer customer = new Customer("Sasuke", "Uchiha", contactObj, accountList);

/**
 * Method		:	checkNameNull
 * Description	:	Check the first and last name entered is null/not
 */
	@Test
	public void checkNameNull(){
		String dummy=null;
	assertEquals("Error enter valid first name",dummy,customer.getFirstName());
	assertEquals("Error enter valid last name",dummy,customer.getLastName());
	}

}