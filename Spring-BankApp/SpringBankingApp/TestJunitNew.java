package springpack.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import controller.CustomerController;
import model.Account;
import model.Address;
import model.Contact;
import model.Customer;
import model.Statement;

public class TestJunitNew {

	final String dummyString = null;
	final double dummyInt = 0;
	CustomerController customerController;
	@Test
	public void ValiateAccount() {
		
		Statement statement1 = new Statement("1st statement");
		Statement statement2 = new Statement("2nd statement");
		
		assertEquals("null content is not allowed", dummyString ,statement1.getContent());
		assertEquals("null content is not allowed", dummyString ,statement2.getContent());
		
		List statementList = new ArrayList<Statement>();
		statementList.add(statement1);
		statementList.add(statement2);
		
		Account account1 = new Account("A1111",1000,statementList ,"Saving Account");
		assertSame("Account number cannot be null", dummyString ,account1.getAccountNumber());
		assertSame("money cannot be 0", dummyInt, account1.getMoney());
		assertSame("Type of account cannot be null", dummyString ,account1.getTypeOfAccount());
		
		Account account2 = new Account("A2222",1000,statementList ,"Saving Account");
		assertSame("Account number cannot be null", dummyString ,account1.getAccountNumber());
		assertSame("money cannot be 0", dummyInt, account1.getMoney());
		assertSame("Type of account cannot be null", dummyString ,account1.getTypeOfAccount());
		
		Account account3 = new Account("A3333",1000,statementList ,"Saving Account");
		assertSame("Account number cannot be null", dummyString ,account1.getAccountNumber());
		assertSame("money cannot be 0", dummyInt, account1.getMoney());
		assertSame("Type of account cannot be null", dummyString ,account1.getTypeOfAccount());
		
		Account account4 = new Account("A4444",1000,statementList ,"Saving Account");
		assertSame("Account number cannot be null", dummyString ,account1.getAccountNumber());
		assertSame("money cannot be 0", dummyInt, account1.getMoney());
		assertSame("Type of account cannot be null", dummyString ,account1.getTypeOfAccount());
		
		Account account5 = new Account("A5555",1000,statementList ,"Flexible Account");
		assertSame("Account number cannot be null", dummyString ,account1.getAccountNumber());
		assertSame("money cannot be 0", dummyInt, account1.getMoney());
		assertSame("Type of account cannot be null", dummyString ,account1.getTypeOfAccount());
		
		List accountList1 = new ArrayList<Account>();
		accountList1.add(account1);
		accountList1.add(account2);
		accountList1.add(account3);
		
		List accountList2 = new ArrayList<Account>();
		accountList2.add(account4);
		accountList2.add(account5);
		
		Address address = new Address("Gd road", 9, 421211,"Japan" );
		assertEquals("Enter a valid street name", dummyString ,address.getStreetName());
		assertSame("house no. is must", dummyInt ,address.getHouseNumber());
		assertEquals("Enter a valid city name", dummyString ,address.getCityName());
		assertSame("Valid pincode is necessary", dummyInt ,address.getZipCode());
		
		Contact contact = new Contact("987654321", "abc@gmail.com", address);
		assertEquals("Enter a valid phone no", dummyString ,contact);
	
		
		Customer customer1 = new Customer("Naruto", "Uzumaki",contact,accountList1,"C1111");
		assertEquals("Enter a valid first name", dummyString ,customer1.getFirstName());
		assertSame("Enter a valid last name", dummyString ,customer1.getLastName());
		assertEquals("Enter a valid city name", dummyString ,customer1.getCustomerId());
		
		Customer customer2 = new Customer("Naruto", "Uzumaki",contact,accountList2,"C2222");
		assertEquals("Enter a valid first name", dummyString ,customer2.getFirstName());
		assertSame("Enter a valid last name", dummyString ,customer2.getLastName());
		assertEquals("Enter a valid city name", dummyString ,customer2.getCustomerId());
		
		List customerList = new ArrayList<Customer>();
		customerList.add(customer1);
		customerList.add(customer2);
		
		Customer customer3 = new Customer("Naruto", "Uzumaki",contact,accountList2,"C333");
		assertEquals("Enter a valid first name", dummyString ,customer2.getFirstName());
		assertSame("Enter a valid last name", dummyString ,customer2.getLastName());
		assertEquals("Enter a valid city name", dummyString ,customer2.getCustomerId());
		
		customerController.addCustomer(customerList,customer3);
	}
}
