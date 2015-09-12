package personal_library;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MathFunctions {

	// Requires: primeNumber must be positive 
	// Check if the number is a prime, 1 is not prime. 
		public static boolean checkPrime(long primeNumber) {
			int a = 2; 

			if (primeNumber == 1 || primeNumber == 0) {
				return false; 
			}
			while(a <= Math.sqrt(primeNumber)){
				if(primeNumber % a == 0){
					return false;
				}
				a++; 
			}
	     return true; 
		}
	
		
		// Requires: A positive number
		// Checks if the number is a palandrome
		public static boolean checkPalandrome(int number){
			LinkedList<Integer> list = new LinkedList<Integer>();
			int tempStorage = 0; 
			
			// make the list of parsed integers 
			while(number > 0){
				tempStorage = number - ((number / 10) * 10);
				list.add(tempStorage);
				number /= 10; 
			}
			
			// Go through list from opposite ends comparing values 
			int listSize = list.size();
			for(int i = 0; i < listSize; i++){
				if(list.get(i) != list.get(listSize - (i + 1))){
					return false; 
				}
			}
			
			// if it got this far it's a palandrome 
			return true; 
			
		}
		
		// Requires: Number is > 0, x is > 0
		// Returns the number of divisors, including 1 and the number itself 
		public static boolean overXDivisors(int x, int number){
			int recorder = 1; 
			int score = 0; 
			
			if(number == 1){
				return 1 > x; 
			}
			
			while(recorder <= Math.sqrt(number)){
				if(number%recorder == 0){
					score++; 
				}
				recorder++;
			}
			
			if(score > (x/2))
				return true;
			else
				return false; 
		}
		
		
		//  Checks if the number is an amicable number:
		//  Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
		//	If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
		//	
		//		For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
		//  
		//  It will return false for numbers <= 0  
		public static boolean amicableNumber(int number){
			if(number == sumOfDivisers(sumOfDivisers(number)) && number != sumOfDivisers(number)){
				return true; 
			}else
				return false; 
		}

		//  Returns the sum of all the proper divisors less than x,
		//  1 is included. It will return 0 if the number <= 1
		public static int sumOfDivisers(int x) {
			int sum = 0; 
			for(int i = 1; i < x; i++){
				if(x%i == 0){
					sum+=i;
				}
			}
			return sum; 
		}
		
		// Return the smallest prime number greater than CurrentNumber
		// Note: Will return 2 if you give it a number < 2
		public static long getNextPrime(long currentNumber) {
			for(long index = currentNumber + 1; ;index++) {
				if(MathFunctions.checkPrime(index)){
					return index; 
				}
			}
		}
		
		
		// Requires: number and x are both positive 
		// Returns whether or not that number has x distinct prime factors 
		public static boolean hasXPrimeFactors(long number, int x) {
			long numberOfFactors = 0;
			long currentDivider  = 2; 
			boolean count = true; 
			for( ; ; ){
				if(number == 1){
					if(numberOfFactors == x) {
						return true;
					} else {
						return false; 
					}
				}
				if(number % currentDivider == 0) {
					number /= currentDivider;
					if(count) {
						numberOfFactors++;
						if(numberOfFactors > x){
							return false; 
						}
						count = false; 
					}				
				} else {
					currentDivider = MathFunctions.getNextPrime(currentDivider);
					count = true; 
				}
			}
		}
		
		// Requires: Positive number (input)
		// Returns: True if the number contains 1 copy of all the digits from 1-9 and no other digits 
		public static boolean checkPandigital(long number) {
			if(String.valueOf(number).length() != 9) {
				return false; 
			}
			Set<Long> digits = new HashSet<Long>();
			while(number > 0) {
				long tempInt = number%10; 
				if(tempInt == 0) {
					return false; 
				}
				digits.add(tempInt);
				number/=10; 
			}	
			return digits.size() == 9; 
		}
}
