package problems40to49;

//correct 
//super easy runs fast 
public class Problem49 {

	public static void main(String[] args) {
		for(int i = 1001; i < 9997; i+=2){
			int adder = 2; 
			while(adder*2 + i <= 9999){
				int number1 = i; 
				int number2 = i + adder; 
				int number3 = i + 2*adder; 
				if(checkPrime(number1) && checkPrime(number2) && checkPrime(number3)){
					if(checkSameDigits(number1, number2, number3)){
						System.out.println(number1 + "" + number2 + "" + number3);
					}
					
				}
				adder+=2; 
			}
		}
	}

	private static boolean checkSameDigits(int number1, int number2, int number3) {
	if(compareTwoNumbers(number1,number2))
		if(compareTwoNumbers(number2,number3))
			return true; 
	return false; 
	}
	
	public static boolean compareTwoNumbers(int number1, int number2){
		int[]digits = new int[]{0,0,0,0,0,0,0,0,0,0};
	    for(int b = 0; b < 4; b++){
		int a = number1 % 10; 
		int a1 = number2 % 10;
	    number1 /= 10; 
	    number2 /= 10; 
	    digits[a]+=1; 
	    digits[a1]-=1;
		}
	    for(int check = 0; check < 10; check++){
	    if(digits[check] != 0){
	    	return false; 
	    }
	    }
	    return true; 
	}

	//checks if given integer is prime (1 and 2 prime)
	private static boolean checkPrime(int primeNumber) {
		int a = 2; 
		while(a <= Math.sqrt(primeNumber)){
			if(primeNumber % a == 0){
				return false;
			}
			a++; 
		}
     return true; 
	}
	
}
