package Examples;

public class ReverseNumberMethod {

	//assume the number given does not end in 0; 
	private static int reverseNumber(int number) {
		//turn it into a string just for length 
		String tempString = String.valueOf(number);
		int length = tempString.length();
		//new number 
		int newNumber = 0; 
		int i = 0; 
		
	    while(number>0){
			int tempNumber = number%10; 
			number/=10; 
			tempNumber *= Math.pow(10, (length-(i+1)));
			newNumber += tempNumber; 
			i++; 
		}
		return newNumber; 
	}
}
