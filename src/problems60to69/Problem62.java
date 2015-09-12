package problems60to69;

// Question -----------------------------------------------------------------------------------------------------------------------
//    The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
//
//            Find the smallest cube for which exactly five permutations of its digits are cube.
// Bonus Question ------------------------------------------------------------------------------------------------------------------
//   Don't just solve for it for FIVE permutations, but rather solve it for N_PERMUTATIONS-permutations! (6 is much more interesting!)
//----------------------------------------------------------------------------------------------------------------------------------
// Correct

import java.util.*;

public class Problem62 {

    private static final int N_PERMUTATIONS = 6;                                // Adjust N_PERMUTATIONS to see answers for other permutation levels

    public static void main(String[] args) {
        // Key [String]:         The cube with the digits rearranged from highest to lowest eg. 5^3 = 125 --> "521"
        // Value [List of Long]: List of numbers that  produced a cube that is some permutation of the digits in KEY eg. 5
        Map<String , ArrayList<Long>> cubeCounter = new HashMap<>();
        ArrayList<Long> answers = new ArrayList<>();                            // store all possible answers, smallest is correct
        int maxDigits = Integer.MAX_VALUE;                                      // max digits used when the first answer is found to make sure there are no other smaller answers with the same number of digits

        for(long i = 0; String.valueOf(i * i * i).length() <= maxDigits; i++) {
            String sortedString = sortDigits(i * i * i);                        // sorts the cube digits (high to low) and puts it into a String

            // Add the index to the map where the key is its cube with sorted digits
            // If statement used here to avoid null pointer exception if it is the first time that key has been found
            if(cubeCounter.containsKey(sortedString)) {
                cubeCounter.get(sortedString).add(i);
            } else {
                ArrayList<Long> temp = new ArrayList<>();
                temp.add(i);
                cubeCounter.put(sortedString , temp);
            }

            // Check if that KEY has N_PERMUTATIONS numbers, if it does, make sure that the key
            // has no other permutation that also has a cube root. (can't have more than N_PERMUTATIONS)
            // As well, you must go up and check all numbers with that many digits because
            // there is a chance that some number that is smaller actually has N_PERMUTATIONS permutations
            // as well but you simply have not discovered all of its permutations yet.
            boolean morePermutations = false;
            if(cubeCounter.get(sortedString).size() == N_PERMUTATIONS) {
                long sortedStringAsLong = Long.valueOf(sortedString);
                for(long j = i + 1; j <= Math.pow(sortedStringAsLong , 1.0/3.0); j++) {
                    String sortedTemp = sortDigits(j * j * j);

                    // If another cube is found that also has the same sortedString, then it has too many permutations
                    if(sortedTemp.equals(sortedString)) {
                        morePermutations = true;
                        break;
                    }
                }

                // If it has exactly N_PERMUTATIONS cubeRoots for all its permutations, then an answer has been found
                // What is left to do is check remaining cubes with the same number of digits to avoid the problem
                // mentioned above.
                if(!morePermutations) {
                    ArrayList<Long> cubeRoots = cubeCounter.get(sortedString);
                    answers.add(cubeRoots.get(0) * cubeRoots.get(0) * cubeRoots.get(0));
                    maxDigits = sortedString.length();
                }
            }
        }

        // Print out all the answers, the smallest is correct (printing all answers out of interest)
        Collections.sort(answers);
        for(Long current: answers) {
            System.out.println(current);
        }
    }

    // Returns: number as a String with digits sorted from high to low
    // Eg. 15367 --> "76531"
    private static String sortDigits(long number) {
        char [] digits = String.valueOf(number).toCharArray();              // convert to char [] for built-in sorting
        Arrays.sort(digits);                                                // sortDigits the digits low - high

        // Reverse the order of the sorted digits to high - low
        char [] reverseOrder = new char[digits.length];
        for(int i = digits.length - 1 , j = 0; i >= 0; i-- , j++ ) {
            reverseOrder[j] = digits[i];
        }
        return new String(reverseOrder);
    }
}
