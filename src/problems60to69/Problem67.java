package problems60to69; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Question -----------------------------------------------------------------------------------------------------------------------
// By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
//
//      3
//     7 4
//    2 4 6
//   8 5 9 3
//
// That is, 3 + 7 + 4 + 9 = 23.
//
// Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.
//
// NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 2^99 altogether! If you could check one trillion (10^12) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem67 {

	public static void main(String[] args) throws IOException {
		// For reading the file
		BufferedReader input = null; 
		String line = null; 
		
		// A 2D String array to represent the input 
		String[][] board = new String[100][100];
	    int greatestCombo = 0; 
		
		// Read the triangle from a file, taking advantage of the spaces and lines
	    // separating the different numbers 
		try {
			int index = 0;
			input = new BufferedReader(new FileReader("Problem67InputFile"));	
			while((line = input.readLine())!= null){
				board[index] = line.split(" ");
				index++;
			}
		} finally {
			if(input != null) {
				input.close();
			}
		}
		
		// This algorithm goes through the board (from left-right) and adds the greater of the two numbers above it (up-left and up-right)
		// to itself. If it only has 1 number above it, (it is on the edge), then it adds that number to itself. By repeating this 
		// from the top to the bottom of the triangle you get an extremely fast way to figure out the fastest path down.
     	for(int index = 1; index < board.length; index++){
     		// The index represents the depth, starting at 1 (row 2) because there is nothing to do at row 1 (nothing above it)
     		// The accumulator represents the horizontal position (starting at 0, spot 1, and going until index, the last element)
     		int accumulator = 0; 
     		while(accumulator <= index) {
     			// Greatest Combo gets updated every time for simplicity
     			// (on the last index it checks the max of the bottom 15 numbers)
     			if(accumulator == 0) {
     				// Dealing with the case that it is on the left edge
	     			board[index][accumulator] = String.valueOf((Integer.parseInt(board[index][accumulator]) + Integer.parseInt(board[index-1][0])));
	     			greatestCombo = Math.max(greatestCombo, Integer.parseInt(board[index][accumulator]));
     			} else if(accumulator == index) {
     				// Dealing with the case that it is on the right edge
	     		    board[index][accumulator] = String.valueOf((Integer.parseInt(board[index][accumulator]) + Integer.parseInt(board[index-1][accumulator-1])));
	     		    greatestCombo = Math.max(greatestCombo, Integer.parseInt(board[index][accumulator]));
     			} else {
     				// In the middle, adding to itself the greater of the two numbers above itself
     				board[index][accumulator] = String.valueOf((Integer.parseInt(board[index][accumulator]) +  Math.max(Integer.parseInt(board[index-1][accumulator]),Integer.parseInt(board[index-1][accumulator-1]))));
     				greatestCombo = Math.max(greatestCombo, Integer.parseInt(board[index][accumulator]));
     			}
     			// Move to the next number horizontally
     			accumulator++; 
     		}
     		
     	}

     	// Print out the answer
		System.out.println(greatestCombo);
	}
}
