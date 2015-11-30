package problems;

import java.math.BigInteger;

// Question -----------------------------------------------------------------------------------------------------------
//    The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
//
//            How many n-digit positive integers exist which are also an nth power?
// --------------------------------------------------------------------------------------------------------------------
// Solution correct

// Strategy:
// This is the important pattern to nice:
//
//  1  --> 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9
//  2  --> X , X , X , 4 , 5 , 6 , 7 , 8 , 9
//  3  --> X , X , X , X , 5 , 6 , 7 , 8 , 9
//  4  --> X , X , X , X , X , 6 , 7 , 8 , 9
//  5  --> X , X , X , X , X , X , 7 , 8 , 9
//  6  --> X , X , X , X , X , X , 7 , 8 , 9
//  7  --> X , X , X , X , X , X , X , 8 , 9
//  8  --> X , X , X , X , X , X , X , 8 , 9
//  9  --> X , X , X , X , X , X , X , 8 , 9
// 10  --> X , X , X , X , X , X , X , 8 , 9
// 11  --> etc etc ...

public class Problem63 {

    public static void main(String[] args) {

        // Go through the columns of the matrix above, counting each number "downwards" until it hits an X, then we know
        // it is "done" (it will only have more Xs beneath it), so we can move to the next column, using BigInteger to
        // avoid overflow on pow(int i ) and using total to keep track of how many non-Xs we got
        int total = 0;
        for (int number = 1; number < 10; number++) {
            int currentExp = 1;
            BigInteger numberBig = BigInteger.valueOf(number);
            while (numberBig.pow(currentExp).toString().length() == currentExp) {
                total++;
                currentExp++;
            }
        }
        System.out.println(total);
    }
}