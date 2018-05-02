/*
 * Program: 			 Determine whether an integer is a palindrome or not.
 * Program Description:  The program takes a value from user and 
 * 						 checks whether it's a palindrome or not.
 * 						 eg:- 121,101. 
 */
package JunitPalindrome.mypack;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class PalindromeNo

{
	private static Logger log = Logger.getLogger(ContainDuplicate.class);

	public int checkPalindrome(int number) {

		// Creating variables.
		int temporary;
		int reverse = 0;
		int remainder;
		// Storing the value accepted from user in temporary variable that will be used
		// for verifying.
		temporary = number;
		while (number > 0) {
			remainder = number % 10;
			number = number / 10;
			reverse = reverse * 10 + remainder;
		}

		// Checking the result with original variable.
		if (reverse == temporary) {
			return reverse;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {

		PalindromeNo palinObject = new PalindromeNo();
		// Accepting a no from user.
		int number;
		while (true) {
			try {
				log.info("Enter any number:");
				Scanner scanner = new Scanner(System.in);
				number = scanner.nextInt();
				palinObject.checkPalindrome(number);
				scanner.close();
			} catch (Exception e) {
				log.info("Please enter a valid input");
			}
		}
	}
}