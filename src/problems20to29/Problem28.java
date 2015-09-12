package problems20to29;

//Question -----------------------------------------------------------------------------------------------------------------------
//	Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
//	
//	21 22 23 24 25
//	20  7  8  9 10
//	19  6  1  2 11
//	18  5  4  3 12
//	17 16 15 14 13
//	
//	It can be verified that the sum of the numbers on the diagonals is 101.
//	
//	What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem28 {

	public static void main(String[] args) {
		int sum = 1; 					// the current sum, starts at 1 to include the very innermost square (just a 1)
		int number = 1; 				// the current number (to be added to the sum)
		
		// Thinking about the problem geometrically, you can think of the data as a series of nested squares where 
		// the inner-most square is just 1, the next square is composed of 2,3,4,5,6,7,8,9 and the next square...
		// Now to get the sum of the diagonals you just need to add the 4 corners of each squares plus the 1 in the very middle
		// In the squares, the 4 corners are a constant amount away from each other so you can just add that 4 times. This constant
		// amount also increases at a constant amount between squares (starts at 2 then goes to 4 then 6 etc...) so it ends up being
		// a simple for-loop. (500 long because 500 nested squares not including the innermost 1)
		for(int index = 1; index <= 500; index++) {
			number += index*2; 				// bottom-right corner of square 	
			sum += number;
			number += index*2; 				// bottom-left corner of square 
			sum += number;
			number += index*2; 				// top-left corner of square
			sum += number;
			number += index*2; 				// top-right corner of square
			sum += number;
		}
		// Print out the answer 
		System.out.println(sum);
	}
}
