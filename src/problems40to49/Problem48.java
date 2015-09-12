package problems40to49;

//correct
//super easy just use BigInteger - symbolic math
import java.math.BigInteger;

public class Problem48{
	
	public static void main(String[]args){
		
		BigInteger number = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		int exponent = 1;
		
		while(BigInteger.valueOf(1001).subtract(number).signum() == 1){
			sum = sum.add(number.pow(exponent));
			number = number.add(BigInteger.ONE);
			exponent++;
		}
		System.out.println(sum);
	}
	
	
	
	
}