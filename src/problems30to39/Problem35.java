package problems30to39;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
//The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
//
//There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//
//How many circular primes are there below one million?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem35 {

	public static void main(String[] args) {
		int total = 0; 													// the total number of circular primes 
		HashSet<Integer> circularPrimes = new HashSet<Integer>();		// using a set to hold all the numbers that could be circular primes
		
		// Go through all the numbers under a million, if the number is a prime number and it has no zeroes then it is a candidate to be 
		// a circular prime so add it to the list of circularPrimes. Add 2 to the list first, that way we can do i+=2 because 2 is the only even prime.
		circularPrimes.add(2);
		for(int i = 3; i < 1E6; i+=2) { 
			if(MathFunctions.checkPrime(i) && !String.valueOf(i).contains("0")) {
				circularPrimes.add(i);
			}
		}
		
		// Go through all these possible circular primes and check which ones are actually circular primes. 
		for(Integer current: circularPrimes) {
			if(circularPrime(current)) {
				total++; 
			}		
		}
		// print out the answer 
		System.out.println(total);
	}	
	
	// Private Function
	// Requires: currentInt has no zeroes 
	// Checks if a number is a circular prime. (if all its circular rotations are prime)
	private static boolean circularPrime(Integer currentInt) {
		List<Integer> cases = createCircularNumbers(currentInt);		// all the circular rotations of currentInt
		// Go through the cases and see if they are all prime 
		for(Integer current: cases) {
			if(!MathFunctions.checkPrime(current)) {
				return false; 
			}
		}
		return true; 
	}

	// Private Function
	// Requires: currentInt has no zeroes
	// Returns: a list of all the circular possibilities of currentInt
	private static List<Integer> createCircularNumbers(int currentInt) {
		List<Integer> circularNumbers = new ArrayList<Integer>();		// the list of circularNumbers
		String currentString = String.valueOf(currentInt);				// convert to string for length
		int length = currentString.length();							// get length of int 
		
		// Go through the number, truncating off the lowest-value digit and adding to the highest-value position
		for(int i = 0; i < length; i++) {
			circularNumbers.add(currentInt);
			int b = currentInt % 10; 
			currentInt /= 10; 
			currentInt += Math.pow(10,length-1) * b;
		}
		return circularNumbers; 
	}
}
