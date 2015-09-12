package problems40to49;

//Question -----------------------------------------------------------------------------------------------------------------------
//	An irrational decimal fraction is created by concatenating the positive integers:
//	
//	0.123456789101112131415161718192021...
//	
//	It can be seen that the 12th digit of the fractional part is 1.
//	
//	If dn represents the nth digit of the fractional part, find the value of the following expression.
//	
//	d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct
// Runtime long: 48 seconds 

public class Problem40 {

	public static void main(String[] args) {
		String numberConcat = "";										// going to record all the numbers concatenated
		
		// Go through the integers concatenating them to numberConcat. 
		for(int index = 1; numberConcat.length() <= 1000000; index++) {
			numberConcat = numberConcat.concat(String.valueOf(index));
		}

		int nthDigit = 1;												// the nth digit 
		int currentProduct = 1; 										// the current product of multiplying the dn
		// Multiply the dn 
		while(nthDigit <= 1E6) {
			currentProduct *= Integer.valueOf(String.valueOf(numberConcat.charAt(nthDigit-1)));
			nthDigit *= 10; 
		}
		// print out the answer
		System.out.println(currentProduct);
	}
}
