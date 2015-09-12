package problems30to39;

//Question -----------------------------------------------------------------------------------------------------------------------
//	The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
//	
//	Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//	
//	(Please note that the palindromic number, in either base, may not include leading zeros.)
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem36 {

	public static void main(String[]args) {
		int sum = 0; 															// sum of all the double-palindromes
		
		// Go through all the numbers between 0-1E6 and check if they are double-palindromes 
		for(int i = 0; i <= 1E6; i++) {
			if(doublePalindrome(i)) {
				sum += i; 
			}		
		}
		// print out the answer
		System.out.println(sum);
	}
	
	// Private Function
	// Returns true if the integer in both base 10 and base 2 is a palindromic 
	private static boolean doublePalindrome(int currentInt) {
		String currentString = String.valueOf(currentInt);						// get string representation of int 
		String currentBinaryString = Integer.toBinaryString(currentInt);		// get string representation of int as binary
		
		return palindrome(currentString) && palindrome(currentBinaryString);	// check if the integer in both base 10 and base 2 is a palindromic 
	}
	
	// Private Function
	// Returns true if a string is palindromic 
	private static boolean palindrome(String number) {
		char[] characters = number.toCharArray();								// number as char array
		
		// Go through checking if all the characters have a matching character on the opposing end
		for(int i = 0; i < characters.length/2; i++) {
			int j = characters.length - ( i+ 1);								// character on opposing end
			if(characters[i] != characters[j]) {
				return false;
			}
		}
		return true; 
	}
}
