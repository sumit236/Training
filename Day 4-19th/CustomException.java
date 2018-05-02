package JunitDay4.JunitDay4;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Program 		: To build a customized exception. 
 * Description 	: The program is to build a customized exception on various scenarios: 
 * 					1) If both are positive method should return a value. 
 * 					2) If both are 0 throw user defined exception.
 * 					3) If one of them is 0 throw user defined exception.
 */

class CustomizedException extends Exception {
	public CustomizedException(final String Message) {
		super(Message);

	}
}

public class CustomException {

	private static Logger log = Logger.getLogger(ContainDuplicate.class);
	/**
	 * Method 		: checkPower 
	 * Description	: The method accepts two inputs from user and throws exception 
	 * 				  if user inputs invalid data.
	 */
	public static int checkPower(final int base, final int power) throws CustomizedException {
		if (base == 0 || power == 0) {
			throw new CustomizedException("0 value is not allowed");
		} else if (base < 0 && power < 0) {
			throw new CustomizedException("Negative values  are not allowed");
		}

		if (power > 0 && base > 0) {
			return base * checkPower(base, power - 1);
		} else {
			return 1;
		}

	}

	public static void main(String[] args) throws CustomizedException {
		Scanner read = new Scanner(System.in);
		final int number1;
		final int number2;
		log.info("Enter two numbers");
		try {
		number1 = read.nextInt();
		number2 = read.nextInt();
		} catch(Exception e){
			log.info("Please enter a valid input");
		}
		System.out.println(checkPower(number1, number2));
	}

}