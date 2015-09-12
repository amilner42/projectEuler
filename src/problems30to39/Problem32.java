package problems30to39;

import java.util.HashSet;
import java.util.Set; 

//Question -----------------------------------------------------------------------------------------------------------------------
// We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
//
// The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
//
// Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
//
// HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem32 {

	public static void main(String[] args) {
		int sum = 0; 											// the sum of all the products  
		Set<Integer> products = new HashSet<Integer>();			// record the products using a set to avoid duplicates

		// Go through a super-set of all the possibilities. A multiplicand/multiplier/product cannot be 1-9 pandigital
		// if either the multiplicand/multiplier are 5 digits, because that would mean that the product is at 
		// minimum 5 digits and the other multiplicand/multiplier is at minimum 1 digits (11 digits). The indexInner
		// starts at 1 greater than the outer index because they could never be the same (same digits). 
		for(int indexOuter = 1; indexOuter < 9999; indexOuter++){
			for(int indexInner = indexOuter+1; indexInner < 9999; indexInner++){
				int product = indexInner * indexOuter; 
				String numbersString = "" + indexOuter + "" + indexInner + "" + product; 
				if(containsAllDigits(numbersString))
					products.add(product);
			}
		}
		
		// Go through the set of products and add them to sum 
		for(Integer current: products){
			sum += current; 
		}
		// Print out the answer
		System.out.println(sum);
	}

	// Private Function
	// Check if numbersString contains all the digits from 1-9 
	private static boolean containsAllDigits(String numbersString) {
		Set<Character> digits = new HashSet<Character>();		// the digits in numbersString, using a set to avoid duplicates
		if(numbersString.length() != 9) {
			return false; 
		}
		// Go through the string and check if it contains a 0, if not add the digit to digits
		for(int i = 0; i < numbersString.length(); i++) {
			if(numbersString.charAt(i) == '0') {
				return false;
			}				 
			digits.add(numbersString.charAt(i));	
		}
		// If the set does not contain 9 digits then there was a duplicate
		if(digits.size() == 9) {
			return true;
		} else {
			return false;
		}			 
	}
}
