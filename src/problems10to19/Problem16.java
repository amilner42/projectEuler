package problems10to19; 

import java.math.BigInteger;

//Question -----------------------------------------------------------------------------------------------------------------------
//  2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//  What is the sum of the digits of the number 2^1000?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem16 {

	public static void main(String[]args){
		// Using BigInteger get 2^1000 and convert it to a char array
		long sum = 0; 
		BigInteger number = (new BigInteger("2")).pow(1000);
		char [] fullNumber = number.toString().toCharArray();
		
		// Go through this array adding every value, subtracting 48 to deal
		// with the conversion from char '1' to integer 1. eg. '1' = 49
		for(int i = 0; i < fullNumber.length; i++){
			sum += fullNumber[i] - 48; 
		}

		// Print out the answer 
        System.out.println(sum);
		
	}
}
