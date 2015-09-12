package problems30to39;

// @Co-author: Stephane Aroca-Oullette 

//Question -----------------------------------------------------------------------------------------------------------------------
//	If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
//	
//	{20,48,52}, {24,45,51}, {30,40,50}
//	
//	For which value of p ≤ 1000, is the number of solutions maximised?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct
 
public class Problem39 {

	public static void main(String[] args) {
		int[] paramPossib= new int[1001];					// Keep track of the number of possibilities for each perimeter  paramPossib[some-param] = number of possibilities

		// Go through all the possibilities, no need to check for side-lengths over 500 because then the perimeter will be over 1000. 
		// Every time you find a proper right triangle then add 1 point to that perimeter (if the perimeter is <= 1000) 
		for(int a=0; a<=500; a++) {
			for(int b=a; b<=500; b++) {
				double cDouble = Math.sqrt(a*a+b*b);		// get the length of the hypotenuse (precise)
				int c = (int) cDouble;						// get the length of the hypotenuse (rounded)
				
				// If the hypotenuse is an exact integer (eg 5 or 8, not 12.2 or 3.333) &&
				// the total perimeter of the triangle is <= 1000 then add 1 point to that perimeter
				if(c == cDouble) {
					if(a+b+c <= 1000) {
						paramPossib[a+b+c]++;
					}
				}
			}
		}

		int most = 0;										// the number of solutions for the perimeter with the most solutions 
		int index = 0;										// the perimeter with the most solutions 
		for(int i=0; i<=1000; i++) {
			if(paramPossib[i] > most) {
				most=paramPossib[i];
				index=i;
			}
		}
		// print out the answer 
		System.out.println(index);
	}
}
