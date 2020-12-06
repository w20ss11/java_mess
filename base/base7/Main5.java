package cn.cqupt.wss;

import java.util.Scanner;

public class Main5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		System.out.println(fun(str1, 0, str1.length(), str2, 0, str2.length()));
	}

	public static int fun(String str1, int str1St,int str1En,String str2, int str2St,int str2En){
		if (str1St > str1En){
			if (str2St > str2En)
				return 0;
			else
				return str2En - str2St + 1;
		}
		if (str2St > str2En){
			if(str1St > str1En)
				return 0;
			else
				return str1En - str1St + 1;
		}
		if (str1.charAt(str1St) == str2.charAt(str2St)){
			return fun(str1,str1St+1,str1En,str2,str2St+1,str2En);
		}else{
			int t1 = fun(str1,str1St+1,str1En,str2,str2St+2,str2En);
			int t2 = fun(str1,str1St+2,str1En,str2,str2St+1,str2En);
			int t3 = fun(str1,str1St+2,str1En,str2,str2St+2,str2En);
			return min(t1,t2,t3)+1;
		}
	}

	private static int min(int t1, int t2, int t3) {
		if(t1<=t2 && t1<=t3)
			return t1;
		else if(t2<=t1 && t2<=t3)
			return t2;
		else
			return t3;
	}
	
}
