package problems40to49;

//correct
//easy
//length of search here just used to make an arbitrary-sized list of primes to go through (as opposed to checking every time) to make program run faster (turns out not needed) 
import java.util.LinkedList;
import java.util.List;


public class Problem46 {

	private static List<Integer>primes; 
	private final static int lengthOfSearch = 1000; 
	
	public static void main(String[] args) {
		primes  = new LinkedList<Integer>();
		for(int i = 2; primes.size() < lengthOfSearch;i++){
			if(checkPrime(i))
				primes.add(i);
		}
		
		for(int i = 33; i < Integer.MAX_VALUE; i+=2){
			if(!checkPrime(i)){
				if(checkGoldNumber(i)){
					System.out.println(i);
				    break;
				}
			}
		}

	}
	
	private static boolean checkGoldNumber(int i) {
		int a = 0;
		int currentPrime; 
		do{
         currentPrime = primes.get(a);	
         int tempNumber = (i - currentPrime)/2; 
         if(((int) Math.pow(tempNumber, 0.5)) * ((int) Math.pow(tempNumber, 0.5)) == tempNumber)
        	 return false; 
         a++;
		}while(currentPrime < i);
		return true; 
	}

	//checks if given integer is prime 
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
