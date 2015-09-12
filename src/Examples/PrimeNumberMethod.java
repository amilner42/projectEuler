package Examples;

public class PrimeNumberMethod {
	
	public static void main(String[]args){
		System.out.println(checkPrime(3));
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
