package Java;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		Writer writer = new Writer();
		Coder coder = new Coder();
		
		System.out.println("Type 's' for encode or 'd' for decode");
		Scanner sc = new Scanner(System.in);
		char c = sc.nextLine().charAt(0);
		if(c=='s') {
			System.out.println("Input address to key file, for example C:\\\\Workspace\\\\Resources\\\\key18.txt");
			String readkey = sc.nextLine();
			List<List<Integer>> key = reader.readKey("C:\\Workspace\\Resources\\key18.txt");
			coder.checkKey(key);
			System.out.println("Input address to data file, for example C:\\\\Workspace\\\\Resources\\\\data2.txt");
			String readFile = sc.nextLine();
			List<Integer> message = reader.readFile("C:\\Workspace\\Resources\\data2.txt");
			List<Integer> coded = coder.codeMessage(message, key);
			String text = writer.writeMessage(coded);
			
			System.out.println("Input address to output file, for example C:\\\\Workspace\\\\Resources\\\\ciphered.txt");
			String writeFile = sc.nextLine();
			if(writeFile.isEmpty()) {
				System.out.println(text);
			}else {
				writer.writeFile(writeFile, text);
			}
			
		}
		else if(c=='d') {
			System.out.println("Input address to key file, for example C:\\\\Workspace\\\\Resources\\\\key18.txt");
			String readkey = sc.nextLine();
			List<List<Integer>> key = reader.readKey("C:\\Workspace\\Resources\\key18.txt");
			coder.checkKey(key);
			
			System.out.println("Input address to encrypted file, for example C:\\\\Workspace\\\\Resources\\\\ciphered.txt");
			String readFile = sc.nextLine();
			List<Integer> message = reader.readFile(readFile);
			List<Integer> decoded =coder.decodeMessage(message, key);
			String text = writer.writeMessage(decoded);
			System.out.println("Input address to output file, for example C:\\\\Workspace\\\\Resources\\\\deciphered.txt");
			String writeFile = sc.nextLine();
			if(writeFile.isEmpty()) {
				System.out.println(text);
			}else {
				writer.writeFile(writeFile, text);
			}
		}else {
			System.out.println("Unexpected input");
		}
			
			
		/* for generating keys use function coder.makeKey(Integer length)
		 *	List<List<Integer>> key = coder.makeKey(18); 
		 */
		
	}

}
