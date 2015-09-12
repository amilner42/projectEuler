package problems40to49;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Question -----------------------------------------------------------------------------------------------------------------------
// The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
//
// 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
//
// By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
//
// Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem42 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null; 								// used to read the single line of the input file
		String[] words = null; 										// used to store the words from the input file
		try {
			reader = new BufferedReader(new FileReader("Problem42InputFile"));
			words = reader.readLine().split(","); 					// the input file has 1 line of words separated by: ","
		} finally {
			if(reader != null) {
				reader.close();										// make sure the file-stream is closed
			}
		}
		int totalWords = 0;											// the total number of words that are triangle-words
		
		// Go through all the words checking if they are triangle-words. A word is a triangle-word if:
		// alpha-value = n(n+1) / 2
		// 2*alpha-value = n(n+1)
		//
		// If an n exists that satisfies this equation, then it must be the rounded-down square root of 2*alpha-value
		//  	- if it was the square root n(n+1) would be too big 
		// 		- if it was less than the rounded-down square root then it would be too small because both n and n+1 would be less than the square root 
		for(int i = 0; i < words.length; i++) {
			int alphaValue = alphaValue(words[i]); 				// the alpha-value of the word 
			int n = (int)Math.sqrt(alphaValue * 2);				// the only n that could satisfy the equation 
			// See if this value of n satisfies the equation to
			// determine if it is a triangle word
			if((n * (n+1)) ==  alphaValue*2) {				
				totalWords++; 
			}
		}
		// print the answer 
		System.out.println(totalWords);
	}
	
	// Private Function
	// Returns: the alphabetical-position-value of the word. Eg.
	// 	SKY == 19 + 11 + 25 == 55
	private static int alphaValue(String word) {
		word = word.substring(1, word.length()-1);					// get rid of the quotes 
		int tempSum = 0; 											// the current sum
		// Go through and add the points for each character
		for(int j = 0;j < word.length(); j++) {
			tempSum += Character.getNumericValue(word.charAt(j)) - 9;
		}
		return tempSum; 
	}
}
