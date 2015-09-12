package problems10to19; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Question -----------------------------------------------------------------------------------------------------------------------
// By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
//         3
// 		  7 4
// 		 2 4 6
// 		8 5 9 3
//
// That is, 3 + 7 + 4 + 9 = 23.
//
// Find the maximum total from top to bottom of the triangle below:
//
//                  75
//                 95 64
//               17 47 82
//              18 35 87 10
//             20 04 82 47 65
//            19 01 23 75 03 34
//           88 02 77 73 07 63 67
//         99 65 04 28 06 16 70 92
//        41 41 26 56 83 40 80 70 33
//       41 48 72 33 47 32 37 16 94 29
//      53 71 44 65 25 43 91 52 97 51 14
//     70 11 33 28 77 73 17 78 39 68 17 57
//    91 71 52 38 17 14 91 43 58 50 27 29 48
//   63 66 04 68 89 53 67 30 73 16 69 87 40 31
//  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
//
// NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem18 {

	public static void main(String[] args) throws IOException {
		// For reading the file
		BufferedReader input = null; 
		String line = null; 
		
		// A 2D String array to represent the input 
		String[][] board = new String[15][15];
	    int greatestCombo = 0; 
		
		// Read the triangle from a file, taking advantage of the spaces and lines
	    // separating the different numbers 
		try {
			int index = 0;
			input = new BufferedReader(new FileReader("Problem18InputFile"));	
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
		// from the top to the bottom of the triangle you get an extremely fast way to figure out the fastest path down. This algorithm
		// runs almost instantly even on a 100-100 board (Problem 67).
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
