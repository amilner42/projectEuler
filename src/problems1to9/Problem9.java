package problems1to9;

//Question -----------------------------------------------------------------------------------------------------------------------
// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
// a^2 + b^2 = c^2
// For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.
//---------- -----------------------------------------------------------------------------------------------------------------------
//Solution correct  

public class Problem9 {

	public static void main(String[] args) {
			
		// Loop through all the combinations for variables a and b, where at most both are 499
		// I picked both limits as 499 as to make sure to encapsulate all the combinations that 
		// could be the answer, this set of possibilities is definitely a super-set of the 
		// possibilities I needed to search. (for ease of programming) 
		outerLoop:
		for(int a = 0; a < 500; a++){
			
			for(int b = a; b < 500; b++){
				// Check to see if it has a clean sqaure root, and check if a + b + c = 1000
				long cSquared = a*a + b*b;
				long c = (long) Math.sqrt(cSquared);
				if(c * c == cSquared){
					if(a + b + c == 1000){
						// print out the answer 
						System.out.println(a*b*c);
						break outerLoop; 
					}
				}
				
			}
			
		}
	

	}

}

