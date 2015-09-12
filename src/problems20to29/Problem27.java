package problems20to29;

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
// 	Euler discovered the remarkable quadratic formula:
// 		n² + n + 41
// 	It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
//	
//	The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.
//	
//	Considering quadratics of the form:
//	
//	n² + an + b, where |a| < 1000 and |b| < 1000
//	
//	where |n| is the modulus/absolute value of n
//	e.g. |11| = 11 and |−4| = 4
//	Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem27 {

	public static void main(String[] args) {
		int mostPrimes = 0;									// the current record for the most primes in a row  
		int product = 0; 									// the product of the coefficients that produced mostPrimes 
		
		// Go through all the numbers from -1000 to 1000 using 2 for-loops
		// to get all the possible combinations of any 2 coefficients 
		for(int a = - 1000; a < 1000; a++) {
			for(int b = - 1000; b < 1000; b++) {
				int numberOfPrimes = howManyPrimes(a,b);	// check how many primes in a row 
				if(numberOfPrimes > mostPrimes) {			 
					mostPrimes = numberOfPrimes;	
					product = a*b; 							// record the product of the coefficients that produced the most primes 
				}				
			}
		}
		// Print out the answer 
		System.out.println(product);
	}

	// Private Function:
	// Using Eulers formula (see problem description above) see how many primes 
	// coefficients a and b produce 
	private static int howManyPrimes(int a, int b) {
		int numberOfPrimes = 0;													// how many primes in a row (also used as index) 										
		boolean stillPrime = true;												// clean loop-control variable  
		while(stillPrime) {
			int value = (numberOfPrimes*numberOfPrimes + a*numberOfPrimes + b); // Eulers Formula
			if(MathFunctions.checkPrime(value) && value > 0) {					// Check if it is a prime (making sure to also check if it is positive as well) 
				numberOfPrimes++; 
			} else {
				stillPrime = false; 
			}
		}
		return numberOfPrimes;
	}
}
