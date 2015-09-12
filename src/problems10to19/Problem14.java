package problems10to19; 

//Question -----------------------------------------------------------------------------------------------------------------------
//  The following iterative sequence is defined for the set of positive integers:
//
//  	n → n/2 (n is even)
//  	n → 3n + 1 (n is odd)
//
//  Using the rule above and starting with 13, we generate the following sequence:
//
//		13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//	It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//	Which starting number, under one million, produces the longest chain?
//
//	NOTE: Once the chain starts the terms are allowed to go above one million.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem14 {

	public static void main(String[]args){
		long number = 0; 
		long sequenceLength = 0; 
		
		// Go through finding the sequence length on every 
		// number under one million
		for(long i = 1; i < 1*1E6;i++){
			long newSequenceLength = findSequenceLength(i);
			if(newSequenceLength > sequenceLength){
				number = i; 
				sequenceLength = newSequenceLength; 
			}
		}
		// Print out the answer 
		System.out.println(number);
		
	}
	// Private Function
	// Find the Collatz Sequence length:(*= 3 + 1 if odd, /2 if even) 
	private static long findSequenceLength(long number) {
		long sequenceLength = 0; 		
		
		// repeat the sequence till at 1 
		while(number != 1){
			if(number % 2 == 0){
				number /= 2; 
				sequenceLength++; 
			} else {
				number *= 3; 
				number++;
				sequenceLength++; 
			}
		}
		return sequenceLength; 
	}
}
