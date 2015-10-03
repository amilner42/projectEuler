package problems50to59;

// Question -----------------------------------------------------------------------------------------------------------
// It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different
// order.
// Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
// --------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem52 {

    public static void main(String[] args) {
        // Go through checking integers in order for 2-6x same-digit attribute as described in question, printing the
        // answer once found
        boolean foundSolution = false;
        for(int i = 1; !foundSolution ; i++) {
            if(sameDigitsToN(6 , i)) {
                System.out.println(i);
                foundSolution = true;
            }
        }
    }

    // Returns: true if the number and the number * n have the same digits, going from n=2 to n
    private static boolean sameDigitsToN(int n , int param)  {
        boolean sameDigits = true;
        // Go through checking that each number and product have the same digits, break the loop at any
        // point and return false if one pair does not have the same digits
        for(int i = 2 ; i < n && sameDigits ; i++) {
            sameDigits = sameDigits && sameDigits(param , param * i);
        }
        return sameDigits;
    }

    // Returns: true if the number1 and number2 have the same digits
    private static boolean sameDigits(int number1 , int number2) {
        int[] counter = new int[10];                    // used to count amount of each digit

        // Go through number1 counting the digits
        for(; number1 > 0; number1 /= 10) {
            int temp = number1 % 10;
            counter[temp]++;
        }

        // Go through number2 counting the digits, but removing from the counter
        // here instead of adding
        for(; number2 > 0; number2 /= 10) {
            int temp = number2 % 10;
            counter[temp]--;
        }

        // If all spot in counter are not 0 then digits were not the same, otherwise they were
        for(int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
