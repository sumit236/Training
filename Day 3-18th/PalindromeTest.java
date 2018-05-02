package JunitPalindrome.mypack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void testPalindrome() {
		// Creating object of class PalindromeNo to access method to check palindrome.
		PalindromeNo paliObj = new PalindromeNo();

		// Junit method for testing if a number is palindrome or not
		assertEquals("Number is palindrome ", 121, paliObj.checkPalindrome(121));
		assertEquals("Number is not a palindrome ", 0, paliObj.checkPalindrome(1));
		assertEquals("Number is a palindrome ", 11, paliObj.checkPalindrome(11));
	}

}
