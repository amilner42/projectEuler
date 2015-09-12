package problems20to29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import personal_library.MathFunctions;

//Question -----------------------------------------------------------------------------------------------------------------------
//	A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//	A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
//	As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
//	Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem23 {
	// Strategy:
	// Go through all the numbers between 1 and 28123 and find all the abundant numbers.
	// While doing this, also find the totalSum of all the numbers from 1 to 28123.
	// Add all these abundant numbers together in every permutation, making sure to use 
	// a round-robin technique to avoid duplicate adding. (Eg. Not doing 7 + 4 and 4 + 7).
	// If any of these sums are less than 28123, subtract it from the totalSum. This
	// leaves us with the sum of all numbers between 1 and 28123 that are not the sum
	// of two abundant numbers.  
	public static void main(String[]args){
		    long totalSum = 0; 
		    // A list of all the abundant numbers beneath 28123
		    List<Integer> abundentNumbers = new ArrayList<Integer>();
		    // A set (no duplicates) of all the numbers that are a sum of two abundant numbers
		    Set<Integer>   abundentSums = new HashSet<Integer>(); 

		    // Go through all numbers between beneath 28123 and find all the abundant numbers.
		    // At the same time, find the sum off all the numbers beneath 28123 (totalSum)
		    for(int number = 0; number < 28123; number++){
		    	totalSum+= number; 
		    	if(MathFunctions.sumOfDivisers(number) > number){
		    		abundentNumbers.add(number);
		    	}
		    }
	   
		    // Go through the abundant numbers and add them together in every possible way
		    // avoiding adding them the same way but backwards for efficiency (7 + 4 and 4 + 7)
		    // Add all the abundant sums that are less than 28123 to a set (to avoid duplicates).
		    // Once finished, subtract all these abundant sums from totalSum
		    for(int i = 0; i < abundentNumbers.size(); i++) {
		    	for(int j = i; j < abundentNumbers.size(); j++) {
		    		Integer tempInt = abundentNumbers.get(i) + abundentNumbers.get(j);
		    		if(tempInt < 28123)
		    	    	abundentSums.add(tempInt);
		    		else
		    			break; //break out of inner loop to prevent unnessasary additions 
		    	}
		    }
		    for(Integer current: abundentSums) {
		    	totalSum -= current; 
		    }
		    
		    // Print out the answer
		    System.out.println(totalSum);
		}
}



		
		


