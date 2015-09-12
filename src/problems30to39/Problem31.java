package problems30to39;

//Question -----------------------------------------------------------------------------------------------------------------------
// In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
//
// 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
// It is possible to make £2 in the following way:
//
// 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
// How many different ways can £2 be made using any number of coins?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct

// General Idea: This problem is solved by using nested for-loops. Starting from the coin of highest value (coin200)
// it goes through all the possibilities of other low value coins and then incrememnts the highest coin. It does not 
// increment a coin beyond its logical maximum. Aka, it will only increment the coin200 up to 1 because you could never
// have two 200coins and have a sum of 200. The ONLY thing to be weary of when using this technique is to add a check 
// that makes sure it does not increment totalWays when the coin you are on is equal to 0. Otherwise you end up double-counting
// a lot because you will count coin100*2 when coin50 == 0 and when coin 20 == 0 etc... 

public class Problem31 {
	
	public static void main(String[] args) {
	    int totalWays = 0; 						// recording the total number of ways to get sumNeeded
		final int sumNeeded = 200; 				// the sum we are trying to get (£2)
	
		// You can have up to one 200-value coin
		for(int coin200 = 0; coin200 <= 1; coin200++) {
                if(coin200*200 == sumNeeded)
					totalWays++; 
			
			// You can have up to two 100-value coins 
			for(int coin100 = 0; coin100 <= 2 ; coin100++) {
				if(coin200*200 + coin100 * 100 == sumNeeded && coin100!= 0)
					totalWays++;
				
				// You can have up to four 50-value coins
				for(int coin50 = 0; coin50 <= 4; coin50++) {
					if(coin200*200 + coin100*100 + coin50*50 == sumNeeded && coin50!= 0)
						totalWays++; 		
					
					// You can have up to ten 20-value coins 
				    for(int coin20 = 0; coin20 <= 10; coin20++) {
				    	if(coin200*200 + coin100*100 + coin50*50 + coin20*20 == sumNeeded && coin20!= 0)
							totalWays++; 		
				    	
				    	// You can have up to twenty 10-value coins
				    	for(int coin10 = 0; coin10 <= 20; coin10++) {
				    		if(coin200*200 + coin100*100 + coin50*50 + coin20*20 + coin10*10 == sumNeeded && coin10!= 0)
								totalWays++; 							
				    		
				    		// You can have up to forty 5-value coins
				    		for(int coin5 = 0; coin5 <= 40; coin5++) {
				    			if(coin200*200 + coin100*100 + coin50*50 + coin20*20 + coin10*10 + coin5*5== sumNeeded && coin5!= 0)
									totalWays++; 									
							
								// You can have up to one-hundred 2-value coins
				    			for(int coin2 = 0; coin2 <= 100; coin2++) {
				    				if(coin200*200 + coin100*100 + coin50*50 + coin20*20 + coin10*10 + coin5*5 + coin2*2== sumNeeded && coin2!= 0)
										totalWays++;									
									
									// You can have up to two-hundred 1-value coins
				    			    for(int coin1 = 0; coin1 <= 200;coin1++) {
				    			    	if(coin200*200 + coin100*100 + coin50*50 + coin20*20 + coin10*10 + coin5*5 + coin2*2 + coin1 == sumNeeded && coin1!= 0)
											totalWays++; 		
								   }				    			
					    		}		
					    	}				    	
					    }					
					}				
				}				
			}
		}
		// Print out the answer
		System.out.println(totalWays);
	}
}
