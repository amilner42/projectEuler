package problems20to29;

import java.math.BigInteger;

//Question -----------------------------------------------------------------------------------------------------------------------
//	n! means n × (n − 1) × ... × 3 × 2 × 1
//	
//	For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
//	and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
//	
//	Find the sum of the digits in the number 100!
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem20 {

	public static void main(String[] args) {
		BigInteger number = BigInteger.valueOf(100);
        BigInteger recorder = BigInteger.valueOf(99);
        BigInteger sum = BigInteger.ZERO;
		
        // !100
        while(!recorder.equals(BigInteger.valueOf(1))){
        	number = number.multiply(recorder);
        	recorder = recorder.subtract(BigInteger.ONE);
        }
        
        // Use the classic %10 and /10 to parse the integer and 
        // sum up all the digits. 
        while(!number.equals(BigInteger.ZERO)){
        	BigInteger tempHolder = number.remainder(BigInteger.TEN);
        	sum = sum.add(tempHolder);
        	number = number.divide(BigInteger.TEN);
        }
        
     	// Print out the answer
        System.out.println(sum);        
	}
}
