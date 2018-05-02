/*
 * Program: 			 Reverse the word in a String.
 * Program Description:  The program takes a sentence from the user and 
 * 						 reverse every word of the sentence . 
 * 						 eg:- "This is it" becomes "sihT si ti"
 */

package JunitPalindrome.mypack;

import org.apache.log4j.Logger;

public class ReverseString {

	private static Logger log = Logger.getLogger(ContainDuplicate.class);
	
	private String checkReverse(StringBuilder holder)
	{
		 int length = holder.length()-1;
		 String tempHolder = holder.reverse().toString();
		 return tempHolder;
	}

	public static void main(String[] args) {

		final String initArray = " Let's take a contest ";
		 StringBuilder strInit = new StringBuilder(initArray);
		// String array to store reverse
		ReverseString reverseObj = new ReverseString();
		String str1 = reverseObj.checkReverse(strInit);
		log.info(str1);
	}
}