package problems10to19; 

//Question -----------------------------------------------------------------------------------------------------------------------
// If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
// If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
// NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem17 {
	
	public static void main(String[]args){
		int total = 0; 

		for(int i = 1; i < 1001; i++){
			// Add the amount of letters for the 1s place
			// Always Constant
			if(i%10 == 1){
				total+= 3; 
			}
			else if(i%10 == 2){
				total+= 3; 
			}
	    	else if(i%10 == 3){
				total+= 5;
			}
	    	else if(i%10 == 4){
	    		total+= 4; 
	    	}
	    	else if(i%10 == 5){
	    		total += 4; 
	    	}
	    	else if(i%10 == 6){
	    		total+= 3;
	    	}
	    	else if(i%10 == 7){
	    		total+= 5;
	    	}
	    	else if(i%10 == 8){
	    		total += 5; 
	    	}
	    	else if(i%10 == 9){
	    		total+=4; 
	    	}
			// Add the letters for a potentially needing an "and" 
			if(i > 100 && !(i%100==0)){
				total += 3; 
			}
			
			// Deal with the cases for 10-19 (an exception to standard 1s place rule)
			// 'total +=' and 'total -=' included to make it more clear, subtracting the normal 
			// 1s place addition and adding length of full word 
			if((i/10)%10 == 1){
				if(i%100 == 10){
					total+= 3;
				}
				if(i%100 == 11){
					total+= 6;
					total-= 3;
				}
				
				if(i%100 == 12){
					total+= 6;
					total-= 3;
				}
				if(i%100 == 13){
					total+= 8;
					total-= 5;
				}
				if(i%100 == 14){
					total+= 8;
					total-= 4;
				}
				if(i%100 == 15){
					total+= 7;
					total-= 4;
				}
				if(i%100 == 16){
					total+= 7;
					total-= 3;
				}
				if(i%100 == 17){
					total+= 9;
					total-= 5;
				}
				if(i%100 == 18){
					total+= 8;
					total-= 5;
				}
				if(i%100 == 19){
					total+= 8;
					total-= 4;
				}
				
			}
			// Dealing with the cases between 20-90
			if((i/10)%10 == 2){
				total += 6;
			}
			if((i/10)%10 == 3){
				total += 6;
			}
			if((i/10)%10 == 4){
				total += 5;
			}
			if((i/10)%10 == 5){
				total += 5;
			}
			if((i/10)%10 == 6){
				total += 5;
			}
			if((i/10)%10 == 7){
				total += 7;
			}
			if((i/10)%10 == 8){
				total += 6;
			}
			if((i/10)%10 == 9){
				total += 6;
			}

			// Dealing with the different hundreds cases
			// eg. 100 or 200 or 300 (same for 300 and 302 and 349 etc...)
			if((i/100)%10 == 1){
				total+= 10; 
			}
			if((i/100)%10 == 2){
				total+= 10;			
			}
			if((i/100)%10 == 3){
				total+= 12;
			}
			if((i/100)%10 == 4){
				total+= 11;
			}
			if((i/100)%10 == 5){
				total += 11;
			}
			if((i/100)%10 == 6){
				total += 10;
			}
			if((i/100)%10 == 7){
				total += 12;
			}
			if((i/100)%10 == 8){
				total += 12; 
			}
			if((i/100)%10 == 9){
				total += 11; 
			}
		}

		// Print out the answer
		// The +11 is for 'o''n''e''t''h''o''u''s''a''n''d'
		System.out.println(total + 11);
	}
}
