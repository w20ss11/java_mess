package cn.cqupt.wss;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();//s的子串
		String t = scanner.nextLine();
		int count = 0;
		for(int i=0;i<=s.length()-t.length();i++){
			if(judge(s.substring(i,i+t.length()),t)){
				count++;
			}
		}
		System.out.println(count);
	}
	public static boolean judge(String str1,String str2){
		char[] chs = new char[26];
		//将str2中的字符串填到str1中
		for(int i=0;i<str1.length();i++){
			int temp = (int)str1.charAt(i)-97;
			if((int)chs[temp]==0){
				chs[temp]=str2.charAt(i);
				continue;
			}else if (chs[temp]!=str2.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
