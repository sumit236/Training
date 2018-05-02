
/* Program: 	To perform lambda expression. 
 * Description: Program is to use lambdaexpression to perform operations.It is divided into 3 parts:-
 * 				1) Return true/false if a number is even/odd. 
 * 				2) Return true/false if a number is Prime/not.
 * 				3) Return true/false if a number is Palindrome/not.
 */

public class LambdaExp {

	// Functional Interface to check odd/even.
	@FunctionalInterface
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

	public static void main(String[] args) {

		int holder = 11;

		// lambda expression to check if a number is even/odd.
		CheckOdd oddEven = (number) -> {
			if (holder % 2 == 0) {
				return true;
			} else {
				return true;
			}
		};
		System.out.println("No is odd "+ oddEven.isOdd(holder));
		
		// lambda expression to check if a number is prime/not.
		CheckPrime prime1 = (number) -> {
			for (int iterator = 2; iterator <= holder / 2; iterator++) {
				if (holder % iterator == 0)
					return false;
			}
			return true;
		};
		System.out.println("No is prime "+ prime1.isPrime(holder));

		// lambda expression to check if a number is palindrome.
		CheckPalindrome palindrome1 = (number) -> {
			int temp = number;
			int remainder = 0;
			int reverse = 0;
			 int duplicate = holder;
			while (holder > 0) {
				remainder = number % 10;
				number = number / 10;
				reverse = reverse * 10 + remainder;
			}
			if (duplicate == temp) {
				return true;
			} else {
				return false;
			}
			
		};
		System.out.println("No is palindrome "+ palindrome1.isPalindrome(holder));	
}
}
