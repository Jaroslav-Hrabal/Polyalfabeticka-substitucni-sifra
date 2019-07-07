package Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	public List<List<Integer>> readKey(String input){
		List<List<Integer>> key = new ArrayList<List<Integer>>();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 \\".toCharArray();
		File file = new File(input);
	    if (!file.exists()) {
	      System.out.println(input + " does not exist.");
	      return null;
	    }
	    if (!(file.isFile() && file.canRead())) {
	      System.out.println(file.getName() + " cannot be read from.");
	      return null;
	    }
	    try {
	      FileInputStream fis = new FileInputStream(file);
	      char current;
	      while (fis.available() > 0) {
	        current = (char) fis.read();
	        int count = (int) current;
	        List<Integer> first = new ArrayList<Integer>();
	        first.add(count);
	        key.add(first);
	        for(int i = 0; i< count; i++) {
	        	List<Integer> tmp = new ArrayList<Integer>();
	        	for(int j = 0; j<64; j++) {
	        		current = (char) fis.read();
	        		int number = new String(alphabet).indexOf(current);
	        		tmp.add(number);
	        	}
	        	key.add(tmp);
	        }
	        
	       
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		return key;
	
	}
		

	
	
	public List<Integer> readFile(String input) throws IOException {
		List<Integer> message = new ArrayList<Integer>();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 \\".toCharArray();
		File file = new File(input);
	    if (!file.exists()) {
	      System.out.println(input + " does not exist.");
	      return null;
	    }
	    if (!(file.isFile() && file.canRead())) {
	      System.out.println(file.getName() + " cannot be read from.");
	      return null;
	    }
	    try {
	      FileInputStream fis = new FileInputStream(file);
	      char current;
	      while (fis.available() > 0) {
	        current = (char) fis.read();
	        int number = new String(alphabet).indexOf(current);
	        if(number== -1){
	        	String temp = String.format("%04x", (int) current);
	        	temp = "\\" + temp;
	        	char[] hexa = temp.toCharArray();
	        	//System.out.println(hexa);
	        	for(char c : hexa){
	        		number = new String(alphabet).indexOf(c);
	        		//System.out.println(number);
	    	        message.add(number);
	        	}
	        	}else {
	        		message.add(number);
	        	}
	        
	        }
	        return message;
	      
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		return message;
	
	}
}

