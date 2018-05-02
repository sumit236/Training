
/* Program: 	To perform lambda expression. 
 * Description: Program is to use lambdaexpression to perform operations.It is divided into 3 parts:-
 * 				1) Return true/false if a number is even/odd. 
 * 				2) Return true/false if a number is Prime/not.
 * 				3) Return true/false if a number is Palindrome/not.
 */
import org.apache.log4j.Logger;
import mypack.ContainDuplicate;

public class LambdaExp {

	private static Logger log = Logger.getLogger(ContainDuplicate.class);

	// Functional Interface to check odd/even.
	interface CheckOdd {
		// abstract method
		public boolean isOdd(int number);
	}

	// Functional Interface to check prime/not.
	interface CheckPrime {
		// abstract method
		public boolean isPrime(int number);
	}

	// Functional Interface to check palindrome/not.
	interface CheckPalindrome {
		// abstract method
		public boolean isPalindrome(int number);
	}

	private boolean oddMethod(int holder) {
		// lambda expression to check if a number is even/odd.
		CheckOdd check1 = (number) -> {
			if (holder % 2 == 0)
				return false;
			else
				return true;
		};
	}

	private boolean primeMethod(int holder) {
		// lambda expression to check if a number is prime/not.
		CheckPrime prime1 = (number) -> {
			for (int iterator = 2; iterator <= holder / 2; iterator++) {
				if (holder % iterator == 0)
					return false;
			}
			return true;
		};
	}

	private boolean palindromeMethod(int holder) {
		// lambda expression to check if a number is palindrome.
		CheckPalindrome palindrome1 = (number) -> {
			int temp = 0;
			int remainder = 0;
			int reverse = 0;
			int duplicate = holder;
			while (holder > 0) {

				remainder = holder % 10;
				holder = holder / 10;
				reverse = reverse * 10 + remainder;
				temp = reverse;
			}
			if (duplicate == temp) {
				return true;
			} else {
				return false;
			}
		};

	}

	public static void main(String[] args) {

		int number = 11;
		LambdaExp lambObj = new LambdaExp();
		log.info("No is odd : " + lambObj.oddMethod(number));
		log.info("No is prime : " + lambObj.primeMethod(number));
		log.info("No is palindrome : " + lambObj.palindromeMethod(number));
	}

}
