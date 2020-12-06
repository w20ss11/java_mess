import java.util.Scanner;
public class Main{ 
	public static void main(String[] args) { 
		Scanner s = new Scanner(System.in); 
		System.out.println("sssssssssssssssss:"); 
		while (s.hasNext()) { 
			String line = s.next(); 
			if (line.equals("exit")) break; 
			System.out.println(">>>" + line); 
		} 
	} 
}