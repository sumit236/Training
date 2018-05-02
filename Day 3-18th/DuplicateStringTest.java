package JunitPalindrome.mypack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DuplicateStringTest {

	@Test
	public void duplicateTest() {

		// Creating object of class ContainDuplicate to access method to check duplicate
		// character.
		ContainDuplicate containObj = new ContainDuplicate();

		// method for testing if a string contains a duplicate character or not
		// assertNull("Null is not allowed", true, containObj.duplicateCheck(null));
		assertEquals("Enter atleast two characters", true, containObj.duplicateCheck(" "));
		assertEquals("It contains duplicate", true, containObj.duplicateCheck("aa"));
		assertEquals("No duplicate found", false, containObj.duplicateCheck("aba"));

	}

}
