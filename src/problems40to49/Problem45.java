package problems40to49;

//correct
//super cool way to do it, self-generative
//watch out for int size, used long
import java.util.ArrayList;
import java.util.List;

public class Problem45 {
	
	public static int currentIPent = 0; 
	public static int currentIHex = 0; 
	public static List<Long> pentagonals = new ArrayList<Long>();
	public static List<Long> hexagonals = new ArrayList<Long>();
	
	
	public static void main(String[] args) {
		long currentTriangle;
		long n = 286; 
		boolean stillSearching = true;
		addNextTenPentagonal();
		addNextTenHexagonal();
		while(stillSearching){
			currentTriangle = produceNextTriangleNumber(n);
			if(hasNumberPentagonal(currentTriangle)){
				if(hasNumberHexagonal(currentTriangle)){
					System.out.println(currentTriangle);
					stillSearching=false;
				}
			}
			n++;
		}
	}

	private static boolean hasNumberHexagonal(long currentTriangle) {
		while(hexagonals.get(hexagonals.size()-1) < currentTriangle){
			addNextTenHexagonal();
		}
		int index = currentIHex - 1; 
		long currentHex = hexagonals.get(index);
		while(currentHex >= currentTriangle){
			if(currentHex == currentTriangle){
			return true; 	
			}
			currentHex = hexagonals.get(--index);
		}
		return false; 
	}

	private static boolean hasNumberPentagonal(long currentTriangle) {
		while(pentagonals.get(pentagonals.size()-1) < currentTriangle){
			addNextTenPentagonal();
		}
		int index = currentIPent - 1; 
		long currentPent = pentagonals.get(index);
		while(currentPent >= currentTriangle){
			if(currentPent == currentTriangle){
			return true; 	
			}
			currentPent = pentagonals.get(--index);
		}
		return false; 
		
	}

	private static long produceNextTriangleNumber(long n) {
		return n*(n+1)/2;
	}

	public static void addNextTenPentagonal() {
		for(long i = currentIPent; i < currentIPent + 10;i++){
		pentagonals.add(i*(3*i-1)/2);
		}
		currentIPent += 10; 
	}

	public static void addNextTenHexagonal() {
		for(long i = currentIHex;i < currentIHex+10;i++){
		hexagonals.add(i*(2*i-1));
		}
		currentIHex += 10; 
	}
	

}
