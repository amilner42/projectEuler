package problems1to9;

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
// What is the 10 001st prime number?
//---------- -----------------------------------------------------------------------------------------------------------------------
//Solution correct 

public class Problem7 {

	public static void main(String[] args) {
		int nthPrime = 0; 
		int primeNumber = 2; 
		
		// go through till 10,001st prime number is reached
		while(nthPrime < 10001){
			if(MathFunctions.checkPrime(primeNumber)){
				nthPrime++; 
			}
			
			// don't add one to the 10,001st prime
			if(nthPrime != 10001){
				primeNumber++; 
			}
		}
		
		// print out the answer 
		System.out.println(primeNumber);
	}

}
