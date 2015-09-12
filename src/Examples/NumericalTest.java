package Examples;

import java.math.BigInteger;

public class NumericalTest {

	public static void main(String[] args) {
		BigInteger number = BigInteger.valueOf(1000);
		BigInteger recorder = BigInteger.valueOf(999);
		
        while(!recorder.equals(BigInteger.valueOf(1))){
        	number = number.multiply(recorder);
        	recorder = recorder.subtract(BigInteger.ONE);
        }
        
    	BigInteger number2 = BigInteger.valueOf(999);
		BigInteger recorder2 = BigInteger.valueOf(998);
        
	      while(!recorder2.equals(BigInteger.valueOf(1))){
	        	number2 = number2.multiply(recorder2);
	        	recorder2 = recorder2.subtract(BigInteger.ONE);
	        }
	
	      System.out.println(number2);
	      System.out.println(number.divide(number2));
	}

}
