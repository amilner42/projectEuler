package Examples;

import java.util.LinkedList;

public class checkPalindromeMethod {

	public static boolean checkPalandrome(int a){
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		int tempStorage = 0; 
		
		//make the list of parsed integers 
		while(a > 0){
			tempStorage = a - ((a / 10) * 10);
			list.add(tempStorage);
			a /= 10; 
		}
		
		//make a new list the reverse way 
		for(int i = 0; i < list.size();i++){
			list2.add(list.get(list.size() - (i+1)));
		}
		
		//compare lists 
		for(int i = 0; i < list.size(); i++){
			if(!list.get(i).equals(list2.get(i))){
				return false; 
			}
			
			
		}
		
		//if it got this far its a palandrome 
		return true; 
		
			
		
	}
	
}
