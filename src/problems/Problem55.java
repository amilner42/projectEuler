package problems;

import java.math.BigInteger;

// Question -----------------------------------------------------------------------------------------------------------
//    If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
//
//            Not all numbers produce palindromes so quickly. For example,
//
//            349 + 943 = 1292,
//            1292 + 2921 = 4213
//            4213 + 3124 = 7337
//
//            That is, 349 took three iterations to arrive at a palindrome.
//
//            Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
//            A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
//            Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that
//            a number is Lychrel until proven otherwise. In addition you are given that for every number below
//            ten-thousand, it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with
//            all the computing power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the
//            first number to be shown to require over fifty iterations before producing a
//            palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).
//
//            Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
//
//            How many Lychrel numbers are there below ten-thousand?
//
//            NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.
// --------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem55 {

    public static void main(String[] args) {

        // Go through all numbers under 10,000 and check if they are lychrel numbers. Using BigInteger to avoid overflow
        int lychrelCounter = 0;
        for(long i = 1; i < 10000; i++) {
            if(isLychrel(BigInteger.valueOf(i))) {
                lychrelCounter++;
            }
        }
        System.out.println(lychrelCounter);
    }

    // Returns: true if the number is a lychrel number. Note that the base number being a palindrome does
    // not make a number a lychrel number. We add the reverse of the number BEFORE we check if it is a palindrome
    private static boolean isLychrel(BigInteger number) {
        boolean isLychel = true;
        for(int i = 0; i < 49; i++) {
            number = number.add(reverse(number));
            if(isPalindrome(number)) {
                return false;
            }
        }
        return true;
    }

    // Returns: true if the number is a palindrome
    // Note: 1 - 9 are palindromes
    private static boolean isPalindrome(BigInteger number) {
        long[] digits = toLongArray(number);
        for(int i = 0; i < digits.length ; i++) {
            if(digits[i] != digits[digits.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // Returns:
    //  Array of longs of the number in reverse order
    //      eg BigInt 125 --> long[] {5 , 2 , 1}
    private static long[] toLongArray(BigInteger number) {
        long[] result = new long[number.toString().length()];
        for(int i = 0; i < result.length; i++) {
            result[i] = Long.valueOf(number.mod(BigInteger.TEN).toString());
            number = number.divide(BigInteger.TEN);
        }
        return result;
    }

    // Returns:
    //  Reverses a big integer
    //      eg. 256 --> 652
    //  leading 0s will be chopped
    //      eg 120 -- new BigInteger("021") --> 21
    private static BigInteger reverse(BigInteger number) {
        String reverseNumber = "";
        int length = number.toString().length();
        for(int i = 0; i < length; i++ ) {
            reverseNumber += number.mod(BigInteger.TEN);
            number = number.divide(BigInteger.TEN);
        }
        return new BigInteger(reverseNumber);
    }

}