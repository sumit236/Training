package JunitDay4.JunitDay4;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExceptionTest {

	@Test
	public void test() throws CustomizedException {
		
		assertEquals("Enter proper input",true, CustomException.checkPower(0, 0));
		assertEquals("Enter proper input",true, CustomException.checkPower(2, 0));
		assertEquals("proper output",8, CustomException.checkPower(2, 3));
	}

}
