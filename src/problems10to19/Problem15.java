package problems10to19; 

// Question -----------------------------------------------------------------------------------------------------------------------
// 	 Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
// 	 How many such routes are there through a 20×20 grid?
// 
//   Goto Website for full diagram: 	https://projecteuler.net/problem=15
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem15 {
	
	public static void main(String[]args){
		// create a 21 by 21 board because its the number of lines separating the row, not the number of rows 
		long [][]board = new long[21][21];
		board[0][0] = 1; 
		
		// This algorithm goes through the board making every point on this 21 by 21 board have an integer 
		// value of the square above it + the square to the left of it. This works because the number of ways
		// to get to the square above you + the number of ways it takes to get to the square to the left of 
		// you accounts for the number of ways to get to your current square. Top row and left-most column
		// get initialized to zero

		for(int i = 0; i < board.length; i++){
			for(int a = 0; a < board.length; a++){
				if(i == 0) {
					board[i][a] = 1; 
				} else if (a == 0) {
					board[i][a] = 1; 
				} else {
					board[i][a] = board[i-1][a] + board[i][a-1];
				}
				
			}
		}

		// Print out the answer 
		System.out.println(board[20][20]);
		
	}
}

