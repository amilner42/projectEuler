package problems1to9;

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
// Find the largest palindrome made from the product of two 3-digit numbers.
//---------- -----------------------------------------------------------------------------------------------------------------------
//Solution correct  

public class Problem4 {

	public static void main(String[] args) {
		// used to loop through all possibilities of 3 digit number multiplication combinations 
		int number1 = 1;
		int number2 = 1; 
		
		// records current largestPalandrome
		int largestPalandrome = 0; 
		
		
		// loop through all possibilities, not repeating the same multiplication
		// check (current > largestPalandrome && ... ) first for efficiency 
		while(number1 < 1000){
			int current; 
			while(number2 < 1000){
				current = number1 * number2; 
				if(current > largestPalandrome && MathFunctions.checkPalandrome(current)){
			        largestPalandrome = current; 
				}
				number2++; 
			}
			number1++; 
			number2 = 1; 
		}

		// print out the answer 
		System.out.println(largestPalandrome);
	}
	
}
















