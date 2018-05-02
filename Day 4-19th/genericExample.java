import java.util.Scanner;

import org.apache.log4j.Logger;

import mypack.ContainDuplicate;

/**
 * Program 		: Program to make use of Generics. 
 * Description 	: A program to accept array and pass it to method that 
 * 				  can accept any type of data.
 */
public class genericExample {

	private static Logger log = Logger.getLogger(ContainDuplicate.class);
	
	/**
	 * Method Name : toArray 
	 * Description : Method that accepts either integer/String array and 
	 * 				 dynamically change type of method using generics.
	 */
	private static <E> void toArray(E[] holdingArray) {

		for (E holder : holdingArray) {
			log.info(holder);
		}

	}

	public static void main(String[] args) {

		final Scanner read = new Scanner(System.in);
		int rangeOfInt;
		int rangeOfStr;
		//
		log.info("Enter size for integer array");
		rangeOfInt = read.nextInt();
		Integer intArrary[] = new Integer[rangeOfInt];
		for (int iterator = 0; iterator < rangeOfInt; iterator++) {
			intArrary[iterator] = read.nextInt();
		}
		log.info("Enter size for string array\t");
		rangeOfStr = read.nextInt();
		String[] stringArray = new String[rangeOfStr];
		for (int iterator = 0; iterator < rangeOfStr; iterator++) {
			stringArray[iterator] = read.nextLine();
		}
		log.info("Outptu is ");
		genericExample.toArray(stringArray);

	}
}
