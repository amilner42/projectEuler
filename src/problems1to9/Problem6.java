package problems1to9;

//Question -----------------------------------------------------------------------------------------------------------------------
// The sum of the squares of the first ten natural numbers is,
// 1^2 + 2^2 + ... + 10^2 = 385
// The square of the sum of the first ten natural numbers is,
// (1 + 2 + ... + 10)^2 = 55^2 = 3025
// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
//---------- ---------------------------------------------------------------------------------------------------------------------
//Solution correct  

public class Problem6 {

	public static void main(String[]args){
		long sum = 0; 
		
		// get (1 + 2 + 3 + ... + 100)
		for(long i = 0; i <= 100; i++){
			sum += i; 
		}		
		// get (1 + 2 + 3 + ... + 100)^2
		sum = sum * sum;
		
		// get (1 + 2 + 3 + ... + 100)^2 - (1^2 + 2^2 ... 100^2)
		for(long i = 1; i <= 100; i++){
			sum -= i * i; 
		}
		
		// print out the answer 
		System.out.println(sum);
		
	}
	
}
