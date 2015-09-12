package problems1to9;

//Question -----------------------------------------------------------------------------------------------------------------------
// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
//---------- ---------------------------------------------------------------------------------------------------------------------
//Solution correct  

public class Problem5 {

	public static void main(String[] args) {
	// start at the smallest number divisible by 20 
	int a = 20;
	
	// clean loop-control variable 
	boolean breakNow = false; 
	
	// keep adding 20 and checking if it matches the requirements. 
	// Yes you could add 60 instead etc etc ... 
		while(!breakNow){
			if(checkDivisibleFromOneToTwenty(a)){
				// print out the answer 
				System.out.println(a);
				breakNow = true; 
			}
		a += 20; 
		}

	}
	
	// Private Function 
	// See if number divides by all the values between 2 and 19 evenly (20 not needed because of 2)
	// Easily could be more efficient but not necessary at all 	
	private static boolean checkDivisibleFromOneToTwenty(int number){
		for(int i = 2; i <= 19; i++){
			if(!(number % i == 0)){
				return false; 
			}
		}
		return true; 
	}
	
}
