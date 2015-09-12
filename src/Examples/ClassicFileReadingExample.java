package Examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//learn to import files 
public class ClassicFileReadingExample {
	
	public static void main(String[]args) throws IOException{
		
	
		FileReader inputStream = null;
		FileWriter outputStream = null; 
		
		try{
			inputStream = new FileReader("Problem13InputFile");
			outputStream = new FileWriter("OutputTest");
			int c; 
		
		while((c = inputStream.read())!=-1){
			outputStream.write(c);
		   }
		}finally{
		       if (inputStream != null) {
		    	   inputStream.close();
	            }
		       if(outputStream != null){
		    	   outputStream.close();
		       }
	        }
		
		
		
	}
	
	
	

}
