package problems20to29;

//Question -----------------------------------------------------------------------------------------------------------------------
// A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
// 	012   021   102   120   201   210
// What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem24 {
	
	private static long number = 123456789;      // smallest number with all digits (assume that there is a 0 in front -> 0123456789)
	private static int numberOfPermutations = 0; // recording which number we are currently on 
	private static boolean running = true;       // clean loop-control variable
	
	public static void main(String[] args) {		
		// Go through the natural numbers, starting at 123456789 and going until it 
		// reaches the millionth proper permutation (proper meaning no duplicate digits, read question for explanation)
		while(running) {
			checkContainsAllDigitsAndGenerateNextNumber();
		}

	}
	// Private Function 
	// This function has slightly confusing code because it has been upgraded multiple times to increase the efficiency.
	// High Level Perspective: Check if the number is a proper permutation and generate the next number to check
	// 
	// Low Level Perspective: Go through from left to right and check if there are any duplicate digits. It checks 
	// duplicate digits by using an array of digits and checking against spot digits[number] to see if the number already had
	// that digit. This way it can do the checks in O(1) and not O(N) where N is the size of the number. Next, if it does encounter 
	// a duplicate digit, it adds 1 to that specific digit, because that is the minimum next smallest number that will have no duplicate
	// digits. This avoids checking 11300, 11301, 11302, 11303 etc... and instead will immediately go 11300, 12300, 12301 etc...
	private static void checkContainsAllDigitsAndGenerateNextNumber() {
		char [] numberCopyArray = String.valueOf(number).toCharArray(); // making a char array to make parsing left to right easier
		int [] digits = new int[10];                                    // digit array for checking duplicate digits in O(1)
		int tempHolder = 0; 
		boolean smallNumber = number < 1000000000;						// if its a small number must be careful with 0 case 
		
		// Go through number and parse left to right, adding 1 to the digit that is a duplicate if a duplicate exists
		for(int i = 0; i < numberCopyArray.length; i++) {
			tempHolder = (int)numberCopyArray[i] - 48; 					  // -48 to convert '1' to 1 
			if(digits[tempHolder]++ != 0){
				number += Math.pow(10, (numberCopyArray.length - i - 1)); // adding 1 to the duplicate 
				return; 
			}
		}
		// Checking if it is indeed a proper permutation, this is needed to deal with the '0' case. The number 
		// can't have a 0 if it is a small number because small numbers have a 0 ahead eg.
		// 123456789 is actually 0123456789
		//
		// Also adds 1 to number so it can continue the search linearly 
		if(!smallNumber || (digits[0] == 0)){
			if(++numberOfPermutations == 1E6){
				// Print out the answer
				System.out.println(number);
				running = false;
			}
		} 
		number++;
	}
}
