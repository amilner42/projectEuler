package problems30to39;

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
// The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
//
// Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
//
// NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem37 {

	public static void main(String[] args) {
		int total = 0; 													// the current number of trunc-primes found
		int sum = 0; 													// sum of the eleven trunc-primes

		// Go through all the numbers incrementally ( += 2 because looking for primes, can't be even)
		// until 11 trunc-primes are found. You do not need to worry about numbers with a 0 in them
		// because at least one of the trunc-permutations will not be prime. 
		for(int currentNumber = 11; total < 11; currentNumber += 2) {
				if(trunctablePrime(currentNumber)) {
					sum +=currentNumber; 
					total++; 
				}
		}
		// print out the answer
		System.out.println(sum);
	}
	
	// Private Function
	// Returns: true if the number is a trunctable prime
	private static boolean trunctablePrime(int number) {
		return checkDeleteLeftToRightPrime(number) && checkDeleteRightToLeftPrime(number);
	}


	// Private Function
	// Returns: true if the number satisfies the Right->Left requirement of being a trunc-prime. 
	// It deletes the digits from right to left checking at each intermittent stage if the remaining number
	// is a prime. Eg.
	// For number 3797:
	// Check 1: 3797 
	// Check 2: 379
	// Check 3: 37
	// Check 4: 3
	private static boolean checkDeleteRightToLeftPrime(int number) {
		while(number > 0) { 
			if(!MathFunctions.checkPrime(number)) {
				return false;
			}
			number /= 10;  												// delete a digit 
		}
		return true; 
	}
	
	// Private Function 
	// Returns: true if the number is satisfies the Left->Right requirement of being a trunc-prime.
	// It deletes the digits from left to right checking at each intermittent stage if the remaining number
	// is a prime. Eg.
	// For number 3797:
	// Check 1: 7
	// Check 2: 97
	// Check 3: 797
	// Check 4: 3797
	// Note: This number checks the possibilities in reverse order. (First it deletes x digits, then x-1 etc...)
	private static boolean checkDeleteLeftToRightPrime(int number) {
		String tempString = String.valueOf(number);						// convert to string to get length easily
		int length = tempString.length(); 								// get length
		for(int i = 0; i < length; i++) {
			int tempNumber = (int) (number%(Math.pow(10, i+1)));		// Use % for deletion
			if(!MathFunctions.checkPrime(tempNumber)) {
				return false;
			}				 
		}
		return true; 
	}
}
