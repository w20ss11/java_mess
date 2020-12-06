package pack180905_niuke;

import java.util.Scanner;

public class Demo3_CommonString {
/**
 * 题目描述
	输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
	例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 * */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		char[] str1 = scanner.nextLine().toCharArray();
		char[] str2 = scanner.nextLine().toCharArray();
		char[] res = new char[str1.length];
		int idx = 0;
		for(int j=0;j<str1.length;j++){
			if(!isInStr2(str1[j], str2))
				res[idx++] = str1[j];
		}
		String reString = new String(res);
		System.out.println(reString);
	}

	public static boolean isInStr2(char ch,char[] str2){
		for(int i=0;i<str2.length;i++)
			if(ch==str2[i])
				return true;
		return false;
	}
}
