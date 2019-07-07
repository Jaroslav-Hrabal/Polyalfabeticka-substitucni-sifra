package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coder {
	

		
	
	
	public List<Integer> codeMessage (List<Integer> message, List<List<Integer>> key) {
		int keyCount = key.get(0).get(0);
		for(int i = 0; i<message.size(); i++) {
			int keyIndex = 1+(i%keyCount);
			message.set(i, key.get(keyIndex).get(message.get(i)));
		}
		return message;
	}
	public List<Integer> decodeMessage(List<Integer> message, List<List<Integer>> key){
		int keyCount = key.get(0).get(0);
		for(int i = 0; i<message.size(); i++) {
			int keyIndex = 1+(i%keyCount);
			message.set(i, key.get(keyIndex).indexOf((message.get(i))));
		}
		return message;
	}
	
	public List<List<Integer>> makeKey(Integer length) {
		List<List<Integer>> key = new ArrayList<List<Integer>>();
		List<Integer> first = new ArrayList<Integer>();
		first.add(length);
		key.add(first);
		for(int i=0; i<length; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int j=0; j<64;j++) {
				temp.add(j);
			}
			Collections.shuffle(temp);
			key.add(temp);
		}	
		return key;
		
		
	}
	public void checkKey(List<List<Integer>> key) {
		
		int j = 0;
		for(List<Integer> keys:key) {
			int count = keys.get(0);
			if(key.size()!=count+1) {
				return;				
			}else {
				System.out.println("Wrong key");
			}
			keys.remove(0);
			Set<String> set=new HashSet<String>();
			boolean flag=true;
			int counter=0;
	        for(int i=0;i<keys.size();i++){
	            flag=set.add(keys.get(i).toString());
	            if(!(flag)){
	        System.out.println("Error has been found in key " + j + " at position " + keys.get(i));
	                flag=true;
					counter++;
	            }
		}}
		
	}


	
	}


