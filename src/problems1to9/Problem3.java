package problems1to9;

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
// The prime factors of 13195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143 ?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct  

public class Problem3 {

	
	public static void main(String[] args) {
		// the number we will be finding the prime factor of 
		long num1 = 600851475143L;
		long num2 = 1; 
		long num3 = 2; 		
		
		// clean loop-control variable 
		boolean breaknow = false; 
		
		// Go through all the numbers, check if the number is a factor and then check if 
		// it is a prime. Because we are dividing from smallest to biggest the first prime
		// factor will be the largest guaranteed
		while(!(num2 == num1)&& !breaknow){
			num3 =num1/num2; 
			
			// check the number is a factor (no rounding error) and then check
			// if the number is a prime number after. (This order more efficient
			// then checking prime first). (Java && short-circuit)
			if(num1 == (num2 * num3) && MathFunctions.checkPrime(num3)){
				// print out the answer 
				System.out.println(num3);
				breaknow = true; // break loop 
			}
			else{
			num2++; 
			}
		}
	}

}
