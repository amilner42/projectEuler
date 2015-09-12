package problems30to39;

//Question -----------------------------------------------------------------------------------------------------------------------
// Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
//
// 1634 = 14 + 64 + 34 + 44
// 8208 = 84 + 24 + 04 + 84
// 9474 = 94 + 44 + 74 + 44
// As 1 = 14 is not a sum it is not included.
//
// The sum of these numbers is 1634 + 8208 + 9474 = 19316.
//
// Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem30 {

	private static final int maxSearch = (int) Math.pow(9,5) * 7; 	// 413343, a six-digit number that you do not need to search beyond

	public static void main(String[] args) {
		int sum = 0;												// sum of all the numbers  
		
		// Go through all the numbers that could possible by the sum of the fifth powers of their digits.
		// Once you reach 9^5 * 7, maxSearch, you do not need to keep searching because 9^5 * 7 does not even 
		// make a 7 digit number so there is no point to continue searching. 
		for(int i = 2; i < maxSearch; i++) {
			if(i == fifthPowerSums(i)) {
				sum += i; 
			}
		}
		// Print out the answer 
		System.out.println(sum);
	}

	// Private Function
	// Parses through the number accumulating each digit to the power of 5 
	private static int fifthPowerSums(int i) {
		int sum = 0; 
		while(i > 0) {
			sum += Math.pow((i%10), 5);
			i /= 10; 
		}
		return sum; 
	}
}
