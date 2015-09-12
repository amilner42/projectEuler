package problems40to49;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//Question -----------------------------------------------------------------------------------------------------------------------
//	The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
//	
//	Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
//	
//	d2d3d4=406 is divisible by 2
//	d3d4d5=063 is divisible by 3
//	d4d5d6=635 is divisible by 5
//	d5d6d7=357 is divisible by 7
//	d6d7d8=572 is divisible by 11
//	d7d8d9=728 is divisible by 13
//	d8d9d10=289 is divisible by 17
//	Find the sum of all 0 to 9 pandigital numbers with this property.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

public class Problem43 {

	public static BigInteger answer = BigInteger.ZERO;					// the sum of all 0-9 pandigital numbers with given property
	
	public static void main(String[] args) {
		// A list of the divisible-by primes
        // 17 not included because it is used for initial creation of the possible numbers
		List<Integer> primes = new ArrayList<Integer>() {{
			add(13);
			add(11);
			add(7);
			add(5);
			add(3);
			add(2);
		}};

        // get all 3 digit numbers that are divisible by 17 and have no repeated digits
		List<String> divisibleBy17 = new ArrayList<>();
		for(int i = 100; i < 1000; i++) {
			if(i%17 == 0 && noRepeats(i))
				divisibleBy17.add(String.valueOf(i));
		}

        // Go through all the numbers that are divisible by 17 and have no repeat digits and
        // "build" the number. Essentially, the solution goes right to left, building the number
        // by attaching each new digit to the front and checking if it follows the necessary divisibility rule
        // This right-to-left building is why we needed to start with numbers that were divisible by 17,
        // because that is the right-most rule
		for(String current: divisibleBy17) {
			buildNumber(current, primes, 0);
		}
		System.out.println(answer);
	}

    // Recursive Function
    // Effects: If it "builds" a full pandigital number from a given base number it adds this number to the answer.
	private static void buildNumber(String current, List<Integer> primes, int i) {
		// If the recursion has made it to the "base case" where all the digits are used but one AND 0 must already be
        // used because it cannot be added to the front of a number. Then find the remaining digit, add it to the front,
        // and add this solution to the answer.
		if(i == 6 && current.contains("0")) {
			for(int b = 1; b < 10; b++) {
				if(!current.contains(String.valueOf(b))) { 
					answer = answer.add(new BigInteger(String.valueOf(b).concat(current)));
				}
			}
		} else {
            // Attempt to put on all the digits, checking that both the next divisible-by-prime rule is followed
            // and that the number remains pandigital. If both these rules are followed it continues the recursion
			for(int a = 0; a < 10; a++) {
				String stringNumber = String.valueOf(a);
				if(!current.contains(stringNumber)){
				String testString = stringNumber.concat(current.substring(0, 2));
					if(Integer.valueOf(testString) % primes.get(i) == 0){
						buildNumber(stringNumber.concat(current), primes, i + 1);
					}
				}
			}
		}
	}

    // Requires: Input given be a 3-digit number
    // Returns: True if all 3 digits are different, false otherwise
    private static boolean noRepeats(int i) {
        int a = i % 10;
        i /= 10;
        int b = i % 10;
        i /= 10;
        int c = i % 10;
        return (a != b && a!= c && b != c);
    }
}
