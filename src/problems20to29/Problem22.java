package problems20to29;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

//Question -----------------------------------------------------------------------------------------------------------------------
//	Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
//	
//	For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
//	
//	What is the total of all the name scores in the file?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem22 {

	public static void main(String[] args) throws IOException {
		// For reading file
		BufferedReader inputStream = null;
		
		// For storing the names in Alpha(betical) order
		LinkedList<String> namesAlpha = new LinkedList<String>();
		String[]names = null; 
		long totalScore = 0; 
		
		// Read all the names and put it into an array of strings 
		try {
			inputStream = new BufferedReader(new FileReader("Problem22InputFile"));
			String input = null; 
			while((input = inputStream.readLine()) != null){
				names = input.split(",");
			}					
		} finally {
			if(inputStream!=null) {
				inputStream.close();
			}
		}
		
		// Done Input here.  
        // Trimming all the words to get rid of the ""
	    for(int i = 0; i < names.length; i++) {
	    	names[i] = names[i].substring(1, names[i].length() -1);
	   	}
	    
	    // Put it in a list so that can make a Collection.sort call
	    for(int i = 0; i < names.length; i++) {
	   	   namesAlpha.add(names[i]);
	    }
	
	    // Sort the list of strings
	    Collections.sort(namesAlpha);
	    
	    // Calculate the score of each word, and 
	    // add it to totalScore
	    for(int i = 1; i <= namesAlpha.size(); i++) {
	    	totalScore += scoreCalculator(i, namesAlpha.get(i-1));
	    }

	    // Print out the answer
	    System.out.println(totalScore);
	}
	
	// Private Function 
    // Takes advantage of the fact that 'A' = 10, 'B' = 11 for ascII values
	// Calculates the score of each word: A = 1, B = 2 etc.. and then the full
	// value of the word is multiplied by its index in the list
	private static long scoreCalculator(int index, String string) {
		int tempSum = 0; 
		for(int j = 0;j < string.length(); j++){
			tempSum += Character.getNumericValue((string.charAt(j))) - 9;
		}
		return tempSum * index; 
	}
}
