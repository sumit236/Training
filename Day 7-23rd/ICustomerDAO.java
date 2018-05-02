package SpringDemo.Day1;

import java.util.Iterator;
import java.util.List;

public class ICustomerDAO implements CustomerDAO {

	public void display(List customer) {
			
		Iterator iterator = customer.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
	}

}
