package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Question -----------------------------------------------------------------------------------------------------------------------
//
//  Refer to: https://projecteuler.net/problem=81
//
//---------------------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem81 {

    public static void main(String[] args) throws IOException {

        // Read 80 by 80 board from input file as integers
        int[][] board = new int[80][80];
        BufferedReader inputStream  = new BufferedReader(new FileReader("Problem81InputFile"));

        try {
            int index = 0;
            String line;

            while((line = inputStream.readLine()) != null) {
                String[] temp = line.split(",");
                int[] result = new int[temp.length];

                for(int i = 0; i < temp.length; i++) {
                    result[i] = Integer.valueOf(temp[i]);
                }
                board[index] = result;
                index++;
            }
        } finally {
            // this finally block making sure that the inputStream closes no matter what
            if(inputStream != null){
                inputStream.close();
            }
        }

        // Go through the board updating each value
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                updateValue(board , i , j);
            }
        }

        // Value of the bottom right number is the minimum path
        System.out.println(board[79][79]);

    }

    // Update the value at position [i][j] in the board by adding the minimum of the value above/left of current position
    // if those values exists on the board. Eg. Top row has nothing above it.
    private static void updateValue(int[][] board, int i, int j) {
        if(j == 0 && i == 0) {
            return;
        } else if(j == 0) {
            board[i][j] += board[i-1][j];
        } else if(i == 0) {
            board[i][j] += board[i][j-1];
        } else {
            board[i][j] += Math.min(board[i][j-1] , board[i-1][j]);
        }
    }
}
