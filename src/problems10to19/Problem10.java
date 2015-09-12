package problems10to19; 

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
// Find the sum of all the primes below two million.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem10 {
	
	public static void main(String[] args) {
		long sum = 0;
		
		// Go through all the numbers less than 2 million
		for(int i = 0; i < 2*1E6; i++){
			if(MathFunctions.checkPrime(i)){
				sum += i; 
			}
		}
		
		// Print out the answer 
		System.out.println(sum);

	}
}
