package problems1to9;

// Question -----------------------------------------------------------------------------------------------------------------------
// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
// Find the sum of all the multiples of 3 or 5 below 1000.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem1 {

	public static void main(String[] args) {
		int sum = 0; 
		
		// Go through 1-1000 and add the number to sum if it  
		// is divisible by 3 or 5 
		for(int i = 0; i < 1000;i++){
		if(i % 3 == 0 || i % 5 == 0)	
			sum += i; 
		}
		
		// Print out the answer 
		System.out.println(sum);
	}
	
}
