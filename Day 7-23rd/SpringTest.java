package SpringDemo.Day1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
		Customer customer1=(Customer) context.getBean("customer1");
		Customer customer2=(Customer) context.getBean("customer2");
		
		List<Customer> customerList = new ArrayList();
		customerList.add(customer1);
		customerList.add(customer2);
		
		ICustomerDAO iCustomer = new ICustomerDAO();
		iCustomer.display(customerList);
	}

}
