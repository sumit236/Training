package JunitDay4.JunitDay4;

import static org.junit.Assert.*;

import org.junit.Test;

public class genericTest {

	@Test
	public void testGenerics() {
		
		/*@Before
		private static String CheckFunc() 
		{
			String dummyStr[] = {"Full " ,"metal", "Alchemist"};
			return dummyStr;
		}*/
		
		String dummyStr[] = {"Full " ,"metal", "Alchemist"};
		int dummyInt[] = {1,2,3,4,5};
		
		assertEquals("Please enter proper input", false,genericExample.toArray(dummyStr));
		assertEquals("Please enter proper input", true,genericExample.toArray(dummyInt));
		
		
	}

}
