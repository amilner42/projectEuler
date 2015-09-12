package personal_library_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personal_library.MathFunctions;

public class MathFunctionsTest {
	
	int x;
	int y;
	
	@Before
	public void runBefore(){
		// Redundant for clarity 
		x = 0; 
		y = 0; 
	}


	@Test
	public void testCheckPrime() {
		assertFalse(MathFunctions.checkPrime(1));
		assertTrue(MathFunctions.checkPrime(2));
		assertTrue(MathFunctions.checkPrime(29));
		assertFalse(MathFunctions.checkPrime(111));
	}

	@Test
	public void testCheckPalandrome(){
		assertTrue(MathFunctions.checkPalandrome(191));
		assertTrue(MathFunctions.checkPalandrome(18899881));
		assertFalse(MathFunctions.checkPalandrome(12));
		assertFalse(MathFunctions.checkPalandrome(1987657891));
	}
	
	@Test
	public void testOverXDivisors(){
		// 10 has 4 divisors, 1, 2, 5, 10
		assertFalse(MathFunctions.overXDivisors(4, 10));
		assertTrue(MathFunctions.overXDivisors(3, 10));
		assertFalse(MathFunctions.overXDivisors(1, 1));
	}
	
	@Test
	public void testAmicableNumber(){
		assertTrue(MathFunctions.amicableNumber(220));
		assertFalse(MathFunctions.amicableNumber(-3));
		assertFalse(MathFunctions.amicableNumber(0));
		assertFalse(MathFunctions.amicableNumber(1));
		assertFalse(MathFunctions.amicableNumber(10));
		
	}
	@Test
	public void testSumOfDivisers(){
		assertEquals(0,MathFunctions.sumOfDivisers(-1));
		assertEquals(0,MathFunctions.sumOfDivisers(0));
		assertEquals(0,MathFunctions.sumOfDivisers(1));
		assertEquals(1,MathFunctions.sumOfDivisers(2));
		// 1 + 2 + 3 + 4 + 6
		assertEquals(16,MathFunctions.sumOfDivisers(12));
	}
	
	@Test 
	public void testGetNextPrime(){
		assertEquals(MathFunctions.getNextPrime(0), 2);
		assertEquals(MathFunctions.getNextPrime(-1), 2);
		assertEquals(MathFunctions.getNextPrime(5), 7);
		assertEquals(MathFunctions.getNextPrime(12), 13);
		assertEquals(MathFunctions.getNextPrime(19), 23);
	}
	
	@Test
	public void	testHasXPrimeFactors(){
		assertTrue(MathFunctions.hasXPrimeFactors(15, 2));
		assertTrue(MathFunctions.hasXPrimeFactors(8, 1));
		assertTrue(MathFunctions.hasXPrimeFactors(10, 2));
		assertTrue(MathFunctions.hasXPrimeFactors(2 * 2 * 2 * 3 * 3 * 3 * 7 * 11, 4));
	}
	
	@Test
	public void testPandigital() {
		assertFalse(MathFunctions.checkPandigital(1));
		assertFalse(MathFunctions.checkPandigital(1209));
		assertFalse(MathFunctions.checkPandigital(12345678));
		assertFalse(MathFunctions.checkPandigital(1234567899));
		assertFalse(MathFunctions.checkPandigital(987123450));
		assertFalse(MathFunctions.checkPandigital(1234567890));
		assertTrue(MathFunctions.checkPandigital(123456789));
		assertTrue(MathFunctions.checkPandigital(987456321));
		assertFalse(MathFunctions.checkPandigital(-123456789));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
