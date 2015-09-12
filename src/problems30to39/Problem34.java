package problems30to39;

//Question -----------------------------------------------------------------------------------------------------------------------
// 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//
// Find the sum of all numbers which are equal to the sum of the factorial of their digits.
//
// Note: as 1! = 1 and 2! = 2 are not sums they are not included.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem34 {

	public static void main(String[] args) {
		final long end = 99999; 				// beyond this number the factorial of the digits can never catch up to the number
		long sum = 0; 							// the sum of the numbers 
		
		// Check a super-set of all the numbers that could possibly be equal to the factorial of 
		// their digits (the actual set ends before 99999)
	    for(int i = 3; i < end; i++) {
		    if(digitFactorialSum(i) == i) {
		    	sum += i; 
		    }  	
	    }	
	    // print out the answer	
        System.out.println(sum);
	}

	// Private Function 
	// Returns: the sum of the factorial of each individual digit 
	private static int digitFactorialSum(int integer) {
		int tempDigit = 0;					// this will be the digit that is truncated 
		int sum = 0; 						// the sum of all the digit-factorials 
		
		// Go through the number, truncating off digits and summing their factorials
		while(integer > 0) {
			tempDigit = integer%10; 
			integer /= 10; 
			sum += factorial(tempDigit); 
		}
		return sum; 
	}

	// Private Function
	private static int factorial(int digit) {
		int sum = 1; 
		while(digit > 0) {
			sum*= digit;
			digit--;
		}
		return sum; 
	}
}
