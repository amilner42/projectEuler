package Examples;

public class practiceclass {

	public static void main(String[] args) {
		//does the binary switch for you! 
		   long n = 600851475143L; // number i am trying to factor
	        long f1;                // finds descending factors of n, ie if find a prime factor i, it is the largest prime factor
	        long r;                 // checks if f1 is prime
	        long f2;                // will be the lower factor of n, along with i, ie i*j = n
	        long s;                 // checks if f2 is prime
	        long ans = 0;               // will be final answer

	        for(f1 = n/2; f1 >= n/f1; f1 = f1-1);{      // why can't i do this as a for loop?
	            if (n%f1 == 0){                         // if f1 is a factor of n
	                for (r = 2; r <= f1/r; r++);{       // run through all the numbers up to the square root of f1
	                    if (f1%r == 0) {                // if f1 has any factors it is not prime
	                        r = f1;                     // so break the for loop
	                    }
	                    if (r == f1/r){                 // if r gets all the way to the limit of the for loop, then it is prime
	                        ans = f1;                   // so f1 is the final answer
	                        f1 = n;                     // and break the original for loop, giving the final answer
	                    }
	                }
	                f2 = n/f1;                          // now check other factor of n, which is n/f1
	                for (s = 2; s <= f2/s; s++);{       // run through all numbers up to square root of f2
	                    if (f2%s == 0){                 // if f2 has any factors then it is not prime
	                        s = f2;                     // so break the for loop
	                    }
	                    if (s == f2/s){                 // if s gets all the way to the limit of the for loop, then it is prime
	                        ans = f2;                   // so it is the intermediate answer, so do not break for loop because it is a low prime factor
	                    }
	                }
	            }
	        }
	        
	        System.out.println(ans);
	    }
}