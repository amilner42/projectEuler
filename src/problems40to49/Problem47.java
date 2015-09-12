package problems40to49;

import personal_library.MathFunctions;

public class Problem47 {

	public static void main(String[] args) {

		long numberInARow = 0;   
		
		for(long index = 10; numberInARow < 4 ; index++) {
			if(MathFunctions.hasXPrimeFactors(index, 4)) {
				numberInARow++;
				if(numberInARow == 4){
					System.out.println(index);
					break;
				}
			} else {
				numberInARow = 0; 
			}
		}	
	}
}
