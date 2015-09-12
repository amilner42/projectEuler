package problems30to39;

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
//	Take the number 192 and multiply it by each of 1, 2, and 3:
//	
//	    192 × 1 = 192
//	    192 × 2 = 384
//	    192 × 3 = 576
//	
//	By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
//	
//	The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
//	
//	What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem38 {

	public static void main(String[] args) {
		long currentMax = 0; 									// the current max concatenated-product

		// Go through all the digits between 1-9999 and check if their concatenated-products are pandigital.
		// No need to check beyond 4-digits because their concatenated-products will be at least 10 digits long. 
		for(int i = 0; i <= 9999; i++) {
			if(checkNumber(i) > currentMax) {
				currentMax = checkNumber(i);
			}
		}
		// print out the answer 
		System.out.println(currentMax); 
	}
	
	// Private Function
	// Returns: Either a 9 digit number that is the pandigital-concatenated-product or 0, 0 meaning that 
	// it has no pandigital concatenated-product. 
	public static long checkNumber(int number) {
		String products = String.valueOf(number);				// use a string to record the products 
		
		// Go through and keep concatenating products as long as it is less than 9 digits 
		for(int i = 2; products.length() < 9; i++) {
			products = products.concat(String.valueOf(i * number));
		}
		
		long concatProduct = Long.valueOf(products);			// Convert to a long to pass it to checkPandigital 
	
		// If it is pandigital then return it, otherwise return 0
		if(MathFunctions.checkPandigital(concatProduct)) {
			return concatProduct;
		} else {
			return 0; 
		}
	}
}





