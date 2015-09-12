package problems20to29;

import java.math.BigInteger;

//Question -----------------------------------------------------------------------------------------------------------------------
//	The Fibonacci sequence is defined by the recurrence relation:
//	
//	Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
//	Hence the first 12 terms will be:
//	
//	F1 = 1
//	F2 = 1
//	F3 = 2
//	F4 = 3
//	F5 = 5
//	F6 = 8
//	F7 = 13
//	F8 = 21
//	F9 = 34
//	F10 = 55
//	F11 = 89
//	F12 = 144
//	The 12th term, F12, is the first term to contain three digits.
//	
//	What is the first term in the Fibonacci sequence to contain 1000 digits?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem25 {
	
	public static void main(String[]args) {
		// BigIntegers used to avoid going out of range
		BigInteger fib1 = BigInteger.ONE;
		BigInteger fib2 = BigInteger.ONE; 
		
		int termHolder = 2;      // Record which term it currently is in the sequence 
		boolean running = true;  // Clean loop-control variable 
		
		while(running) {
			// get next two fib numbers
			fib1 = fib1.add(fib2);
			fib2 = fib2.add(fib1);
			
			// If either of the two new terms have 1000
			// digits then stop running and print which term it was in 
			// the sequence of terms
			if(hasXDigits(fib1, 1000)) {
				// Print out the answer
				System.out.println(termHolder + 1);
				running = false;  
			}
			
			if(hasXDigits(fib2, 1000)) {
				// Print out the answer
				System.out.println(termHolder + 2);
				running = false;  
			}			
			// Record that two new fib numbers have been viewed
			termHolder += 2; 
		}					
	}
	
	// Private Function
	// Used to see how many digits are in the BigInteger (does it have x digits?)
	public static boolean hasXDigits(BigInteger bigInteger, int xDigits) {	
		return String.valueOf(bigInteger).length() == xDigits; 				
	}
}
