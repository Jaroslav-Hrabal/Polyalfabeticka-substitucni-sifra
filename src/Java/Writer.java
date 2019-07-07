package Java;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {
	
	public void writeFile(String file, String text) throws FileNotFoundException {
		try (PrintWriter out = new PrintWriter(file)) {
		    out.println(text);
		}
	}
	public String writeKey(List<List<Integer>> key){
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 \\".toCharArray();
		String result = "";
		for(List<Integer> l : key) {
			for(Integer i: l) {
				if (result=="") {
					result += (char)((int)i);
				}else {
					result += alphabet[i]; 
				}
			}
		}
		return result;
	}
	
	
	public String writeMessage(List<Integer> message) {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 \\".toCharArray();
		String result = "";
		for(int i = 0; i<message.size();i++) {
			if(message.get(i)!=-1) {
				if (message.get(i)!= 63) {
				result += alphabet[message.get(i)];
				}else {
					if(message.get(i)==63) {
						if(i<message.size()-4) {
							if(message.get(i+1)==52) {
								String tmp="";
								tmp += alphabet[message.get(i+1)];
								tmp += alphabet[message.get(i+2)];
								tmp += alphabet[message.get(i+3)];
								tmp += alphabet[message.get(i+4)];
								//System.out.println(tmp);
								try {
									int temp = Integer.decode("0x"+tmp);
									result += (char)temp;
								}catch (Exception e) {
									result += alphabet[message.get(i)];
									result += alphabet[message.get(i+1)];
									result += alphabet[message.get(i+2)];
									result += alphabet[message.get(i+3)];
									result += alphabet[message.get(i+4)];
								}
								//System.out.println(temp);
								//System.out.println((char)temp);
								//System.out.println((char)Integer.parseInt(tmp));
								//result += (char)(Integer.parseInt(tmp));
								
								i = i+4;
										
							}else {
								result += '\\';
							}
						}
					}
				}
			}
		}
		return result;
	}
}
