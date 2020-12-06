package pack180104_mess;

import java.util.Scanner;

public class Main7 {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		char[][] chs = new char[m][n];
		char[] res = new char[n];
		for(int i=0;i<m;i++){
			chs[i] = scanner.nextLine().toCharArray();
		}
		System.out.println("-");
	}
	public static boolean judgeChs(char[][] chs,char[] res){
		for(int i=0;i<chs.length;i++){
			if(chs[i].toString().equals(res.toString()))
				return false;
			else
				continue;
		}
		return true;//res与chs中字符都不一样
	}
}
