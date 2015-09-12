package problems30to39;

//Question -----------------------------------------------------------------------------------------------------------------------
// The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
//
// We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
//
// There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
//
// If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

// The only thing to note about this problem/solution is that for fraction ab/cd there is no need to check 
// if digit a cancels with c or if digit b cancels with d, you only need to check if a cancels with d and 
// if b cancels with c. (Write it out on paper and basic algebra eliminates two cases)
//
// CASE1: AX/BX --> Impossible
// CASE2: XA/XB --> Impossible
// CASE3: AX/XB --> Possible
// CASE4: XA/BX --> Possible

public class Problem33 {

	public static void main(String[] args) {
		double currentNumeratorProduct = 1;			// holds the numerator product 
	    double currentDenominatorProduct = 1;		// holds the denominator product

	    // Use classic round-robin loops to go through all the 2-digit possibilities. Denom always starts bigger than numer because the 
	    // fraction must be less than 1. 
		for(int numer = 10; numer < 100; numer++) {
			for(int denom =numer+1; denom < 100; denom++) {
 				double numerator = numer; 						// set numerator 
				double denominator = denom; 					// set denominator 
				double fraction = numerator / denominator;		// get actual value of fraction as double
				
				if(fraction == cancelNumberFirst(numer,denom) || fraction == cancelNumberSecond(numer,denom)) {
					System.out.println(numer + "/" + denom);	// print out fraction out of curiosity
					currentNumeratorProduct *= numerator; 		// update currentNumeratorProduct
					currentDenominatorProduct *= denominator; 	// update currentDenominatorProduct
				}					
			}
		}
		// print out the answer (in decimal form)
		System.out.println(currentNumeratorProduct / currentDenominatorProduct);

	}
	// Private Function 
	// Returns: -1 if this fraction is not a fraction which has digits that can be cancelled, otherwise returns 
	// the fraction of the remaining uncanceled digits. This function only attempts to remove the second  
	// digit in the numerator with the first digit in the denominator.
	private static double cancelNumberSecond(int a, int b) {
		// If the second digit in the numerator is the same as the first digit in the denominator, does a check 
		// to make sure the uncanceled digit in the denominator is not zero because you can't divide by zero 
		if(String.valueOf(a).charAt(1) == String.valueOf(b).charAt(0) && String.valueOf(b).charAt(1) != '0') {
			return (double)(a/10)/(double)(b%10);
		} else {
			return -1; 
		}		
	}

	// Private Function
	// Returns: -1 if this fraction is not a fraction which has digits that can be cancelled, otherwise returns 
	// the fraction of the remaining uncanceled digits. This function only attempts to remove the first  
	// digit in the numerator with the second digit in the denominator. 
	private static double cancelNumberFirst(int a, int b) {
		// If the first digit in the numerator is the same as the second digit in the denominator, does a check 
		// to make sure the uncanceled digit in the denominator is not zero because you can't divide by zero
		if(String.valueOf(a).charAt(0) == String.valueOf(b).charAt(1) && String.valueOf(b).charAt(0) != '0') {
			return (double)(a%10)/(double)(b/10);
		} else {
			return -1; 
		}			
	}

}
