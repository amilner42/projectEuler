package problems10to19; 

//Question -----------------------------------------------------------------------------------------------------------------------
//  You are given the following information, but you may prefer to do some research for yourself:
//  
//  1 Jan 1900 was a Monday.
//  Thirty days has September,
//  April, June and November.
//  All the rest have thirty-one,
//  Saving February alone,
//  Which has twenty-eight, rain or shine.
//  And on leap years, twenty-nine.
//  A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
//  How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
//---------- -----------------------------------------------------------------------------------------------------------------------
// Solution correct 

public class Problem19 {

	public static void main(String[] args) {
		// Starting Parameters 
		// Standard Calendar Date represented with 3 ints 
		int month = 1;
		int day = 1; 
		int year = 1901;
		
		// Recording the day of the week with an int for simplicity
		// 1 == Monday, 7 == Sunday
		int dayOfWeek = 1; 
		boolean isLeapYear = false; 
		int totalSundays = 0; 
		
		// Go through all the days in all the years starting in 1901,
		// stopping when 2001 is reached
		while(year < 2001){
			if(dayOfWeek == 7 && day == 1){
				totalSundays++; 
			}
			// Start updating the day, by adding one to the day
			// and changing all the variables from there
			day++;
			
			// Update day of week
			dayOfWeek++; 
			if(dayOfWeek == 8){
				dayOfWeek = 1; 
			}
			
			// Deal with all the months
			if((month == 2 && ((day == 29 && isLeapYear) || (day == 28 && !isLeapYear)))) {
				// Dealing with February
				day = 1; 
				month++; 
			} else if((month == 1 ||month == 3||month==5 ||month == 7||month == 8|| month == 10||month==12)&& day == 31) {
				// Dealing with all 31 day months
				day = 1;
				month++; 
			}
			else if((month == 4 || month == 6 || month == 9|| month == 11) && day == 30) {
				// Dealing with all 30 day months
				day = 1;
				month++;
			}
			
			// Deal with the year 
			if(month == 13) {
				month = 1; 
				year++; 
				
				// Update whether it is a leap year 
				if(year%400 == 0||(year%4==0 && year%100!=0)) {
					isLeapYear = true; 
				} else {
					isLeapYear = false; 
				}
				
			}
			
		}

     	// Print out the answer
		System.out.println(totalSundays);
	}
}
