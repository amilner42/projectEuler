package problems;

import java.util.HashSet;

// Question -----------------------------------------------------------------------------------------------------------
//    A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.
//
//            For example,
//
//            44 → 32 → 13 → 10 → 1 → 1
//            85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
//
//            Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
//
//            How many starting numbers below ten million will arrive at 89?
// --------------------------------------------------------------------------------------------------------------------
// Solution correct

public class problem92 {

    public static HashSet<Integer> solutions89;
    public static HashSet<Integer> solutions1;

    public static void main(String[] args) {

        // Initialize solution lists
        solutions89 = new HashSet<>();
        solutions89.add(89);
        solutions1 = new HashSet<>();
        solutions1.add(1);

        // Go through all 10 million numbers using the dynamic function to avoid repetitive calculation
        for (int i = 1; i < 10000000; i++) {
            squareDigitsDynamicSequence(i);
        }

        System.out.println(solutions89.size());
    }

    // (int) --> void
    // Go through the sequence for the number, checking at every number whether it is already in either of the lists.
    // Once it is in one of the lists, add it and all of the numbers it went through to that list.
    private static void squareDigitsDynamicSequence(int i) {
        HashSet<Integer> temp = new HashSet<>();

        while (!solutions1.contains(i) && !solutions89.contains(i)) {
            temp.add(i);
            i = squareDigits(i);
        }

        if (solutions1.contains(i)) {
            solutions1.addAll(temp);
        } else {
            solutions89.addAll(temp);
        }
    }

    // (int) --> int
    // Returns the sum of the square of all the digits
    private static int squareDigits(int i) {
        int total = 0;
        while (i > 0) {
            int temp = i % 10;
            total += temp * temp;
            i /= 10;
        }
        return total;
    }
}