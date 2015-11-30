package problems;

import java.math.BigInteger;

// Question -----------------------------------------------------------------------------------------------------------
//  A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large:
//        one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
//        Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
// --------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem56 {

    public static void main(String[] args) {

        // Go through counting on all the possibilities, keeping track of the current max
        int max = 0;
        for(long i = 1; i < 100; i++) {
            BigInteger a = BigInteger.valueOf(i);
            for(int b = 1; b < 100; b++) {
                max = Math.max(digitCount(a.pow(b)) , max);
            }
        }
        System.out.println(max);
    }

    // Requires: Positive big integer
    // Returns: the sum of all the digits in the BigInteger
    private static int digitCount(BigInteger number) {
        int sum = 0;
        int length = number.toString().length();

        for(int i = 0; i < length; i++) {
            sum += number.mod(BigInteger.TEN).intValue();
            number = number.divide(BigInteger.TEN);
        }
        return sum;
    }
}
