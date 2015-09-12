package problems40to49;

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
// We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime
//
// What is the largest n-digit pandigital prime that exists?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct
// Runtime long: 45 seconds

public class Problem41 {

	public static void main(String[] args) {
		boolean looking = true; 							// clean loop-control variable 

		// Start at the highest n-pandigital and go down from there checking if the
		// number is both n-pandigital and prime 
		for(long i = 987654321; looking; i -= 2) {
			if(checkPandigital(i) && MathFunctions.checkPrime(i)) {
				// print out the answer
				System.out.println(i);
				looking = false;  
			}				
		}
	}	
	
	// Private Function
	// Returns: true if the number is n-digit-pandigital (it is pandigital from 1..n where n is the number of digits)
	private static boolean checkPandigital(long number) {
		int length = String.valueOf(number).length(); 		// length of number
		int [] digits = new int[10];						// array used for parsing the digits 
		
		// Parse the number in a way that array[x] == number of occurrences of the digit x in the number 
		while(number > 0) {
			digits[(int)(number % 10)]++;
			number /= 10; 
		}
		
		// Go through the array and make sure that there is 1 of every digit up to the length of the number
		for(int i = 0; i < length; i++) {
			if(digits[i+1] != 1) {
				return false; 
			}
		}
		return true; 
	}
}


