package JunitPalindrome.mypack;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseTest {

	@Test
	public void test() {

		// Creating object of class Reverse to access method to check reverse .
		ReverseString reverseObj = new ReverseString();

				// Junit method for testing if reverse is successfull or not
				assertEquals("Enter atleast two characters", true, reverseObj.checkReverse(" "));
			
	}

}
