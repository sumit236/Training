/* 
 * Program: 			 Program to check whether a particular word is containing duplicate
 * 						 character or not.
 * Program Description:  It checks whether the particular string contains a duplicate 
 * 						 character or not.  
 */

package JunitPalindrome.mypack;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class ContainDuplicate {

	
	private static Logger log = Logger.getLogger(ContainDuplicate.class);

/* Method Name:		DuplicateCheck
 * Description:  	A method accepts string and check for duplicate character if found returns true.
 */
	public boolean duplicateCheck(final String holder) {
		int iterate = 0;
		final int length = holder.length();
		for (iterate = 0; iterate < length; iterate++) {
			for (int inneriter = iterate + 1; inneriter < length - 1; inneriter++) {
				if (holder.charAt(iterate) == holder.charAt(inneriter))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// A string passed to function for checking the duplicate character.
		String nameCheck;
		log.info("Enter any string:");
		Scanner scanner = new Scanner(System.in);
		nameCheck = scanner.next();
		ContainDuplicate contain = new ContainDuplicate();
		log.info(nameCheck + " is " + contain.duplicateCheck(nameCheck) + "ly containing duplicate character");
	}

}